INSERT INTO "user" VALUES (nextval('user_id_seq'),'bob');
INSERT INTO manufacturer VALUES (nextval('manufacturer_id_seq'),1);
INSERT INTO main_disc VALUES (nextval('main_disc_id_seq'),'disc1','discmaker',1.0,1.0,1.0,1.0,'putteridk',1.6,'22cm','1cm','1cm','.5cm','1cm','1:1','rimconfiguration','very','12/6/97');
INSERT INTO disc VALUES (nextval('disc_id_seq'),1,'disc name','discmaker','plastic plasticy',1.005,1.0,1.0,1.0,1.0,'good disc','fair','blue',false);
INSERT INTO bag VALUES (nextval('bag_id_seq'),1,'testbag','grip');
INSERT INTO bag VALUES (nextval('bag_id_seq'),1,'testbag2','pund');
INSERT INTO disc_bag VALUES (nextval('disc_bag_id_seq'),1,1,1,true);
INSERT INTO plastic VALUES (nextval('plastic_id_seq'),1,'plasticname','very plastic very nice','plastic classification');
INSERT INTO shelf VALUES (nextval('shelf_id_seq'),1,1);