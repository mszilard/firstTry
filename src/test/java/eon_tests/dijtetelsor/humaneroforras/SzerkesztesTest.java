package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void humanEroforrasSzerkesztese(String megnevezes, String oradij, String szerkesztendo) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.humanEroforrasSzerkesztese(megnevezes, oradij, szerkesztendo);
        actionwords.humanEroforrasSzerkesztesEllenorzese(megnevezes);
    }

    @Test
    public void humanEroforrasSzerkeszteseSzerkesztesHelyesenUidc063291b9b464346be2f7c849bfb5b84() {
        humanEroforrasSzerkesztese("Humán 01", "2800", "Humán 1");
    }

    @Test
    public void humanEroforrasSzerkeszteseSzerkesztesHelytelenulUid8375fe4904104cdb869f7d1d2a476af4() {
        humanEroforrasSzerkesztese("...-.", "", "Humán 2");
    }
}