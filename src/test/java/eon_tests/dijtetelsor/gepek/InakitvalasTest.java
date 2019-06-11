package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class InakitvalasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void gepInaktivalasaNemMegfeleloFeltetellel(String gepMegnevezese) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasHelytelenInaktivalas(gepMegnevezese);
    }

    @Test
    public void gepInaktivalasaNemMegfeleloFeltetellelInaktivalandoGepUid1e455dac6d774d099cd2804db5b7b89c() {
        gepInaktivalasaNemMegfeleloFeltetellel("Teszt-Gép 1");
    }


    public void gepInaktivalas(String gepMegnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasInaktivalasa(gepMegnevezes);
        actionwords.eroforrasInaktivalasEllenorzese(gepMegnevezes);
    }

    @Test
    public void gepInaktivalasInaktivalandoGepUidf37aa90d40cb469eadb5ffceb07a70f9() {
        gepInaktivalas("Teszt-Gép 1");
    }
}