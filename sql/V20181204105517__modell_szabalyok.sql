create table tetel (
    "id" serial primary key,
    nev varchar(255) not null,
    tetelszam varchar(255) not null
);

insert into tetel("id", nev, tetelszam) select "id", nev, tetelszam from arutetel;
insert into tetel("id", nev, tetelszam) select dijtetel_id, megnevezes, tetelszam from dijtetel;

alter table arutetel add constraint fk_arutetel_tetel foreign key ("id") references tetel("id");
alter table dijtetel add constraint fk_dijtetel_tetel foreign key (dijtetel_id) references tetel("id");

alter table arutetel drop column tetelszam;
alter table arutetel drop column nev;

alter table dijtetel drop column megnevezes;
alter table dijtetel drop column tetelszam;

create table aktivalasi_szabaly (
    "id" serial primary key,
    nev varchar(255) not null,
    feltetel jsonb not null,
    jellemzo_id int not null,
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);

create table aktivalasi_szab_muvelet (
    "id" serial primary key,
    aktivalasi_szabaly_id int not null references aktivalasi_szabaly("id"),
    nev varchar(255) not null
);

create table tetel_hozzaadas_szab_muvelet (
    "id" integer primary key,
    tetel_id integer not null references tetel("id"),
    mennyiseg_kifejezes text not null
);