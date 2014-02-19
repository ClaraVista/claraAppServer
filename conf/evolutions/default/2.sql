
# --- !Ups

CREATE TABLE t_user (
    iduser INT NOT NULL AUTO_INCREMENT,
    login varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    nom varchar(255),
    prenom varchar(255),
    isAdmin boolean NOT NULL,
    PRIMARY KEY (iduser)
);

# --- !Ups
CREATE TABLE t_flow (
    idflow INT NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    firstdate DATE NOT NULL,
    nb_lines_total INT NOT NULL,
    lastreceptiondate DATE NOT NULL,
    nb_lines_received INT NOT NULL,
    PRIMARY KEY (idflow)
);

  INSERT INTO t_user (login,password,isadmin)
  VALUES ('germain','tanguy','false');
  INSERT INTO t_user (login,password,isadmin)
  VALUES ('ludovic','abgrall','false');


  INSERT INTO t_flow (name, firstdate,nb_lines_total,lastreceptiondate,nb_lines_received)
  VALUES ('AAAAA','2008-11-09 ','1000','2010-11-09 ','100');
  INSERT INTO t_flow (name, firstdate,nb_lines_total,lastreceptiondate,nb_lines_received)
  VALUES ('BBBBB','2007-07-07 ','7000','2014-11-09 ','700');

# --- !Downs


DROP TABLE t_user;
DROP TABLE t_flow;