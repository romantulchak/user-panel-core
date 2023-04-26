ALTER TABLE IF EXISTS account
    ADD COLUMN IF NOT EXISTS amount numeric not null default 0;