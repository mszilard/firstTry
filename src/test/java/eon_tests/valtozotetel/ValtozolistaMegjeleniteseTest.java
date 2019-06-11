package eon_tests.valtozotetel;

import org.testng.annotations.*;
import eon_tests.anyagkezeles.Actionwords;

public class ValtozolistaMegjeleniteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void valtozotetelKeresese(String anyagNev) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.valtozotetelek();
        actionwords.aktivaltAnyagvaltozolistaEllenorzese(anyagNev);
    }

    @Test
    public void valtozotetelKereseseKeresesMegfeleloParameterrelUid6b26c7aac1c14a12a9b094ae2ba45a8a() {
        valtozotetelKeresese("Új tétel 2");
    }

    @Test
    public void valtozotetelKereseseKeresesHelytelenParameterrelUidcd8fd4a02cb44633b0e7d2eb60f1d70c() {
        valtozotetelKeresese("wedf");
    }



    @Test
    public void valtozotetelListazasaUid5e039bccfc40444aa7adace4c4a885e5() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.valtozotetelek();
        actionwords.aktivAnyagvaltozolistaReszletek();
    }

    @Test
    public void valtozotetelLapozomodulEllenorzeseUidea6b7e784fc44c2bbc09c090e3a40279() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.valtozotetelek();
        actionwords.aktivAnyagvaltozolistaReszletek();
        actionwords.lapozasEllenorzeseAnyagokValtozotetelek();
    }
}