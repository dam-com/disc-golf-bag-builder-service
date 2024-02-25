create schema if not exists dbb;
set schema 'dbb';

DO $$ DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END $$;

CREATE TABLE "user"
(
    id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NOT NULL
);
ALTER TABLE "user" ADD PRIMARY KEY (id);
CREATE SEQUENCE user_id_seq START 1 INCREMENT 1 OWNED BY "user".id;


CREATE TABLE main_disc
(
    id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NOT NULL,
    manufacturer CHARACTER VARYING(255) NULL,
    speed DECIMAL(8, 2) NULL,
    glide DECIMAL(8, 2) NULL,
    turn DECIMAL(8, 2) NULL,
    fade DECIMAL(8, 2) NULL,
    description CHARACTER VARYING(255) NULL,
    max_weight DECIMAL(8, 2) NULL,
    diameter CHARACTER VARYING(255) NULL,
    height CHARACTER VARYING(255) NULL,
    rim_depth CHARACTER VARYING(255) NULL,
    inside_rim_diameter CHARACTER VARYING(255) NULL,
    rim_thickness CHARACTER VARYING(255) NULL,
    rim_depth_diameter_ratio CHARACTER VARYING(255) NULL,
    rim_configuration CHARACTER VARYING(255) NULL,
    flexibility CHARACTER VARYING(255) NULL,
    approved_date CHARACTER VARYING(255) NULL
);
ALTER TABLE main_disc ADD PRIMARY KEY (id);
CREATE SEQUENCE main_disc_id_seq START 1 INCREMENT 1 OWNED BY main_disc.id;


CREATE TABLE manufacturer
(
    id BIGINT NOT NULL,
    name BIGINT NULL
);
ALTER TABLE manufacturer ADD PRIMARY KEY (id);
CREATE SEQUENCE manufacturer_id_seq START 1 INCREMENT 1 OWNED BY manufacturer.id;


CREATE TABLE bag
(
    id BIGINT NOT NULL,
    user_id BIGINT NULL,
    name CHARACTER VARYING(255) NULL,
    type CHARACTER VARYING(255) NULL
);
ALTER TABLE bag ADD PRIMARY KEY (id);
CREATE SEQUENCE bag_id_seq START 1 INCREMENT 1 OWNED BY bag.id;

CREATE TABLE disc_bag
(
    id BIGINT NOT NULL,
    bag_id BIGINT NOT NULL,
    disc_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    favorite BOOLEAN NULL
);
ALTER TABLE disc_bag ADD PRIMARY KEY (id);
CREATE SEQUENCE disc_bag_id_seq START 1 INCREMENT 1 OWNED BY disc_bag.id;


CREATE TABLE plastic
(
    id BIGINT NOT NULL,
    manufacturer_id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NULL,
    description CHARACTER VARYING(255) NULL,
    classification CHARACTER VARYING(255) NULL
);
ALTER TABLE plastic ADD PRIMARY KEY (id);
CREATE SEQUENCE plastic_id_seq START 1 INCREMENT 1 OWNED BY plastic.id;


CREATE TABLE shelf
(
    id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    disc_id BIGINT NOT NULL
);
ALTER TABLE shelf ADD PRIMARY KEY (id);
CREATE SEQUENCE shelf_id_seq START 1 INCREMENT 1 OWNED BY shelf.id;

CREATE TABLE disc
(
    id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NOT NULL,
    manufacturer CHARACTER VARYING(255) NULL,
    plastic CHARACTER VARYING(255) NULL,
    weight DECIMAL(8, 2) NULL,
    speed DECIMAL(8, 2) NULL,
    glide DECIMAL(8, 2) NULL,
    turn DECIMAL(8, 2) NULL,
    fade DECIMAL(8, 2) NULL,
    description CHARACTER VARYING(255) NULL,
    condition CHARACTER VARYING(255) NULL,
    color CHARACTER VARYING(255) NULL,
    favorite BOOLEAN NULL
);
ALTER TABLE disc ADD PRIMARY KEY (id);
CREATE SEQUENCE disc_id_seq START 1 INCREMENT 1 OWNED BY disc.id;


ALTER TABLE disc_bag ADD CONSTRAINT disc_bag_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE plastic ADD CONSTRAINT plastic_manufacturer_id_foreign FOREIGN KEY(manufacturer_id) REFERENCES manufacturer(id);
--ALTER TABLE main_disc ADD CONSTRAINT main_disc_manufacturer_foreign FOREIGN KEY(manufacturer) REFERENCES manufacturer(id);
ALTER TABLE disc ADD CONSTRAINT disc_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE shelf ADD CONSTRAINT shelf_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE bag ADD CONSTRAINT bag_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE disc_bag ADD CONSTRAINT disc_bag_disc_id_foreign FOREIGN KEY(disc_id) REFERENCES disc(id);
ALTER TABLE disc_bag ADD CONSTRAINT disc_bag_bag_id_foreign FOREIGN KEY(bag_id) REFERENCES bag(id);
ALTER TABLE shelf ADD CONSTRAINT shelf_disc_id_foreign FOREIGN KEY(disc_id) REFERENCES disc(id);

INSERT INTO "user" VALUES (1,'bob');
INSERT INTO manufacturer VALUES (1,1);
INSERT INTO main_disc VALUES (1,'disc1','discmaker',1.0,1.0,1.0,1.0,'putteridk',1.6,'22cm','1cm','1cm','.5cm','1cm','1:1','rimconfiguration','very','12/6/97');
INSERT INTO disc VALUES (1,1,'disc name','discmaker','plastic plasticy',1.005,1.0,1.0,1.0,1.0,'good disc','fair','blue',false);
INSERT INTO bag VALUES (nextval('bag_id_seq'),1,'testbag','grip');
INSERT INTO bag VALUES (nextval('bag_id_seq'),1,'testbag2','pund');
INSERT INTO disc_bag VALUES (1,1,1,1,true);
INSERT INTO plastic VALUES (1,1,'plasticname','very plastic very nice','plastic classification');
INSERT INTO shelf VALUES (1,1,1);

