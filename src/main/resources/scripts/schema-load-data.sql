set schema 'public';

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


CREATE TABLE main_disc
(
    id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NOT NULL,
    manufacturer CHARACTER VARYING(255) NULL,
    speed CHARACTER VARYING(255) NULL,
    glide CHARACTER VARYING(255) NULL,
    turn CHARACTER VARYING(255) NULL,
    fade CHARACTER VARYING(255) NULL,
    description CHARACTER VARYING(255) NULL,
    max_weight CHARACTER VARYING(255) NULL,
    diameter CHARACTER VARYING(255) NULL,
    height CHARACTER VARYING(255) NULL,
    rim_depth CHARACTER VARYING(255) NULL,
    inside_rim_diameter CHARACTER VARYING(255) NULL,
    rim_thickness CHARACTER VARYING(255) NULL,
    rim_depth_diameter_ratio CHARACTER VARYING(255) NULL,
    rim_configuration CHARACTER VARYING(255) NULL,
    flexibility CHARACTER VARYING(255) NULL
);
ALTER TABLE main_disc ADD PRIMARY KEY (id);


CREATE TABLE manufacturer
(
    id BIGINT NOT NULL,
    name BIGINT NULL
);
ALTER TABLE manufacturer ADD PRIMARY KEY (id);


CREATE TABLE bag
(
    id BIGINT NOT NULL,
    user_id BIGINT NULL,
    name CHARACTER VARYING(255) NULL,
    type CHARACTER VARYING(255) NULL
);
ALTER TABLE bag ADD PRIMARY KEY (id);


CREATE TABLE disc_bag
(
    id BIGINT NOT NULL,
    bag_id BIGINT NOT NULL,
    disc_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    favorite BOOLEAN NULL
);
ALTER TABLE disc_bag ADD PRIMARY KEY (id);


CREATE TABLE plastic
(
    id BIGINT NOT NULL,
    manufacturer_id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NULL,
    description CHARACTER VARYING(255) NULL,
    classification CHARACTER VARYING(255) NULL
);
ALTER TABLE plastic ADD PRIMARY KEY (id);


CREATE TABLE shelf
(
    id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    disc_id BIGINT NOT NULL
);
ALTER TABLE shelf ADD PRIMARY KEY (id);


CREATE TABLE disc
(
    id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NOT NULL,
    manufacturer CHARACTER VARYING(255) NULL,
    plastic CHARACTER VARYING(255) NULL,
    weight DECIMAL(8, 2) NULL,
    speed CHARACTER VARYING(255) NULL,
    glide CHARACTER VARYING(255) NULL,
    turn CHARACTER VARYING(255) NULL,
    fade CHARACTER VARYING(255) NULL,
    description CHARACTER VARYING(255) NULL,
    condition CHARACTER VARYING(255) NULL,
    color CHARACTER VARYING(255) NULL,
    favorite BOOLEAN NULL
);
ALTER TABLE disc ADD PRIMARY KEY (id);


ALTER TABLE disc_bag ADD CONSTRAINT disc_bag_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE plastic ADD CONSTRAINT plastic_manufacturer_id_foreign FOREIGN KEY(manufacturer_id) REFERENCES manufacturer(id);
--ALTER TABLE main_disc ADD CONSTRAINT main_disc_manufacturer_foreign FOREIGN KEY(manufacturer) REFERENCES manufacturer(id);
ALTER TABLE disc ADD CONSTRAINT disc_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE shelf ADD CONSTRAINT shelf_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE bag ADD CONSTRAINT bag_user_id_foreign FOREIGN KEY(user_id) REFERENCES "user"(id);
ALTER TABLE disc_bag ADD CONSTRAINT disc_bag_disc_id_foreign FOREIGN KEY(disc_id) REFERENCES disc(id);
ALTER TABLE disc_bag ADD CONSTRAINT disc_bag_bag_id_foreign FOREIGN KEY(bag_id) REFERENCES bag(id);
ALTER TABLE shelf ADD CONSTRAINT shelf_disc_id_foreign FOREIGN KEY(disc_id) REFERENCES disc(id);
