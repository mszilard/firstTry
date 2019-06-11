package eon_tests.dijtetelsor.humaneroforras;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void humanEroforrasLetrehozasa(String megnevezes, int oradij) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.ujHumanEroforrasHozzaadas(megnevezes, oradij);
        actionwords.humanLetrejottenekEllenorzese(megnevezes);
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkal() {
        humanEroforrasLetrehozasa("Humán 1", 2000);
    }

    @Test
    public void humanEroforrasLetrehozasaHelytelenAdatokkal() {
        humanEroforrasLetrehozasa("$", 0);
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkal2() {
        humanEroforrasLetrehozasa("Humán 2", 2000);
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkal3() {
        humanEroforrasLetrehozasa("Humán 3", 1000);
    }
}