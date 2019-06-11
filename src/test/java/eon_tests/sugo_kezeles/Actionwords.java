package eon_tests.sugo_kezeles;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
        //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        webDriver = new FirefoxDriver();


//        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        webDriver = new FirefoxDriver(options);


    }

    public void bejelentkezes(String s, String s1) {
        this.webDriver.get(url_belso);
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 45);
        this.webDriver.findElement(By.cssSelector("input[name=username]")).sendKeys(s);
        this.webDriver.findElement(By.cssSelector("input[name=password]")).sendKeys(s1, Keys.ENTER);
        Wait();

    }


    public void sugo() {
        Wait();

        webDriver.findElement(By.cssSelector("a[href*=sugo]")).click();
        Assert.assertTrue(webDriver.findElement(By.cssSelector("m-subheader h3")).getText().equals("Súgó"));
        Wait();
    }

    public void sugoSzerkesztes() {

        webDriver.findElement(By.cssSelector("div m-subheader a.btn")).click();
    }

    public void temakorTorlese(String torlendoTemakor) {

        List<WebElement> temakor = webDriver.findElements(By.cssSelector("mat-panel-title span"));
        for (int i = 0; i < temakor.size(); i++) {
            if (temakor.get(i).getText().trim().equals(torlendoTemakor)) {
                webDriver.findElement(By.cssSelector("mat-expansion-panel:nth-of-type("+(i+1)+") i.material-icons:nth-child(3)")).click();
                webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
                break;
            }
        }
        Wait();
        List<WebElement> temakornew = webDriver.findElements(By.cssSelector("mat-panel-title"));
        if (temakor.size() > temakornew.size())
        {
            System.out.println("Sikeres témakör törlés");
        }else Assert.fail("Sikertelen témakör törlés");


    }

    public void csoportTorlese(String torlendoCsoport) {
        List<WebElement> csoport = webDriver.findElements(By.cssSelector("div.csoport"));

        webDriver.findElement(By.cssSelector("div.csoport.active i.material-icons:nth-of-type(2)")).click();
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();

        Wait();

        List<WebElement> csoportnew = webDriver.findElements(By.cssSelector("div.csoport"));

        if (csoport.size() > csoportnew.size())
        {
            System.out.println("Sikeres csoport törlés");
            webDriver.close();
        }else {
            webDriver.close();
            Assert.fail("Sikertelen csoport törlés");
        }

    }

    public void csoportSzerkesztese(String szerkesztendoCsoport, String ujCsoport) {

        List<WebElement> csoportok = webDriver.findElements(By.cssSelector("div.csoport span"));


        for (int i = 0; i < csoportok.size(); i++) {
            if (csoportok.get(i).getText().trim().equals(szerkesztendoCsoport)) {
                webDriver.findElement(By.cssSelector("div.csoport:nth-of-type("+(i+1)+") i.material-icons:nth-of-type(1)")).click();
                break;
            }else {
                webDriver.close();
                Assert.fail("Nem található a szerkeszteni kívánt csoport");
            }
        }
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container input")).clear();
        webDriver.findElement(By.cssSelector("mat-dialog-container input")).sendKeys(ujCsoport);
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

    }

    public void temakorokSzerkesztese(String temakorNeve, String temakorLeirasa) {
        webDriver.findElement(By.cssSelector("mat-expansion-panel:nth-of-type(1) i.material-icons:nth-of-type(1)")).click();

        webDriver.findElement(By.cssSelector(".mat-form-field input[name=temakorNev]")).clear();
        webDriver.findElement(By.cssSelector(".mat-form-field textarea[name=temakorLeiras")).clear();

        webDriver.findElement(By.cssSelector(".mat-form-field input[name=temakorNev]")).sendKeys(temakorNeve);
        webDriver.findElement(By.cssSelector(".mat-form-field textarea[name=temakorLeiras")).sendKeys(temakorLeirasa);
        webDriver.findElement(By.cssSelector(".mat-dialog-actions .btn-primary")).click();

    }

    public void szerkesztesEllenorzese(String ujCsoport) {

        boolean szerkesztve= false;

        List<WebElement> temakor = webDriver.findElements(By.cssSelector("div.csoport span"));
        for (int i = 0; i < temakor.size(); i++) {
            if (temakor.get(i).getText().trim().equals(ujCsoport)) {
                szerkesztve=true;
                break;
            }
        }
        if (szerkesztve){
            System.out.println("A csoport szerkesztese sikeres");
            webDriver.close();
        }else {
            webDriver.close();
            Assert.fail("A csoport szerkesztese sikertelen.");
        }


    }

    public void ujCsoportLetrehozasa(String csoportNeve) {
        Wait();
        webDriver.findElement(By.cssSelector(".m-portlet:nth-of-type(2) button.btn-primary")).click();
        webDriver.findElement(By.cssSelector("div form input")).sendKeys(csoportNeve);
        webDriver.findElement(By.cssSelector("div mat-dialog-container button")).click();
        Wait();


    }

    public void ujTemakorokMegadasa(String temakorNeve1, String temakorLeirasa1, String temakorNeve2, String temakorLeirasa2) {

        List<WebElement> csoportList = webDriver.findElements(By.cssSelector("div.csoport"));
        csoportList.get(csoportList.size()-1).click();
        webDriver.findElement(By.cssSelector("div.ng-star-inserted:nth-of-type(2) div button")).click();
        webDriver.findElement(By.cssSelector(".mat-form-field input[name=temakorNev]")).sendKeys(temakorNeve1);
        webDriver.findElement(By.cssSelector(".mat-form-field textarea[name=temakorLeiras")).sendKeys(temakorLeirasa1);
        webDriver.findElement(By.cssSelector(".mat-dialog-actions .btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector("div.ng-star-inserted:nth-of-type(2) div button")).click();
        webDriver.findElement(By.cssSelector(".mat-form-field input[name=temakorNev]")).sendKeys(temakorNeve2);
        webDriver.findElement(By.cssSelector(".mat-form-field textarea[name=temakorLeiras")).sendKeys(temakorLeirasa2);
        webDriver.findElement(By.cssSelector(".mat-dialog-actions .btn-primary")).click();
        Wait();

    }

    public void csoporttemakorLetrejottenekEllenorzese(String csoportNeve) {

        boolean letrejott= false;

        List<WebElement> csoportlist = webDriver.findElements(By.cssSelector("div.csoport span"));
        for (int i = 0; i < csoportlist.size(); i++) {
            if (csoportlist.get(i).getText().trim().equals(csoportNeve)) {
                letrejott=true;
                break;
            }
        }
        if (letrejott){
            webDriver.close();
            System.out.println("A csoport létrejött");
        }else{
            webDriver.close();
            Assert.fail("A csoport létreozása sikertelen.");
        }
    }
}