ALTER TABLE IF EXISTS goal
    ADD COLUMN IF NOT EXISTS add_date date not null default now();