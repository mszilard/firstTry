package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void ujGepHozzaadasa(String megnevezes, int oradij) {
        // Új gép hozzáadása amely során nevet és óradíjat kell beállítani.
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dijtetelsor
        actionwords.dijtetelsor();
        // And Dijtetelsor-Gepek
        actionwords.dijtetelsorGepek();
        // And Uj gep hozzaadasa "<megnevezes>" "<oradij>"
        actionwords.ujGepHozzaadasa(megnevezes, oradij);
        // Then Gep letrejottenek ellenorzese "<megnevezes>"
        actionwords.gepLetrejottenekEllenorzese(megnevezes);
    }

    @Test
    public void ujGepHozzaadasaHelyesUid513cc751f82e40f2859dd4ae1818213a() {
        ujGepHozzaadasa("Gép 1", 1000);
    }

    @Test
    public void ujGepHozzaadasaHelytelenUidf7fc0aa6c0bf4d84be25ccf15dd7e547() {
        ujGepHozzaadasa("$ß$ß", 0);
    }

    @Test
    public void ujGepHozzaadasaHelyes2Uid7d004ea685634f5c8699060bc6f1a3d9() {
        ujGepHozzaadasa("Gép 2", 1000);
    }

    @Test
    public void ujGepHozzaadasaHelyes3Uidd43f5c516e5e425fa7d4046b252d3069() {
        ujGepHozzaadasa("Gép 3", 1500);
    }
}