   # --- !Ups
      INSERT INTO  t_format_indicators  (idformat, fieldname, indicatorname, orderofname)
      VALUES ('2','test5','Test lordre du champs ordre 5', '5');
      INSERT INTO  t_format_indicators  (idformat, fieldname, indicatorname, orderofname)
      VALUES ('2','test4','Test lordre du champs ordre 4', '4');

 CREATE TABLE t_file_received (
      idreception SERIAL NOT NULL,
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

     # --- !Ups
 CREATE TABLE t_format_indicators (
      idindicator SERIAL NOT NULL,
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
           id_client SERIAL NOT NULL,
           ca_lastmonth INT NOT NULL,
           nb_pages INT NOT NULL,
           PRIMARY KEY (id_client)
       );


# --- !Down

DROP TABLE t_file_received;
DROP TABLE recep2;
DROP TABLE t_format_indicators;