package eon_tests.megbizo_cegek_kezelese;


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
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
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

        //Assert.assertFalse(webDriver.getCurrentUrl().contains("auth"));

    }


    public void megbizoCegek() {
        Wait();
        webDriver.findElement(By.cssSelector("a[href*=megbizocegek]")).click();
    }

    public void ujMegbizoFelvetele(String rovidNev, String teljesNev, String telepules, String vallalat, String felelos, String fejleszto, String tervezo) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
        webDriver.findElement(By.cssSelector("m-subheader a.btn")).click();

        webDriver.findElement(By.cssSelector("input[name=megbizoRovidNev]")).sendKeys(rovidNev);
        webDriver.findElement(By.cssSelector("input[name=megbizoTeljesNev]")).sendKeys(teljesNev);
        webDriver.findElement(By.cssSelector("mat-select[name=telepules]")).click();


        List<WebElement> telepulesList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < telepulesList.size(); i++) {
            if (telepulesList.get(i).getText().equals(telepules)) {
                telepulesList.get(i).click();
                break;
            }
        }

        webDriver.findElement(By.cssSelector("mat-select[name=vallalat]")).click();


        List<WebElement> vallalatList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < vallalatList.size(); i++) {
            if (vallalatList.get(i).getText().contains(vallalat)) {
                vallalatList.get(i).click();
                break;
            }
        }



        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok a")).click();

        this.webDriver.findElement(By.cssSelector("mat-dialog-container input[name=felhasznaloId]")).sendKeys(felelos);
        Wait();
        List<WebElement> felelosok = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : felelosok) {
            if (element.getText().contains(felelos)) {
                element.click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();


        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok a")).click();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container input[name=felhasznaloId]")).sendKeys(fejleszto);
        Wait();
        List<WebElement> fejlesztok = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : fejlesztok) {
            if (element.getText().contains(fejleszto)) {
                element.click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();

        webDriver.findElement(By.cssSelector(".eon-kovetelmenyek-gombok a")).click();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container input[name=felhasznaloId]")).sendKeys(tervezo);
        Wait();
        List<WebElement> tervezok = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : tervezok) {
            if (element.getText().contains(tervezo)) {
                element.click();
                break;
            }
        }
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();

        WebElement mentes = webDriver.findElement(By.cssSelector("m-uj-megbizo-ceg button.btn-primary"));
        if(!mentes.isEnabled())
        {
            Assert.fail("Helyes kitöltés esetén nem lehet menteni a megbízót.");
        }
        else mentes.click();


    }

    public void megbizoLetrejottenekEllenorzese(String rovidNev, String teljesNev) {

        Wait();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys(rovidNev);
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(2) input")).sendKeys(teljesNev, Keys.ENTER);
        Wait();

        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(1) mat-cell.mat-cell:nth-child(1)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(rovidNev)) {
                System.out.println(i);
                break;
            }else Assert.fail("Nincs találat.");
        }
        webDriver.close();
    }

    public void megbizoReszletek(String valasztandoMegbizo) {

        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(2) input")).sendKeys(valasztandoMegbizo, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(1) mat-cell.mat-cell:nth-child(2)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(valasztandoMegbizo)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+i+1+") > mat-cell:nth-child(4) > a")).click();
                break;
            }
        }
        Wait();

    }

    public void megbizoSzerkesztese(String rovidNev, String teljesNev, String telepules, String vallalat, String torlendoFelhasznalo) {

        webDriver.findElement(By.cssSelector("input[name=megbizoRovidNev]")).clear();
        webDriver.findElement(By.cssSelector("input[name=megbizoTeljesNev]")).clear();

        webDriver.findElement(By.cssSelector("input[name=megbizoRovidNev]")).sendKeys(rovidNev);
        webDriver.findElement(By.cssSelector("input[name=megbizoTeljesNev]")).sendKeys(teljesNev);
        webDriver.findElement(By.cssSelector("mat-select[name=telepules]")).click();


        List<WebElement> telepulesList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < telepulesList.size(); i++) {
            if (telepulesList.get(i).getText().equals(telepules)) {
                telepulesList.get(i).click();
                break;
            }
        }

        webDriver.findElement(By.cssSelector("mat-select[name=vallalat]")).click();

        List<WebElement> vallalatList = webDriver.findElements(By.cssSelector("mat-option"));
        for (int i = 0; i < vallalatList.size(); i++) {
            if (vallalatList.get(i).getText().contains(vallalat)) {
                vallalatList.get(i).click();
                break;
            }
        }

        List<WebElement> felhasznalok = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(1) mat-cell.mat-cell:nth-child(1)"));


        for (int i = 0; i < felhasznalok.size(); i++) {
            if (felhasznalok.get(i).getText().trim().equals(torlendoFelhasznalo)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+i+1+") > mat-cell:nth-child(2) > a")).click();
                break;
            }
        }
        Wait();

        webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(1) button.btn-primary")).click();



    }

    public void megbizoSzerkesztesenekEllenorzese(String teljesNev) {

        Wait();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-child(2) input")).sendKeys(teljesNev, Keys.ENTER);
        Wait();

        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(2)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(teljesNev)) {
                System.out.println(i);
                break;
            }
            else Assert.fail("Szerkesztett elem nem található meg.");
        }
        webDriver.close();
    }

    public void lapozasEllenorzeseMegbizok() {
        this.webDriver.findElement(By.cssSelector("div.mat-paginator-container .mat-select-value")).click();
        this.webDriver.findElement(By.cssSelector("mat-option:nth-of-type(1)")).click();
    }

    public void lapzasMegfeleloenMukodik() {

        List<WebElement> megbizokLista = webDriver.findElements(By.cssSelector("mat-row mat-cell:nth-of-type(1)"));
        if (megbizokLista.size() > 5) {
            Assert.fail("Vártnál több elem jelenik meg");
        } else {
            List<WebElement> olda11 = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(2)"));

            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();

            Wait();

            List<WebElement> oldal2 = webDriver.findElements(By.cssSelector("div.m-portlet mat-cell.mat-cell:nth-child(2)"));

            if (olda11.equals(oldal2)) {
                Assert.fail("Két oldal elemei megegyeznek");
            }
        }
        webDriver.close();
    }
}