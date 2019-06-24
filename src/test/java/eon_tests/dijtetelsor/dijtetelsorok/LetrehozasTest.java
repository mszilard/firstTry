package eon_tests.dijtetelsor.dijtetelsorok;

import org.testng.annotations.*;

import java.io.IOException;

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
    public void ujDijtetelsorLetrehozasaDijtetelsor1Uida787df6935f04001a76fdbde990ce4ec() {
        ujDijtetelsorLetrehozasa("Ditetelsor-Teszt");
    }



    public void dijtetelsorMultbeliAktivalasiIdovel(String nev, int ora, int perc) throws IOException {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelsorok();
        actionwords.dijtetelsorReszletek(nev);
        actionwords.dijtetelsorMultbeliIdoMegadasa(ora, perc);
    }

    @Test
    public void dijtetelsorMultbeliAktivalasiIdovelAktivalandoUid44f3ec9b9419406983e7584bbe6f5b49() throws IOException {
        dijtetelsorMultbeliAktivalasiIdovel("Ditetelsor-Teszt", 4, 30);
    }


    public void dijtetelsorAzonnaliAktivalas(String nev) throws IOException {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelsorok();
        actionwords.dijtetelsorReszletek(nev);
        actionwords.dijtetesorAzonnaliAktivalasaEsAnnakEllenorzese(nev);
    }

    @Test
    public void dijtetelsorAzonnaliAktivalasAktivalandoUid5ce2c1ada0484793a3ccc759eed83df7() throws IOException {
        dijtetelsorAzonnaliAktivalas("Ditetelsor-Teszt");
    }
}