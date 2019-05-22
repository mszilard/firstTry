alter table projekt_kalkulacio_tetel
    add column vegleges_mennyiseg decimal,
    drop column if exists terv_modositas_megjegyzes;

create table revinfo (
    rev bigserial primary key,
    rev_ido timestamp with time zone not null
);

create table projekt_AUD (
    "id" int not null,
    REV bigint  not null references REVINFO(REV),
    REVEND bigint references REVINFO(REV),
    REVTYPE smallint not null,
    nev varchar(255),
    koala_dosszie_id varchar(255),
    uzletag int,
    szakasz int,
    szakasz_MOD boolean,
    statusz int,
    statusz_MOD boolean,
    megbizo_id int references megbizo(megbizo_id),
    modositva timestamp with time zone,
    modosito varchar(255),
    primary key ("id", REV)
);

create table projekt_felh_hozzarendeles_AUD (
    "id" int not null,
    REV bigint not null references REVINFO(REV),
    REVEND bigint references REVINFO(REV),
    REVTYPE smallint not null,
    felhasznalo_id varchar(255),
    hozzarendeles_tipus int,
    primary key ("id", REV)
);

create table projekt_projekt_felh_hozzarend_AUD (
    projekt_id int not null,
    felh_hozzarendeles_id int not null,
    REV bigint not null references REVINFO(REV),
    REVEND bigint references REVINFO(REV),
    REVTYPE smallint not null,
    primary key (projekt_id, felh_hozzarendeles_id, REV)
);

create table projekt_kalkulacio_AUD (
    "id" int not null,
    projekt_id int,
    REV bigint not null references REVINFO(REV),
    REVEND bigint references REVINFO(REV),
    REVTYPE smallint not null,
    nev varchar(255),
    statusz int,
    sap_attoltotes_ido timestamp with time zone,
    megjegyzes varchar(2000),
    modositva timestamp with time zone,
    modosito varchar(255),
    primary key ("id", REV)
);

create table projekt_kalk_pst_AUD (
    kalkulacio_id int not null,
    pst_elem_id int not null references pst_elem("id"),
    REV bigint not null references REVINFO(REV),
    REVEND bigint references REVINFO(REV),
    REVTYPE smallint not null,
    primary key (kalkulacio_id, pst_elem_id, REV)
);

create table projekt_kalkulacio_tetel_AUD (
    "id" bigint not null,
    REV bigint not null references REVINFO(REV),
    REVEND bigint references REVINFO(REV),
    REVTYPE smallint not null,
    pst_elem_id int references pst_elem("id"),
    projekt_kalkulacio_id int,
    mennyiseg decimal,
    mennyiseg_MOD boolean,
    szarmazas int,
    tetel_id uuid,
    tetel_koltseg_id bigint references tetel_aktiv_koltseg("id"),
    tetel_koltseg_id_mod boolean,
    terv_modositas decimal,
    terv_modositas_MOD boolean,
    raktarbol decimal,
    raktarbol_MOD boolean,
    tenyadat decimal,
    tenyadat_MOD boolean,
    mertekegyseg_id int references mertekegyseg("id"),
    jovahagyasi_modositas decimal,
    jovahagyasi_modositas_MOD boolean,
    vegleges_mennyiseg decimal,
    vegleges_mennyiseg_MOD boolean,
    valtozas_indok varchar(2000),
    modositva timestamp with time zone,
    modosito varchar(255),
    primary key ("id", REV)
);