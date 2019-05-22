create table skill(
    "skill_id" serial primary key,
    "name" varchar(255),
    "halozat_tipus" integer not null,
    "aktiv" boolean not null default true
)