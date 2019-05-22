package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void ujGepHozzaadasa(String megnevezes, String oradij) {
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
    public void ujGepHozzaadasaHelyesUiddb5e5087905145d19b36e696d7052e76() {
        ujGepHozzaadasa("Gép 1", "1000");
    }

    @Test
    public void ujGepHozzaadasaHelytelenUidf72df4f510d04a82ae441f561a7ff8b3() {
        ujGepHozzaadasa("$ß$ß", "");
    }

    @Test
    public void ujGepHozzaadasaHelyes2Uid7287a91a6d0f402ca9bb56f35d253fa7() {
        ujGepHozzaadasa("Gép 2", "1000");
    }

    @Test
    public void ujGepHozzaadasaHelyes3Uid0d2c4e9dc4d44df098d62623d0883f48() {
        ujGepHozzaadasa("Gép 3", "1500");
    }
}