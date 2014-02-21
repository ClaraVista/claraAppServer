     # --- !Ups
 DROP TABLE t_file_received;
 DROP TABLE t_format_indicators;

 CREATE TABLE t_file_received (
      idreception INT NOT NULL AUTO_INCREMENT,
      receptiondate  DATE NOT NULL,
      tablename varchar(255) NOT NULL,
      idformat INT,
      PRIMARY KEY (idreception)
  );


INSERT INTO t_file_received (receptiondate,tablename, idformat)
VALUES ('2008-11-09','recep1', '1');
INSERT INTO t_file_received (receptiondate,tablename, idformat)
VALUES ('2008-11-09','recep2', '2');
INSERT INTO t_file_received (receptiondate,tablename, idformat)
VALUES ('2008-11-09','recep3 ','2');

 CREATE TABLE t_format_indicators (
      idindicator INT NOT NULL AUTO_INCREMENT,
      idformat INT NOT NULL,
      fieldname  varchar(255) NOT NULL,
      indicatorname varchar(255) NOT NULL,
      orderofname INT NOT NULL,
      PRIMARY KEY (idindicator)
  );

  INSERT INTO  t_format_indicators  (idformat, fieldname, indicatorname, orderofname)
  VALUES ('1','id_client','Identifiant du client', '1');
  INSERT INTO  t_format_indicators  (idformat, fieldname, indicatorname, orderofname)
  VALUES ('1','ca_3month','Ca des 3 derniers mois', '2');
  INSERT INTO  t_format_indicators  (idformat, fieldname, indicatorname, orderofname)
  VALUES ('2','id_client','Identifiant du client', '1');
  INSERT INTO  t_format_indicators  (idformat, fieldname, indicatorname, orderofname)
  VALUES ('2','ca_lastmonth','Ca du dernier mois', '2');
  INSERT INTO  t_format_indicators  (idformat, fieldname, indicatorname, orderofname)
  VALUES ('2','nb_pages','Nombre de pages vues le dernier mois', '3');

   CREATE TABLE recep2 (
        id_client INT NOT NULL AUTO_INCREMENT,
        ca_lastmonth INT NOT NULL,
        nb_pages INT NOT NULL,
        PRIMARY KEY (id_client)
    );


# --- !Down

DROP TABLE t_file_received;
DROP TABLE recep2;
DROP TABLE t_format_indicators;