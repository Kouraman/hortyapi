DROP TABLE IF EXISTS family_advices;
DROP TABLE IF EXISTS regroupment_advices;
DROP TABLE IF EXISTS plant_advices;
DROP TABLE IF EXISTS family_treatments;
DROP TABLE IF EXISTS regroupment_treatments;
DROP TABLE IF EXISTS plant_treatments;
DROP TABLE IF EXISTS plants_plating_dates;
DROP TABLE IF EXISTS plants_prices;
DROP TABLE IF EXISTS plants_images;
DROP TABLE IF EXISTS planting_dates;
DROP TABLE IF EXISTS prices;
DROP TABLE IF EXISTS plants;
DROP TABLE IF EXISTS regroupments;
DROP TABLE IF EXISTS families;
DROP TABLE IF EXISTS categories;


CREATE TABLE categories (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  name                  VARCHAR(64) UNIQUE NOT NULL,
  src_img               VARCHAR(255)
);

CREATE TABLE families (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  category_id           INTEGER NOT NULL,
  name                  VARCHAR(64) UNIQUE NOT NULL,
  path_name             VARCHAR(64) UNIQUE NOT NULL,
  src_img               VARCHAR(64) NOT NULL,

  FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE regroupments (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  family_id             INTEGER NOT NULL,
  name                  VARCHAR(64) UNIQUE NOT NULL,
  src_img               VARCHAR(64) NOT NULL,
  path_name             VARCHAR(64) UNIQUE NOT NULL,

  FOREIGN KEY (family_id) REFERENCES families(id)
);

CREATE TABLE plants (
  id                            INTEGER PRIMARY KEY AUTO_INCREMENT,
  regroupment_id                INTEGER NOT NULL,
  name                          VARCHAR(64) NOT NULL,
  description                   VARCHAR(255),
  path_name                     VARCHAR(64) UNIQUE NOT NULL,

  FOREIGN KEY (regroupment_id) REFERENCES regroupments(id)
);

CREATE TABLE plants_images (
  id                            INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id                      INTEGER NOT NULL,
  src_img                       VARCHAR(64) NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id)
);

CREATE TABLE planting_dates (

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  name	                VARCHAR(64) NOT NULL,
  start_planting        DATE,
  end_planting          DATE,
  days_until_harvest    INTEGER

);

CREATE TABLE plants_plating_dates (
  id                      INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id                INTEGER NOT NULL,
  plating_dates_id        INTEGER NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id),
  FOREIGN KEY (plating_dates_id) REFERENCES planting_dates(id)
);

CREATE TABLE prices (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  name                  VARCHAR(64) NOT NULL,
  price                 DECIMAL(4, 2) NOT NULL,
  quantity              INTEGER NOT NULL
);

CREATE TABLE plants_prices (

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id	            INTEGER NOT NULL,
  price_id              INTEGER NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id),
  FOREIGN KEY (price_id) REFERENCES prices(id)
);

CREATE TABLE family_advices(

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  family_id             INTEGER NOT NULL,
  advice                VARCHAR(255) NOT NULL,

  FOREIGN KEY (family_id) REFERENCES families(id)
);

CREATE TABLE regroupment_advices(

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  regroupment_id        INTEGER NOT NULL,
  advice                VARCHAR(255) NOT NULL,

  FOREIGN KEY (regroupment_id) REFERENCES regroupments(id)
);

CREATE TABLE plant_advices(

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id              INTEGER NOT NULL,
  advice                VARCHAR(255) NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id)
);

CREATE TABLE family_treatments(

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  family_id             INTEGER NOT NULL,
  treatment             VARCHAR(255) NOT NULL,

  FOREIGN KEY (family_id) REFERENCES families(id)

);

CREATE TABLE regroupment_treatments(

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  regroupment_id        INTEGER NOT NULL,
  treatment             VARCHAR(255) NOT NULL,

  FOREIGN KEY (regroupment_id) REFERENCES regroupments(id)
);

CREATE TABLE plant_treatments(

  id	                INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id              INTEGER NOT NULL,
  treatment             VARCHAR(255) NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id)
);


