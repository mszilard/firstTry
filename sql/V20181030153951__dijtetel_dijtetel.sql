create table dijtetel(
  "dijtetel_id" serial primary key,
  halozat_tipus integer not null,
  tetelszam varchar(255) not null,
  megnevezes varchar(255) not null,
  megjegyzes varchar(1000) not null,
  leiras varchar(2000) not null,
  "fejezet_id" integer references fejezet("fejezet_id"),
  mertekegyseg_id integer references mertekegyseg("id")
);

create table ember_ora(
     "ember_ora_id" serial primary key,
     "dijtetel_id" integer references dijtetel("dijtetel_id"),
     "ember_eroforras_id" integer references human_eroforras("human_eroforras_id") not null,
     "oraszam" integer  not null
);

create table gep_ora(
     "gep_ora_id" serial primary key,
     "gep_eroforras_id" integer references gep("gep_eroforras_id") not null,
     "dijtetel_id" integer references dijtetel("dijtetel_id"),
     "oraszam" integer not null
);

