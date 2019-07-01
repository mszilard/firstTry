package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class KapcsolodoDijtetelekSzerkeszteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    public void valtasDijtetelekKozottUidc4ef7184cfc14baeb2fa7744fd4ba5ad() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.dijtetelValasztasaAktivIdozitett();
    }

    public void gepEltavolitasaDijtetelrol(String tetelszam, String gep) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(gep);
        actionwords.eroforrasTorleseADijtetelrol(tetelszam);
    }

    @Test
    public void gepEltavolitasaDijtetelrolGep1EltavolitasaUid0f7ac1d5da2c49daa2950e0cee0f8b12() {
        gepEltavolitasaDijtetelrol("13.9.2.220", "Gép 19");
    }


    public void gepCserejeADijtetelrol(String kivalasztottGep, String kapcsDijtetel) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(kivalasztottGep);
        actionwords.gepCserejeADijtetelben(kivalasztottGep, kapcsDijtetel);
    }

    @Test
    public void gepCserejeADijtetelrolSzerk1Uida9469f4e28f949ee99c42a8a64d2774d() {
        gepCserejeADijtetelrol("Gép 2", "10.0.0.010");
    }


    public void gepEltavolitasaDijtetelrolUtolsoEroforras(String gep, String tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(gep);
        actionwords.eroforrasTorleseADijtetelbolegyeduliEroforras(tetelszam);
    }

    @Test
    public void gepEltavolitasaDijtetelrolUtolsoEroforrasTeszt1Uidd94dea29445c43ddb0c13f5637d80469() {
        gepEltavolitasaDijtetelrolUtolsoEroforras("Gép 2", "10.0.0.000");
    }
}