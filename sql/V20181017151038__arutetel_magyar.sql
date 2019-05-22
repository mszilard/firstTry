alter table materials rename column item_number to tetelszam;
alter table materials rename column "name" to nev;
alter table materials rename column price to ar;
alter table materials rename column unit_id to mertekegyseg_id;

alter table unit_of_measure rename column "name" to nev;

alter table materials rename to arutetel;
alter table unit_of_measure rename to mertekegyseg;