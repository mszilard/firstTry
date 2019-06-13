package eon_tests.dijtetelsor.dijtetelek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class SzerkesztesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void dijtetelSzerkesztesetorzs(String szerkesztendoDijtetel, String ujMegnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelSzerkesztese(szerkesztendoDijtetel, ujMegnevezes);
        actionwords.dijtetelSzerkesztesEllenorzese(ujMegnevezes);
    }

    @Test
    public void dijtetelSzerkesztesetorzsNevSzerkesztesUid61d74fe0f36d48d396b031d3d0dc3133() {
        dijtetelSzerkesztesetorzs("Díjtétel 1", "Szerkesztett Díjtétel");
    }


    public void dijtetelSzerkeszteseEroforras(String dijtetelNeve, String vartOsszeg) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelReszletek(dijtetelNeve);
        actionwords.dijtetelEroforrasSzerkesztese(vartOsszeg);
    }

    @Test
    public void dijtetelSzerkeszteseEroforrasDijtetelMegnevezesUid9b85c07af92a4a619e1bd5d32ed9fc03() {
        dijtetelSzerkeszteseEroforras("Új dijtétel1", "85 800 Ft");
    }


    public void dijtetelSzerkeszteseUtolsoEroforras(String dijtetelMegnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelReszletek(dijtetelMegnevezes);
        actionwords.dijtetelEroforrasTorlese();
    }

    @Test
    public void dijtetelSzerkeszteseUtolsoEroforrasDijtetelNeveUidf4984dff6ecb453c8f80ad42cae27261() {
        dijtetelSzerkeszteseUtolsoEroforras("Új dijtétel1");
    }
}