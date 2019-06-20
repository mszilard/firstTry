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
    String url_belso = "http://calcon/";
//    private String url_belso = "https://calcon.upsolution.hu";


    static {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
    }

    public Actionwords() {
        //Linux
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        webDriver = new FirefoxDriver(options);


        //Headless
//        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        webDriver = new FirefoxDriver(options);

        //Normal
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        webDriver = new FirefoxDriver();

    }

    public void Wait() {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
    }

    public void dijtetelsor() {
        this.Wait();
        this.webDriver.findElement(By.cssSelector("a[href*=dijtetelsorok")).click();
        this.Wait();

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
        //this.webDriver.findElement(By.cssSelector("li.m-menu__item.ng-star-inserted.m-menu__item--submenu.m-menu__item--open li:nth-of-type(1)")).click();
    }

    public void ujDijtetelsorLetrehozasa(String nev) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container input[name=nev]")).sendKeys(nev);
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
    }

    public void dijtetelsorLetrejottenekEllenorzese(String nev) {
        Wait();
            List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(1)"));
            for (int i = 0; i < dijtetelsorok.size(); i++) {
                if (dijtetelsorok.get(i).getText().trim().equals(nev)) {
                    System.out.println(i);
                    break;
                }
            }
            webDriver.close();
    }

    public void dijtetelsorReszletek(String nev) {
        List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell:nth-child(1)"));


        for (int i = 0; i < dijtetelsorok.size(); i++) {
            if (dijtetelsorok.get(i).getText().trim().equals(nev)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+ (i +1)+") mat-cell:nth-child(6) a.btn")).click();
                break;
            }
        }
        Wait();
    }

    public void dijtetesorAzonnaliAktivalasaEsAnnakEllenorzese(String nev) {
        this.webDriver.findElement(By.cssSelector("div button.m-btn.ng-star-inserted")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("a[href*=dijtetelsorok")).click();
        Wait();

            List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(1)"));
            List<WebElement> dijtetelsorallapotok = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(5)"));

            for (int i = 0; i < dijtetelsorok.size(); i++) {
                if (dijtetelsorok.get(i).getText().trim().equals(nev) && dijtetelsorallapotok.get(i).getText().trim().equals("Aktív")) {
                    System.out.println(i);
                    break;
                }
            }
            if(dijtetelsorok.size()==0){
                webDriver.close();
                Assert.fail();
            }
    }

    public void dijtetelsorMultbeliIdoMegadasa(int ora, int perc) {
        this.webDriver.findElement(By.cssSelector(".ngx-material-timepicker-toggle")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("ngx-material-timepicker-face div div div:nth-child("+ ora +") span")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("div:nth-child(2) ngx-material-timepicker-button button")).click();
        Assert.assertTrue(!this.webDriver.findElement(By.cssSelector("div.m-portlet button:nth-child(2)")).isEnabled());
        webDriver.close();

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
            webDriver.close();
            Assert.fail();
        }
    }

}