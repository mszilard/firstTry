create table dijtetelsor (
    "id" serial primary key,
    aktivalasi_ido timestamp with time zone,
    allapot int not null,
    nev varchar(255) not null,
    uzletag int not null,
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);

create table idozitett_projekt_ujraszamolas (
    "id" serial primary key,
    projekt_id int not null
);

create table idozitett_dijtetel_valtozas (
    "id" bigserial primary key,
    eredeti_dijtetel_id int not null references dijtetel(dijtetel_id),
    csere_dijtetel_azon uuid,
    muvelet int not null,
    letrehozas timestamp with time zone not null default current_timestamp
);

alter table dijtetel add column azonosito uuid not null;
alter table dijtetel add column dijtetelsor_id int not null references dijtetelsor("id");

alter table fejezet add column azonosito uuid not null;
alter table fejezet add column dijtetelsor_id int not null references dijtetelsor("id");

alter table gep add column azonosito uuid not null;
alter table gep add column dijtetelsor_id int not null references dijtetelsor("id");

alter table human_eroforras add column azonosito uuid not null;
alter table human_eroforras add column dijtetelsor_id int not null references dijtetelsor("id");

alter table dijtetel add constraint uq_dijtetel_sor unique(dijtetelsor_id, azonosito);
alter table fejezet add constraint uq_fejezet_sor unique(dijtetelsor_id, azonosito);
alter table gep add constraint uq_gep_sor unique(dijtetelsor_id, azonosito);
alter table human_eroforras add constraint uq_human_sor unique(dijtetelsor_id, azonosito);

alter table tetel add column letrehozva timestamp with time zone not null default current_timestamp;
alter table tetel add column letrehozo varchar(255) not null;
alter table tetel add column modositva timestamp with time zone;
alter table tetel add column modosito varchar(255);

alter table fejezet add column letrehozva timestamp with time zone not null default current_timestamp;
alter table fejezet add column letrehozo varchar(255) not null;
alter table fejezet add column modositva timestamp with time zone;
alter table fejezet add column modosito varchar(255);

alter table gep add column letrehozva timestamp with time zone not null default current_timestamp;
alter table gep add column letrehozo varchar(255) not null;
alter table gep add column modositva timestamp with time zone;
alter table gep add column modosito varchar(255);

alter table human_eroforras add column letrehozva timestamp with time zone not null default current_timestamp;
alter table human_eroforras add column letrehozo varchar(255) not null;
alter table human_eroforras add column modositva timestamp with time zone;
alter table human_eroforras add column modosito varchar(255);