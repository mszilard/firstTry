create table kivitelezo_tipus(
    "kivitelezo_tipus_id" serial primary key,
    "tipus_nev" varchar(255)
);

create table kivitelezo_terulet(
    "kivitelezo_terulet_id" serial primary key,
    "terulet_nev" varchar(255)
);

create table kivitelezo (
    "kivitelezo_id" serial primary key,
    "kivitelezo_tipus_id" integer not null references kivitelezo_tipus("kivitelezo_tipus_id"),
    "kivitelezo_terulet_id" integer not null references kivitelezo_terulet("kivitelezo_terulet_id"),
    "kivitelezo_nev" varchar(255),
    "keretszerzodes_szam" integer,
    "halozat_tipus" integer not null,
    "szallitoi_szam" integer,
    "gyar_szam" integer,
    "raktarhely_szam" integer,
    "vallalasi_szazalek" integer,
    passziv boolean not null default false
);