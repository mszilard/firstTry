package eon_tests.dijtetelsor.dijtetelek;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void dijtetelSzerkesztesetorzs() {
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
        actionwords.dijtetelReszletek(dijtetelNeve);
        actionwords.dijtetelEroforrasSzerkesztese();
    }

    @Test
    public void dijtetelSzerkeszteseEroforrasDijtetelMegnevezes() {
        dijtetelSzerkeszteseEroforras("Új dijtétel1");
    }


    public void dijtetelSzerkeszteseUtolsoEroforras(String dijtetelMegnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelReszletek(dijtetelMegnevezes);
        actionwords.dijtetelEroforrasTorlese();
    }

    @Test
    public void dijtetelSzerkeszteseUtolsoEroforrasDijtetelNeve() {
        dijtetelSzerkeszteseUtolsoEroforras("Új dijtétel1");
    }
}