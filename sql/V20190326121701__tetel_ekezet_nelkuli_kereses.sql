CREATE OR REPLACE FUNCTION public.f_unaccent(text)
  RETURNS text AS
$func$
SELECT public.unaccent('public.unaccent', $1)
$func$  LANGUAGE sql IMMUTABLE;

create extension pg_trgm;
create index tetel_unaccent_nev_trgm_idx on tetel
using gin (lower(public.f_unaccent(nev)) gin_trgm_ops);