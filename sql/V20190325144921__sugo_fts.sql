alter table topic
    alter column topic_leiras type text,
    add column topic_leiras_ts tsvector;

create extension if not exists unaccent;

CREATE TEXT SEARCH DICTIONARY public.simple_hun_dict (
    TEMPLATE = pg_catalog.simple,
    STOPWORDS = hungarian
);

CREATE TEXT SEARCH CONFIGURATION hu_simple ( COPY = hungarian );
ALTER TEXT SEARCH CONFIGURATION hu_simple ALTER MAPPING
FOR asciiword, asciihword, hword_asciipart, hword, hword_part, word WITH unaccent, simple_hun_dict;

CREATE FUNCTION topic_leiras_fts_trigger() RETURNS trigger AS $$
begin
  new.topic_leiras_ts :=
     to_tsvector('pg_catalog.hungarian', coalesce(new.topic_leiras,'')) ||
     to_tsvector('public.hu_simple', coalesce(new.topic_leiras,''));
  return new;
end
$$ LANGUAGE plpgsql;

CREATE TRIGGER topic_leiras_tsvector_upd BEFORE INSERT OR UPDATE
    ON topic FOR EACH ROW EXECUTE PROCEDURE topic_leiras_fts_trigger();