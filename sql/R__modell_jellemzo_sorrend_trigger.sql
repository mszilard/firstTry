create or replace function uj_modell_jellemzo_sorrend()
returns trigger as
$$
begin
  if NEW.sorrend is null or NEW.sorrend = 0 then
    NEW.sorrend := (select coalesce(max(sorrend)+1, 1) from modell_jellemzo where modell_verzio_id=NEW.modell_verzio_id AND jellemzo_csoport_id=NEW.jellemzo_csoport_id);
   end if;
   return NEW;
end;
$$ LANGUAGE plpgsql;

drop trigger if exists uj_modell_jellemzo_sorrend_allitas on modell_jellemzo;

create trigger uj_modell_jellemzo_sorrend_allitas
before insert
on modell_jellemzo
for each row
execute procedure uj_modell_jellemzo_sorrend();