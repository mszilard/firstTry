package eon_tests.dijtetelsor.dijtetelsorok;

import org.testng.annotations.*;
import eon_tests.Actionwords;

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
    public void dijtetelsorSzerkeszteseSzerkesztesUide7470e70f34245b29644a9f0dd907b5f() {
        dijtetelsorSzerkesztese("Ditetelsor-Teszt", "Ditetelsor-Teszt 1");
    }
}