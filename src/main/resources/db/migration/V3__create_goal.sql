CREATE TABLE IF NOT EXISTS goal_category
(
    id        uuid    not null primary key,
    name      varchar not null,
    icon_path varchar
);

CREATE TABLE IF NOT EXISTS goal
(
    id          uuid    not null primary key,
    name        varchar not null,
    price       double precision default 0,
    is_active   bool             default false,
    icon_path   varchar not null,
    category_id uuid    not null references goal_category,
    account_id  uuid    not null references account
);