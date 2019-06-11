package eon_tests.dokumentum_kezeles;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Actionwords {

    private WebDriver webDriver;
    protected WebDriverWait wait;
    String url_belso = "http://10.10.1.25:91";
    //String url_belso = "https://calcon.upsolution.hu";

    private Path currentPath = Paths.get("");
    private String dokumentumok = currentPath.toAbsolutePath().toString() + "\\feltoltendo\\dokumentumok\\";


    public void Wait() {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
    }

    public Actionwords() {
       // System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        webDriver = new FirefoxDriver();


        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        webDriver = new FirefoxDriver(options);


    }

    public void bejelentkezes(String s, String s1) {
        this.webDriver.get(url_belso);
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 45);
        this.webDriver.findElement(By.cssSelector("input[name=username]")).sendKeys(s);
        this.webDriver.findElement(By.cssSelector("input[name=password]")).sendKeys(s1, Keys.ENTER);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_header_menu\"]/ul/li[1]/a")));

    }


    public void dokumentumok() {
        Wait();
        webDriver.findElement(By.cssSelector(".m-menu__item a[href*=javascript]")).click();
        Wait();
    }

    public void tipustervek() {
        Wait();
        webDriver.findElement(By.cssSelector(" li.m-menu__item--submenu a[href*=tipustervek]")).click();
        Wait();
    }

    public void muszakiDokumentaciok() {
        Wait();
        webDriver.findElement(By.cssSelector(" li.m-menu__item--submenu a[href*=muszakitervek]")).click();
        Wait();
    }

    public void tervezesiSegedlet() {
        Wait();
        webDriver.findElement(By.cssSelector(" li.m-menu__item--submenu a[href*=tervezesisegedletek]")).click();
        Wait();
    }

    public void tudastar() {
        Wait();
        webDriver.findElement(By.cssSelector(" li.m-menu__item--submenu a[href*=tudastar]")).click();
        Wait();
    }

    public void ujDokumentacioLetrehozasa(String nev, String tervszam, String feltoltendoAnyag1, String feltoltendoAnyag2) {

        webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        webDriver.findElement(By.cssSelector("input[name=nev]")).sendKeys(nev);
        webDriver.findElement(By.cssSelector("input[name=tervszam]")).sendKeys(tervszam);
        webDriver.findElement(By.cssSelector("input[type=file]")).sendKeys(dokumentumok+feltoltendoAnyag1);
        webDriver.findElement(By.cssSelector("input[type=file]")).sendKeys(dokumentumok+feltoltendoAnyag2);

        if (!webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).isEnabled()){
            webDriver.close();
            Assert.fail("Hibás kitöltés történt, mentésre nincs lehetőség ezért a teszt megszakad.");
        }

        webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
        Wait();
    }


    public void dokumentacioReszletek(String szerkesztendo) {

        Wait();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys(szerkesztendo, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(szerkesztendo)) {

                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+i+1+") > mat-cell:nth-child(3) a")).click();

            }else Assert.fail("Nem található a szerkeszteni kívánt dokumentáció");
        }
        Wait();
    }

    public void dokumentacioSzerkesztese(String nev, String tervszam) {

        webDriver.findElement(By.cssSelector("input[name=nev]")).clear();
        webDriver.findElement(By.cssSelector("input[name=tervszam]")).clear();
        webDriver.findElement(By.cssSelector("input[name=nev]")).sendKeys(nev);
        webDriver.findElement(By.cssSelector("input[name=tervszam]")).sendKeys(tervszam);
        webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
        Wait();

    }

    public void dokumentacioTorlese() {

        webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
    }

    public void dokumentacioMuveletEllenorzese(String nev) {

        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).clear();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys(nev, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(nev)) {
                System.out.println("Létrehozott dokumentáció megtalálva");
            }else Assert.fail("Nem található a létrehozott dokumentáció");
        }
        webDriver.close();
    }
}