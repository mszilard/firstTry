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
    public void ujGepHozzaadasaHelyesUid5984ee07d50047efba76aac61520103e() {
        ujGepHozzaadasa("Gép 1", 1000);
    }

    @Test
    public void ujGepHozzaadasaHelytelenUidec1d2326b2d149ee9ccc15afd8ba13bc() {
        ujGepHozzaadasa("$ß$ß", 0);
    }

    @Test
    public void ujGepHozzaadasaHelyes2Uiddec42d1bd62c460d941cfa73a1bde054() {
        ujGepHozzaadasa("Gép 2", 1000);
    }

    @Test
    public void ujGepHozzaadasaHelyes3Uid3776acb7c3b047b7af0fcced6ef432f0() {
        ujGepHozzaadasa("Gép 3", 1500);
    }
}