package eon_tests.dijtetelsor.dijtetelek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class KeresesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void dijtetelekLapozomodulEllenorzeseUid119b301849274b5e83fa9c6ff795c3f9() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.lapozasEllenorzesedijtetelek();
    }

    @Test
    public void dijtetelekDijtetelsorValasztasUida92a672507414528a6d50fb9de725e4e() {
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
    public void dijtetelKeresesKeresesUid15666fdad8db41baaae64f11367b6e2c() {
        dijtetelKereses("Új díjtétel1");
    }
}