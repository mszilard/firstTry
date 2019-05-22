create table gep(
  "gep_eroforras_id" serial primary key,
  nev varchar(255) not null,
  oradij integer not null,
  halozat_tipus integer not null,
  passziv boolean not null default false

);