package eon_tests.kivitelezok_kezelese;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.Console;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Actionwords {

    private WebDriver webDriver;
    protected WebDriverWait wait;
    String url_belso = "http://10.10.1.25:91";
    //private String url_belso = "https://calcon.upsolution.hu";

    public void Wait() {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
    }

    public Actionwords() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        webDriver = new FirefoxDriver();

//        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
//        //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//        webDriver = new FirefoxDriver(options);
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

    public void kivitelezok() {
        Wait();
        webDriver.findElement(By.cssSelector("a[href*=kivitelezok]")).click();
    }

    public void ujKivitelezoHozzaadasa(String cegnev, String tipus, String uzemnev, int keretszerzodesSzama, int szallitoiSzam, int gyarSzama, int raktarhelySzama, int vallalasiSzazalek, String kivitelezo, String rezsianyag1, String rezsianyag2) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
        webDriver.findElement(By.cssSelector("m-subheader a.btn")).click();
        Wait();

        webDriver.findElement(By.cssSelector("input[name=kivitelezoNev]")).sendKeys(cegnev);
        webDriver.findElement(By.cssSelector("mat-select[name=kivitelezoTipus]")).click();

        List<WebElement> tipusList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < tipusList.size(); i++) {
            if (tipusList.get(i).getText().equals(tipus)) {
                tipusList.get(i).click();
                break;
            }
        }


        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok:nth-of-type(2) a.btn")).click();
        Wait();

        Assert.assertTrue(webDriver.findElement(By.cssSelector("mat-dialog-container")).isDisplayed());

        webDriver.findElement(By.cssSelector("input[name=megbizo]")).click();
        webDriver.findElement(By.cssSelector("input[name=megbizo]")).sendKeys(uzemnev);
        Wait();
        List<WebElement> uzemek = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : uzemek) {
            if (element.getText().contains(uzemnev)) {
                element.click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("input[name=keretszerzodesSzam]")).sendKeys(String.valueOf(keretszerzodesSzama));
        webDriver.findElement(By.cssSelector("input[name=szallitoiSzam]")).sendKeys(String.valueOf(szallitoiSzam));
        webDriver.findElement(By.cssSelector("input[name=gyarszam]")).sendKeys(String.valueOf(gyarSzama));
        webDriver.findElement(By.cssSelector("input[name=raktarhelySzam]")).sendKeys(String.valueOf(raktarhelySzama));
        webDriver.findElement(By.cssSelector("input[name=vallalasiszazalek]")).sendKeys(String.valueOf(vallalasiSzazalek));
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok:nth-of-type(2) a.btn")).click();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container input[name=felhasznaloId]")).sendKeys(kivitelezo);
        Wait();
        List<WebElement> kivitelezokk = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : kivitelezokk) {
            if (element.getText().contains(kivitelezo)) {
                element.click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();

        WebElement mentes = webDriver.findElement(By.cssSelector(".m-portlet button.btn-primary"));
        if (mentes.isEnabled()){

            mentes.click();
        }else Assert.fail("Helyes kitöltés esetén is a mentés gomb disabled");

        Wait();

        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys(cegnev, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(cegnev)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+(i+1)+") mat-cell:nth-child(3) a")).click();
                break;
            }
        }
        Wait();
        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok:nth-of-type(3) a.btn")).click();
        Wait();
        List<WebElement> rezsiAnyagok = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));



        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok a.btn")).click();
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container input[name=anyagId]")).click();
        webDriver.findElement(By.cssSelector("mat-dialog-container input[name=anyagId]")).sendKeys(rezsianyag1);
        Wait();
        List<WebElement> anyagLista = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < anyagLista.size(); i++) {
            if (anyagLista.get(i).getText().contains(rezsianyag1)) {
                anyagLista.get(i).click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok a.btn")).click();
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container input[name=anyagId]")).click();
        webDriver.findElement(By.cssSelector("mat-dialog-container input[name=anyagId]")).sendKeys(rezsianyag2);
        Wait();
        List<WebElement> anyagLista2 = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < anyagLista2.size(); i++) {
            if (anyagLista2.get(i).getText().contains(rezsianyag2)) {
                anyagLista2.get(i).click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
        List<WebElement> rezsiAnyagok1 = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));
        if(rezsiAnyagok.size() == rezsiAnyagok1.size()){
            Assert.fail("Nem sikerült az anyagok hozzáadása.");
        } else webDriver.findElement(By.cssSelector("div:nth-of-type(2) a.btn")).click();

        Wait();

        webDriver.findElement(By.cssSelector(".m-portlet button.btn-primary")).click();

    }

    public void ujKivitelezoHozzaadasaDuplikaltAdatokkal(String cegnev, String tipus, String uzemnev, int keretszerzodesSzama, int szallitoiSzam, int gyarSzama, int raktarhelySzama, int valalasiSzazalek, String kivitelezo, String rezsianyag1, String rezsianyag2, String uzemnev2, int keretszerzodesSzama2, int szallitoiSzam2, int gyarSzama2, int raktarhelySzama2, int valalasiSzazalek2) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
        webDriver.findElement(By.cssSelector("m-subheader a.btn")).click();
        Wait();

        webDriver.findElement(By.cssSelector("input[name=kivitelezoNev]")).sendKeys(cegnev);
        webDriver.findElement(By.cssSelector("mat-select[name=kivitelezoTipus]")).click();

        List<WebElement> tipusList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < tipusList.size(); i++) {
            if (tipusList.get(i).getText().equals(tipus)) {
                tipusList.get(i).click();
                break;
            }
        }

        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok:nth-of-type(2) a.btn")).click();
        Wait();
        Assert.assertTrue(webDriver.findElement(By.cssSelector("mat-dialog-container")).isDisplayed());
        webDriver.findElement(By.cssSelector("input[name=megbizo]")).click();
        webDriver.findElement(By.cssSelector("input[name=megbizo]")).sendKeys(uzemnev);
        Wait();
        List<WebElement> uzemek = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : uzemek) {
            if (element.getText().contains(uzemnev)) {
                element.click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("input[name=keretszerzodesSzam]")).sendKeys(String.valueOf(keretszerzodesSzama));
        webDriver.findElement(By.cssSelector("input[name=szallitoiSzam]")).sendKeys(String.valueOf(szallitoiSzam));
        webDriver.findElement(By.cssSelector("input[name=gyarszam]")).sendKeys(String.valueOf(gyarSzama));
        webDriver.findElement(By.cssSelector("input[name=raktarhelySzam]")).sendKeys(String.valueOf(raktarhelySzama));
        webDriver.findElement(By.cssSelector("input[name=vallalasiszazalek]")).sendKeys(String.valueOf(valalasiSzazalek));
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok:nth-of-type(2) a.btn")).click();
        Wait();
        Assert.assertTrue(webDriver.findElement(By.cssSelector("mat-dialog-container")).isDisplayed());
        webDriver.findElement(By.cssSelector("input[name=megbizo]")).click();
        webDriver.findElement(By.cssSelector("input[name=megbizo]")).sendKeys(uzemnev2);
        Wait();
        List<WebElement> uzemek2 = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : uzemek2) {
            if (element.getText().contains(uzemnev2)) {
                Assert.assertTrue(!element.isEnabled());
                break;
            }
        }
        webDriver.findElement(By.cssSelector("input[name=keretszerzodesSzam]")).sendKeys(String.valueOf(keretszerzodesSzama2));
        webDriver.findElement(By.cssSelector("input[name=szallitoiSzam]")).sendKeys(String.valueOf(szallitoiSzam2));
        webDriver.findElement(By.cssSelector("input[name=gyarszam]")).sendKeys(String.valueOf(gyarSzama2));
        webDriver.findElement(By.cssSelector("input[name=raktarhelySzam]")).sendKeys(String.valueOf(raktarhelySzama2));
        webDriver.findElement(By.cssSelector("input[name=vallalasiszazalek]")).sendKeys(String.valueOf(valalasiSzazalek2));

        WebElement hozzaad = webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary"));
        if (!hozzaad.isEnabled()){
            System.out.println("Megfelelően műkdik: Nem lehet duplikálni az üzemeket.");
        }else Assert.fail("Az üzemek duplikálhatóak!");
    }

    public void kivitelezoLetrejottenekEllenorzese(String cegnev) {
        Wait();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).clear();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys(cegnev, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(cegnev)) {
                System.out.println("Létrehozott kivitelező megtalálva");
            }else {
                webDriver.close();
                Assert.fail("Nem található a létrehozott kivitelező");
            }
        }
    }

    public void kivitelezokSzurese(String szurendo) {

        Wait();
        webDriver.findElement(By.cssSelector("div.m-portlet__body span.mat-select-placeholder")).click();
        Wait();
        List<WebElement> tipusList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < tipusList.size(); i++) {
            if (tipusList.get(i).getText().equals(szurendo)) {
                tipusList.get(i).click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(1) button.btn-primary")).click();
        Wait();
    }

    public void kivitelezokSzurtListaEllenorzese(String szurendo) {
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(2)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (!keresesEredmenye.get(i).getText().trim().equals(szurendo)) {
                Assert.fail("Szűrt típuson kívül más típust is kilistáz ");
                webDriver.close();
            }else System.out.println("Sikeres szűrés");
        }
    }

    public void lapozasEllenorzeseAnyagokValtozotetelek() {

        this.webDriver.findElement(By.cssSelector("div.mat-paginator-container .mat-select-value")).click();
        this.webDriver.findElement(By.cssSelector("mat-option:nth-of-type(1)")).click();
        List<WebElement> kivitelezokLista = webDriver.findElements(By.cssSelector("mat-row mat-cell:nth-of-type(1)"));
        if (kivitelezokLista.size() > 5) {
            Assert.fail("Vártnál több elem jelenik meg");
        } else {
            List<WebElement> olda11 = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));
            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            Wait();
            List<WebElement> oldal2 = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));

            if (olda11.equals(oldal2)) {
                Assert.fail("Hibás lapozó modul: Két oldal elemei megegyeznek");
            }
        }
    }

    public void eroforrasKeresese(String keresendoKivitelezo) {
        webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(keresendoKivitelezo, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            System.out.println(keresesEredmenye.get(i).getText());
            if (!keresesEredmenye.get(i).getText().trim().equals(keresendoKivitelezo)) {
                System.out.println(keresesEredmenye.get(i).getText());
                webDriver.close();
                Assert.fail("Nem létező kivitelező.");
                break;
            }
        }

    }

    public void kivitelezoReszletek(String szerkesztendoKivitelezo) {
        Wait();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys(szerkesztendoKivitelezo, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(szerkesztendoKivitelezo)) {

                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+i+1+") > mat-cell:nth-child(3) > a")).click();
                System.out.println("Létrehozott kivitelező megtalálva");

            }else Assert.fail("Nem található a szerkeszteni kívánt kivitelező");
        }
        Wait();

    }

    public void kivitelezoSzerkesztese(String cegnev, String tipus) {


        webDriver.findElement(By.cssSelector("input[name=kivitelezoNev]")).sendKeys(cegnev);
        webDriver.findElement(By.cssSelector("mat-select[name=kivitelezoTipus]")).click();

        List<WebElement> tipusList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < tipusList.size(); i++) {
            if (tipusList.get(i).getText().equals(tipus)) {
                tipusList.get(i).click();
                break;
            }
        }

    }

    public void szerkesztendoUzemReszletek(String szerkesztendoUzem) {
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(szerkesztendoUzem)) {

                webDriver.findElement(By.cssSelector("div.m-portlet__body mat-row.mat-row:nth-of-type("+(i+1)+") > mat-cell:nth-child(7) a")).click();
                webDriver.findElement(By.cssSelector("button.mat-menu-item:nth-of-type(1)")).click();
                break;
            }
        }
        Wait();
    }

    public void uzemSzerkesztese(String uzemnev, int keretszerzodesSzama, int szallitoiSzam, int gyarSzama, int raktarhelySzama, float valalasiSzazalek) {

        webDriver.findElement(By.cssSelector("input[name=keretszerzodesSzam]")).sendKeys(String.valueOf(keretszerzodesSzama));
        webDriver.findElement(By.cssSelector("input[name=szallitoiSzam]")).sendKeys(String.valueOf(szallitoiSzam));
        webDriver.findElement(By.cssSelector("input[name=gyarszam]")).sendKeys(String.valueOf(gyarSzama));
        webDriver.findElement(By.cssSelector("input[name=raktarhelySzam]")).sendKeys(String.valueOf(raktarhelySzama));
        webDriver.findElement(By.cssSelector("input[name=vallalasiszazalek]")).sendKeys(String.valueOf(valalasiSzazalek));
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
        webDriver.findElement(By.cssSelector(".m-portlet button.btn-primary")).click();

    }

    public void kivitelezoSzerkesztesEllenorzese(String cegnev) {
        Wait();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys(cegnev, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(1)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(cegnev)) {
                System.out.println("Létrehozott kivitelező megtalálva");
            }else {
                webDriver.close();
                Assert.fail("Nem található a létrehozott kivitelező");
            }
        }
    }
}