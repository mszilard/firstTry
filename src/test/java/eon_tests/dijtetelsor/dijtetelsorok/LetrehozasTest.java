package eon_tests.dijtetelsor.dijtetelsorok;

import org.testng.annotations.*;
import eon_tests.Actionwords;

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
    public void ujDijtetelsorLetrehozasaDijtetelsor1Uidb428ac6b86eb48e6b3328788998633af() {
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
    public void dijtetelsorAzonnaliAktivalasAktivalandoUid2918366ee864427aba519691ad6ba99f() {
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
    public void dijtetelsorMultbeliAktivalasiIdovelAktivalandoUid30386a2af2ad4424b118d4669dab61ec() {
        dijtetelsorMultbeliAktivalasiIdovel("Ditetelsor-Teszt", 4, 30);
    }
}