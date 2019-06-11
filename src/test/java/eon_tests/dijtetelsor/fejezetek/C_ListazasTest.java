package eon_tests.dijtetelsor.fejezetek;

import eon_tests.Actionwords;
import org.testng.annotations.*;

public class C_ListazasTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void fejezetekLapozoModulEllenorzese() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.lapozasEllenorzesefejezetek();
    }

    @Test
    public void valtasDijtetelekKozottfejezetek() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.vizsgalandoDijtetelsorKivalasztasa();
    }
}