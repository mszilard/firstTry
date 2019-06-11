package eon_tests.valtozotetel;

import org.testng.annotations.*;
import eon_tests.anyagkezeles.Actionwords;

public class ValtozolistaValidalasaTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void listaValtozotetelValidalasa(String fajlMegnevezese, String fajlMegnevezeseKiterjesztesNelkul, String tetelNev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.valtozotetelek();
        actionwords.ujValtozolistaHozzaadasa(fajlMegnevezese);
        actionwords.anyagokvaltozotetelekValidalasa(fajlMegnevezese);
        actionwords.valtozolistaAktivalasa(fajlMegnevezese);
        actionwords.aktivaltAnyagvaltozolistaEllenorzese(tetelNev);
    }

    @Test
    public void listaValtozotetelValidalasaFeltoltendoAllomanyUid8ca063a5252649b583a5fdaca61a904a() {
        listaValtozotetelValidalasa("vtetel_validalando.xlsx", "vtetel_validalando", "Új tétel 2");
    }
}