package eon_tests.dijtetelsor.dijtetelek;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class D_KeresesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void dijtetelekLapozomodulEllenorzese() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.lapozasEllenorzesedijtetelek();
    }

    @Test
    public void dijtetelekDijtetelsorValasztas() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelsorValasztasaAktivIdozitett();
    }
    public void dijtetelKereses(String dijtetelMegnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelKeresese(dijtetelMegnevezes);
    }

    @Test
    public void dijtetelKeresesKereses() {
        dijtetelKereses("Új díjtétel1");
    }
}