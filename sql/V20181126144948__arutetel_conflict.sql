create table problemasarutetel(
    "id" serial primary key,
    "tetelszam" varchar(18) not null unique,
    "nev" varchar(255) not null,
    "ar" integer not null check (ar > 0),
    "mertekegyseg_id" integer not null references mertekegyseg("id"),
    "kozos" boolean not null default false,
    "uzletag" integer,
    "beszerzo" varchar(255),
    "besorolas" varchar(255),
    "keretszerzodes" varchar(255),
    "kerekites" varchar(255),
    "helyszinreelozetes1" varchar(255),
    "helyszinreelozetes2" varchar(255),
    "utanpotlasiido" varchar(255),
    "cikkszam" varchar(255),
    "arutetelproblema" integer
);