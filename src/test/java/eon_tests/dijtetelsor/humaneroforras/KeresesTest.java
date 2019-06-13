package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class KeresesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void megjelenoHumanokEllenorzeseUid2d4270f630474abcb75e6e7234a394fa() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.listazottEroforrasokEllenorzese();
    }

    @Test
    public void lapozoModulEllenorzesehumanUid8175b6c7c0174165bb82c3ad28f2d025() {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dijtetelsor
        actionwords.dijtetelsor();
        // And Dijtetelsor - Human eroforras
        actionwords.dijtetelsorHumanEroforras();
        // And Lapozas ellenorzese (Anyagok/Valtozotetelek)
        actionwords.lapozasEllenorzese();
    }
    public void kereseshuman(String megnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasKeresese(megnevezes);
    }

    @Test
    public void kereseshumanMegfeleloParameterekkelUidffabfb5b69fb437fb7709eadb6ccf6ba() {
        kereseshuman("Humán 2");
    }

    @Test
    public void kereseshumanNemMegfeleloParameterekkelUid5eb82010e6c34bd7ac350e6271703490() {
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
    public void keresesInaktivHumanraTeszt1Uid0f66eb9267fb4fdeb997b30068c6ec1a() {
        keresesInaktivHumanra("Humán 01");
    }
}