alter table excel_arutetel add column arutetel_id uuid references arutetel("id");
alter table cserelendo_arutetel
    add constraint fk_cserelendo_arutetel_excel_elem foreign key (cserelendo_tetel_id) references excel_arutetel("id"),
    add constraint fk_csere_arutetel_excel_elem foreign key (csere_tetel_id) references excel_arutetel("id");