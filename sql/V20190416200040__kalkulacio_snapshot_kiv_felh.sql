create table kivitelezo_felhasznalok (
    "id" serial primary key,
    felhasznalo_id varchar(255) not null,
    kivitelezo_id int not null references kivitelezo(kivitelezo_id),
    unique(kivitelezo_id, felhasznalo_id)
);

create table kalkulacio_snapshot (
    "id" bigserial primary key,
    kalkulacio_id int not null,
    projekt_statusz int not null,
    projekt_szakasz int not null,
    letrehozas timestamp with time zone not null default current_timestamp,
    ok varchar(2000)
);

create table kitoltott_modell_ver_snapshot (
    "id" bigserial primary key,
    verzio_id int not null references modell_verzio("id")
);

create table jellemzo_ertek_snapshot (
    "id" bigserial primary key,
    hivatkozas uuid not null,
    jellemzo_nev varchar(255) not null,
    jellemzo_tipus int not null,
    szam_jellemzo_ertek decimal,
    valasztas_ertek varchar(500),
    valasztas_id uuid
);

create table pst_elem_snapshot (
    "id" bigserial primary key,
    azonosito varchar(255) not null,
    nev varchar(255) not null,
    szulo_id int references pst_elem_snapshot("id"),
    kalkulacio_snapshot_id bigint not null references kalkulacio_snapshot("id"),
    kitoltott_modell_ver_snapshot_id int references kitoltott_modell_ver_snapshot("id")
);

create table kalkulacio_tetel_snapshot (
    "id" bigserial primary key,
    kalk_snapshot_id bigint not null references kalkulacio_snapshot("id"),
    kalkulacio_tetel_id bigint not null,
    pst_snapshot_id bigint not null references pst_elem_snapshot("id"),
    mennyiseg decimal not null,
    szarmazas int not null,
    tetel_id uuid not null references tetel("id"),
    tetel_koltseg_id bigint not null references tetel_aktiv_koltseg("id"),
    terv_modositas decimal,
    raktarbol decimal,
    tenyadat decimal,
    mertekegyseg_id int not null references mertekegyseg("id"),
    jovahagyasi_modositas decimal,
    vegleges_mennyiseg decimal
);

create table projekt_felh_hozz_snapshot (
    "id" bigserial primary key,
    felhasznalo_id varchar(255) not null,
    tipus int not null,
    kalk_snapshot_id bigint not null references kalkulacio_snapshot("id")
);