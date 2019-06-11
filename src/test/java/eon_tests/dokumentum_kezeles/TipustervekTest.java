package eon_tests.dokumentum_kezeles;

import org.testng.annotations.*;

public class TipustervekTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void dokumentacioLetrehozasaTipusterv(String nev, String tervszam, String feltoltendoAnyag1, String feltoltendoAnyag2) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tipustervek
        actionwords.tipustervek();
        // And Uj dokumentacio letrehozasa "<nev>" "<tervszam>" "<feltoltendo_anyag_1>" "<feltoltendo_anyag_2>"
        actionwords.ujDokumentacioLetrehozasa(nev, tervszam, feltoltendoAnyag1, feltoltendoAnyag2);
        // Then Dokumentacio muvelet ellenorzese "<nev>"
        actionwords.dokumentacioMuveletEllenorzese(nev);
    }

    @Test
    public void dokumentacioLetrehozasaTipustervLetrehozasHelyesAdatokkalUid4eddc080337746c28b77566fb2a838d0() {
        dokumentacioLetrehozasaTipusterv("Típusterv 1", "Tervszám 1", "Kep 1.jpeg", "Kep 2.jpg");
    }

    @Test
    public void dokumentacioLetrehozasaTipustervLetrehozasHelytelenAdatokkal1Uida55338dddf204ae8a570cfa204a6cce9() {
        dokumentacioLetrehozasaTipusterv("Tipusterv 2", "Tervszám 2", "teszt_pdf.pdf", "Firefox installer.exe");
    }

    @Test
    public void dokumentacioLetrehozasaTipustervLetrehozasHelytelenAdatokkal2Uid9dc41ddbb09d46ecbe93af768255cca2() {
        dokumentacioLetrehozasaTipusterv("Tipusterv 3", "Tervszám 3", "Firefox installer.exe", "teszt_pdf.pdf");
    }


    public void dokumentacioSzerkeszteseTipusterv(String szerkesztendo, String nev, String tervszam, String szerkesztettKeres) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tipustervek
        actionwords.tipustervek();
        // And Dokumentacio reszletek "<szerkesztendo>"
        actionwords.dokumentacioReszletek(szerkesztendo);
        // And Dokumentacio szerkesztese "<nev>" "<tervszam>"
        actionwords.dokumentacioSzerkesztese(nev, tervszam);
        // And Dokumentacio muvelet ellenorzese "<szerkesztett_keres>"
        actionwords.dokumentacioMuveletEllenorzese(szerkesztettKeres);
    }

    @Test
    public void dokumentacioSzerkeszteseTipustervSzerkesztesHelyesenUidff2067fab62a4b389afb729339c25f58() {
        dokumentacioSzerkeszteseTipusterv("Típusterv 1", "Szerkesztett típusterv", "Szerkesztett tervszám", "Szerkesztett típusterv");
    }

    @Test
    public void dokumentacioSzerkeszteseTipustervSzerkesztesHelytelenulUid7cf8a7c31a8e4bf38234c3f5d5af176c() {
        dokumentacioSzerkeszteseTipusterv("Típusterv 1", "Szerkesztett típusterv", "", "Szerkesztett típusterv");
    }


    public void dokumentacioTorleseTipusterv(String torlendoNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Dokumentumok
        actionwords.dokumentumok();
        // And Tipustervek
        actionwords.tipustervek();
        // And Dokumentacio reszletek "<torlendo_neve>"
        actionwords.dokumentacioReszletek(torlendoNeve);
        // And Dokumentacio torlese
        actionwords.dokumentacioTorlese();
        // And Dokumentacio muvelet ellenorzese "<torlendo_neve>"
        actionwords.dokumentacioMuveletEllenorzese(torlendoNeve);
    }

    @Test
    public void dokumentacioTorleseTipustervTorlendoUid97a424eb619e4743ab894dc9a8faa664() {
        dokumentacioTorleseTipusterv("Szerkesztett típusterv");
    }
}