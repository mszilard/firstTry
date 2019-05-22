create table tudastar_file(
  "tar_id" integer not null references tudastar("tudastar_id"),
  "file_id" uuid not null references tarolt_file("id")
)