alter table projekt add column folyamat_id varchar(50);
alter table projekt_kalkulacio
    add column organizacios_becsles_datum date,
    alter column sap_attoltotes_ido type date using sap_attoltotes_ido::date;