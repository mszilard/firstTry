package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class KeresesTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void megjelenoGepekEllenorzeseUidcd2652d7f22a44cd89c781ca6f02a057() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.listazottEroforrasokEllenorzese();
    }

    @Test
    public void lapozoModulEllenorzeseUid31740132159948bcbe74ab9fc2b45ee1() {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dijtetelsor
        actionwords.dijtetelsor();
        // And Dijtetelsor-Gepek
        actionwords.dijtetelsorGepek();
        // And Lapozas ellenorzese (Anyagok/Valtozotetelek)
        actionwords.lapozasEllenorzese();
    }
    public void kereses(String megnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasKeresese(megnevezes);
    }

    @Test
    public void keresesMegfeleloParameterekkelUid421350804ceb4cb0a17a36bbd4379b39() {
        kereses("Gép 2");
    }

    @Test
    public void keresesNemMegfeleloParameterekkelUid302e008e2ccc4c35823d7f3cd466691d() {
        kereses(">ß$>");
    }


    public void keresesInaktivGepre(String gep) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.passzivEroforrasokListazasa();
        actionwords.eroforrasKeresese(gep);
    }

    @Test
    public void keresesInaktivGepreInaktivGepUid2d8d3c495bdb4c90a66041fc40ddb357() {
        keresesInaktivGepre("Teszt-Gép 1");
    }


    public void kapcsolodoDijtetelekListazasagep(String gep) {
        // Azon díjtételek megjelenítése melyeken az adott gép erőforrásként szerepel.
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(gep);
    }

    @Test
    public void kapcsolodoDijtetelekListazasagepTeszt1Uid9d62fadfb08c4f53b519c6bbe0aebe69() {
        kapcsolodoDijtetelekListazasagep("Gép 2");
    }
}