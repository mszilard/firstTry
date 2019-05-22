alter table kalkulacio_snapshot add column human_ora_koltseg decimal not null default 0;
alter table kalkulacio_snapshot add column kalkulacio_ar decimal not null default 0;
alter table kalkulacio_snapshot add column kalkulacio_ar_MOD boolean;
alter table kalkulacio_snapshot add column human_ora_koltseg_MOD boolean;

alter table pst_elem_snapshot add column eredeti_id int not null;
alter table pst_elem_snapshot add column ertek decimal not null default 0;

CREATE TABLE kalkulacio_snapshot_aud (
    "id" bigint not null,
	kalkulacio_id int4 NOT NULL,
	rev int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	human_ora_koltseg numeric NULL,
	human_ora_koltseg_mod bool NULL,
	kalkulacio_ar numeric NULL,
	kalkulacio_ar_mod bool NULL,
	letrehozas timestamp NULL,
	ok varchar(255) NULL,
	projekt_statusz int4 NULL,
	projekt_szakasz int4 NULL,
	CONSTRAINT kalkulacio_snapshot_aud_pkey PRIMARY KEY ("id", rev),
	CONSTRAINT fk_kalk_snap_revend FOREIGN KEY (revend) REFERENCES revinfo(rev),
	CONSTRAINT fk_kalk_snap_rev FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE kitoltott_modell_ver_snapshot_aud (
	id int8 NOT NULL,
	rev int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	verzio_id int4 NULL,
	CONSTRAINT kitoltott_modell_ver_snapshot_aud_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fk5elyniuvq621sx0904utsh2lg FOREIGN KEY (revend) REFERENCES revinfo(rev),
	CONSTRAINT fkmumv6po55tj41b9gq9n70o39y FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE jellemzo_ertek_snapshot_aud (
	id int8 NOT NULL,
	rev int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	hivatkozas uuid NULL,
	jellemzo_nev varchar(255) NULL,
	jellemzo_tipus int4 NULL,
	szam_jellemzo_ertek numeric NULL,
	valasztas_ertek varchar(255) NULL,
	valasztas_id uuid NULL,
	CONSTRAINT jellemzo_ertek_snapshot_aud_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fkh30i0fl6mj2rhqnb5fojokrvy FOREIGN KEY (revend) REFERENCES revinfo(rev),
	CONSTRAINT fkqmqwn68goota6pf28jwrbtvgf FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE pst_elem_snapshot_aud (
	id int8 NOT NULL,
	rev int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	azonosito varchar(255) NULL,
	eredeti_id int4 NULL,
	ertek numeric NULL,
	nev varchar(255) NULL,
	kitoltott_modell_ver_snapshot_id int8 NULL,
	kalkulacio_snapshot_id int4 NULL,
	szulo_id int8 NULL,
	CONSTRAINT pst_elem_snapshot_aud_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fkb33q3lhs2v9ypupd1yd5hq6q3 FOREIGN KEY (revend) REFERENCES revinfo(rev),
	CONSTRAINT fkq68a59m2mmfiiwhayg4aoqo70 FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE public.projekt_felh_hozz_snapshot_aud (
	id int8 NOT NULL,
	rev int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	felhasznalo_id varchar(255) NULL,
	tipus int4 NULL,
	CONSTRAINT projekt_felh_hozz_snapshot_aud_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fk4dyosa0lm6ba6koutk1h3r841 FOREIGN KEY (revend) REFERENCES revinfo(rev),
	CONSTRAINT fkt4e4df2pm5hoieinvovjxi4uv FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE public.kalkulacio_tetel_snapshot_aud (
	id int8 NOT NULL,
	rev int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	jovahagyasi_modositas numeric NULL,
	jovahagyasi_modositas_mod bool NULL,
	kalkulacio_tetel_id int8 NULL,
	mennyiseg numeric NULL,
	mennyiseg_mod bool NULL,
	raktarbol numeric NULL,
	raktarbol_mod bool NULL,
	szarmazas int4 NULL,
	tenyadat numeric NULL,
	tenyadat_mod bool NULL,
	terv_modositas numeric NULL,
	terv_modositas_mod bool NULL,
	vegleges_mennyiseg numeric NULL,
	vegleges_mennyiseg_mod bool NULL,
	mertekegyseg_id int4 NULL,
	pst_snapshot_id int8 NULL,
	kalk_snapshot_id int4 NULL,
	tetel_id uuid NULL,
	tetel_koltseg_id int8 NULL,
	tetel_koltseg_id_mod bool NULL,
	CONSTRAINT kalkulacio_tetel_snapshot_aud_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fkami91e197layfj168eyd7aadt FOREIGN KEY (revend) REFERENCES revinfo(rev),
	CONSTRAINT fkaseroac6y29ctl4jum3fenxcu FOREIGN KEY (rev) REFERENCES revinfo(rev)
);

CREATE TABLE kalk_snapshot_felhasznalo_hozzarendeles_aud (
	rev int8 NOT NULL,
	kalk_snapshot_id int4 NOT NULL,
	id int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	CONSTRAINT kalkulacio_snapshot_projekt_felhasznalo_hozzarendeles_snap_pkey PRIMARY KEY (rev, kalk_snapshot_id, id),
	CONSTRAINT fk4ifjek2u09nv5783jjrcil2s8 FOREIGN KEY (rev) REFERENCES revinfo(rev),
	CONSTRAINT fkdcsqkvi04w8pkhd3h09axn6br FOREIGN KEY (revend) REFERENCES revinfo(rev)
);

CREATE TABLE kitoltott_modell_ver_snap_jell_ert_aud (
	rev int8 NOT NULL,
	kit_ver_snapshot_id int8 NOT NULL,
	id int8 NOT NULL,
	revtype int2 NULL,
	revend int8 NULL,
	CONSTRAINT kitoltott_modell_ver_snapshot_jellemzo_ertek_snapshot_aud_pkey PRIMARY KEY (rev, kit_ver_snapshot_id, id),
	CONSTRAINT fk4nla2f83y3ehvj05dkx05l5tc FOREIGN KEY (revend) REFERENCES revinfo(rev),
	CONSTRAINT fkftbxad55tx33b7rs9jdlsfg75 FOREIGN KEY (rev) REFERENCES revinfo(rev)
);