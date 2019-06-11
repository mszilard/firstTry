package eon_tests.dijtetelsor.fejezetek;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void fejezetLetrehozasa(int sorszam, String megnevezes, String rovidnev, String humanSzorzo, String gepSzorzo) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.ujFejezetLetrehozasa(sorszam, megnevezes, rovidnev, humanSzorzo, gepSzorzo);
        actionwords.fejezetLetrejottenekEllenorzese(megnevezes);
    }

    @Test
    public void fejezetLetrehozasaHelyesAdatokkal() {
        fejezetLetrehozasa(1, "Teszt fejezet", "TF", "s1", "s1");
    }

    @Test
    public void fejezetLetrehozasaHelytelenAdatokkal() {
        fejezetLetrehozasa(101, "", "GT", "s3", "s3");
    }
}