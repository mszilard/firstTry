with ins(nev, halozat_tipus) as ( values
    ('Kaposvár',0),
    ('Siófok',0),
    ('Nagykanizsa',0),
    ('Keszthely',0),
    ('Szekszárd',0),
    ('Dunaújváros',0),
    ('Pécs',0),
    ('Kapuvár',0),
    ('Győr',0),
    ('Tatabánya',0),
    ('Veszprém',0),
    ('Pápa',0),
    ('Szombathely',0),
    ('Zalaegerszeg',0),
    ('Székesfehérvár',0),
    ('Szajol',0),
    ('Berettyóújfalu',0),
    ('Debrecen',0),
    ('Nyíregyháza',0),
    ('Mátészalka',0)
)
insert into letesites(nev, halozat_tipus)
select nev, halozat_tipus
from ins
where not exists (select 1 from letesites where ins.nev=letesites.nev and ins.halozat_tipus=letesites.halozat_tipus);