create or replace view modell_aktiv_verzioval as
select
m.*,
(select "id" from modell_verzio ver where ver.aktiv=true and ver.modell_id=m.id) as aktiv_ver_id
from modell m