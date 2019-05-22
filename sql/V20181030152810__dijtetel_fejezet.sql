create table fejezet(
  "fejezet_id" serial primary key,
  uzletag integer,
  sorszam integer not null,
  megnevezes varchar(255) not null,
  rovidnev varchar(255) not null,
  humanszorzo decimal not null,
  gepszorzo decimal not null
);