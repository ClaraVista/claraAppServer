
 # --- !Ups


 CREATE TABLE t_globalid (
      idindicator INT NOT NULL AUTO_INCREMENT,
      name varchar(255) NOT NULL,
      description varchar(255) NOT NULL,
      orderofname INT NOT NULL UNIQUE,
      valueofname INT NOT NULL,
      PRIMARY KEY (idindicator)
  );

INSERT INTO t_globalid (name, description,orderofname,valueofname)
VALUES ('Nombre de clients','Nombres de clientts dans la BDD ','2','325000');

INSERT INTO t_globalid (name, description,orderofname,valueofname)
VALUES ('Nombre de prospects','Nombres de prospects sur website ','3','4500');


INSERT INTO t_globalid (name, description,orderofname,valueofname)
VALUES ('Test lordre dynamique','ok','1','0000');
# --- !Down

DROP TABLE t_globalid;