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
    public void gepInaktivalasaNemMegfeleloFeltetellelInaktivalandoGepUid06b216ffb07447f7830e619b7545eaad() {
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
    public void gepInaktivalasInaktivalandoGepUidf5d40d4ee09d4f02bb31790e9157c75d() {
        gepInaktivalas("Teszt-Gép 1");
    }
}