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
    public void dijtetelekLapozomodulEllenorzeseUidef3a70a1fcab4325bd96eed6fa356b7a() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.lapozasEllenorzesedijtetelek();
    }

    @Test
    public void dijtetelekDijtetelsorValasztasUid2e640a073c174a2296976aeb0bf86376() {
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
    public void dijtetelKeresesKeresesUid4ca3367e9b624b3ebf7b8070a2ac1ca3() {
        dijtetelKereses("Új díjtétel1");
    }
}