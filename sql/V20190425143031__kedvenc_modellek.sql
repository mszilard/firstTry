create table modell_kedvencek (
    "id" serial primary key,
    modell_id int not null references modell("id"),
    felhasznalo_id varchar(255) not null
);