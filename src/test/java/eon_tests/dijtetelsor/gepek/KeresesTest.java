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
    public void megjelenoGepekEllenorzeseUidf9958720c251439e896169033ca155e5() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.listazottEroforrasokEllenorzese();
    }

    @Test
    public void lapozoModulEllenorzeseUid02bd827a1abd4ed59754ad2408dfaaba() {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dijtetelsor
        actionwords.dijtetelsor();
        // And Dijtetelsor-Gepek
        actionwords.dijtetelsorGepek();
        // And Lapozas ellenorzese
        actionwords.lapozasEllenorzese();
    }
    public void kereses(String megnevezes) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasKeresese(megnevezes);
    }

    @Test
    public void keresesMegfeleloParameterekkelUidcabf9dc511114c628a55bf182dfeb3b5() {
        kereses("Gép 2");
    }

    @Test
    public void keresesNemMegfeleloParameterekkelUidbcfc300ac59449e593adf40672a40e52() {
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
    public void keresesInaktivGepreInaktivGepUidb9e17b0617814e6ca74435bd6fddec7b() {
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
    public void kapcsolodoDijtetelekListazasagepTeszt1Uidf6e432a72e434c0181a901c788801f61() {
        kapcsolodoDijtetelekListazasagep("Gép 2");
    }
}