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

    @Test
    public void alapAdatFeltoltesFeltoltes2Uidfc26852da1474a0196e45de690b275fe() {
        alapAdatFeltoltes("aram_teszt", "aram", "Díjtételsor 2", "Gép 2", 1250, "Humán 2", 1500, 2, "Új fejezet", "UF", 2, 3);
    }

    @Test
    public void alapAdatFeltoltesFeltoltes3Uid99d0a37331c841ce9e78d83d927a3d45() {
        alapAdatFeltoltes("aram_teszt", "aram", "Díjtételsor 3", "Gép 3", 33000, "Humán 3", 22000, 3, "Harmadik fejezet", "HF", 3, 3);
    }
}