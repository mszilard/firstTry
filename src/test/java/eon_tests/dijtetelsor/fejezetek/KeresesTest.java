package eon_tests.dijtetelsor.fejezetek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class KeresesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void fejezetekKeresese(int sorszam, String megnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.fejezetKeresese(sorszam, megnevezes);
    }

    @Test
    public void fejezetekKereseseKeresesHelyesParameterekkelUidfab81373b5ff4021858b85acbb61049b() {
        fejezetekKeresese(1, "Teszt Fejezet");
    }

    @Test
    public void fejezetekKereseseKeresesHelytelenParameterekkelUidd5434a55ebb840549dc2d7d7df26db82() {
        fejezetekKeresese(120, "qwwe");
    }
}