alter table excel_arutetel
    drop constraint excel_arutetel_cikkszam_key,
    add constraint excel_arutetel_tetelszam_key unique(tetelszam);