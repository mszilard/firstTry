package eon_tests;


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
    //6
    //String url_belso = "https://calcon.upsolution.hu";

    public void Wait() {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-splash screen")));
    }

    public Actionwords() {
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        webDriver = new FirefoxDriver();


        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        webDriver = new FirefoxDriver(options);


    }

    public void dijtetelsor() {
        this.Wait();
        this.webDriver.findElement(By.cssSelector("li.m-menu__item:nth-child(6) a:nth-child(1) span:nth-child(2)")).click();

    }

    public void dijtetelsorGepek() {
        this.webDriver.findElement(By.cssSelector("li.m-menu__item.ng-star-inserted.m-menu__item--submenu.m-menu__item--open li:nth-of-type(3)")).click();
        this.Wait();

    }

    public void ujGepHozzaadasa(String megnevezes, String oradij) {

        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).sendKeys(megnevezes);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(oradij);
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();

    }

    public void eroforrasInaktivalasa(String inkativalando) {
        webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(inkativalando, Keys.ENTER);
        Wait();

        List<WebElement> inakitavalandoKeres = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(1)"));

        System.out.println(inakitavalandoKeres.size());
        for (int i = 0; i < inakitavalandoKeres.size(); i++) {
            System.out.println(i + 1);
            if (inakitavalandoKeres.get(i).getText().trim().equals(inkativalando)) {
                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-cell a.btn")).click();
                break;
            }
        }
        Wait();

        List<WebElement> gepDijtetelei = webDriver.findElements(By.cssSelector("div.m-portlet__body m-dijtetel-lista mat-table mat-row"));
        if (gepDijtetelei.size() > 0) {

            for (int i = 0; i < gepDijtetelei.size(); i++) {

                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-select")).click();
                Wait();
                List<WebElement> inkativalasiLehetoseg = webDriver.findElements(By.cssSelector(".mat-option"));

                for (WebElement element : inkativalasiLehetoseg) {
                    if (element.getText().contains("Eltávolít")) {
                        element.click();
                        break;
                    }
                }
            }
            webDriver.findElement(By.cssSelector("div.m-portlet__body:nth-of-type(2) button.btn-primary")).click();
            Wait();

        }


        webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
        Assert.assertFalse(webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).getText().contentEquals("Inaktiválás"));

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

    public void listazottEroforrasokEllenorzese() {
    }

    public void eroforrasKeresese(String megnevezes) {
        webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(megnevezes, Keys.ENTER);
        Wait();

        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (!keresesEredmenye.get(i).getText().trim().equals(megnevezes) || keresesEredmenye.size() == 0) {
                System.out.println();
                Assert.fail();
                break;
            }
        }

    }

    public void passzivEroforrasokListazasa() {
    }

    public void eroforrasReszletek(String gep) {
        webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(gep, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(gep)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-child(2) > mat-cell:nth-child(4) > a:nth-child(" + (i + 1) + ")")).click();
                break;
            }
        }
        Wait();
    }

    public void dijtetelsorDijtetelek() {
        this.webDriver.findElement(By.cssSelector("li.m-menu__item.ng-star-inserted.m-menu__item--submenu.m-menu__item--open li:nth-of-type(2)")).click();
        this.Wait();
    }

    public void dijtetelsorHumanEroforras() {
        this.webDriver.findElement(By.cssSelector("li.m-menu__item.ng-star-inserted.m-menu__item--submenu.m-menu__item--open li:nth-of-type(4)")).click();
        this.Wait();
    }

    public void ujHumanEroforrasHozzaadas(String megnevezes, String oradij) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(megnevezes);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(oradij);
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();

    }

    public void eroforrasTorleseADijtetelrol(String tetelszam) {
        List<WebElement> kapcsDijtetelek = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(2)"));
        for (int i = 0; i < kapcsDijtetelek.size(); i++) {

            if (kapcsDijtetelek.get(i).getText().equals(tetelszam)) {

                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-select")).click();
                Wait();
                List<WebElement> inkativalasiLehetoseg = webDriver.findElements(By.cssSelector(".mat-option"));

                for (WebElement element : inkativalasiLehetoseg) {

                    if (element.getText().contains("Eltávolít")) {
                        element.click();
                        Wait();
                        this.webDriver.findElement(By.cssSelector("div.m-portlet__body:nth-of-type(2) button.btn-primary")).click();
                        break;
                    }
                }
            }
        }
    }

    public void gepCserejeADijtetelben(String kivalasztottGep, String kapcsDijtetel) {

        List<WebElement> kapcsDijtetelek = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(2)"));
        for (int i = 0; i < kapcsDijtetelek.size(); i++) {

            if (kapcsDijtetelek.get(i).getText().equals(kapcsDijtetel)) {

                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-select")).click();
                Wait();
                List<WebElement> inkativalasiLehetoseg = webDriver.findElements(By.cssSelector(".mat-option"));

                for (WebElement element : inkativalasiLehetoseg) {


                    if (element.getText().contains("Cserél")) {
                        element.click();
                        this.webDriver.findElement(By.cssSelector("input[name=gepId]")).sendKeys(kivalasztottGep);
                        Wait();
                        List<WebElement> cseregepek = webDriver.findElements(By.cssSelector("mat-option"));
                        String csere = kivalasztottGep;
                        for (WebElement gep : cseregepek) {
                            if (gep.getText().equals(csere)) {
                                gep.click();
                                break;
                            }
                        }
                        //todo felvenni hiptestbe
                        this.webDriver.findElement(By.cssSelector("input[name=oraSzam]")).sendKeys("1");
                        this.webDriver.findElement(By.cssSelector("input[name=monoblockOraszam]")).sendKeys("3");
                        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
                        this.webDriver.findElement(By.cssSelector("div.m-portlet__body:nth-of-type(2) button.btn-primary")).click();
                        break;
                    }
                }
            }
        }
    }

    public void eroforrasTorleseADijtetelbolegyeduliEroforras(String tetelszam) {
        List<WebElement> kapcsDijtetelek = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(2)"));
        for (int i = 0; i < kapcsDijtetelek.size(); i++) {

            if (kapcsDijtetelek.get(i).getText().equals(tetelszam)) {

                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-select")).click();
                Wait();
                List<WebElement> inkativalasiLehetoseg = webDriver.findElements(By.cssSelector(".mat-option"));

                for (WebElement element : inkativalasiLehetoseg) {

                    if (element.getText().contains("Eltávolít")) {
                        Assert.assertFalse(element.isEnabled());
                        break;
                    }
                }
            }
        }
    }

    public void humanEroforrasSzerkesztese(String megnevezes, String oradij, String szerkesztendo) {
        webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(szerkesztendo, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(2) mat-cell.mat-cell:nth-child(1)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(szerkesztendo)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-child(2) > mat-cell:nth-child(4) > a:nth-child(" + (i + 1) + ")")).click();
                break;
            }
        }
        Wait();

        webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).clear();
        webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(megnevezes);
        webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).clear();
        webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(oradij);

        Assert.assertFalse(!webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).isEnabled() );
        webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();


        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector("mat-form-field input")).clear();
        webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(megnevezes, Keys.ENTER);
        Wait();

        if (!webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-child(2) > mat-cell:nth-child(1)")).getText().contentEquals(megnevezes)) {
            Assert.fail();
        } else
            Assert.assertTrue(webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-child(2) > mat-cell:nth-child(1)")).getText().contentEquals(megnevezes));
    }

    //todo felvenni hiptestbe
    public void humanCserejeADijtetelben(String csereHuman) {
        List<WebElement> kapcsDijtetelek = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(2)"));
        for (int i = 0; i < kapcsDijtetelek.size(); i++) {

            if (kapcsDijtetelek.get(i).getText().equals("32.1.4.562")) {

                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-select")).click();
                Wait();
                List<WebElement> inkativalasiLehetoseg = webDriver.findElements(By.cssSelector(".mat-option"));

                for (WebElement element : inkativalasiLehetoseg) {


                    if (element.getText().contains("Cserél")) {
                        element.click();
                        this.webDriver.findElement(By.cssSelector("input[name=emberId]")).sendKeys(csereHuman);
                        Wait();
                        List<WebElement> csereEmber = webDriver.findElements(By.cssSelector("mat-option"));
                        for (WebElement ember : csereEmber) {
                            if (ember.getText().equals(csereHuman)) {
                                ember.click();
                                break;
                            }
                        }
                        this.webDriver.findElement(By.cssSelector("input[name=oraSzam]")).sendKeys("1");
                        this.webDriver.findElement(By.cssSelector("input[name=monoblockOraszam]")).sendKeys("3");
                        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
                        this.webDriver.findElement(By.cssSelector("div.m-portlet__body:nth-of-type(2) button.btn-primary")).click();
                        break;
                    }
                }
            }
        }
    }

    public void gepReszletekszerkesztes(String megnevezes, String oradij, String szekesztendo) {
        webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(2) input")).sendKeys(szekesztendo, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));


        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(szekesztendo)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-child(2) > mat-cell:nth-child(4) > a:nth-child(" + (i + 1) + ")")).click();
                break;
            }
        }
        Wait();

        webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).clear();
        webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).sendKeys(megnevezes);
        webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).clear();
        webDriver.findElement(By.cssSelector("div.m-portlet input[name=oradij]")).sendKeys(oradij);

        Assert.assertTrue(webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).isEnabled());

        //TODO mat-dialog-container displayed check

        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(2) input")).clear();
        webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(2) input")).sendKeys(megnevezes, Keys.ENTER);
        Wait();

        if (!webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-child(2) > mat-cell:nth-child(1)")).getText().contentEquals(megnevezes)) {
            Assert.fail();
        } else
            Assert.assertTrue(webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-child(2) > mat-cell:nth-child(1)")).getText().contentEquals(megnevezes));
    }

    //todo felvenni hiptestbe
    public void ujDijtetelLetrehozasa(String tetelszam, String fejezet, String megnevezes, String felesSor, String leiras, String megjegyzes, String mennyisegiEgyseg,
                                      String gep1Megnevezes, String gep1Normaora, String gep1Monoblokk, String gep2Megnevezes, String gep2Normaora, String gep2Monoblokk,
                                      String human1Megnevezes, String human1Normaora, String human1Monoblokk, String human2Megnevezes, String  human2Normaora, String human2Monoblokk) {

        this.webDriver.findElement(By.cssSelector("a.m-btn--pill:nth-child(1)")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=tetelszam]")).sendKeys(tetelszam);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=fejezet]")).sendKeys(fejezet);
        Wait();
        List<WebElement> fejezetek = webDriver.findElements(By.className("mat-option"));
        for (WebElement element : fejezetek) {
            if (element.getText().contains(fejezet)) {
                element.click();
                break;
            }
        }

        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(megnevezes);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=haromFelesSor]")).sendKeys(felesSor);
        this.webDriver.findElement(By.cssSelector("div.m-portlet textarea[name=leiras]")).sendKeys(leiras);
        this.webDriver.findElement(By.cssSelector("div.m-portlet textarea[name=megjegyzes]")).sendKeys(megjegyzes);

        this.webDriver.findElement(By.cssSelector("div.m-portlet mat-select[name=mertekegysegId]")).click();
        Wait();
        List<WebElement> megysegek = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : megysegek) {
            if (element.getText().contains(mennyisegiEgyseg)) {
                element.click();
                break;
            }
        }
        this.webDriver.findElement(By.cssSelector(".m-form div:nth-child(9) div:nth-child(2) a:nth-child(1)")).click();
        Wait();

        //Gép1
        this.webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child(1) input[name=gepId]")).sendKeys(gep1Megnevezes);
        Wait();
        List<WebElement> gepek1 = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : gepek1) {
            if (element.getText().equals(gep1Megnevezes)) {
                element.click();
                break;
            }
        }
        this.webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child(1) input[name=oraSzam]")).sendKeys(gep1Normaora);
        this.webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child(1) input[name=monoblockOraszam]")).sendKeys(gep1Monoblokk);


        this.webDriver.findElement(By.cssSelector(".m-form div:nth-child(9) div:nth-child(2) a:nth-child(1)")).click();
        //Gép1
        Wait();
        this.webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child(2) input[name=gepId]")).sendKeys(gep2Megnevezes);
        Wait();
        List<WebElement> gepek2 = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : gepek2) {
            if (element.getText().equals(gep2Megnevezes)) {
                element.click();
                break;
            }
        }
        this.webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child(2) input[name=oraSzam]")).sendKeys(gep2Normaora);
        this.webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child(2) input[name=monoblockOraszam]")).sendKeys(gep2Monoblokk);

        //Human hozzáadása

        this.webDriver.findElement(By.cssSelector(".m-form div:nth-child(12) div:nth-child(2) a:nth-child(1)")).click();
        Wait();

        //Human1
        this.webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child(1) input[name=humanId]")).sendKeys(human1Megnevezes);
        Wait();
        List<WebElement> human1 = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : human1) {
            if (element.getText().equals(human1Megnevezes)) {
                element.click();
                break;
            }
        }
        this.webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child(1) input[name=oraSzam]")).sendKeys(human1Normaora);
        this.webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child(1) input[name=monoblockOraszam]")).sendKeys(human1Monoblokk);


        this.webDriver.findElement(By.cssSelector(".m-form div:nth-child(12) div:nth-child(2) a:nth-child(1)")).click();
        //Human2
        Wait();
        this.webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child(2) input[name=humanId]")).sendKeys(human2Megnevezes);
        Wait();
        List<WebElement> humanok2 = webDriver.findElements(By.cssSelector("mat-option"));
        for (WebElement element : humanok2) {
            if (element.getText().equals(human2Megnevezes)) {
                element.click();
                break;
            }
        }
        this.webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child(2) input[name=oraSzam]")).sendKeys(human2Normaora);
        this.webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child(2) input[name=monoblockOraszam]")).sendKeys(human2Monoblokk);


        Assert.assertFalse(!this.webDriver.findElement(By.cssSelector("button.btn:nth-child(2)")).isEnabled());

        this.webDriver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();

    }

    public void gepLetrejottenekEllenorzese(String megnevezes) {
        //todo url csere és humannal megegyezik
        Wait();
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/gepek")) {
            webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(2) input")).sendKeys(megnevezes, Keys.ENTER);
            Wait();

            List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));


            for (int i = 0; i < keresesEredmenye.size(); i++) {
                if (keresesEredmenye.get(i).getText().trim().equals(megnevezes)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }

    public void gepSzerkesztesenekEllenorzese(String s) {
        //todo url lecserélni hogy a gép és human egy lehessen
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/gepek")) {
            webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(2) input")).clear();
            webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(2) input")).sendKeys(s, Keys.ENTER);
            Wait();

            List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));


            for (int i = 0; i < keresesEredmenye.size(); i++) {
                if (keresesEredmenye.get(i).getText().trim().equals(s)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }

    public void eroforrasHelytelenInaktivalas(String inaktivalando) {
        webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(2) input")).sendKeys(inaktivalando, Keys.ENTER);
        Wait();

        List<WebElement> inakitavalandoKeres = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(1)"));

        System.out.println(inakitavalandoKeres.size());
        for (int i = 0; i < inakitavalandoKeres.size(); i++) {
            System.out.println(i + 1);
            System.out.println(inakitavalandoKeres.get(i).getText());
            if (inakitavalandoKeres.get(i).getText().trim().toLowerCase().equals(inaktivalando.trim().toLowerCase())) {
                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-cell a.btn")).click();
                break;
            }
        }
        Wait();

        List<WebElement> gepDijtetelei = webDriver.findElements(By.cssSelector("div.m-portlet__body m-dijtetel-lista mat-table mat-row"));
        if (gepDijtetelei.size() > 0) {

            //Todo Esetleges jobb megoldás keresése

            Assert.assertFalse(webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).isEnabled());

        }
    }

    public void eroforrasInaktivalasEllenorzese(String gepMegnevezes) {



        this.webDriver.findElement(By.cssSelector("li.m-menu__item:nth-child(6) div:nth-child(2) ul:nth-child(2) li:nth-child(2) a:nth-child(1) span:nth-child(2)")).click();
        this.Wait();
        this.webDriver.findElement(By.cssSelector("a.m-btn--pill:nth-child(1)")).click();

        this.webDriver.findElement(By.cssSelector(".m-form div:nth-child(9) div:nth-child(2) a:nth-child(1)")).click();
        Wait();

        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=gepId]")).sendKeys(gepMegnevezes);
        Wait();
        List<WebElement> gepek = webDriver.findElements(By.cssSelector("mat-option"));
        String gep = gepMegnevezes;
        for (WebElement element : gepek) {
            if (element.getText().equals(gep)) {
                Assert.fail();
                break;
            }
        }


    }

    public void humanEroforrasInaktivalasEllenorzese(String humanMegnevezes) {



        this.webDriver.findElement(By.cssSelector("li.m-menu__item:nth-child(6) div:nth-child(2) ul:nth-child(2) li:nth-child(2) a:nth-child(1) span:nth-child(2)")).click();
        this.Wait();
        this.webDriver.findElement(By.cssSelector("a.m-btn--pill:nth-child(1)")).click();

        this.webDriver.findElement(By.cssSelector(".m-form div:nth-child(12) div:nth-child(2) a:nth-child(1)")).click();
        Wait();

        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=humanId]")).sendKeys(humanMegnevezes);
        Wait();
        List<WebElement> humanok = webDriver.findElements(By.cssSelector("mat-option"));
        String human = humanMegnevezes;
        for (WebElement element : humanok) {
            if (element.getText().equals(human)) {
                Assert.fail();
                break;
            }
        }


    }

    public void lapozasEllenorzese() {
        this.webDriver.findElement(By.cssSelector("div.mat-paginator-container .mat-select-value")).click();
        this.webDriver.findElement(By.cssSelector("mat-option:nth-of-type(1)")).click();
        List<WebElement> gepekLista = webDriver.findElements(By.cssSelector("mat-row mat-cell:nth-of-type(1)"));
        if (gepekLista.size() > 5) {
            Assert.fail();
        } else {
            List<WebElement> olda11 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();

            Wait();

            List<WebElement> oldal2 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

            if (olda11.equals(oldal2)) {
                Assert.fail();
            }

        }

    }

    public void dijtetelValasztasaAktivIdozitett() {
        webDriver.findElement(By.cssSelector("m-dijtetelsor-valaszto .mat-select")).click();
        List<WebElement> dijtetelsorValaszto = webDriver.findElements(By.cssSelector(".mat-option"));

        for (WebElement element : dijtetelsorValaszto) {
            if (element.getText().contains("Időzített")) {
                element.click();
                break;
            }
        }

        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

        webDriver.findElement(By.cssSelector("m-dijtetelsor-valaszto .mat-select")).click();
        for (WebElement element : dijtetelsorValaszto) {
            if (element.getText().contains("Aktív")) {
                element.click();
                break;
            }
        }

        List<WebElement> keresesEredmenye2 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

        if(keresesEredmenye.equals(keresesEredmenye2))
        {
            Assert.fail("A két lista ugyan az!");
        }
    }

    public void humanLetrejottenekEllenorzese(String megnevezes) {
        Wait();
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/humaneroforras")) {
            webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(1) #mat-input-2")).sendKeys(megnevezes, Keys.ENTER);
            Wait();

            List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));


            for (int i = 0; i < keresesEredmenye.size(); i++) {
                if (keresesEredmenye.get(i).getText().trim().equals(megnevezes)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }

    }

    public void humanEroforrasSzerkesztesEllenorzese(String megnevezes) {
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/humaneroforras")) {
            webDriver.findElement(By.cssSelector("mat-form-field input")).clear();
            webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(megnevezes, Keys.ENTER);
            Wait();

            List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));


            for (int i = 0; i < keresesEredmenye.size(); i++) {
                if (keresesEredmenye.get(i).getText().trim().equals(megnevezes)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }


    public void dijtetelsorFejezetek() {
        this.webDriver.findElement(By.cssSelector("li.m-menu__item.ng-star-inserted.m-menu__item--submenu.m-menu__item--open li:nth-of-type(5)")).click();
        this.Wait();
    }

    public void ujFejezetLetrehozasa(String sorszam, String megnevezes, String rovidnev, String humanSzorzo, String gepSzorzo) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=sorszam]")).sendKeys(sorszam);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(megnevezes);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=rovidnev]")).sendKeys(rovidnev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=humanSzorzo]")).sendKeys(humanSzorzo);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=gepSzorzo]")).sendKeys(gepSzorzo);
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();

    }

    public void fejezetLetrejottenekEllenorzese(String megnevezes) {
        Wait();
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/fejezetek")) {
            webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys(megnevezes, Keys.ENTER);
            Wait();

            List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(2)"));


            for (int i = 0; i < keresesEredmenye.size(); i++) {
                if (keresesEredmenye.get(i).getText().trim().equals(megnevezes)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }

    public void fejezetReszletek(String szerkesztendoMegnev) {
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys(szerkesztendoMegnev, Keys.ENTER);
        Wait();
        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(2)"));


        for (int i = 1; i < keresesEredmenye.size(); i++) {
            if (keresesEredmenye.get(i).getText().trim().equals(szerkesztendoMegnev)) {
                webDriver.findElement(By.cssSelector("mat-row.mat-row:nth-of-type("+i+") > mat-cell:nth-child(3) > a.btn")).click();
                break;
            }
        }
        Wait();
    }

    public void fejezetSzerkesztesenekEllenorzese(String megnevezes) {
        if (webDriver.getCurrentUrl().contentEquals(url_belso + "/fejezetek")) {
            webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).clear();
            webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys(megnevezes, Keys.ENTER);
            Wait();

            List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(2)"));


            for (int i = 0; i < keresesEredmenye.size(); i++) {
                if (keresesEredmenye.get(i).getText().trim().equals(megnevezes)) {
                    System.out.println(i);
                    break;
                }else Assert.fail();
            }
        } else {
            Assert.fail();
        }
    }

    public void fejezetKeresese(int sorszam, String megnevezes ) {
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys(megnevezes, Keys.ENTER);
        Wait();

        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(2)"));
        Wait();

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            if (!keresesEredmenye.get(i).getText().trim().equals(megnevezes)) {
                System.out.println(i);
                Assert.fail();
            }
        }
    }

    public void lapozasEllenorzesefejezetek() {
        this.webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(3) mat-select")).click();
        this.webDriver.findElement(By.cssSelector("mat-option:nth-of-type(1)")).click();
        List<WebElement> fejezetkLista = webDriver.findElements(By.cssSelector("mat-row mat-cell:nth-of-type(1)"));
        if (fejezetkLista.size() > 5) {
            Assert.fail();
        } else {
            List<WebElement> olda11 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();

            Wait();

            List<WebElement> oldal2 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(1)"));

            if (olda11.equals(oldal2)) {
                Assert.fail();
            }

        }
    }

    public void vizsgalandoDijtetelsorKivalasztasa() {
    }

    public void ujDijtetelLetrehozasanakEllenorzese(String megnevezes) {
    }

    public void dijtetelsorDijtetelsorok() {
        this.webDriver.findElement(By.cssSelector("li.m-menu__item.ng-star-inserted.m-menu__item--submenu.m-menu__item--open li:nth-of-type(1)")).click();
        this.Wait();
    }

    public void ujDijtetelsorLetrehozasa(String nev) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=nev]")).sendKeys(nev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
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


    public void dijtetelsorMultbeliIdoMegadasa(int ora, int perc) {
        this.webDriver.findElement(By.cssSelector(".ngx-material-timepicker-toggle")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("ngx-material-timepicker-face > div > div > div:nth-child("+ ora +") > span")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("div:nth-child(2) ngx-material-timepicker-button button")).click();
        Assert.assertTrue(!this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).isEnabled());

    }

    public void fejezetSzerkesztese(String sorszam, String megnevezes, String rovidnev, String humanSzorzo, String gepSzorzo) {
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=sorszam]")).clear();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).clear();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=rovidnev]")).clear();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=humanSzorzo]")).clear();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=gepSzorzo]")).clear();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=sorszam]")).sendKeys(sorszam);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys(megnevezes);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=rovidnev]")).sendKeys(rovidnev);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=humanSzorzo]")).sendKeys(humanSzorzo);
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=gepSzorzo]")).sendKeys(gepSzorzo);
        this.webDriver.findElement(By.cssSelector("div.m-portlet button.btn-primary")).click();
    }

    //todo hiptest
    public void dijtetelInaktivalasa(String dijtetelNeve) {
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys(dijtetelNeve, Keys.ENTER);
        Wait();

        List<WebElement> inakitavalandoKeres = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(3)"));

        System.out.println(inakitavalandoKeres.size());
        for (int i = 0; i < inakitavalandoKeres.size(); i++) {
            System.out.println(i + 1);
            if (inakitavalandoKeres.get(i).getText().trim().equals(dijtetelNeve)) {
                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-cell a.btn")).click();
                break;
            }
        }
        Wait();
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container .mat-select")).click();
        Wait();
        List<WebElement> inkativalasiLehetoseg = webDriver.findElements(By.cssSelector(".mat-option"));

        for (WebElement element : inkativalasiLehetoseg) {
            if (element.getText().contains("Eltávolít")) {
                element.click();
                break;
            }
        }
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
    }

    public void dijtetelInaktivalasEllenorzese(String dijtetelNeve) {
        if (webDriver.findElement(By.cssSelector("span.mat-slide-toggle-content")).getText().equals("Aktív")) {

            webDriver.findElement(By.cssSelector("div.mat-slide-toggle-thumb")).click();
        }

        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).clear();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys(dijtetelNeve, Keys.ENTER);
        Wait();

        List<WebElement> inaktivalt = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(3)"));

        for (int i = 0; i < inaktivalt.size(); i++) {
            System.out.println(i + 1);
            if (inaktivalt.get(i).getText().trim().equals(dijtetelNeve)) {
                break;
            }
        }
    }

    public void dijtetelSzerkesztese() {
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys("", Keys.ENTER);
        Wait();

        List<WebElement> dijtetelek = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(3)"));

        for (int i = 0; i < dijtetelek.size(); i++) {
            System.out.println(i + 1);
            if (dijtetelek.get(i).getText().trim().equals("")) {
                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-cell a.btn")).click();
                break;
            }
        }
        Wait();

        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).clear();
        this.webDriver.findElement(By.cssSelector("div.m-portlet input[name=megnevezes]")).sendKeys("");
        this.webDriver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

    }

    public void dijtetelSzerkesztesEllenorzese() {
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).clear();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys("", Keys.ENTER);

        Wait();
        List<WebElement> dijtetelek = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(3)"));

        for (int i = 0; i < dijtetelek.size(); i++) {
            System.out.println(i + 1);
            if (dijtetelek.get(i).getText().trim().equals("")) {
                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-cell a.btn")).click();
                break;
            }
            else Assert.fail();
        }
    }

    public void dijtetelReszletek() {
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys("Új díjtétel1", Keys.ENTER);
        Wait();

        List<WebElement> dijtetelek = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(3)"));

        for (int i = 0; i < dijtetelek.size(); i++) {
            System.out.println(i + 1);
            if (dijtetelek.get(i).getText().trim().equals("Új díjtétel1")) {
                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-cell a.btn")).click();
                break;
            }
        }
        Wait();
    }

    public void dijtetelEroforrasSzerkesztese() {
        List<WebElement> dijtetelGep= webDriver.findElements(By.cssSelector("m-gep-ora.ng-star-inserted"));
        List<WebElement> dijtetelHuman= webDriver.findElements(By.cssSelector("m-human-ora.ng-star-inserted"));

        for (int i = 0; i < dijtetelGep.size(); i++) {

            webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child("+(i+1)+") input[name=oraSzam]")).clear();
            webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child("+(i+1)+") input[name=oraSzam]")).sendKeys("1");
        }

        for (int j = 0; j < dijtetelHuman.size(); j++) {


            webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child("+(j+1)+") input[name=oraSzam]")).clear();
            webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child("+(j+1)+") input[name=oraSzam]")).sendKeys("1");
        }

        this.webDriver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();

        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).clear();
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys("Új díjtétel1", Keys.ENTER);

        Wait();
        List<WebElement> dijtetelek = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(3)"));

        for (int i = 0; i < dijtetelek.size(); i++) {
            System.out.println(i + 1);
            if (dijtetelek.get(i).getText().trim().equals("Új díjtétel1")) {
                //össz költésg
                Assert.assertTrue(webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") mat-cell:nth-child(7)")).getText().equals("85 800"));
                System.out.println(webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") mat-cell:nth-child(7)")).getText());
                break;

            }
        }

    }

    public void dijtetelEroforrasTorlese() {
        List<WebElement> dijtetelGep= webDriver.findElements(By.cssSelector("m-gep-ora.ng-star-inserted"));
        List<WebElement> dijtetelHuman= webDriver.findElements(By.cssSelector("m-human-ora.ng-star-inserted"));

        for (int i = 0; i < dijtetelGep.size(); i++) {

            webDriver.findElement(By.cssSelector("m-gep-ora.ng-star-inserted:nth-child(1) .m-portlet__nav-link")).click();
            Wait();
        }

        for (int j = 0; j < dijtetelHuman.size(); j++) {

            webDriver.findElement(By.cssSelector("m-human-ora.ng-star-inserted:nth-child(1) .m-portlet__nav-link")).click();
            Wait();
        }

        this.webDriver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        this.webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
        Assert.assertTrue(this.webDriver.findElement(By.cssSelector("mat-dialog-container .hiba-dialog__szoveg")).isDisplayed()
                && this.webDriver.findElement(By.cssSelector("mat-dialog-container .hiba-dialog__szoveg")).getText().equals("Validációs hiba!") );
    }

    public void lapozasEllenorzesedijtetelek() {
        this.webDriver.findElement(By.cssSelector("div.m-portlet:nth-of-type(3) mat-select")).click();
        this.webDriver.findElement(By.cssSelector("mat-option:nth-of-type(1)")).click();
        List<WebElement> fejezetkLista = webDriver.findElements(By.cssSelector("mat-row mat-cell:nth-of-type(3)"));
        if (fejezetkLista.size() > 5) {
            Assert.fail();
        } else {
            List<WebElement> olda11 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(3)"));

            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            Wait();

            List<WebElement> oldal2 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(3)"));

            if (olda11.equals(oldal2)) {
                Assert.fail();
            }

        }
    }

    public void dijtetelsorValasztasaAktivIdozitett() {
        webDriver.findElement(By.cssSelector("m-dijtetelsor-valaszto .mat-select")).click();
        List<WebElement> dijtetelsorValaszto = webDriver.findElements(By.cssSelector(".mat-option"));

        for (WebElement element : dijtetelsorValaszto) {
            if (element.getText().contains("Időzített")) {
                element.click();
                break;
            }
        }

        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(3)"));

        webDriver.findElement(By.cssSelector("m-dijtetelsor-valaszto .mat-select")).click();
        for (WebElement element : dijtetelsorValaszto) {
            if (element.getText().contains("Aktív")) {
                element.click();
                break;
            }
        }

        List<WebElement> keresesEredmenye2 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(3) mat-cell.mat-cell:nth-child(3)"));

        if(keresesEredmenye.equals(keresesEredmenye2))
        {
            Assert.fail("A két lista ugyan az!");
        }
    }

    public void dijtetelKeresese(String dijtetelMegnevezes) {
        webDriver.findElement(By.cssSelector("mat-form-field:nth-of-type(2) input")).sendKeys(dijtetelMegnevezes, Keys.ENTER);
        Wait();

        List<WebElement> dijtetelek = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(3)"));

        for (int i = 0; i < dijtetelek.size(); i++) {
            System.out.println(i + 1);
            if (dijtetelek.get(i).getText().trim().equals(dijtetelMegnevezes)) {
                webDriver.findElement(By.cssSelector("mat-row:nth-of-type(" + (i + 1) + ") .mat-cell a.btn")).click();
                break;
            }
        }
    }
}