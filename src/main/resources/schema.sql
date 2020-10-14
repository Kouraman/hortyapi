DROP TABLE IF EXISTS generic_prices;
DROP TABLE IF EXISTS generic_advices;
DROP TABLE IF EXISTS generic_treatments;
DROP TABLE IF EXISTS specific_prices;
DROP TABLE IF EXISTS specific_advices;
DROP TABLE IF EXISTS specific_treatments;
DROP TABLE IF EXISTS plants_images;
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
  src_img               VARCHAR(255),

  FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE regroupments (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  family_id             INTEGER NOT NULL,
  name                  VARCHAR(64) UNIQUE NOT NULL,

  FOREIGN KEY (family_id) REFERENCES families(id)
);

CREATE TABLE plants (
  id                            INTEGER PRIMARY KEY AUTO_INCREMENT,
  group_id                      INTEGER NOT NULL,
  name                          VARCHAR(64) NOT NULL,
  start_specific_plating        DATE,
  end_specific_plating          DATE

  FOREIGN KEY (group_id) REFERENCES regroupments(id)
);

CREATE TABLE plants_images (
  id                            INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id                      INTEGER NOT NULL,
  src_img                       VARCHAR(64) NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id)
);



-- Tables linked to families

CREATE TABLE generic_prices (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  family_id             INTEGER NOT NULL,
  price                 DECIMAL(4, 2) NOT NULL,
  quantity              INTEGER NOT NULL,

  FOREIGN KEY (family_id) REFERENCES families(id)
);

CREATE TABLE generic_advices (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  family_id             INTEGER NOT NULL,
  advice                VARCHAR(255) NOT NULL,

  FOREIGN KEY (family_id) REFERENCES families(id)
);

CREATE TABLE generic_treatments (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  family_id             INTEGER NOT NULL,
  treatment             VARCHAR(255) NOT NULL,

  FOREIGN KEY (family_id) REFERENCES families(id)
);

-- Tables linked to Plants

CREATE TABLE specific_prices (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id              INTEGER NOT NULL,
  price                 INTEGER NOT NULL,
  quantity              INTEGER NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id)
);

CREATE TABLE specific_advices (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id              INTEGER NOT NULL,
  advice                VARCHAR(255) NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id)
);

CREATE TABLE specific_treatments (
  id                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  plant_id              INTEGER NOT NULL,
  treatment             VARCHAR(255) NOT NULL,

  FOREIGN KEY (plant_id) REFERENCES plants(id)
);