package eon_tests.dijtetelsor.fejezetek;

import org.testng.annotations.*;
import eon_tests.Actionwords;

public class ListazasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void fejezetekLapozoModulEllenorzeseUid1085a42e440741ef9d943c3ee881997e() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.lapozasEllenorzesefejezetek();
    }

    @Test
    public void valtasDijtetelekKozottfejezetekUid5df65e6ba3434881a0def6b1a08bde06() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.vizsgalandoDijtetelsorKivalasztasa();
    }
}