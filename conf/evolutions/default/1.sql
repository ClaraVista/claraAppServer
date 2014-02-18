# Users schema

# --- !Ups

CREATE TABLE t_userBis (
    login varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    isAdmin boolean NOT NULL,
    PRIMARY KEY (login)
);


CREATE TABLE t_user (
    iduser INT NOT NULL AUTO_INCREMENT,
    login varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    nom varchar(255) NOT NULL,
    prenom varchar(255) NOT NULL,
    isAdmin boolean NOT NULL,        s
    PRIMARY KEY (iduser)
);

  INSERT INTO t_user (login,password)
  VALUES ('germain','tanguy');
  INSERT INTO t_user (login,password)
  VALUES ('ludovic','abgrall');

# --- !Downs

DROP TABLE t_userBis;
DROP TABLE t_user;