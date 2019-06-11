package eon_tests.anyagkezeles;

import org.testng.annotations.*;

public class AnayaglistaMegjeleniteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void anyagKeresese(String anyagNev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.anyagkezeles();
        actionwords.aktivaltAnyagvaltozolistaEllenorzese(anyagNev);
    }

    @Test
    public void anyagKereseseKeresesMegfeleloParameterrelUidd6a97431530042729853adcc484764b8() {
        anyagKeresese("Új anyag 2");
    }

    @Test
    public void anyagKereseseKeresesHelytelenParameterrelUidfb60da5ff41d4d0681c740496c33c8b8() {
        anyagKeresese("wedf");
    }



    @Test
    public void anyagListazasaUidb0fe6466825e4d83aced3c1a191f38a7() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.anyagkezeles();
        actionwords.aktivAnyagvaltozolistaReszletek();
    }

    @Test
    public void anyaglistaLapozomodulEllenorzeseUidf2ae7434f2d14f919f81f65f764db9d4() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.anyagkezeles();
        actionwords.aktivAnyagvaltozolistaReszletek();
        actionwords.lapozasEllenorzeseAnyagokValtozotetelek();
    }
}