create table valtozo_cserelendo_arutetel(
     "id" serial primary key,
     "cserelendo_tetel_id"  uuid not null,
     "csere_tetel_id" uuid not null
);

alter table valtozo_cserelendo_arutetel
    add constraint csere_arutetel_cserelendo_fkey foreign key(cserelendo_tetel_id) references valtozo_tetel("id"),
    add constraint csere_arutetel_csere_fkey foreign key(csere_tetel_id) references valtozo_tetel("id");