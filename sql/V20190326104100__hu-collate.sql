drop view if exists modell_aktiv_verzioval;

alter table aktivalasi_szab_muvelet alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table aktivalasi_szabaly alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table dijtetelsor alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table dokumentum alter column dokumentum_nev type varchar(255) collate "hu-HU-x-icu";
alter table excel_arutetel alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table excel_valtozo_tetel alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table fejezet
	alter column megnevezes type varchar(255) collate "hu-HU-x-icu",
	alter column rovidnev type varchar(255) collate "hu-HU-x-icu";
alter table gep alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table human_eroforras alter column megnevezes type varchar(255) collate "hu-HU-x-icu";
alter table kivitelezo alter column kivitelezo_nev type varchar(255) collate "hu-HU-x-icu";
alter table kivitelezo_terulet alter column terulet_nev type varchar(255) collate "hu-HU-x-icu";
alter table kivitelezo_tipus alter column tipus_nev type varchar(255) collate "hu-HU-x-icu";
alter table letesites alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table megbizo
	alter column megbizo_rovid_nev type varchar(255) collate "hu-HU-x-icu",
	alter column megbizo_teljes_nev type varchar(255) collate "hu-HU-x-icu";
alter table mertekegyseg alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table modell alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table modell_csoport alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table monoblock alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table muszakiterv alter column muszakiterv_megnevezes type varchar(255) collate "hu-HU-x-icu";
alter table orszag alter column orszag_nev type varchar(255) collate "hu-HU-x-icu";
alter table problemasarutetel alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table projekt
	alter column nev type varchar(255) collate "hu-HU-x-icu",
	alter column koala_dosszie_id type varchar(255) collate "hu-HU-x-icu";
alter table projekt_kalkulacio alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table skill alter column "name" type varchar(255) collate "hu-HU-x-icu";
alter table szerelo alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table szint alter column szint_nev type varchar(255) collate "hu-HU-x-icu";
alter table telepules alter column telepules_nev type varchar(255) collate "hu-HU-x-icu";
alter table tervezesisegedlet alter column segedlet_nev type varchar(255) collate "hu-HU-x-icu";
alter table tetel alter column nev type varchar(255) collate "hu-HU-x-icu";
alter table tipusterv alter column tipusterv_megnevezes type varchar(255) collate "hu-HU-x-icu";
alter table topic alter column topic_cim type varchar(500) collate "hu-HU-x-icu";
alter table topic_group alter column topic_group_title type varchar(500) collate "hu-HU-x-icu";
alter table tudastar
	alter column tudastar_nev type varchar(255) collate "hu-HU-x-icu",
	alter column tudastar_szam type varchar(255) collate "hu-HU-x-icu";
alter table vallalat
	alter column rovidites type varchar(255) collate "hu-HU-x-icu",
	alter column vallalat_nev type varchar(255) collate "hu-HU-x-icu";

create or replace view modell_aktiv_verzioval as
select
m.*,
(select "id" from modell_verzio ver where ver.aktiv=true and ver.modell_id=m.id) as aktiv_ver_id
from modell m