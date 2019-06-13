package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

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
    public void humanEroforrasLetrehozasaHelyesAdatokkalUidcbd8052dbaca48a2b0bc92d428517fc5() {
        humanEroforrasLetrehozasa("Humán 1", 2000);
    }

    @Test
    public void humanEroforrasLetrehozasaHelytelenAdatokkalUidf3d43b6c68004f9689decbbb6ddece20() {
        humanEroforrasLetrehozasa("$", 0);
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkal2Uid00229d1ba9714f2cb01dade90928ab00() {
        humanEroforrasLetrehozasa("Humán 2", 2000);
    }

    @Test
    public void humanEroforrasLetrehozasaHelyesAdatokkal3Uid5661eaf96546441e8eb13b000a4a09a1() {
        humanEroforrasLetrehozasa("Humán 3", 1000);
    }
}