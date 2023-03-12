CREATE TABLE IF NOT EXISTS account
(
    id      uuid not null primary key,
    user_id uuid not null references users
);

CREATE TABLE IF NOT EXISTS finance
(
    id         uuid             not null primary key,
    value      double precision not null default 0.0,
    date       timestamp        not null default now(),
    type       varchar          not null,
    account_id uuid references account

);