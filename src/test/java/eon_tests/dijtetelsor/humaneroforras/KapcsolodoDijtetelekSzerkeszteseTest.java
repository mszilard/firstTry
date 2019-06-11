package eon_tests.dijtetelsor.humaneroforras;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class KapcsolodoDijtetelekSzerkeszteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void humanEltavolitasaDijtetelrol(String human, int tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasReszletek(human);
        actionwords.eroforrasTorleseADijtetelrol(tetelszam);
    }

    @Test
    public void humanEltavolitasaDijtetelrolTeszt1() {
        humanEltavolitasaDijtetelrol("Humán 01", 1000000);
    }


    public void humanCserejeADijtetelrol(String human, String csereHuman) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasReszletek(human);
        actionwords.humanCserejeADijtetelben(csereHuman);
    }

    @Test
    public void humanCserejeADijtetelrolCsere1() {
        humanCserejeADijtetelrol("Humán 2", "Humán 2");
    }


    public void humanEltavolitasaDijtetelrolUtolsoEroforras(String human, int tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasReszletek(human);
        actionwords.eroforrasTorleseADijtetelbolegyeduliEroforras(tetelszam);
    }

    @Test
    public void humanEltavolitasaDijtetelrolUtolsoEroforrasTeszt1() {
        humanEltavolitasaDijtetelrolUtolsoEroforras("Humán 01", 1000000);
    }



    @Test
    public void valtasDijtetelekKozotthuman() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.dijtetelValasztasaAktivIdozitett();
    }
}