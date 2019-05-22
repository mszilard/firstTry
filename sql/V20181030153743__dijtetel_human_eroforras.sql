create table human_eroforras(
  "human_eroforras_id" serial primary key,
  megnevezes varchar(255),
  oradij decimal,
  halozat_tipus integer not null,
  passziv boolean not null default false
)


