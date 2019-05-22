delete from alap_elokalkulacio_pst;
insert into alap_elokalkulacio_pst("id", kod, nev, szulo_id) values
    (1, 'semmi', '%s', null),
    (2, 'semmi', '%s', 1),
    (3, 'semmi', '%s', 2),
    (4, 'semmi', 'ELÕKÉSZÍTÉS KIF KÁB. - %s', 3),
    (5, 'semmi', 'JAR.NA.TEV - %s', 4),
    (6, 'semmi', 'TERVEZES - %s', 4),
    (7, 'semmi', 'MEGVALÓSÍTÁS KIF KÁB. - %s', 3),
    (8, 'semmi', 'JAR.TEV - %s', 7),
    (9, 'semmi', 'KABEL.H.KIF- %s', 7),
    (10, 'semmi', 'EGYÉB KIF KÁB. - %s', 3),
    (11, 'semmi', 'VEZETEKJOG - %s', 10),
    (12, 'semmi', 'KARTALANITAS - %s', 10);

select setval('alap_elokalkulacio_pst_id_seq', 12, true);