package eon_tests.anyagkezeles;

import org.testng.annotations.*;

public class AnayaglistaFeltolteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void allomanyFeltoltese(String allomanyNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Anyagkezeles
        actionwords.anyagkezeles();
        // And Uj anyaglista hozzaadasa "<allomany_neve>"
        actionwords.ujAnyaglistaHozzaadasa(allomanyNeve);
        // Then Anyag/valtozolista feltoltesre kerul "<allomany_neve>"
        actionwords.anyagvaltozolistaFeltoltesreKerul(allomanyNeve);
    }

    @Test
    public void allomanyFeltolteseFormailagHelyesAllomanyUid91a112dc78624094a1e939142adb41ef() {
        allomanyFeltoltese("anyag_aram_linkkel.xlsx");
    }


    public void allomanyFeltolteseHelytelen(String allomanyNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Anyagkezeles
        actionwords.anyagkezeles();
        // And Uj anyaglista hozzaadasa "<allomany_neve>"
        actionwords.ujAnyaglistaHozzaadasa(allomanyNeve);
        // Then A rendszer hibauzenettel valaszol
        actionwords.aRendszerHibauzenettelValaszol();
    }

    @Test
    public void allomanyFeltolteseHelytelenFormailagHelytelenAllomanyUide016aec6e5b9433bb80c0efa05f2979c() {
        allomanyFeltolteseHelytelen("anyag_aram_linkkel_helytelen.xlsx");
    }

    @Test
    public void allomanyFeltolteseHelytelenSzabadonValasztottAllomanyUid1b1fb869584b411dbb50e2451adf0649() {
        allomanyFeltolteseHelytelen("Firefox Installer.exe");
    }
}