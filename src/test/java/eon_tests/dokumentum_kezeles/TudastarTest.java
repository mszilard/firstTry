package eon_tests.dokumentum_kezeles;

import org.testng.annotations.*;

public class TudastarTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void dokumentacioLetrehozasaTudastar(String nev, String tervszam, String feltoltendoAnyag1, String feltoltendoAnyag2) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tudastar
        actionwords.tudastar();
        // And Uj dokumentacio letrehozasa "<nev>" "<tervszam>" "<feltoltendo_anyag_1>" "<feltoltendo_anyag_2>"
        actionwords.ujDokumentacioLetrehozasa(nev, tervszam, feltoltendoAnyag1, feltoltendoAnyag2);
        // Then Dokumentacio muvelet ellenorzese "<nev>"
        actionwords.dokumentacioMuveletEllenorzese(nev);
    }

    @Test
    public void dokumentacioLetrehozasaTudastarLetrehozasHelyesAdatokkalUid3d8ac5768eba4832939c49bfed437a6c() {
        dokumentacioLetrehozasaTudastar("Tudástár", "1T32321", "teszt_pdf.pdf", "teszt_pdf_2.pdf");
    }

    @Test
    public void dokumentacioLetrehozasaTudastarLetrehozasHelytelenAdatokkal1Uid95a734d223b04bc6a02c31681143afbb() {
        dokumentacioLetrehozasaTudastar("Tudástár 1", "", "Kep 1.jpeg", "Firefox installer.exe");
    }


    public void dokumentacioSzerkeszteseTudastar(String szerkesztendo, String nev, String tervszam, String szerkesztettKeres) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tudastar
        actionwords.tudastar();
        // And Dokumentacio reszletek "<szerkesztendo>"
        actionwords.dokumentacioReszletek(szerkesztendo);
        // And Dokumentacio szerkesztese "<nev>" "<tervszam>"
        actionwords.dokumentacioSzerkesztese(nev, tervszam);
        // And Dokumentacio muvelet ellenorzese "<szerkesztett_keres>"
        actionwords.dokumentacioMuveletEllenorzese(szerkesztettKeres);
    }

    @Test
    public void dokumentacioSzerkeszteseTudastarSzerkesztesHelyesenUiddc1394bf1f7043cdb76b645ac3dacd99() {
        dokumentacioSzerkeszteseTudastar("Tudástár", "Szerkesztett Tudástár", "12345T", "Szerkesztett Tudástár");
    }

    @Test
    public void dokumentacioSzerkeszteseTudastarSzerkesztesHelytelenulUidb41ad45ce885483c85c7fe8ac2e826c8() {
        dokumentacioSzerkeszteseTudastar("Szerkesztett Tudástár", "Tudástár", "", "Tudástár");
    }


    public void dokumentacioTorleseTudastar(String torlendoNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tudastar
        actionwords.tudastar();
        // And Dokumentacio reszletek "<torlendo_neve>"
        actionwords.dokumentacioReszletek(torlendoNeve);
        // And Dokumentacio torlese
        actionwords.dokumentacioTorlese();
        // And Dokumentacio muvelet ellenorzese "<torlendo_neve>"
        actionwords.dokumentacioMuveletEllenorzese(torlendoNeve);
    }

    @Test
    public void dokumentacioTorleseTudastarTorlendoUid2c8c7cad1638422b81c165a96976d669() {
        dokumentacioTorleseTudastar("Szerkesztett Tudástár");
    }
}