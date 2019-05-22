alter table ember_ora drop constraint ember_ora_dijtetel_id_fkey;
alter table gep_ora drop constraint gep_ora_dijtetel_id_fkey;
alter table dijtetel_history drop constraint dijtetel_history_dijtetel_id_fkey;
alter table idozitett_dijtetel_valtozas drop constraint idozitett_dijtetel_valtozas_eredeti_dijtetel_id_fkey;

alter table dijtetel drop constraint dijtetel_pkey;
alter table dijtetel rename to dijtetel_verzio;
alter table dijtetel_verzio add column letrehozva timestamp with time zone not null default current_timestamp;
alter table dijtetel_verzio add column letrehozo varchar(255) not null;
alter table dijtetel_verzio add column modositva timestamp with time zone;
alter table dijtetel_verzio add column modosito varchar(255);

create table dijtetel (
    "id" uuid primary key,
    uzletag int not null
);

alter table dijtetel_verzio add column "id" serial primary key;
alter table dijtetel_verzio alter column dijtetel_id drop default;
alter table dijtetel_verzio drop constraint fk_dijtetel_tetel;
alter table dijtetel_verzio alter column dijtetel_id type uuid using uuid_generate_v4();
alter table dijtetel_verzio alter column dijtetel_id set not null;
alter table dijtetel_verzio add constraint fk_dijtetel_ver_dijtetel foreign key(dijtetel_id) references dijtetel("id");
alter table dijtetel_verzio drop column azonosito;

alter table ember_ora rename column dijtetel_id to dijtetel_ver_id;
alter table gep_ora rename column dijtetel_id to dijtetel_ver_id;

alter table dijtetel_history alter column dijtetel_id type uuid using uuid_generate_v4();
alter table idozitett_dijtetel_valtozas alter column eredeti_dijtetel_id type uuid using uuid_generate_v4();

alter table ember_ora add constraint ember_ora_dijtetel_ver_id_fkey foreign key(dijtetel_ver_id) references dijtetel_verzio("id");
alter table gep_ora add constraint gep_ora_dijtetel_ver_id_fkey foreign key(dijtetel_ver_id) references dijtetel_verzio("id");
alter table dijtetel_history add constraint dijtetel_history_dijtetel_id_fkey foreign key(dijtetel_id) references dijtetel("id");
alter table idozitett_dijtetel_valtozas add constraint idozitett_dijtetel_valtozas_eredeti_dijtetel_id_fkey foreign key(eredeti_dijtetel_id) references dijtetel("id");

--insert into dijtetel("id", tetelszam, nev, uzletag, letrehozva, letrehozo, modositva, modosito)
--select
--dv.azonosito,
--(select tetelszam from tetel where tetel."id"=dv.dijtetel_id),
--(select nev from tetel where tetel."id"=dv.dijtetel_id),
--(select uzletag from dijtetelsor where dijtetelsor."id"=dv.dijtetelsor_id),
--dv.letrehozva,
--dv.letrehozo,
--dv.modositva,
--dv.modosito,
--from dijtetel_verzio dv;

alter table tetel add column id_uuid uuid;
alter table arutetel add column id_uuid uuid;

update tetel set id_uuid=uuid_generate_v4();
update arutetel set id_uuid=(select id_uuid from tetel where tetel.id=arutetel.id);

alter table arutetel drop constraint fk_arutetel_tetel;
alter table tetel_hozzaadas_szab_muvelet drop constraint tetel_hozzaadas_szab_muvelet_tetel_id_fkey;
alter table tetel drop constraint tetel_pkey;
alter table arutetel drop column "id";
alter table tetel drop column "id";

alter table tetel rename id_uuid to "id";
alter table arutetel rename id_uuid to "id";
alter table tetel add primary key("id");
alter table arutetel add primary key("id");

alter table excel_arutetel
    drop constraint excel_arutetel_pkey,
    alter column "id" drop default,
    alter column "id" type uuid using uuid_generate_v4(),
    add primary key("id");

alter table arutetel add constraint fk_arutetel_tetel foreign key("id") references tetel("id");
alter table tetel_hozzaadas_szab_muvelet alter column tetel_id type uuid using uuid_generate_v4(),
    add constraint tetel_hozzaadas_szab_muvelet_tetel_id_fkey foreign key(tetel_id) references tetel("id");