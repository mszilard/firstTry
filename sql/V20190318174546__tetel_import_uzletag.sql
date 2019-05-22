alter table tetel
    add column uzletag int not null,
    drop constraint uq_tetelszam,
    add constraint uq_tetelszam_uzletag unique(tetelszam, uzletag);

alter table arutetel drop column uzletag;
alter table dijtetel drop column uzletag;

alter table idozitett_anyag_lista add column uzletag int not null;
alter table cserelendo_arutetel add column uzletag int not null;

alter table idozitett_valtozo_anyag_lista add column uzletag int not null;
alter table valtozo_cserelendo_arutetel add column uzletag int not null;
alter table excel_valtozo_tetel add column uzletag int not null;
alter table valtozo_arutetel_sor_fejlec add column uzletag int not null;