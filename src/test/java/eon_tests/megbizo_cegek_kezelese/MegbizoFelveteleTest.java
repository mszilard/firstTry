package eon_tests.megbizo_cegek_kezelese;

import org.testng.annotations.*;

public class MegbizoFelveteleTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void ujMegbizoFelvetele(String rovidNev, String teljesNev, String telepules, String vallalat, String felelos, String fejleszto, String tervezo) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Megbizo cegek
        actionwords.megbizoCegek();
        // And Uj megbizo felvetele "<rovid_nev>" "<teljes_nev>" "<telepules>" "<vallalat>" "<felelos>" "<fejleszto>" "<tervezo>"
        actionwords.ujMegbizoFelvetele(rovidNev, teljesNev, telepules, vallalat, felelos, fejleszto, tervezo);
        // Then Megbizo letrejottenek ellenorzese "<rovid_nev>" "<teljes_nev>"
        actionwords.megbizoLetrejottenekEllenorzese(rovidNev, teljesNev);
    }

    @Test
    public void ujMegbizoFelveteleFelvetelHelyesAdatokkalUida677de52a966440aa37b51863572abb7() {
        ujMegbizoFelvetele("ETA", "E.ON Tiszántúli Áramhálózat Zrt.", "Debrecen", "E.ON Tiszántúli Áramhálózati Zrt.", "Felelos", "fejleszto", "tervezo");
    }

    @Test
    public void ujMegbizoFelveteleFelvetelHelytelenAdatokkalUid808381b17fbf4e7da88b629409cb641c() {
        ujMegbizoFelvetele("E.ON ", "", "Győr", "E.ON Tiszántúli Áramhálózati Zrt.", "", "", "");
    }
}