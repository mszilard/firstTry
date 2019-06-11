package eon_tests.anyagkezeles;


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
    private String anyaglista = currentPath.toAbsolutePath().toString() + "\\feltoltendo\\anyaglista\\";
    private String valtozoLista = currentPath.toAbsolutePath().toString() + "\\feltoltendo\\valtozoLista\\";


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

    }


    public void anyagkezeles() {
        Wait();
        webDriver.findElement(By.cssSelector("li a[href*=anyagok]")).click();
    }

    public void ujAnyaglistaHozzaadasa(String allomanyNeve) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        webDriver.findElement(By.cssSelector("input[type=file]")).sendKeys(anyaglista+allomanyNeve);
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();


    }

    public void anyagvaltozolistaFeltoltesreKerul(String allomanyNeve) {

        List<WebElement> anyaglistak = webDriver.findElements(By.cssSelector(" mat-row mat-cell:nth-of-type(1)"));

        for (WebElement element : anyaglistak) {
            if (element.getText().equals(allomanyNeve)) {

                System.out.println(element.getText());
            }
        }

        //todo új ellenőrzés írása a lista létrejöttének ellenőrzéséhez


//        System.out.println(anyaglistak.size());
//        for (int i = 0; i < anyaglistak.size(); i++) {
//            System.out.println(i + 1);
//            if (!anyaglistak.get(i).getText().trim().equals(allomanyNeve ))
//            {
//                Assert.fail("Fájl feltöltése nem sikerült formailag helyes álománnyal sem.");
//            }
//        }


    }

    public void aRendszerHibauzenettelValaszol() {


        Assert.assertTrue(this.webDriver.findElement(By.cssSelector("mat-dialog-container .hiba-dialog__szoveg")).isDisplayed()
                && this.webDriver.findElement(By.cssSelector("mat-dialog-container .hiba-dialog__szoveg")).getText().equals("Helytelen fájlformátum!"));

    }

    public void anyagokvaltozotetelekValidalasa(String fajlMegnevezes) {
        Wait();

        List<WebElement> anyagListak = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(1)"));
        List<WebElement> anyagGomb = webDriver.findElements(By.cssSelector("mat-cell.mat-cell:nth-child(4)"));


        for (int i = 0; i < anyagListak.size(); i++) {
            if (anyagListak.get(i).getText().trim().equals(fajlMegnevezes) &&
                    anyagGomb.get(i).getText().equals("Validálás")) {
                webDriver.findElement(By.cssSelector(".mat-row:nth-of-type("+(i+1)+") mat-cell:nth-child(4) a.btn")).click();
                break;
            }
        }
        Wait();

        String max = webDriver.findElement(By.cssSelector(".mat-paginator-range-label")).getText();
        String[] split = max.split(" ");
        int m = Integer.parseInt(split[4]);
         Random random = new Random();
        int csere = 0;


        for (int j = 0; j < m; j++) {

             String gomb = webDriver.findElement(By.cssSelector("mat-row:nth-of-type(1) a.btn")).getText();


                if (gomb.contains("jóváhagyás")) {
                    webDriver.findElement(By.cssSelector("mat-row:nth-of-type(1) a.btn")).click();
                    System.out.println("ASSAAA");
                    webDriver.findElement(By.cssSelector("mat-dialog-container input")).sendKeys(String.valueOf(1000));
                    webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
                    Wait();
                }

                if (gomb.equals("Cserél")) {
                    if (csere == 0) {
                        System.out.println("Csere");
                        webDriver.findElement(By.cssSelector("mat-row:nth-of-type(1) a.btn")).click();
                        webDriver.findElement(By.cssSelector("input[name=anyagId]")).sendKeys("Acéllemez 6mm");
                        Wait();
                        List<WebElement> csereAnyag = webDriver.findElements(By.cssSelector("span.mat-option-text"));
                        Wait();
                        for (WebElement elements : csereAnyag) {

                            if (elements.getText().equals("Acéllemez 6mm bordás")) {
                                elements.click();
                                break;
                            }
                        }
                        webDriver.findElement(By.cssSelector(".mat-dialog-actions button:nth-of-type(1)")).click();
                        Wait();
                    }
                    if (csere == 1) {
                        System.out.println("Inaktiválás");
                        webDriver.findElement(By.cssSelector("mat-row:nth-of-type(1) a.btn")).click();
                        webDriver.findElement(By.cssSelector("mat-dialog-container h1")).click();
                        Wait();
                        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary:nth-of-type(3)")).click();
                        Wait();

                    }

                }

            }
    }


    public void anyaglistaAktivalasa(String fajlMegnevezeseKiterjesztesNelkul) {

        webDriver.findElement(By.cssSelector("div.m-subheader a[href*=anyagok]")).click();

        List<WebElement> fileList = webDriver.findElements(By.cssSelector("mat-cell a.btn"));
        Assert.assertTrue(fileList.size() > 1);

        for (WebElement element : fileList) {
            if (element.getText().equals("Aktiválás")) {
                element.click();
                break;
            }
        }
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container button:nth-of-type(3)")).click();
    }

    public void aktivaltAnyagvaltozolistaEllenorzese(String anyagNev) {

        Wait();
        List<WebElement> fileList = webDriver.findElements(By.cssSelector("mat-cell a.btn"));
        Assert.assertTrue(fileList.size() == 1);

        for (WebElement element : fileList) {
            if (element.getText().equals("Részletek")) {
                element.click();
                break;
            }
        }
        Wait();
        webDriver.findElement(By.cssSelector("mat-form-field input")).sendKeys(anyagNev, Keys.ENTER);
        Wait();

        List<WebElement> keresesEredmenye = webDriver.findElements(By.cssSelector("div.m-portlet:nth-child(2) mat-cell.mat-cell:nth-child(2)"));

        for (int i = 0; i < keresesEredmenye.size(); i++) {
            System.out.println(keresesEredmenye.get(i).getText());
            if (keresesEredmenye.get(i).getText().trim().equals(anyagNev)) {
                System.out.println("Keresett anyag megtalálva");
                break;
            }else{
                System.out.println("Nincs találat az anyagra");
            }
        }
    }

    public void aktivAnyagvaltozolistaReszletek() {

        List<WebElement> fileList = webDriver.findElements(By.cssSelector("mat-cell a.btn"));
        Assert.assertTrue(fileList.size() == 1);

        for (WebElement element : fileList) {
            if (element.getText().equals("Részletek")) {
                element.click();
                break;
            }
        }
        List<WebElement> listaElem = webDriver.findElements(By.cssSelector("div.m-portlet:nth-child(2) mat-row"));
        if(listaElem.size()==0){
            Assert.fail("Hibás lista: 0 anyag szerepel a listán");
        }



    }

    public void lapozasEllenorzeseAnyagokValtozotetelek() {

        this.webDriver.findElement(By.cssSelector("div.mat-paginator-container .mat-select-value")).click();
        this.webDriver.findElement(By.cssSelector("mat-option:nth-of-type(1)")).click();
        List<WebElement> anyagokLista = webDriver.findElements(By.cssSelector("mat-row mat-cell:nth-of-type(1)"));
        if (anyagokLista.size() > 5) {
            Assert.fail("Vártnál több elem jelenik meg");
        } else {
            List<WebElement> olda11 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(1) mat-cell.mat-cell:nth-child(1)"));
            webDriver.findElement(By.cssSelector("button.mat-paginator-navigation-next")).click();
            Wait();
            List<WebElement> oldal2 = webDriver.findElements(By.cssSelector("div.m-portlet:nth-of-type(1) mat-cell.mat-cell:nth-child(1)"));

            if (olda11.equals(oldal2)) {
                Assert.fail("Hibás lapozó modul: Két oldal elemei megegyeznek");
            }

        }
    }

    public void valtozotetelek() {
        Wait();
        webDriver.findElement(By.cssSelector("li a[href*=valtozoanyagok]")).click();
    }

    public void ujValtozolistaHozzaadasa(String allomanyNeve) {
        this.webDriver.findElement(By.cssSelector("div.m-subheader a.btn")).click();
        Wait();
        webDriver.findElement(By.cssSelector("input[type=file]")).sendKeys(valtozoLista+allomanyNeve);
        webDriver.findElement(By.cssSelector("mat-dialog-container button.btn-primary")).click();
        Wait();
    }

    public void valtozolistaAktivalasa(String fajlMegnevezese) {
        webDriver.findElement(By.cssSelector("div.m-subheader a[href*=valtozoanyagok]")).click();

        List<WebElement> fileList = webDriver.findElements(By.cssSelector("mat-cell a.btn"));
        Assert.assertTrue(fileList.size() > 1);

        for (WebElement element : fileList) {
            if (element.getText().equals("Aktiválás")) {
                element.click();
                break;
            }
        }
        Wait();
        webDriver.findElement(By.cssSelector("mat-dialog-container button:nth-of-type(3)")).click();
    }
}