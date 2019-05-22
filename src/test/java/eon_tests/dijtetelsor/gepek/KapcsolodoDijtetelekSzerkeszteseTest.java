package eon_tests.dijtetelsor.gepek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class KapcsolodoDijtetelekSzerkeszteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void valtasDijtetelekKozottUiddbb1b8e3bc0445239446cce9e57c3e61() {
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
    public void gepEltavolitasaDijtetelrolGep1EltavolitasaUidee860054027249e3a81d98819256cfa8() {
        gepEltavolitasaDijtetelrol("1000000", "Teszt-Gép 1");
    }


    public void gepCserejeADijtetelrol(String kivalasztottGep, String kapcsDijtetel) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(kivalasztottGep);
        actionwords.gepCserejeADijtetelben(kivalasztottGep, kapcsDijtetel);
    }

    @Test
    public void gepCserejeADijtetelrolSzerk1Uida80e5219a9274a6abecbe34abb5b1f57() {
        gepCserejeADijtetelrol("Gép 2", "1000000");
    }


    public void gepEltavolitasaDijtetelrolUtolsoEroforras(String gep, String tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(gep);
        actionwords.eroforrasTorleseADijtetelbolegyeduliEroforras(tetelszam);
    }

    @Test
    public void gepEltavolitasaDijtetelrolUtolsoEroforrasTeszt1Uid371fc102c6fa4c58a6d2d0e1f0233e3d() {
        gepEltavolitasaDijtetelrolUtolsoEroforras("Gép 2", "1000000");
    }
}