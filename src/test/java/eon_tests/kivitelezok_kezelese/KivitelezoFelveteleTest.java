package eon_tests.kivitelezok_kezelese;

import org.testng.annotations.*;

public class KivitelezoFelveteleTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void kivitelezoFelvetele(String cegnev, String tipus, String uzemnev, int keretszerzodesSzama, int szallitoiSzam, int gyarSzama, int raktarhelySzama, int vallalasiSzazalek, String kivitelezo, String rezsianyag1, String rezsianyag2) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.kivitelezok();
        actionwords.ujKivitelezoHozzaadasa(cegnev, tipus, uzemnev, keretszerzodesSzama, szallitoiSzam, gyarSzama, raktarhelySzama, vallalasiSzazalek, kivitelezo, rezsianyag1, rezsianyag2);
        actionwords.kivitelezoLetrejottenekEllenorzese(cegnev);
    }

    @Test
    public void kivitelezoFelveteleFelvetelHelyesenUid9de7e73eaaad4a6685d9f0163b0acb7a() {
        kivitelezoFelvetele("Teszt-Cég", "Saját kivitelező", "E.ON Dél-dunántúli Áramhálózati Zrt.", 1000000000, 1000000000, 1000, 1000, 10, "kiv2", "3 karakteres sorszám tábla", "Acéllemez 8mm bordás");
    }

    @Test
    public void kivitelezoFelveteleFelvetelHelytelenulUidb08603c53a074f5085109d84a5034411() {
        kivitelezoFelvetele("ds", "Saját kivitelező", "", 12233, 234, 0, 1111, 100000, "", "", "");
    }


    public void kivitelezoFelveteleDuplikaltAdatokkal(String cegnev, String tipus, String uzemnev, int keretszerzodesSzama, int szallitoiSzam, int gyarSzama, int raktarhelySzama, int valalasiSzazalek, String uzemnev2, int keretszerzodesSzama2, int szallitoiSzam2, int gyarSzama2, int raktarhelySzama2, int valalasiSzazalek2, String kivitelezo, String rezsianyag1, String rezsianyag2) {
        actionwords.bejelentkezes("aram_teszt", "aram");
        actionwords.kivitelezok();
        actionwords.ujKivitelezoHozzaadasaDuplikaltAdatokkal(cegnev, tipus, uzemnev, keretszerzodesSzama, szallitoiSzam, gyarSzama, raktarhelySzama, valalasiSzazalek, kivitelezo, rezsianyag1, rezsianyag2, uzemnev2, keretszerzodesSzama2, szallitoiSzam2, gyarSzama2, raktarhelySzama2, valalasiSzazalek2);
        actionwords.kivitelezoLetrejottenekEllenorzese(cegnev);
    }

    @Test
    public void kivitelezoFelveteleDuplikaltAdatokkalDuplikaltUzemUidfd24b489affa4b5db292c7fd27e68b22() {
        kivitelezoFelveteleDuplikaltAdatokkal("Teszt-Cég2", "Saját kivitelező", "E.ON Dél-dunántúli Áramhálózati Zrt.", 1000000011, 1000000022, 1001, 1001, 15, "E.ON Dél-dunántúli Áramhálózati Zrt.", 1000000011, 1000000022, 1001, 1001, 10, "kiv2", "3 karakteres sorszám tábla", "3 karakteres sorszám tábla");
    }

    @Test
    public void kivitelezoFelveteleDuplikaltAdatokkalDuplikaltRezsianyagUid15ce411ea3844967b86a440760af7e75() {
        kivitelezoFelveteleDuplikaltAdatokkal("Teszt-Cég2", "Saját kivitelező", "E.ON Észak-dunántúli Áramhálózati Zrt.", 1000000011, 1000000022, 1001, 1001, 15, "E.ON Dél-dunántúli Áramhálózati Zrt.", 1000000011, 1000000022, 1001, 1001, 10, "kiv2", "3 karakteres sorszám tábla", "3 karakteres sorszám tábla");
    }
}