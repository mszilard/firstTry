package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void gepSzerkesztese(String megnevezes, int oradij, String szerkesztendo) {
        // A gép alapadatainak szerkesztése, változtatás esetén az új adatok frissítésre kerülnek az érintett díjtételeken, díjtételsorokon, modelleken, projekteken.
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dijtetelsor
        actionwords.dijtetelsor();
        // And Dijtetelsor-Gepek
        actionwords.dijtetelsorGepek();
        // And Gep reszletek(szerkesztes) "<megnevezes>" "<oradij>" "<szerkesztendo>"
        actionwords.gepReszletekszerkesztes(megnevezes, oradij, szerkesztendo);
        // Then Gep szerkesztesenek ellenorzese "<megnevezes>"
        actionwords.gepSzerkesztesenekEllenorzese(megnevezes);
    }

    @Test
    public void gepSzerkeszteseSzerkesztesHelyesAdatokkalUida5bce23548624d2ab94ed22d510cc7b7() {
        gepSzerkesztese("Teszt-Gép 1", 2000, "Gép 1");
    }

    @Test
    public void gepSzerkeszteseSzerkesztesHelytelenAdatokkalUid2e4f33255bb8403c88585e96c4451d2f() {
        gepSzerkesztese(".", 0, "Teszt-Gép 1");
    }
}