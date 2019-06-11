package eon_tests.megbizo_cegek_kezelese;

import org.testng.annotations.*;

public class MegbizoListazasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void lapozoModulEllenorzeseMegbizokUid44a21a87007b4defb223bee7d6eec71d() {
        // Given Bejelentkezés "aram_teszt" "aram"
        actionwords.bejelentkezes("aram_teszt", "aram");
        // And Megbizo cegek
        actionwords.megbizoCegek();
        // And Lapozas ellenorzese (Megbizok)
        actionwords.lapozasEllenorzeseMegbizok();
        // Then Lapzas megfeleloen mukodik
        actionwords.lapzasMegfeleloenMukodik();
    }
}