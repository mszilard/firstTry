package eon_tests.dokumentum_kezeles;

import org.testng.annotations.*;

public class MuszakiDokumentaciokTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void dokumentacioLetrehozasaMuszaki(String nev, String tervszam, String feltoltendoAnyag1, String feltoltendoAnyag2) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Muszaki dokumentaciok
        actionwords.muszakiDokumentaciok();
        // And Uj dokumentacio letrehozasa "<nev>" "<tervszam>" "<feltoltendo_anyag_1>" "<feltoltendo_anyag_2>"
        actionwords.ujDokumentacioLetrehozasa(nev, tervszam, feltoltendoAnyag1, feltoltendoAnyag2);
        // Then Dokumentacio muvelet ellenorzese "<nev>"
        actionwords.dokumentacioMuveletEllenorzese(nev);
    }

    @Test
    public void dokumentacioLetrehozasaMuszakiLetrehozasHelyesAdatokkalUid724936d14c354741b8c30f87d9579407() {
        dokumentacioLetrehozasaMuszaki("Dokumentáció 1", "Tervszám 1", "teszt_pdf.pdf", "teszt_pdf_2.pdf");
    }

    @Test
    public void dokumentacioLetrehozasaMuszakiLetrehozasHelytelenAdatokkal1Uidca597e3b1f0740baa89b2beafd1b8e04() {
        dokumentacioLetrehozasaMuszaki("Dokumentáció 2", "Tervszám 2", "Kep 1.jpeg", "Firefox Installer.exe");
    }


    public void dokumentacioSzerkeszteseMuszaki(String szerkesztendo, String nev, String tervszam, String szerkesztettKeres) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Muszaki dokumentaciok
        actionwords.muszakiDokumentaciok();
        // And Dokumentacio reszletek "<szerkesztendo>"
        actionwords.dokumentacioReszletek(szerkesztendo);
        // And Dokumentacio szerkesztese "<nev>" "<tervszam>"
        actionwords.dokumentacioSzerkesztese(nev, tervszam);
        // And Dokumentacio muvelet ellenorzese "<szerkesztett_keres>"
        actionwords.dokumentacioMuveletEllenorzese(szerkesztettKeres);
    }

    @Test
    public void dokumentacioSzerkeszteseMuszakiSzerkesztesHelyesenUiddc5a5bf412424f3d8fbf631da58c7769() {
        dokumentacioSzerkeszteseMuszaki("Dokumentáció 1", "Műszaki dokumentáció", "Terv 1", "Műszaki dokumentáció");
    }

    @Test
    public void dokumentacioSzerkeszteseMuszakiSzerkesztesHelytelenulUiddf9b65f854e64bbd8dd089d253666d37() {
        dokumentacioSzerkeszteseMuszaki("Műszaki dokumentáció", "Szerk. Műszaki dokumentáció", "", "Szerk. Műszaki dokumentáció");
    }


    public void dokumentacioTorleseMuszaki(String torlendoNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Muszaki dokumentaciok
        actionwords.muszakiDokumentaciok();
        // And Dokumentacio reszletek "<torlendo_neve>"
        actionwords.dokumentacioReszletek(torlendoNeve);
        // And Dokumentacio torlese
        actionwords.dokumentacioTorlese();
        // And Dokumentacio muvelet ellenorzese "<torlendo_neve>"
        actionwords.dokumentacioMuveletEllenorzese(torlendoNeve);
    }

    @Test
    public void dokumentacioTorleseMuszakiTorlendoUidc4bfac25e83a48e087a7a6d7dd1d1819() {
        dokumentacioTorleseMuszaki("Műszaki dokumentáció");
    }
}