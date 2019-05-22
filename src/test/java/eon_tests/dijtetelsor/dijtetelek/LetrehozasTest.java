package eon_tests.dijtetelsor.dijtetelek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class LetrehozasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void ujDijtetelLetrehozasa(String tetelszam, String fejezet, String megnevezes, String felesSor, String leiras, String megjegyzes, String mennyisegiEgyseg, String gep1Megnevezes, String gep1Normaora, String gep1Monoblokk, String gep2Megnevezes, String gep2Normaora, String gep2Monoblokk, String human1Megnevezes, String human1Normaora, String human1Monoblokk, String human2Megnevezes, String human2Normaora, String human2Monoblokk) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorDijtetelek();
        actionwords.ujDijtetelLetrehozasa(tetelszam, fejezet, megnevezes, felesSor, leiras, megjegyzes, mennyisegiEgyseg, gep1Megnevezes, gep1Normaora, gep1Monoblokk, gep2Megnevezes, gep2Normaora, gep2Monoblokk, human1Megnevezes, human1Normaora, human1Monoblokk, human2Megnevezes, human2Normaora, human2Monoblokk);
        actionwords.ujDijtetelLetrehozasanakEllenorzese(megnevezes);
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasHelyesAdatokkalUid5185541fc9ad41b48ce43e6ac027e100() {
        ujDijtetelLetrehozasa("1000001", "Teszt Fejezet", "Új díjtétel1", "feles", "leírás", "megj", "db", "Teszt-Gép 1", "1", "1", "Gép 2", "2", "2", "Humán 01", "2", "2", "Humán 2", "2", "2");
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasHelytelenAdatokkalUid021d78c2061644b191271d340e2de7fe() {
        ujDijtetelLetrehozasa("1000002", "Teszt Fejezet", "", "feles", "leírás", "megj", "tek", "Gép 2", "", "1", "Gép 3", "0", "0", "Humán 2", "1", "", "Humán 3", "0", "");
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasDuplikaltGeppelUid5b6dee43a17e4f0687d44a36210a694d() {
        ujDijtetelLetrehozasa("1000003", "Teszt Fejezet", "Új díjtétel3", "feles", "leírás", "megj", "db", "Gép 3", "3", "3", "Gép 3", "2", "2", "Humán 2", "2", "2", "Humán 3", "3", "3");
    }

    @Test
    public void ujDijtetelLetrehozasaLetrehozasDuplikaltHumannalUid6ab97d7dfc5f43829a2db492aea539f6() {
        ujDijtetelLetrehozasa("1000004", "Teszt Fejezet", "Új díjtétel4", "feles", "leírás", "megj", "db", "Gép 2", "1", "1", "Gép 3", "2", "2", "Humán 2", "3", "1", "Humán 2", "1", "1");
    }
}