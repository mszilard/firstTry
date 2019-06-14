package eon_tests.adat_feltoltes;

import org.testng.annotations.*;

public class DijtetelsorTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void alapAdatFeltoltes(String felhNev, String jelszo, String dijtetelsorNev, String gepNev, int gepOradij, String humanNev, int humanOradij, int fSorszam, String fMegnevezes, String fRovidnev, int fGepszorzo, int fHumanszorzo) {
        actionwords.dijtetelsorFelvetele(felhNev, jelszo, dijtetelsorNev);
        actionwords.dijtetelsorAktivalas(dijtetelsorNev);
        actionwords.gepFelvetele(gepNev, gepOradij);
        actionwords.humanFelvetele(humanNev, humanOradij);
        actionwords.fejezetFelvetele(fGepszorzo, fHumanszorzo, fMegnevezes, fRovidnev, fSorszam);
    }

    @Test
    public void alapAdatFeltoltesFeltoltes1Uid8e79a5e3d68a47f0bca9859991a1c6ec() {
        alapAdatFeltoltes("aram_teszt", "aram", "Díjtételsor 1", "Gép 1", 1000, "Humán 1", 2000, 1, "Teszt fejezet", "TF", 1, 1);
    }
}