package eon_tests.adat_feltoltes;

import org.testng.annotations.*;

public class DijtetelsorTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void alapAdatFeltoltes(String felhNev, String jelszo, String dijtetelsorNev, String gepNev, int gepOradij, String gep2Megnevezes, int gep2Oradij, String humanNev, int humanOradij, String human2Megnevezes, int human2Oradij, int fSorszam, String fMegnevezes, String fRovidnev, int fGepszorzo, int fHumanszorzo) {
        actionwords.dijtetelsorFelvetele(felhNev, jelszo, dijtetelsorNev);
        actionwords.dijtetelsorAktivalas(dijtetelsorNev);
        actionwords.gepFelvetele(gepNev, gepOradij, gep2Megnevezes, gep2Oradij);
        actionwords.humanFelvetele(humanNev, humanOradij, human2Megnevezes, human2Oradij);
        actionwords.fejezetFelvetele(fGepszorzo, fHumanszorzo, fMegnevezes, fRovidnev, fSorszam);
    }

    @Test
    public void alapAdatFeltoltesFeltoltes1Uid8e79a5e3d68a47f0bca9859991a1c6ec() {
        alapAdatFeltoltes("aram_teszt", "aram", "Díjtételsor 1", "Alap Gép 1", 1000, "Alap Gép 2", 2500, "Alap  Humán 1", 2000, "Alap Humán 2", 4500, 1, "Alap  Teszt fejezet", "ATF", 1, 1);
    }
}