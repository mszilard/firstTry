package eon_tests.dijtetelsor.humaneroforras;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class KeresesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void megjelenoHumanokEllenorzese() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.listazottEroforrasokEllenorzese();
    }

    @Test
    public void lapozoModulEllenorzesehuman() {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dijtetelsor
        actionwords.dijtetelsor();
        // And Dijtetelsor - Human eroforras
        actionwords.dijtetelsorHumanEroforras();
        // And Lapozas ellenorzese
        actionwords.lapozasEllenorzese();
    }
    public void kereseshuman(String megnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasKeresese(megnevezes);
    }

    @Test
    public void kereseshumanMegfeleloParameterekkel() {
        kereseshuman("Humán 2");
    }

    @Test
    public void kereseshumanNemMegfeleloParameterekkel() {
        kereseshuman(">ß$>");
    }


    public void keresesInaktivHumanra(String human) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.passzivEroforrasokListazasa();
        actionwords.eroforrasKeresese(human);
    }

    @Test
    public void keresesInaktivHumanraTeszt1() {
        keresesInaktivHumanra("Humán 01");
    }
}