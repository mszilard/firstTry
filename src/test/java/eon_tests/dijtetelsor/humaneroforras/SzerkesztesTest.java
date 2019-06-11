package eon_tests.dijtetelsor.humaneroforras;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void humanEroforrasSzerkesztese(String megnevezes, int oradij, String szerkesztendo) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.humanEroforrasSzerkesztese(megnevezes, oradij, szerkesztendo);
        actionwords.humanEroforrasSzerkesztesEllenorzese(megnevezes);
    }

    @Test
    public void humanEroforrasSzerkeszteseSzerkesztesHelyesen() {
        humanEroforrasSzerkesztese("Humán 01", 2800, "Humán 1");
    }

    @Test
    public void humanEroforrasSzerkeszteseSzerkesztesHelytelenul() {
        humanEroforrasSzerkesztese("...-.", 0, "Humán 2");
    }
}