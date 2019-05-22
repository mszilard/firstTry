package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void gepSzerkesztese(String megnevezes, String oradij, String szerkesztendo) {
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
    public void gepSzerkeszteseSzerkesztesHelyesAdatokkalUid8273f9f5b139428d819a903522f53156() {
        gepSzerkesztese("Teszt-Gép 1", "2000", "Gép 1");
    }

    @Test
    public void gepSzerkeszteseSzerkesztesHelytelenAdatokkalUid29d4d690dd134be79ca30d7cdbaf4ecd() {
        gepSzerkesztese(".", "", "Teszt-Gép 1");
    }
}