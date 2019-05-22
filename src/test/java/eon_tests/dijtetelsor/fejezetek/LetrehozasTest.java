package eon_tests.dijtetelsor.fejezetek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void fejezetLetrehozasa(String sorszam, String megnevezes, String rovidnev, String humanSzorzo, String gepSzorzo) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.ujFejezetLetrehozasa(sorszam, megnevezes, rovidnev, humanSzorzo, gepSzorzo);
        actionwords.fejezetLetrejottenekEllenorzese(megnevezes);
    }

    @Test
    public void fejezetLetrehozasaHelyesAdatokkalUidfcc2b4417aa649efa5bb822cbfa1f846() {
        fejezetLetrehozasa("1", "Teszt fejezet", "TF", "s1", "s1");
    }

    @Test
    public void fejezetLetrehozasaHelytelenAdatokkalUida828a22d34e745ed975dd1110dee27c6() {
        fejezetLetrehozasa("101", "", "GT", "s3", "s3");
    }
}