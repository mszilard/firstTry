package eon_tests.dijtetelsor.fejezetek;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class B_SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void fejezetSzerkesztese(int sorszam, String megnevezes, String rovidnev, int humanSzorzo, int gepSzorzo, String szerkesztendoMegnev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.fejezetReszletek(szerkesztendoMegnev);
        actionwords.fejezetSzerkesztese(sorszam, megnevezes, rovidnev, humanSzorzo, gepSzorzo);
        actionwords.fejezetSzerkesztesenekEllenorzese(megnevezes);
    }

    @Test
    public void fejezetSzerkeszteseHelyesAdatokkal() {
        fejezetSzerkesztese(1, "Teszt Fejezet", "TF", 1, 1, "Teszt fejezet");
    }

    @Test
    public void fejezetSzerkeszteseHelytelenAdatokkal() {
        fejezetSzerkesztese(200, "", "TF", 0, 0, "");
    }
}