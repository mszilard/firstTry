create table szerelo(
      "szerelo_id" serial primary key,
      "nev" varchar(255),
      "aktiv" boolean not null default true,
      "gepkezelo" boolean not null default false,
      "halozat_tipus" integer not null,
      "letesites_id" integer not null references letesites("letesites_id")
)