alter table tipusterv
    drop column tipusterv_file_nev,
    add column tarolt_file_id uuid not null references tarolt_file("id");

alter table muszakiterv
    drop column muszakiterv_file_nev,
    add column tarolt_file_id uuid not null references tarolt_file("id");