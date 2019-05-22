package eon_tests.dijtetelsor;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class GepekTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    // Azon díjtételek megjelenítése melyeken az adott gép erőforrásként szerepel.
    @Test
    public void kapcsolodoDijtetelekListazasagep() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        //actionwords.eroforrasReszletek();
    }
}