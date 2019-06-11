package eon_tests.dokumentum_kezeles;

import org.testng.annotations.*;

public class TervezesiSegedletTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void dokumentacioLetrehozasaTervezesiSegedlet(String nev, String tervszam, String feltoltendoAnyag1, String feltoltendoAnyag2) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tervezesi segedlet
        actionwords.tervezesiSegedlet();
        // And Uj dokumentacio letrehozasa "<nev>" "<tervszam>" "<feltoltendo_anyag_1>" "<feltoltendo_anyag_2>"
        actionwords.ujDokumentacioLetrehozasa(nev, tervszam, feltoltendoAnyag1, feltoltendoAnyag2);
        // Then Dokumentacio muvelet ellenorzese "<nev>"
        actionwords.dokumentacioMuveletEllenorzese(nev);
    }

    @Test
    public void dokumentacioLetrehozasaTervezesiSegedletLetrehozasHelyesAdatokkalUiddc7dfe8be603484ebc8027e0adbdf6cc() {
        dokumentacioLetrehozasaTervezesiSegedlet("Tervezesi segedlet", "T1234", "Kep 1.jpeg", "Kep 2.jpg");
    }

    @Test
    public void dokumentacioLetrehozasaTervezesiSegedletLetrehozasHelytelenAdatokkal1Uide6a0e06fe38e4c47bf9933780c3dd63b() {
        dokumentacioLetrehozasaTervezesiSegedlet("Tervezesi segedlet 1", "T1234", "teszt_pdf.pdf", "Firefox Installer.exe");
    }


    public void dokumentacioSzerkeszteseTervezesiSegedlet(String szerkesztendo, String nev, String tervszam, String szerkesztettKeres) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tervezesi segedlet
        actionwords.tervezesiSegedlet();
        // And Dokumentacio reszletek "<szerkesztendo>"
        actionwords.dokumentacioReszletek(szerkesztendo);
        // And Dokumentacio szerkesztese "<nev>" "<tervszam>"
        actionwords.dokumentacioSzerkesztese(nev, tervszam);
        // And Dokumentacio muvelet ellenorzese "<szerkesztett_keres>"
        actionwords.dokumentacioMuveletEllenorzese(szerkesztettKeres);
    }

    @Test
    public void dokumentacioSzerkeszteseTervezesiSegedletSzerkesztesHelyesenUiddfde59a1d9e1464b972c844aaf002f07() {
        dokumentacioSzerkeszteseTervezesiSegedlet("Tervezési segédlet", "Szerkesztett Tervezési segédlet", "T12233", "Szerkesztett Tervezési segédlet");
    }

    @Test
    public void dokumentacioSzerkeszteseTervezesiSegedletSzerkesztesHelytelenulUid9d71d748f63349f29b2f276af48dc4d4() {
        dokumentacioSzerkeszteseTervezesiSegedlet("Szerkesztett Tervezési segedlet", "Szerkesztett segédlet", "", "Szerkesztett segédlet");
    }


    public void dokumentacioTorleseTervezesiSegedlet(String torlendoNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tervezesi segedlet
        actionwords.tervezesiSegedlet();
        // And Dokumentacio reszletek "<torlendo_neve>"
        actionwords.dokumentacioReszletek(torlendoNeve);
        // And Dokumentacio torlese
        actionwords.dokumentacioTorlese();
        // And Dokumentacio muvelet ellenorzese "<torlendo_neve>"
        actionwords.dokumentacioMuveletEllenorzese(torlendoNeve);
    }

    @Test
    public void dokumentacioTorleseTervezesiSegedletTorlendoUidabacdef7ed2a476293038c69daf3b3f5() {
        dokumentacioTorleseTervezesiSegedlet("Szerkesztett Tervezési segédlet");
    }
}