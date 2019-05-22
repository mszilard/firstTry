create table szint (
    "szint_id" serial primary key,
    "szint_nev" varchar(255)
);

create table orszag (
    "orszag_id" serial primary key,
    "orszag_nev" varchar(255)
);
create table megbizo (
    "megbizo_id" serial primary key,
    "megbizo_rovid_nev" varchar(255),
    "halozat_tipus" integer not null,
    "megbizo_teljes_nev" varchar(255),
    "szint_id" integer not null references szint("szint_id"),
    "orszag_id" integer not null references orszag("orszag_id"),
    passziv boolean not null default false
);