package eon_tests.dijtetelsor.dijtetelsorok;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Actionwords {

    private WebDriver webDriver;
    protected WebDriverWait wait;
    //String url_belso = "http://10.10.1.25:91";

    private String url_belso = "https://calcon.upsolution.hu";

    public void Wait() {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
    }

    public Actionwords() {
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        webDriver = new FirefoxDriver();


        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        webDriver = new FirefoxDriver(options);


    }

    public void dijtetelsor() {
        this.Wait();
        this.webDriver.findElement(By.cssSelector("li.m-menu__item:nth-child(6) a:nth-child(1) span:nth-child(2)")).click();

    }
    public void bejelentkezes(String s, String s1) {
        this.webDriver.get(url_belso);
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 45);
        this.webDriver.findElement(By.cssSelector("input[name=username]")).sendKeys(s);
        this.webDriver.findElement(By.cssSelector("input[name=password]")).sendKeys(s1, Keys.ENTER);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_header_menu\"]/ul/li[1]/a")));

        //Assert.assertFalse(webDriver.getCurrentUrl().contains("auth"));
    }

    public void dijtetelsorDijtetelsorok() {
        this.webDriver.findElement(By.cssSelector("li.m-menu__item.ng-star-inserted.m-menu__item--submenu.m-menu__item--open li:nth-of-type(1)")).click();
        this.Wait();
    }

    public void ujDijtetelsorLetrehozasa(String nev) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container input[name=nev]")).sendKeys(nev);
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
    }

    public void dijtetelsorLetrejottenekEllenorzese(String nev) {
        Wait();
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/dijtetelsorok")) {

            List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(1)"));
            for (int i = 0; i < dijtetelsorok.size(); i++) {
                if (dijtetelsorok.get(i).getText().trim().equals(nev)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }

    public void dijtetelsorReszletek(String regiNev) {
        List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell:nth-child(1)"));


        for (int i = 1; i < dijtetelsorok.size(); i++) {
            if (dijtetelsorok.get(i).getText().trim().equals(regiNev)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+ (i +1)+") mat-cell:nth-child(6) a.btn")).click();
                break;
            }
        }
        Wait();
    }

    public void dijtetesorAzonnaliAktivalasaEsAnnakEllenorzese(String nev) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/dijtetelsorok")) {


            List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(1)"));
            List<WebElement> dijtetelsorallapotok = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(5)"));

            for (int i = 0; i < dijtetelsorok.size(); i++) {
                if (dijtetelsorok.get(i).getText().trim().equals(nev) && dijtetelsorallapotok.get(i).getText().trim().equals("Aktív")) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }

    }

    public void dijtetelsorMultbeliIdoMegadasa(int ora, int perc) {
        this.webDriver.findElement(By.cssSelector(".ngx-material-timepicker-toggle")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("ngx-material-timepicker-face > div > div > div:nth-child("+ ora +") > span")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("div:nth-child(2) ngx-material-timepicker-button button")).click();
        Assert.assertTrue(!this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).isEnabled());

    }


    public void dijtetelsorSzerkesztese(String ujNev) {
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).clear();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).sendKeys(ujNev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
        Wait();
    }

    public void dijtetelsorSzerkesztesenekEllenorzese(String ujNev) {
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/dijtetelsorok")) {


            List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(1)"));

            for (int i = 0; i < dijtetelsorok.size(); i++) {
                if (dijtetelsorok.get(i).getText().trim().equals(ujNev)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }

}