update kivitelezo_tipus set tipus_nev='Saját kivitelező' where tipus_nev='Sajat kivitelezo';
update kivitelezo_tipus set tipus_nev='Minősített kivitelező' where tipus_nev='Minositett kivitelezo';
update kivitelezo_tipus set tipus_nev='Szerződött kivitelező' where tipus_nev='Szerzodott kivitelezo';

with ins(nev) as ( values
    ('Sajat kivitelezo'),
    ('Minositett kivitelezo'),
    ('Szerzodott kivitelezo')
)
insert into kivitelezo_tipus(tipus_nev)
select nev
from ins
where not exists (select 1 from kivitelezo_tipus where ins.nev=kivitelezo_tipus.tipus_nev);