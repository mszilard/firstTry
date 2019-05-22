create table tarolt_file_tartalom (
    "id" bigserial not null primary key,
    eleres varchar(2000) not null,
    mime_tipus varchar(255) not null,
    meret bigint not null,
    "hash" varchar(100) not null
);

create table tarolt_file (
    "id" uuid not null primary key,
    nev varchar(1024) not null,
    tartalom_id int not null references tarolt_file_tartalom("id"),
    letrehozva timestamp with time zone not null default current_timestamp,
    letrehozo varchar(255) not null,
    modositva timestamp with time zone,
    modosito varchar(255)
);