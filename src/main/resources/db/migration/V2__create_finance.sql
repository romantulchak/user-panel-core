CREATE TABLE IF NOT EXISTS finance
(
    id      uuid not null primary key,
    user_id uuid not null references users
);

CREATE TABLE IF NOT EXISTS income
(
    id         uuid             not null primary key,
    value      double precision not null default 0.0,
    date       timestamp        not null default now(),
    finance_id uuid references finance

);

CREATE TABLE IF NOT EXISTS expense
(
    id         uuid             not null primary key,
    value      double precision not null default 0.0,
    date       timestamp        not null default now(),
    finance_id uuid references finance

);