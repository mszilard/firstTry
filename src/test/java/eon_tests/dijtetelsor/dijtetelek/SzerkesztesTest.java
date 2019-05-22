package eon_tests.dijtetelsor.dijtetelek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void dijtetelSzerkesztesetorzsUid3ceb04946a264e798751d57ef6ecdc94() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelSzerkesztese();
        actionwords.dijtetelSzerkesztesEllenorzese();
    }
    public void dijtetelSzerkeszteseEroforras(String dijtetelNeve) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelReszletek();
        actionwords.dijtetelEroforrasSzerkesztese();
    }

    @Test
    public void dijtetelSzerkeszteseEroforrasDijtetelMegnevezesUid1f1b3c010e1d4552aca8e5f31c284b05() {
        dijtetelSzerkeszteseEroforras("Új dijtétel1");
    }



    @Test
    public void dijtetelSzerkeszteseUtolsoEroforrasUid32a1b098e6894045b83f0111d760115d() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelReszletek();
        actionwords.dijtetelEroforrasTorlese();
    }
}