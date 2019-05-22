alter table ember_ora alter column oraszam type decimal;
alter table gep_ora alter column oraszam type decimal;

alter table tetel add column mertekegyseg_id int references mertekegyseg("id");
update tetel tet set mertekegyseg_id=(select atetel.mertekegyseg_id from arutetel atetel where atetel."id"=tet."id" limit 1) where tet.id in (select id from arutetel);
update tetel tet set mertekegyseg_id=(select dt.mertekegyseg_id from dijtetel_verzio dt where dt.dijtetel_id=tet."id" limit 1) where tet.id in (select id from dijtetel);
alter table tetel alter column mertekegyseg_id set not null;

alter table arutetel drop column mertekegyseg_id;
alter table dijtetel_verzio drop column mertekegyseg_id;

create table tetel_aktiv_koltseg (
    "id" bigserial primary key,
    tetel_id uuid not null references tetel("id"),
    kezdet date not null,
    veg date,
    ar decimal not null,
    human_oraszam decimal,
    gep_oraszam decimal
);

create table projekt (
    "id" serial primary key,
    nev varchar(255) not null,
    koala_dosszie_id varchar(255),
    uzletag int not null,
    szakasz int not null,
    statusz int not null,
    megbizo_id int not null references megbizo(megbizo_id),
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);

create table projekt_felh_hozzarendeles (
    "id" serial primary key,
    felhasznalo_id varchar(255) not null,
    hozzarendeles_tipus int not null,
    projekt_id int not null references projekt("id")
);

create table projekt_kalkulacio (
    "id" serial primary key,
    projekt_id int not null references projekt("id"),
    nev varchar(255) not null,
    statusz int not null,
    sap_attoltotes_ido timestamp with time zone,
    megjegyzes varchar(2000),
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);

create table kitoltott_modell_verzio (
    "id" bigserial primary key,
    modell_verzio_id int not null references modell_verzio("id")
);

create table jellemzo_ertekek (
    "id" serial primary key,
    jellemzo_id int references modell_jellemzo("id"),
    kitoltott_modell_ver_id int not null references kitoltott_modell_verzio("id"),
    tipus int not null,
    szam_jellemzo_ertek decimal,
    jellemzo_valasztas_id int references jellemzo_valasztasok("id")
);

create table kit_modell_aktiv_jell_csoport (
    kitoltott_modell_ver_id int not null references kitoltott_modell_verzio("id"),
    jellemzo_csoport_id int not null references modell_jellemzo_csoport("id"),
    primary key (kitoltott_modell_ver_id, jellemzo_csoport_id)
);

create table hozzaszolasok (
    "id" bigserial primary key,
    felhasznalo_id varchar(255) not null,
    szoveg text not null,
    ido timestamp with time zone not null default current_timestamp
);

create table projekt_kalk_hozzaszolas (
    "id" bigserial primary key,
    proj_kalkulacio_id int not null references projekt_kalkulacio("id"),
    hozzaszolas_id bigint not null references hozzaszolasok("id"),
    sorszam int not null default 1
);

create table projekt_hozzaszolas (
    "id" bigserial primary key,
    projekt_id int not null references projekt("id"),
    hozzaszolas_id bigint not null references hozzaszolasok("id"),
    sorszam int not null default 1
);

create table pst_elem (
    "id" serial primary key,
    azonosito varchar(255) not null,
    nev varchar(255) not null,
    szerkesztheto boolean not null,
    kitoltott_modell_ver_id int,
    szulo_id int references pst_elem("id")
);

create table projekt_kalkulacio_tetel (
    "id" bigserial primary key,
    pst_elem_id int not null references pst_elem("id"),
    projekt_kalkulacio_id int not null references projekt_kalkulacio("id"),
    mennyiseg decimal not null,
    verzio int not null default 0,
    szarmazas int not null,
    tetel_id uuid not null references tetel("id"),
    tetel_koltseg_id bigint not null references tetel_aktiv_koltseg("id"),
    terv_modositas decimal,
    raktarbol decimal,
    tenyadat decimal,
    mertekegyseg_id int not null references mertekegyseg("id"),
    jovahagyasi_modositas decimal,
    valtozas_indok varchar(2000),
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);

create table projekt_kalk_pst (
    kalkulacio_id int not null references projekt_kalkulacio("id"),
    pst_elem_id int not null references pst_elem("id"),
    primary key(kalkulacio_id, pst_elem_id)
);

create table alap_elokalkulacio_pst (
    "id" serial primary key,
    kod varchar(255) not null,
    nev varchar(255) not null,
    szulo_id int references alap_elokalkulacio_pst("id")
);