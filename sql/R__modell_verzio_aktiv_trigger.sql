create or replace function modell_ver_aktiv_beallitas()
returns trigger as
$$
begin
  if NEW.aktiv is true then
    update modell_verzio set aktiv=false where modell_id=NEW.modell_id and aktiv is true;
  end if;
  return NEW;
end;
$$ LANGUAGE plpgsql;

drop trigger if exists modell_ver_aktiv_valtozas on modell_verzio;

create trigger modell_ver_aktiv_valtozas
before insert or update
on modell_verzio
for each row
execute procedure modell_ver_aktiv_beallitas();

