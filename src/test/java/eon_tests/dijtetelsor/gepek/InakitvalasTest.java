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
    public void gepInaktivalasaNemMegfeleloFeltetellelInaktivalandoGepUid20b97f17c21b4166841b97cddce8d0ce() {
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
    public void gepInaktivalasInaktivalandoGepUid8cf225a88f8b4cc6854a9b1b4c8b0563() {
        gepInaktivalas("Teszt-Gép 1");
    }
}