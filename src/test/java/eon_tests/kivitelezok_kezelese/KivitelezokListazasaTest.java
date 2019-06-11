package eon_tests.kivitelezok_kezelese;

import org.testng.annotations.*;

public class KivitelezokListazasaTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void lapozoModulEllenorzeseKivitelezokUid591327be7bb34b5094248f4ef9402c94() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.kivitelezok();
        actionwords.lapozasEllenorzeseAnyagokValtozotetelek();
    }
    public void kivitelezokSzurese(String szurendo) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.kivitelezok();
        actionwords.kivitelezokSzurese(szurendo);
        actionwords.kivitelezokSzurtListaEllenorzese(szurendo);
    }

    @Test
    public void kivitelezokSzureseSzures1Uideba5cc5a5eb14126b6ff8c54f4d1d8e6() {
        kivitelezokSzurese("Saját kivitelező");
    }


    public void kivitelezoKeresese(String keresendoKivitelezo) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.kivitelezok();
        actionwords.eroforrasKeresese(keresendoKivitelezo);
    }

    @Test
    public void kivitelezoKereseseKeresendoKivitelezoUid0f1a93552b1c4577b956505f603c800d() {
        kivitelezoKeresese("Szerkesztett kivitelező");
    }
}