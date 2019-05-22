create table modell_csoport (
    "id" serial primary key,
    nev varchar(255) not null,
    uzletag int not null,
    szulo_csoport_id int references modell_csoport("id")
);

create table modell (
    "id" serial primary key,
    nev varchar(255) not null,
    uzletag int not null,
    csoport_id int not null references modell_csoport("id"),
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);

create table modell_verzio (
    "id" serial primary key,
    modell_id int not null references modell("id"),
    verzio_szam int not null default 1 check(verzio_szam >= 1),
    aktiv boolean not null,
    modosithato boolean not null,
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255),
    unique(modell_id, verzio_szam)
);

create table modell_jellemzo_csoport (
    "id" serial primary key,
    nev varchar(255) not null,
    modell_verzio_id int not null references modell_verzio("id"),
    sorrend int not null default 1
);

create table modell_jellemzo (
    "id" serial primary key,
    nev varchar(255) not null,
    tipus int not null,
    leiras varchar(2048),
    jellemzo_csoport_id int not null references modell_jellemzo_csoport("id"),
    mertekegyseg_id int references mertekegyseg("id"),
    sorrend int not null default 1,
    modell_verzio_id int not null references modell_verzio("id"),
    valaszto_szam_jellemzo_id int references modell_jellemzo("id"),
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);

create table jellemzo_valasztasok (
    "id" serial primary key,
    nev varchar(255) not null,
    sorrend int not null default 1,
    jellemzo_id int not null references modell_jellemzo("id")
);

create table modell_jellemzo_sablon (
    "id" serial primary key,
    nev varchar(255) not null,
    tipus int not null,
    leiras varchar(2048),
    valaszto_szam_jellemzo_id int references modell_jellemzo_sablon("id")
);

create table jellemzo_valasztasok_sablon (
    "id" serial primary key,
    nev varchar(255) not null,
    jellemzo_sablon_id int not null references modell_jellemzo_sablon("id")
);