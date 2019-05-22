create table dijtetel_history(
   "dijtetel_history_id" serial primary key,
   "kezdo_datum" date not null,
   "dijtetel_id" integer not null references dijtetel("dijtetel_id"),
   "osszeg" decimal not null
);