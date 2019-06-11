package eon_tests.kivitelezok_kezelese;

import org.testng.annotations.*;

public class KivitelezoSzerkeszteseTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void kivitelezoSzerkesztese(String szerkesztendoKivitelezo, String cegnev, String tipus, String szerkesztendoUzem, String uzemnev, int keretszerzodesSzama, int gyarSzama, int szallitoiSzam, int raktarhelySzama, float valalasiSzazalek) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.kivitelezok();
        actionwords.kivitelezoReszletek(szerkesztendoKivitelezo);
        actionwords.kivitelezoSzerkesztese(cegnev, tipus);
        actionwords.szerkesztendoUzemReszletek(szerkesztendoUzem);
        actionwords.uzemSzerkesztese(uzemnev, keretszerzodesSzama, szallitoiSzam, gyarSzama, raktarhelySzama, valalasiSzazalek);
        actionwords.kivitelezoSzerkesztesEllenorzese(cegnev);
    }

    @Test
    public void kivitelezoSzerkeszteseSzerkesztesHelyesenUid318217ad00ff4787a39be050df907504() {
        kivitelezoSzerkesztese("Teszt-Cég", "Szekesztett Kivitelező", "Saját kivitelező", "E.ON Dél-dunántúli Áramhálózati Zrt.", "E.ON Észak-dunántúli Áramhálózati Zrt.", 1111111111, 2222, 1234567891, 3333, (float) 13.5);
    }

    @Test
    public void kivitelezoSzerkeszteseSzerkesztesHelytelenulUidc66e99bd989545509c18e0bc7efe9f77() {
        kivitelezoSzerkesztese("Szekesztett Cég", "Teszt-Cég", "Saját kivitelező", "E.ON Észak-dunántúli Áramhálózati Zrt.", "", 0, 3000, 0, 0, 0);
    }
}