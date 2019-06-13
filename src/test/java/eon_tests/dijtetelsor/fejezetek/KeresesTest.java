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
    public void fejezetekKereseseKeresesHelyesParameterekkelUid53d3032076834447be9cd6a05dd3023a() {
        fejezetekKeresese(1, "Teszt Fejezet");
    }

    @Test
    public void fejezetekKereseseKeresesHelytelenParameterekkelUid57cb82efe0aa41ecb8ab7c5ebfc4e806() {
        fejezetekKeresese(120, "qwwe");
    }
}