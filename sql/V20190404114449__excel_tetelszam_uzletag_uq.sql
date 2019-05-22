alter table excel_arutetel
    drop constraint excel_arutetel_tetelszam_key,
    add constraint excel_arutetel_tetelszam_key unique(tetelszam, uzletag);

alter table excel_valtozo_tetel
    drop constraint excel_valtozo_tetel_tetelszam_key,
    add constraint excel_valtozo_tetel_tetelszam_key unique(tetelszam, uzletag);