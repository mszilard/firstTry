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
    public void valtasDijtetelekKozottUide00b4296995b4bbc8277a52b95f2be8b() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.dijtetelValasztasaAktivIdozitett();
    }
    public void gepEltavolitasaDijtetelrol(int tetelszam, String gep) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(gep);
        actionwords.eroforrasTorleseADijtetelrol(tetelszam);
    }

    @Test
    public void gepEltavolitasaDijtetelrolGep1EltavolitasaUid02ff3e5d8d734c5281cec78c4e4ef56b() {
        gepEltavolitasaDijtetelrol(1000000, "Teszt-Gép 1");
    }


    public void gepCserejeADijtetelrol(String kivalasztottGep, int kapcsDijtetel) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(kivalasztottGep);
        actionwords.gepCserejeADijtetelben(kivalasztottGep, kapcsDijtetel);
    }

    @Test
    public void gepCserejeADijtetelrolSzerk1Uide17ecc563bf54ff2acb9063d99e8e365() {
        gepCserejeADijtetelrol("Gép 2", 1000000);
    }


    public void gepEltavolitasaDijtetelrolUtolsoEroforras(String gep, int tetelszam) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorGepek();
        actionwords.eroforrasReszletek(gep);
        actionwords.eroforrasTorleseADijtetelbolegyeduliEroforras(tetelszam);
    }

    @Test
    public void gepEltavolitasaDijtetelrolUtolsoEroforrasTeszt1Uid61955983fd084d75bb86583983f10e84() {
        gepEltavolitasaDijtetelrolUtolsoEroforras("Gép 2", 1000000);
    }
}