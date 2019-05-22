
create table topic_group(
    topic_group_id serial primary key,
    topic_group_title varchar(500) not null
);
create table topic(
    topic_id serial primary key,
    topic_cim varchar(500) not null,
    topic_leiras varchar(60000) not null,
    topic_group_id integer not null references topic_group("topic_group_id")
);

