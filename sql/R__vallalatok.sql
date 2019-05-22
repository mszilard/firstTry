with ins(rovid, nev) as ( values
    ('EDE','E.ON Dél-dunántúli Áramhálózati Zrt.'),
    ('EDD','E.ON Észak-dunántúli Áramhálózati Zrt.'),
    ('ETI','E.ON Tiszántúli Áramhálózati Zrt.'),
    ('EDD','E.ON Dél-dunántúli Gázhálózati Zrt.'),
    ('EKO','E.ON Közép-dunántúli Gáz hálózati Zrt.')
)
insert into vallalat(rovidites, vallalat_nev)
select rovid, nev
from ins
where not exists (select 1 from vallalat where ins.rovid=vallalat.rovidites);