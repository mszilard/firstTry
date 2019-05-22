create table hiba_tipus (
    "hiba_tipus_id" serial primary key,
    "hiba_tipus_megnevezes" varchar(255)
);

create table hiba (
    "hiba_id" serial primary key,
    "hiba_tipus_id" integer not null references hiba_tipus("hiba_tipus_id"),
    "hiba_leiras"  varchar(3000) not null,
    "hiba_file_nev" varchar(200)
);