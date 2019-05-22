create table monoblock(
    "monoblock_id" serial primary key,
    "nev" varchar(255),
    "halozat_tipus" integer not null,
    "skill_id" integer references skill("skill_id")
)