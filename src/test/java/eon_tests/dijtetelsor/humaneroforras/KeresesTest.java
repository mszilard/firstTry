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
    public void megjelenoHumanokEllenorzeseUid4d9e8999bca14832a1d499ae0260ae4d() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.listazottEroforrasokEllenorzese();
    }

    @Test
    public void lapozoModulEllenorzesehumanUid1e11beca53c345428b29568d64ebd867() {
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
    public void kereseshumanMegfeleloParameterekkelUid03d73fe75b174efe998b93b23712190c() {
        kereseshuman("Humán 2");
    }

    @Test
    public void kereseshumanNemMegfeleloParameterekkelUidae86bad8678048bf879867a265653c25() {
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
    public void keresesInaktivHumanraTeszt1Uiddcac8c690bff4fb3b8b6f0bbfa3148b9() {
        keresesInaktivHumanra("Humán 01");
    }
}