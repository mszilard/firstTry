alter table arutetel rename column cikkszam to import_tetelszam;

alter table excel_arutetel rename column cikkszam to import_tetelszam;
alter table excel_arutetel alter column import_tetelszam type varchar(255);