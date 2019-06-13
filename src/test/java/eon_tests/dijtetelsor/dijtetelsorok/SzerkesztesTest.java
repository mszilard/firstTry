package eon_tests.dijtetelsor.dijtetelsorok;

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
    public void dijtetelsorSzerkeszteseSzerkesztesUid905a156dda9c41e1b522f11db57bebd9() {
        dijtetelsorSzerkesztese("Ditetelsor-Teszt", "Ditetelsor-Teszt 1");
    }
}