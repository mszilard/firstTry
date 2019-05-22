alter table kivitelezo drop column keretszerzodes_szam;
alter table kivitelezo drop column szallitoi_szam;
alter table kivitelezo drop column gyar_szam;
alter table kivitelezo drop column raktarhely_szam;
alter table kivitelezo drop column vallalasi_szazalek;

create table kivitelezo_uzem(
    "kivitelezo_uzem_id" serial primary key,
    "uzem_id" integer not null references megbizo("megbizo_id"),
    "kivitelezo_id" integer not null references kivitelezo("kivitelezo_id"),
    "keretszerzodes_szam" integer,
    "halozat_tipus" integer not null,
    "szallitoi_szam" integer,
    "gyar_szam" integer,
    "raktarhely_szam" integer,
    "vallalasi_szazalek" integer
);