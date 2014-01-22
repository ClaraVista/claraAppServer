# Users schema

# --- !Ups

CREATE TABLE t_user (
    login varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    isAdmin boolean NOT NULL,
    PRIMARY KEY (login)
);

# --- !Downs

DROP TABLE User;