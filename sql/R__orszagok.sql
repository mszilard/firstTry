update orszag set orszag_nev='Magyaroszág' where orszag_nev='MAGYARORSZAG';
update orszag set orszag_nev='Németország' where orszag_nev='NEMETORSZAG';
update orszag set orszag_nev='Olaszország' where orszag_nev='OLASZORSZAG';

with ins(nev) as ( values
    ('Magyaroszág'),
    ('Németország'),
    ('Olaszország')
)
insert into orszag(orszag_nev)
select nev
from ins
where not exists (select 1 from orszag where ins.nev=orszag.orszag_nev);