create or replace function get_dijtetel_ver_koltseg(variadic _ver_idk int[])
returns table (
  id int,
  gep_koltseg decimal,
  human_koltseg decimal,
  belso_human_koltseg decimal,
  gep_mono_koltseg decimal,
  human_mono_koltseg decimal,
  gep_oraszam decimal,
  human_oraszam decimal,
  gep_mono_oraszam decimal,
  human_mono_oraszam decimal
)
as $$
select distinct on (id)
dv.id,
coalesce((sum(gep_ora.oraszam * gep.oradij) over w) * fejezet.gepszorzo, 0) as gep_koltseg,
coalesce((sum(ember_ora.oraszam * human_eroforras.oradij) over w) * fejezet.humanszorzo, 0) as human_koltseg,
coalesce((sum(ember_ora.oraszam * human_eroforras.belso_oradij) over w) * fejezet.humanszorzo, 0) as belso_human_koltseg,
coalesce((sum(gep_ora.monoblock_oraszam * gep.oradij) over w) * fejezet.gepszorzo, 0) as gep_mono_koltseg,
coalesce((sum(ember_ora.monoblock_oraszam * human_eroforras.oradij) over w) * fejezet.humanszorzo, 0) as human_mono_koltseg,
coalesce((sum(gep_ora.oraszam) over w), 0) as gep_oraszam,
coalesce((sum(ember_ora.oraszam) over w), 0) as human_oraszam,
coalesce((sum(gep_ora.monoblock_oraszam) over w), 0) as gep_mono_oraszam,
coalesce((sum(ember_ora.monoblock_oraszam) over w), 0) as human_mono_oraszam
from dijtetel_verzio dv
inner join fejezet on fejezet.fejezet_id=dv.fejezet_id
left outer join gep_ora on gep_ora.dijtetel_ver_id=dv.id
left outer join gep on gep.gep_eroforras_id=gep_ora.gep_eroforras_id
left outer join ember_ora on ember_ora.dijtetel_ver_id=dv.id
left outer join human_eroforras on human_eroforras.human_eroforras_id=ember_ora.ember_eroforras_id
where dv.id=any(_ver_idk)
window w as (partition by id);
$$
language sql;