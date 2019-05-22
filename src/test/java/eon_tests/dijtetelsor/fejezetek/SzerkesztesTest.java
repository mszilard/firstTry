package eon_tests.dijtetelsor.fejezetek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void fejezetSzerkesztese(String sorszam, String megnevezes, String rovidnev, String humanSzorzo, String gepSzorzo, String szerkesztendoMegnev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.fejezetReszletek(szerkesztendoMegnev);
        actionwords.fejezetSzerkesztese(sorszam, megnevezes, rovidnev, humanSzorzo, gepSzorzo);
        actionwords.fejezetSzerkesztesenekEllenorzese(megnevezes);
    }

    @Test
    public void fejezetSzerkeszteseHelyesAdatokkalUidb19d16cb3ca845d3b134152e97aa2b75() {
        fejezetSzerkesztese("1", "Teszt Fejezet", "TF", "1", "1", "Teszt fejezet");
    }

    @Test
    public void fejezetSzerkeszteseHelytelenAdatokkalUidcb36f8706de14f36a011945ac790615d() {
        fejezetSzerkesztese("200", "", "TF", "0", "0", "");
    }
}