create table arutetel_sor_fejlec (
    "fejlec_id" serial primary key,
    "lista_allapot" integer,
    "feltoltes_datuma"  date,
    "file_nev" varchar(200)
);