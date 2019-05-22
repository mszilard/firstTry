alter table cserelendo_arutetel
    alter column cserelendo_tetel_id type uuid using uuid_generate_v4(),
    alter column csere_tetel_id type uuid using uuid_generate_v4(),
    add constraint csere_arutetel_cserelendo_fkey foreign key(cserelendo_tetel_id) references arutetel("id"),
    add constraint csere_arutetel_csere_fkey foreign key(csere_tetel_id) references arutetel("id");