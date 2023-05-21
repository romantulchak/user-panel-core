CREATE TABLE IF NOT EXISTS purchase
(
    id         uuid      not null primary key,
    name       varchar   null,
    shop       varchar   not null,
    date_time  timestamp not null default now(),
    item_count int       not null default 0,
    account_id uuid      not null references account
);

CREATE TABLE IF NOT EXISTS item
(
    id          uuid             not null primary key,
    name        varchar(99)      not null,
    price       double precision not null default 0.0,
    amount      int              not null default 1,
    purchase_id uuid             not null references purchase
);