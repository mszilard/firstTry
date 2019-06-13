package eon_tests.dijtetelsor.dijtetelek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void ujDijtetelLetrehozasa(int tetelszam, String fejezet, String megnevezes, String felesSor, String leiras, String megjegyzes, String mennyisegiEgyseg, String gep1Megnevezes, int gep1Normaora, int gep1Monoblokk, String gep2Megnevezes, int gep2Normaora, int gep2Monoblokk, String human1Megnevezes, int human1Normaora, int human1Monoblokk, String human2Megnevezes, int human2Normaora, int human2Monoblokk) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.ujDijtetelLetrehozasa(tetelszam, fejezet, megnevezes, felesSor, leiras, megjegyzes, mennyisegiEgyseg, gep1Megnevezes, gep1Normaora, gep1Monoblokk, gep2Megnevezes, gep2Normaora, gep2Monoblokk, human1Megnevezes, human1Normaora, human1Monoblokk, human2Megnevezes, human2Normaora, human2Monoblokk);
        actionwords.ujDijtetelLetrehozasanakEllenorzese(megnevezes);
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasHelyesAdatokkalUidb1a9309b1a9548c3b51fa7e92b3f5480() {
        ujDijtetelLetrehozasa(1000001, "TF", "Új díjtétel1", "feles", "leírás", "megj", "db", "Teszt-Gép 1", 1, 1, "Gép 2", 2, 2, "Humán 01", 2, 2, "Humán 2", 2, 2);
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasHelytelenAdatokkalUid80b3c9f5660a4c21ae3d98a73839d215() {
        ujDijtetelLetrehozasa(1000002, "TF", "", "feles", "leírás", "megj", "tek", "Gép 2", 0, 1, "Gép 3", 0, 0, "Humán 2", 1, 0, "Humán 3", 0, 0);
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasDuplikaltGeppelUid8094652abfc843a0878743e120884196() {
        ujDijtetelLetrehozasa(1000003, "TF", "Új díjtétel3", "feles", "leírás", "megj", "db", "Gép 3", 3, 3, "Gép 3", 2, 2, "Humán 2", 2, 2, "Humán 3", 3, 3);
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasDuplikaltHumannalUidf2deb9c34a1d4511bbc260e3a18c136d() {
        ujDijtetelLetrehozasa(1000004, "TF", "Új díjtétel4", "feles", "leírás", "megj", "db", "Gép 2", 1, 1, "Gép 3", 2, 2, "Humán 2", 3, 1, "Humán 2", 1, 1);
    }
}