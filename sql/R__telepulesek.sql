with ins(nev) as ( values
    ('Pécs'),
    ('Győr'),
    ('Kaposvár'),
    ('Debrecen'),
    ('Veszprém'),
    ('Szekszárd'),
    ('Nagykanizsa'),
    ('Székesfehérvár'),
    ('Szombathely'),
    ('Tatabánya'),
    ('Nyíregyháza'),
    ('Szolnok')
)
insert into telepules(telepules_nev)
select nev
from ins
where not exists (select 1 from telepules where ins.nev=telepules.telepules_nev);