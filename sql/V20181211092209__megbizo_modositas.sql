alter table megbizo add column vallalat_id integer not null references vallalat("id");
alter table megbizo drop column szint_id;
