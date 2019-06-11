package eon_tests.dijtetelsor.dijtetelek;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class C_InaktivalasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void dijtetelInaktivalasa(String dijtetelNeve) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.dijtetelInaktivalasa(dijtetelNeve);
        actionwords.dijtetelInaktivalasEllenorzese(dijtetelNeve);
    }

    @Test
    public void dijtetelInaktivalasaDijtetelInaktivalasa() {
        dijtetelInaktivalasa("Új díjtétel1");
    }
}