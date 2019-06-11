package eon_tests.megbizo_cegek_kezelese;

import org.testng.annotations.*;

public class MegbizoSzerkeszteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void megbizoSzerkesztese(String valasztandoMegbizo, String rovidNev, String teljesNev, String telepules, String vallalat, String torlendoFelhasznalo) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Megbizo cegek
        actionwords.megbizoCegek();
        // And Megbizo reszletek "<valasztando_megbizo>"
        actionwords.megbizoReszletek(valasztandoMegbizo);
        // And Megbizo szerkesztese "<rovid_nev>" "<teljes_nev>" "<telepules>" "<vallalat>" "<torlendo_felhasznalo>"
        actionwords.megbizoSzerkesztese(rovidNev, teljesNev, telepules, vallalat, torlendoFelhasznalo);
        // Then Megbizo szerkesztesenek ellenorzese "<teljes_nev>"
        actionwords.megbizoSzerkesztesenekEllenorzese(teljesNev);
    }

    @Test
    public void megbizoSzerkeszteseSzerkesztesHelyesenUidb2b01db5b0a243f3b37095542e008029() {
        megbizoSzerkesztese("E.ON Tiszántúli Áramhálózat Zrt.", "ETAZ", "E.ON Áramhálózat Zrt.", "Győr", "E.ON Dél-dunántúli Gázhálózati Zrt.", "aram_tervezo");
    }

    @Test
    public void megbizoSzerkeszteseSzerkesztesHelytelenulUidb3158fa9fe8b4110b1d5e5a631677d8f() {
        megbizoSzerkesztese("E.ON Áramhálózat Zrt.", "", "E.ON Áramhálózat 123 Zrt.", "Debrecen", "E.ON Tiszántúli Áramhálózati Zrt.", "aram fejleszto");
    }
}