package eon_tests.sugo_kezeles;

import org.testng.annotations.*;

public class MuveletekTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void sugoTorlese(String torlendoTemakor, String torlendoCsoport) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Sugo
        actionwords.sugo();
        // And Sugo - Szerkesztes
        actionwords.sugoSzerkesztes();
        // And Temakor torlese "<torlendo_temakor>"
        actionwords.temakorTorlese(torlendoTemakor);
        // Then Csoport torlese "<torlendo_csoport>"
        actionwords.csoportTorlese(torlendoCsoport);
    }

    @Test
    public void sugoTorleseTorles1Uidcf78d31e93314a49b064257796a58309() {
        sugoTorlese("Teszt témakör 2.1", "Teszt csoport 2");
    }


    public void sugoSzerkesztese(String szerkesztendoCsoport, String ujCsoport, String temakorNeve, String temakorLeirasa) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Sugo
        actionwords.sugo();
        // And Sugo - Szerkesztes
        actionwords.sugoSzerkesztes();
        // And Csoport szerkesztese "<szerkesztendo_csoport>" "<uj_csoport>"
        actionwords.csoportSzerkesztese(szerkesztendoCsoport, ujCsoport);
        // And Temakorok szerkesztese "<temakor_neve>" "<temakor_leirasa>"
        actionwords.temakorokSzerkesztese(temakorNeve, temakorLeirasa);
        // Then Szerkesztes ellenorzese "<uj_csoport>"
        actionwords.szerkesztesEllenorzese(ujCsoport);
    }

    @Test
    public void sugoSzerkeszteseSzerkesztes1Uid82513ce8ac204210acf41146fd2da472() {
        sugoSzerkesztese("Teszt csoport 1", "Szerkesztett csoport", "Szerkesztett témakör", "Szerkesztett témakör leírás");
    }


    public void sugoLetrehozasa(String csoportNeve, String temakorNeve1, String temakorLeirasa1, String temakorNeve2, String temakorLeirasa2) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Sugo
        actionwords.sugo();
        // And Sugo - Szerkesztes
        actionwords.sugoSzerkesztes();
        // And Uj csoport letrehozasa "<csoport_neve>"
        actionwords.ujCsoportLetrehozasa(csoportNeve);
        // And Uj temakorok megadasa "<temakor_neve_1>" "<temakor_leirasa_1>" "<temakor_neve_2>" "<temakor_leirasa_2>"
        actionwords.ujTemakorokMegadasa(temakorNeve1, temakorLeirasa1, temakorNeve2, temakorLeirasa2);
        // Then Csoport/temakor letrejottenek ellenorzese "<csoport_neve>"
        actionwords.csoporttemakorLetrejottenekEllenorzese(csoportNeve);
    }

    @Test
    public void sugoLetrehozasaBejegyzes1Uidc9157fd7bf9841f58b03140c381d4cf3() {
        sugoLetrehozasa("Teszt csoport 1", "Teszt témakör 1.1", "Témakör leírása", "Teszt témakör 2.1", "Témakör leírása");
    }

    @Test
    public void sugoLetrehozasaBejegyzes2Uidad603d1c102940299c03a07c509ce800() {
        sugoLetrehozasa("Teszt csoport 2", "Teszt témakör 1.2", "Témakör leírása", "Teszt témakör 2.2", "Témakör leírása");
    }
}