create table megbizo_felhasznalok (
    "id" serial primary key,
    felhasznalo_id varchar(255) not null,
    megbizo_id int not null references megbizo(megbizo_id),
    unique(megbizo_id, felhasznalo_id)
);