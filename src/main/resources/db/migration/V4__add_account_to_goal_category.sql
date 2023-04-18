ALTER TABLE IF EXISTS goal_category
    ADD COLUMN account_id uuid not null references account;