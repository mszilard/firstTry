-- Projekt
delete from projekt_kalkulacio_tetel;
delete from projekt_kalk_hozzaszolas;
delete from projekt_kalk_pst;
delete from projekt_kalkulacio;
delete from projekt_felh_hozzarendeles;
delete from projekt_hozzaszolas;
delete from idozitett_projekt_ujraszamolas;
delete from projekt;
delete from kit_modell_aktiv_jell_csoport;
delete from jellemzo_ertekek;
delete from kitoltott_modell_verzio;
delete from pst_elem;
delete from hozzaszolasok;

delete from kalkulacio_tetel_snapshot;
delete from jellemzo_ertek_snapshot;
delete from pst_elem_snapshot;
delete from kitoltott_modell_ver_snapshot;
delete from projekt_felh_hozz_snapshot;
delete from kalkulacio_snapshot;
delete from jellemzo_ertek_snapshot_aud;
delete from kalk_snapshot_felhasznalo_hozzarendeles_aud;
delete from kalkulacio_snapshot_aud;
delete from kalkulacio_tetel_snapshot_aud;
delete from kitoltott_modell_ver_snapshot_aud;
delete from projekt_felh_hozz_snapshot_aud;
delete from pst_elem_snapshot_aud;

-- Modell/jellemzok
delete from jellemzo_valasztasok;
delete from aktivalasi_szabaly_hiv_jellemzok;
delete from modell_jellemzo;
delete from modell_kedvencek;
delete from modell_jellemzo_csoport;
delete from tetel_hozzaadas_szab_muvelet;
delete from aktivalasi_szab_muvelet;
delete from aktivalasi_szabaly;
delete from modell_verzio;
delete from modell;

-- Kivitelezo
delete from kivitelezo_uzem;
delete from kivitelezo_felhasznalok;
delete from kivitelezo_rezsianyag;
delete from kivitelezo_terulet;
delete from kivitelezo;

-- Arutetel
delete from excel_arutetel;
delete from cserelendo_arutetel;
delete from problemasarutetel;
delete from arutetel;
delete from arutetel_sor_fejlec;

-- Valtozo tetel
delete from valtozo_cserelendo_arutetel;
delete from idozitett_valtozo_anyag_lista;
delete from excel_valtozo_tetel;
delete from valtozo_tetel;
delete from valtozo_arutetel_sor_fejlec;

-- Dijtetel
delete from gep_ora;
delete from ember_ora;
delete from dijtetel_verzio;
delete from idozitett_dijtetel_valtozas;
delete from fejezet;
delete from gep;
delete from human_eroforras;
delete from dijtetel;
delete from dijtetelsor;

-- Tetel
delete from tetel_aktiv_koltseg;
delete from tetel;

-- Megbizo
delete from megbizo_felhasznalok;
delete from megbizo;

