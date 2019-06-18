package eon_tests.adat_feltoltes;


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
    String url_belso = "http://10.10.1.25:91";
    //private String url_belso = "https://calcon.upsolution.hu";

    static {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
    }

    public Actionwords() {
//        //Linux
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
       // wait.until(ExpectedConditions())
    }


    public void dijtetelsorFelvetele(String felhNev, String jelszo, String dijtetelsorNev) {
        this.webDriver.get(url_belso);
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 60);
        Wait();
        this.webDriver.findElement(By.cssSelector("input[name=username]")).sendKeys(felhNev);
        this.webDriver.findElement(By.cssSelector("input[name=password]")).sendKeys(jelszo, Keys.ENTER);
        Wait();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
        this.webDriver.findElement(By.cssSelector("a[href*=dijtetelsorok")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container input[name=nev]")).sendKeys(dijtetelsorNev);
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

    }

    public void dijtetelsorAktivalas(String dijtetelsorNev) {

        List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell:nth-child(1)"));
        Wait();
        for (int i = 0; i < dijtetelsorok.size(); i++) {
            if (dijtetelsorok.get(i).getText().trim().equals(dijtetelsorNev)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+ (i +1)+") mat-cell:nth-child(6) a.btn")).click();
                break;
            }

        }
        Wait();
        this.webDriver.findElement(By.cssSelector("div button.m-btn.ng-star-inserted")).click();
        Wait();
    }

    public void gepFelvetele(String gepNev, int gepOradij,String gep2Nev, int gep2Oradij) {
        Wait();
        List<WebElement> dijtetelsorok = webDriver.findElements(By.cssSelector("mat-cell:nth-child(5)"));

        for (int i = 1; i < dijtetelsorok.size(); i++) {
            if (dijtetelsorok.get(i).getText().trim().equals("Aktív")) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+ (i +1)+") mat-cell:nth-child(6) a.btn")).click();
                break;
            }
        }
        Wait();

        webDriver.findElement(By.cssSelector("div.m-portlet__body a[href*=gepek]")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet:nth-child(2) button.btn-primary")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).sendKeys(gepNev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(String.valueOf(gepOradij));
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector("div.m-portlet__body a[href*=gepek]")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet:nth-child(2) button.btn-primary")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).sendKeys(gep2Nev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(String.valueOf(gep2Oradij));
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
        Wait();
    }

    public void humanFelvetele(String humanNev, int humanOradij,String human2Nev, int human2Oradij) {

        webDriver.findElement(By.cssSelector("div.m-portlet__body a[href*=humaneroforrasok]")).click();

        this.webDriver.findElement(By.cssSelector("div.m-portlet:nth-child(2) button.btn-primary")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(humanNev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(String.valueOf(humanOradij));
        if (webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).isEnabled()){
            this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
        }else {
            webDriver.close();
            Assert.fail("Hibás kitöltés miatt a humánerőforrás nem menthető ezért a folymat megszakad.");
        }
        Wait();

        this.webDriver.findElement(By.cssSelector("div.m-portlet:nth-child(2) button.btn-primary")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(human2Nev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(String.valueOf(human2Oradij));
        if (webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).isEnabled()){
            this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
        }else {
            webDriver.close();
            Assert.fail("Hibás kitöltés miatt a humánerőforrás nem menthető ezért a folymat megszakad.");
        }
        Wait();
    }

    public void fejezetFelvetele(int fGepszorzo, int fHumanszorzo, String fMegnevezes, String fRovidnev, int fSorszam) {

        webDriver.findElement(By.cssSelector("div.m-portlet__body a[href*=fejezetek]")).click();

        this.webDriver.findElement(By.cssSelector("div.m-portlet:nth-child(2) button.btn-primary")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=sorszam]")).sendKeys(String.valueOf(fSorszam));
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(fMegnevezes);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=rovidnev]")).sendKeys(fRovidnev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=humanSzorzo]")).sendKeys(String.valueOf(fHumanszorzo));
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=gepSzorzo]")).sendKeys(String.valueOf(fGepszorzo));
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
    }
}