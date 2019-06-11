package eon_tests.valtozotetel;

import org.testng.annotations.*;
import eon_tests.anyagkezeles.Actionwords;

public class ValtozolistaFeltolteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void allomanyValtozotetelFeltoltese(String allomanyNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Valtozotetelek
        actionwords.valtozotetelek();
        // And Uj valtozolista hozzaadasa "<allomany_neve>"
        actionwords.ujValtozolistaHozzaadasa(allomanyNeve);
        // Then Anyag/valtozolista feltoltesre kerul "<allomany_neve>"
        actionwords.anyagvaltozolistaFeltoltesreKerul(allomanyNeve);
    }

    @Test
    public void allomanyValtozotetelFeltolteseFormailagHelyesAllomanyUid49a78b102cf642239f3662a0593a00de() {
        allomanyValtozotetelFeltoltese("vtetel.xlsx");
    }


    public void allomanyFeltolteseValtozotetelHelytelen(String allomanyNeve) {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Valtozotetelek
        actionwords.valtozotetelek();
        // And Uj valtozolista hozzaadasa "<allomany_neve>"
        actionwords.ujValtozolistaHozzaadasa(allomanyNeve);
        // Then A rendszer hibauzenettel valaszol
        actionwords.aRendszerHibauzenettelValaszol();
    }

    @Test
    public void allomanyFeltolteseValtozotetelHelytelenFormailagHelytelenAllomanyUid969eb7dc598a4b3a8c2d98b7ed7b6211() {
        allomanyFeltolteseValtozotetelHelytelen("vtetel_helytelen.xlsx");
    }

    @Test
    public void allomanyFeltolteseValtozotetelHelytelenSzabadonValasztottAllomanyUid8b5269914312466c96f3da65171f1e16() {
        allomanyFeltolteseValtozotetelHelytelen("Firefox Installer.exe");
    }
}