alter table valtozo_cserelendo_arutetel
    drop constraint csere_arutetel_cserelendo_fkey,
    drop constraint csere_arutetel_csere_fkey;

alter table excel_valtozo_tetel add column arutetel_id uuid references valtozo_tetel("id");
alter table valtozo_cserelendo_arutetel
    add constraint fk_cserelendo_arutetel_excel_elem foreign key (cserelendo_tetel_id) references excel_valtozo_tetel("id"),
    add constraint fk_csere_arutetel_excel_elem foreign key (csere_tetel_id) references excel_valtozo_tetel("id")