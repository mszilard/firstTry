package eon_tests.dijtetelsor.dijtetelsorok;

import eon_tests.dijtetelsor.dijtetelsorok.Actionwords;
import org.testng.annotations.*;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void dijtetelsorSzerkesztese(String regiNev, String ujNev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelsorok();
        actionwords.dijtetelsorReszletek(regiNev);
        actionwords.dijtetelsorSzerkesztese(ujNev);
        actionwords.dijtetelsorSzerkesztesenekEllenorzese(ujNev);
    }

    @Test
    public void dijtetelsorSzerkeszteseSzerkesztes() {
        dijtetelsorSzerkesztese("Ditetelsor-Teszt", "Ditetelsor-Teszt 1");
    }
}