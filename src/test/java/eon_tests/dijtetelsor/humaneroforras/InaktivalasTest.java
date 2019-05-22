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
    public void humanEroforrasInaktivalasMegfeleloFeltetellelInaktivalandoHumanUide2b9fbb900d14c3abb65c5c7dc6a6479() {
        humanEroforrasInaktivalasMegfeleloFeltetellel("Humán 01");
    }


    public void humanEroforrasInaktivalasNemMegfeleloFeltetellel(String humanMegnevezese) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasHelytelenInaktivalas(humanMegnevezese);
    }

    @Test
    public void humanEroforrasInaktivalasNemMegfeleloFeltetellelInaktivalandoHumanUidca48977b37c04ffc824b6457950519a8() {
        humanEroforrasInaktivalasNemMegfeleloFeltetellel("Humán 2");
    }
}