create table unit_of_measure (
    "id" serial primary key,
    "name" varchar(255) not null unique
);

create table materials (
    "id" serial primary key,
    item_number varchar(18) not null unique,
    "name" varchar(255) not null,
    price integer not null check (price > 0),
    unit_id integer not null references unit_of_measure("id")
);

