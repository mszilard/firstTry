package eon_tests.dijtetelsor.humaneroforras;

import eon_tests.Actionwords;
import org.testng.annotations.*;

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
    public void humanEroforrasInaktivalasMegfeleloFeltetellelInaktivalandoHuman() {
        humanEroforrasInaktivalasMegfeleloFeltetellel("Humán 01");
    }


    public void humanEroforrasInaktivalasNemMegfeleloFeltetellel(String humanMegnevezese) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasHelytelenInaktivalas(humanMegnevezese);
    }

    @Test
    public void humanEroforrasInaktivalasNemMegfeleloFeltetellelInaktivalandoHuman() {
        humanEroforrasInaktivalasNemMegfeleloFeltetellel("Humán 2");
    }
}