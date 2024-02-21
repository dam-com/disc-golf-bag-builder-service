SET search_path TO public;
CREATE TABLE public.user
(
    id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NOT NULL
);
ALTER TABLE public.user ADD PRIMARY KEY (id);
CREATE TABLE public.main_disc
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
ALTER TABLE public.main_disc ADD PRIMARY KEY (id);
CREATE TABLE public.manufacturer
(
    id BIGINT NOT NULL,
    name BIGINT NULL
);
ALTER TABLE public.manufacturer ADD PRIMARY KEY (id);
CREATE TABLE public.bag
(
    id BIGINT NOT NULL,
    user_id BIGINT NULL,
    name CHARACTER VARYING(255) NULL,
    type CHARACTER VARYING(255) NULL
);
ALTER TABLE public.bag ADD PRIMARY KEY (id);
CREATE TABLE public.disc_bag
(
    id BIGINT NOT NULL,
    bag_id BIGINT NOT NULL,
    disc_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    favorite BOOLEAN NULL
);
ALTER TABLE public.disc_bag ADD PRIMARY KEY (id);
CREATE TABLE public.plastic
(
    id BIGINT NOT NULL,
    manufacturer_id BIGINT NOT NULL,
    name CHARACTER VARYING(255) NULL,
    description CHARACTER VARYING(255) NULL,
    classification CHARACTER VARYING(255) NULL
);
ALTER TABLE public.plastic ADD PRIMARY KEY (id);
--COMMENT ON COLUMN plastic.classification IS 'base, premium?';
CREATE TABLE public.shelf
(
    id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    disc_id BIGINT NOT NULL
);
ALTER TABLE public.shelf ADD PRIMARY KEY (id);
CREATE TABLE public.disc
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
-- ALTER TABLE public.disc ADD PRIMARY KEY (id);
-- ALTER TABLE public.disc_bag
-- ADD CONSTRAINT disc_bag_user_id_foreign
--     FOREIGN KEY (user_id)
--     REFERENCES public.user (id);
-- ALTER TABLE public.plastic
-- ADD CONSTRAINT plastic_manufacturer_id_foreign
--     FOREIGN KEY (manufacturer_id)
--     REFERENCES public.manufacturer (id);
-- ALTER TABLE public.main_disc
-- -- ADD CONSTRAINT main_disc_manufacturer_foreign
-- --     FOREIGN KEY (manufacturer)
-- --     REFERENCES public.manufacturer (id);
-- -- ALTER TABLE public.disc
-- ADD CONSTRAINT disc_user_id_foreign
--     FOREIGN KEY (user_id)
--     REFERENCES public.user (id);
-- ALTER TABLE public.shelf
-- ADD CONSTRAINT shelf_user_id_foreign
--     FOREIGN KEY (user_id)
--     REFERENCES public.user (id);
-- ALTER TABLE public.bag
-- ADD CONSTRAINT bag_user_id_foreign
--     FOREIGN KEY (user_id)
--     REFERENCES public.user (id);
-- ALTER TABLE public.disc_bag
-- ADD CONSTRAINT disc_bag_disc_id_foreign
--     FOREIGN KEY (disc_id)
--     REFERENCES public.disc (id);
-- ALTER TABLE public.disc_bag
-- ADD CONSTRAINT disc_bag_bag_id_foreign
--     FOREIGN KEY (bag_id)
--     REFERENCES public.bag (id);
-- ALTER TABLE public.shelf
-- ADD CONSTRAINT shelf_disc_id_foreign
--     FOREIGN KEY (disc_id)
--     REFERENCES public.disc (id);