package eon_tests.dijtetelsor.fejezetek;

import eon_tests.Actionwords;
import org.testng.annotations.*;

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
    public void fejezetekKereseseKeresesHelyesParameterekkel() {
        fejezetekKeresese(1, "Teszt Fejezet");
    }

    @Test
    public void fejezetekKereseseKeresesHelytelenParameterekkel() {
        fejezetekKeresese(120, "qwwe");
    }
}