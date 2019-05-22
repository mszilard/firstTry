create table dokumentum(
    "dokumentum_id" serial primary key,
    "dokumentum_nev" varchar(255) not null,
    "dokumentum_szam" varchar(255) not null,
    "dokumentum_tipus" integer not null,
    "uzletag" integer not null
);

create table dokumentum_file(
  "dokumentum_id" integer not null references dokumentum("dokumentum_id"),
  "file_id" uuid not null references tarolt_file("id")
);