create table tipusterv_file(
  "terv_id" integer not null references tipusterv("tipusterv_id"),
  "file_id" uuid not null references tarolt_file("id")
)