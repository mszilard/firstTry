package eon_tests.dijtetelsor.dijtetelek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class InaktivalasTest {

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
    public void dijtetelInaktivalasaDijtetelInaktivalasaUid45c6831bda1d44e48e19475d759cc5ab() {
        dijtetelInaktivalasa("Új díjtétel2");
    }
}