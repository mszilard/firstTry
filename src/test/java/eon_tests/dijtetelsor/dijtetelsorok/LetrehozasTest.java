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
    public void ujDijtetelsorLetrehozasaDijtetelsor1() {
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
    public void dijtetelsorAzonnaliAktivalasAktivalando() {
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
    public void dijtetelsorMultbeliAktivalasiIdovelAktivalando() {
        dijtetelsorMultbeliAktivalasiIdovel("Ditetelsor-Teszt", 4, 30);
    }
}