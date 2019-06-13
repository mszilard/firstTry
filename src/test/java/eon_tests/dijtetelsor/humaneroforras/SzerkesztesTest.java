package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

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
    public void humanEroforrasSzerkeszteseSzerkesztesHelyesenUid41227445bbbe44a78fd3a7359da68c26() {
        humanEroforrasSzerkesztese("Humán 01", 2800, "Humán 1");
    }

    @Test
    public void humanEroforrasSzerkeszteseSzerkesztesHelytelenulUide046bf5860a241969cdf35b852b39eac() {
        humanEroforrasSzerkesztese("...-.", 0, "Humán 2");
    }
}