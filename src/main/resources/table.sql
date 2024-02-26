CREATE TABLE IF NOT EXISTS parts
(
    part_id BIGSERIAL NOT NULL PRIMARY KEY,
    car_model         VARCHAR (50) NOT NULL,
    part_description  VARCHAR (999),
    part_number       INTEGER NOT NULL,
    part_type         VARCHAR (100)NOT NULL
);