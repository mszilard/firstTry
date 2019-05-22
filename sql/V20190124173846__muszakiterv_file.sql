create table muszakiterv_file(
  "terv_id" integer not null references muszakiterv("muszakiterv_id"),
  "file_id" uuid not null references tarolt_file("id")
)