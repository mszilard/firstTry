create extension if not exists "uuid-ossp";

alter table modell_jellemzo add column hivatkozas uuid;
alter table jellemzo_valasztasok add column hivatkozas uuid;
alter table modell_jellemzo_csoport add column hivatkozas uuid;

update modell_jellemzo set hivatkozas=uuid_generate_v4();
update jellemzo_valasztasok set hivatkozas=uuid_generate_v4();
update modell_jellemzo_csoport set hivatkozas=uuid_generate_v4();

alter table modell_jellemzo alter column hivatkozas set not null;
alter table jellemzo_valasztasok alter column hivatkozas set not null;
alter table modell_jellemzo_csoport alter column hivatkozas set not null;

alter table modell_jellemzo add constraint uq_jellemzo_ver unique(modell_verzio_id, hivatkozas);
alter table jellemzo_valasztasok add constraint uq_jellemzo_valaszt_ver unique(jellemzo_id, hivatkozas);
alter table modell_jellemzo_csoport add constraint uq_jellemzo_csop_ver unique(modell_verzio_id, hivatkozas);

alter table modell_jellemzo_sablon add column hivatkozas uuid not null;
alter table jellemzo_valasztasok_sablon add column hivatkozas uuid not null;