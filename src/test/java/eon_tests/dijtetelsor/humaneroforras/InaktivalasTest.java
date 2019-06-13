package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class InaktivalasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void humanEroforrasInaktivalasMegfeleloFeltetellel(String humanMegnevezese) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasInaktivalasa(humanMegnevezese);
        actionwords.humanEroforrasInaktivalasEllenorzese(humanMegnevezese);
    }

    @Test
    public void humanEroforrasInaktivalasMegfeleloFeltetellelInaktivalandoHumanUid6c890ea7132649c1b5208494825f0b5f() {
        humanEroforrasInaktivalasMegfeleloFeltetellel("Humán 01");
    }


    public void humanEroforrasInaktivalasNemMegfeleloFeltetellel(String humanMegnevezese) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasHelytelenInaktivalas(humanMegnevezese);
    }

    @Test
    public void humanEroforrasInaktivalasNemMegfeleloFeltetellelInaktivalandoHumanUidc37a8e0dece34590a99db97169b808ca() {
        humanEroforrasInaktivalasNemMegfeleloFeltetellel("Humán 2");
    }
}