package eon_tests.dijtetelsor.fejezetek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class SzerkesztesTest {

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

    @Test(priority = 1)
    public void fejezetSzerkeszteseHelyesAdatokkalUid471a37668825470982269242fe5f9635() {
        fejezetSzerkesztese(1, "Teszt Fejezet", "TF", 1, 1, "Teszt fejezet");
    }

    @Test(priority = 2)
    public void fejezetSzerkeszteseHelytelenAdatokkalUid4bd273b9865b40cbb437ee9bd4d9b417() {
        fejezetSzerkesztese(200, "", "TF", 0, 0, "Teszt Fejezet");
    }
}