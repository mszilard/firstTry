create table segedlet_file(
  "terv_id" integer not null references tervezesisegedlet("segedlet_id"),
  "file_id" uuid not null references tarolt_file("id")
)