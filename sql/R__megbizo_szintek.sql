update szint set szint_nev='Üzem' where szint_nev='UZEM';
update szint set szint_nev='Vállalat' where szint_nev='VALLALAT';

with ins(nev) as ( values
    ('Üzem'),
    ('Vállalat')
)
insert into szint(szint_nev)
select nev
from ins
where not exists (select 1 from szint where ins.nev=szint.szint_nev);