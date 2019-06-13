package eon_tests.dijtetelsor.dijtetelsorok;

import org.testng.annotations.*;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void ujDijtetelsorLetrehozasa(String nev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelsorok();
        actionwords.ujDijtetelsorLetrehozasa(nev);
        actionwords.dijtetelsorLetrejottenekEllenorzese(nev);
    }

    @Test
    public void ujDijtetelsorLetrehozasaDijtetelsor1Uidb5ff25f90017447eb7908fcc64d37ff4() {
        ujDijtetelsorLetrehozasa("Ditetelsor-Teszt");
    }


    public void dijtetelsorAzonnaliAktivalas(String nev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelsorok();
        actionwords.dijtetelsorReszletek(nev);
        actionwords.dijtetesorAzonnaliAktivalasaEsAnnakEllenorzese(nev);
    }

    @Test
    public void dijtetelsorAzonnaliAktivalasAktivalandoUid6e1e277aaf4c4562941abc4cd7b29634() {
        dijtetelsorAzonnaliAktivalas("Ditetelsor-Teszt");
    }


    public void dijtetelsorMultbeliAktivalasiIdovel(String nev, int ora, int perc) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelsorok();
        actionwords.dijtetelsorReszletek(nev);
        actionwords.dijtetelsorMultbeliIdoMegadasa(ora, perc);
    }

    @Test
    public void dijtetelsorMultbeliAktivalasiIdovelAktivalandoUidcb039365b5b94bad97365b1de6ec45ce() {
        dijtetelsorMultbeliAktivalasiIdovel("Ditetelsor-Teszt", 4, 30);
    }
}