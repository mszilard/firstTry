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
    public void megjelenoGepekEllenorzeseUidffb522faad904d129855dc6f5850e1d7() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.listazottEroforrasokEllenorzese();
    }

    @Test
    public void lapozoModulEllenorzeseUidff7d4f8aa1e645df86947f5743ca9062() {
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
    public void keresesMegfeleloParameterekkelUid64e7085faec24d069672098b165805e9() {
        kereses("Gép 2");
    }

    @Test
    public void keresesNemMegfeleloParameterekkelUidca2e3c39e9fe48d38e1550da1bcde7c0() {
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
    public void keresesInaktivGepreInaktivGepUid4bd474835bea4244919b8839ca94b99c() {
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
    public void kapcsolodoDijtetelekListazasagepTeszt1Uid7d56d6e466d84257ab79f9501f273ffe() {
        kapcsolodoDijtetelekListazasagep("Gép 2");
    }
}