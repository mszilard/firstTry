create table excel_valtozo_tetel(
    "id" uuid primary key references tetel("id"),
    "tetelszam" varchar(255) not null unique,
    "nev" varchar(255),
    "kornyezetvedelem" varchar(255),
    "koltsegnem" varchar(255),
    "mertekegyseg_id" integer not null references mertekegyseg("id"),
    "egysegar" integer not null check (egysegar > 0),
    "arutetelproblema" integer,
    "passziv" boolean not null default false
);