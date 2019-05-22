create table aktivalasi_szabaly_hiv_jellemzok (
    aktivalasi_szabaly_id int not null references aktivalasi_szabaly("id"),
    jellemzo_hivatkozas uuid not null
);