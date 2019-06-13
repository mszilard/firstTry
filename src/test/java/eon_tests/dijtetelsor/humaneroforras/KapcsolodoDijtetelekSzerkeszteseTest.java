package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class KapcsolodoDijtetelekSzerkeszteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void humanEltavolitasaDijtetelrol(String human, String tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasReszletek(human);
        actionwords.eroforrasTorleseADijtetelrol(tetelszam);
    }

    @Test
    public void humanEltavolitasaDijtetelrolTeszt1Uid831401fd1d1c484abb78b9622afbd693() {
        humanEltavolitasaDijtetelrol("Humán 01", "10.0.0.000");
    }


    public void humanCserejeADijtetelrol(String human, String csereHuman, String kapcsDijtetel) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasReszletek(human);
        actionwords.humanCserejeADijtetelben(csereHuman, kapcsDijtetel);
    }

    @Test
    public void humanCserejeADijtetelrolCsere1Uidac810374c7c449299f4d4c767ca1abce() {
        humanCserejeADijtetelrol("Humán 2", "Humán 2", "32.1.4.562");
    }


    public void humanEltavolitasaDijtetelrolUtolsoEroforras(String human, int tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasReszletek(human);
        actionwords.eroforrasTorleseADijtetelbolegyeduliEroforras(tetelszam);
    }

    @Test
    public void humanEltavolitasaDijtetelrolUtolsoEroforrasTeszt1Uid21666454aeb74806aa6b5efff0c8fecc() {
        humanEltavolitasaDijtetelrolUtolsoEroforras("Humán 01", 1000000);
    }



    @Test
    public void valtasDijtetelekKozotthumanUidc08fbfddd6f044c2919eeb1599801141() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.dijtetelValasztasaAktivIdozitett();
    }
}