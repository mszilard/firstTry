alter table megbizo add column telepules_id integer not null references telepules("telepules_id");
alter table megbizo drop column orszag_id;