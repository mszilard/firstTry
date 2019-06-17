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
    public void fejezetekLapozoModulEllenorzeseUid25e2777b79404e4fa7b182a139a515ab() {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.dijtetelsor();
        actionwords.dijtetelsorFejezetek();
        actionwords.lapozasEllenorzesefejezetek();
    }
}