package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void humanEroforrasLetrehozasa(String megnevezes, String oradij) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.ujHumanEroforrasHozzaadas(megnevezes, oradij);
        actionwords.humanLetrejottenekEllenorzese(megnevezes);
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkalUid2cd740144dc049059052d1d097aa4476() {
        humanEroforrasLetrehozasa("Humán 1", "2000");
    }

    @Test
    public void humanEroforrasLetrehozasaHelytelenAdatokkalUid57e8764479a54eb8bb24244551e40791() {
        humanEroforrasLetrehozasa("$", "");
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkal2Uid6adc96615fb54e8fb540fa7f0164c957() {
        humanEroforrasLetrehozasa("Humán 2", "2000");
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkal3Uid85d9f0f43a0644d4bcc435fc04a757db() {
        humanEroforrasLetrehozasa("Humán 3", "1000");
    }
}