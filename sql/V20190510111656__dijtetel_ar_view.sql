create or replace view tetel_ervenyes_ar as
select *
from tetel_aktiv_koltseg
where kezdet<=current_date and (veg>current_date or veg is null);

create or replace view dijtetel_ver_ervenyes_arral as
select
dv.*,
sor.uzletag as uzletag,
coalesce(ar.ar, 0) as ar,
coalesce(ar.human_oraszam, 0) as human_oraszam,
coalesce(ar.gep_oraszam, 0) as gep_oraszam,
(select max(modositva) from dijtetel_verzio where dijtetel_verzio.dijtetel_id=dv.dijtetel_id) as utolso_modositas
from dijtetel_verzio dv
inner join dijtetelsor sor on sor.id=dv.dijtetelsor_id
left outer join tetel_ervenyes_ar ar on ar.tetel_id=dv.dijtetel_id;
