package eon_tests.dijtetelsor.fejezetek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

import java.io.IOException;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void fejezetLetrehozasa(int sorszam, String megnevezes, String rovidnev, int humanSzorzo, int gepSzorzo) throws IOException {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.ujFejezetLetrehozasa(sorszam, megnevezes, rovidnev, humanSzorzo, gepSzorzo);
        actionwords.fejezetLetrejottenekEllenorzese(megnevezes);
    }

    @Test
    public void fejezetLetrehozasaHelyesAdatokkalUid31b10c10251b4f75916f1b3b1b5dbb9c() throws IOException {
        fejezetLetrehozasa(1, "Teszt fejezet", "TF", 1, 1);
    }

    @Test
    public void fejezetLetrehozasaHelytelenAdatokkalUid12041dc1396a457f85b63009246b2b49() throws IOException {
        fejezetLetrehozasa(101, "", "GT", 33123123, 33123123);
    }
}