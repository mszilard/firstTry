alter table dijtetel_verzio add column  harom_feles_sor varchar(255);

update dijtetel_verzio set harom_feles_sor = '' ;

alter table dijtetel_verzio alter column  harom_feles_sor set not null;

