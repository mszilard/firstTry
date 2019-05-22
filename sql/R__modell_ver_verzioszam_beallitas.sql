create or replace function modell_ver_verzioszam_beallitas()
returns trigger as
$$
begin
  NEW.verzio_szam := (select coalesce(max(verzio_szam)+1, 1) from modell_verzio where modell_id=NEW.modell_id);
  return NEW;
end;
$$ language plpgsql;

drop trigger if exists modell_ver_verzioszam_trigger on modell_verzio;

create trigger modell_ver_verzioszam_trigger
before insert
on modell_verzio
for each row
execute procedure modell_ver_verzioszam_beallitas();