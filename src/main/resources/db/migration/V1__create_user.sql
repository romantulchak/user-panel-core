CREATE TABLE IF NOT EXISTS users
(
    id       uuid               not null primary key,
    email    varchar(35) unique not null,
    name     varchar(40)        not null,
    password varchar(24)        not null
)