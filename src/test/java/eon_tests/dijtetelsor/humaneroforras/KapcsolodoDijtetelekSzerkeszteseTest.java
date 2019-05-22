package eon_tests.dijtetelsor.humaneroforras;

import org.testng.annotations.*;
import eon_tests.Actionwords;

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
        actionwords.eroforrasReszletek("");
        actionwords.eroforrasTorleseADijtetelrol("");
    }

    @Test
    public void humanEltavolitasaDijtetelrolTeszt1Uid6fefc663e5ad453a98eab99d49ddd0dd() {
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
    public void humanCserejeADijtetelrolCsere1Uid57bdcad3c90e47af9b3fb91f7970e5c4() {
        humanCserejeADijtetelrol("Humán 2", "Humán 2");
    }


    public void humanEltavolitasaDijtetelrolUtolsoEroforras(String human, String tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.eroforrasReszletek(human);
        actionwords.eroforrasTorleseADijtetelbolegyeduliEroforras(tetelszam);
    }

    @Test
    public void humanEltavolitasaDijtetelrolUtolsoEroforrasTeszt1Uiddd83aa004a234c0fa24fc95f61511c76() {
        humanEltavolitasaDijtetelrolUtolsoEroforras("Humán 01", "1000000");
    }



    @Test
    public void valtasDijtetelekKozotthumanUidc3f56297c30e4652ab9a247b682b24ba() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorHumanEroforras();
        actionwords.dijtetelValasztasaAktivIdozitett();
    }
}