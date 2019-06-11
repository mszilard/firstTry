package eon_tests.anyagkezeles;

import org.testng.annotations.*;

public class AnayaglistaValidalasaTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void listaValidalasa(String fajlMegnevezese, String fajlMegnevezeseKiterjesztesNelkul, String anyagNev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.anyagkezeles();
        actionwords.ujAnyaglistaHozzaadasa(fajlMegnevezese);
        actionwords.anyagokvaltozotetelekValidalasa(fajlMegnevezese);
        actionwords.anyaglistaAktivalasa(fajlMegnevezeseKiterjesztesNelkul);
        actionwords.aktivaltAnyagvaltozolistaEllenorzese(anyagNev);
    }

    @Test
    public void listaValidalasaFeltoltendoAllomanyUid5b665c5da38449b6b3e3b3eb39a554b9() {
        listaValidalasa("anyag_aram_linkkel_validalando.xlsx", "anyag_aram_linkkel_validalando", "Új anyag 2");
    }
}