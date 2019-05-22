create table letesites(
        "letesites_id" serial primary key,
        "nev" varchar(255),
        "halozat_tipus" integer not null,
        "oraszam" decimal not null default 8.0
);