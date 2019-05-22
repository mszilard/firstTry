create table kivitelezo_rezsianyag(
  "kivitelezo_id" integer not null references kivitelezo("kivitelezo_id"),
  "arutetel_id" uuid not null references arutetel("id")
)