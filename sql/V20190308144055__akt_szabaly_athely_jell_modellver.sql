alter table aktivalasi_szabaly add column modell_verzio_id int references modell_verzio("id");
update aktivalasi_szabaly set modell_verzio_id=(select j.modell_verzio_id from modell_jellemzo j where j.id=aktivalasi_szabaly.jellemzo_id);
alter table aktivalasi_szabaly
    alter column modell_verzio_id set not null,
    drop column jellemzo_id;