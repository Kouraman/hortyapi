-- DROP TABLE generic_prices;
-- DROP TABLE generic_advices;
-- DROP TABLE generic_treatments;
-- DROP TABLE generic_images;
-- DROP TABLE specific_prices;
-- DROP TABLE specific_advices;
-- DROP TABLE specific_treatments;
-- DROP TABLE plants;
-- DROP TABLE regroupments;
-- DROP TABLE families;
-- DROP TABLE categories;

-- choux fleur : https://www.carrefour.fr/media/1500x1500/Photosite/PRODUITS_FRAIS_TRANSFORMATION/FRUITS_ET_LEGUMES/3000001038436_PHOTOSITE_20150617_162744_0.jpg?placeholder=1
-- choux frise : https://cdn.panierlocal.org/media/PXJTJUXEC/chou-vert_zoom.jpg
-- bata bl : https://jardinage.lemonde.fr/images/dossiers/2017-07/batavia-153406.jpg
-- bata br : https://locavor.fr/data/produits/4/81168/81168-batavia-brune-1.jpg

SET @batabl = 'https://jardinage.lemonde.fr/images/dossiers/2017-07/batavia-153406.jpg';
SET @batabr = 'https://locavor.fr/data/produits/4/81168/81168-batavia-brune-1.jpg';
SET @choufri = 'https://cdn.panierlocal.org/media/PXJTJUXEC/chou-vert_zoom.jpg';
SET @choufleu = 'https://www.carrefour.fr/media/1500x1500/Photosite/PRODUITS_FRAIS_TRANSFORMATION/FRUITS_ET_LEGUMES/3000001038436_PHOTOSITE_20150617_162744_0.jpg?placeholder=1';
SET @mache = 'https://www.monpetitcoinvert.com/blog/wp-content/uploads/2016/10/mache.jpg'

INSERT INTO categories (name)
 VALUES
 ('LEGUMES'),
 ('FLEUR')
;

INSERT INTO families (category_id,name,src_img)
 VALUES
 ((SELECT id from categories WHERE name LIKE 'LEGUMES'),'Choux',@choufri),
 ((SELECT id from categories WHERE name LIKE 'LEGUMES'),'Salade',@batabl)
;

INSERT INTO regroupments (family_id,name,start_plating,end_plating)
 VALUES
 ((SELECT id from families WHERE name LIKE 'Choux'),'Choux d''automne','2019-07-01','2019-07-31'),
 ((SELECT id from families WHERE name LIKE 'Choux'),'Choux d''hiver','2019-07-21','2019-08-31'),
 ((SELECT id from families WHERE name LIKE 'Choux'),'Choux de printemps','2019-09-21','2019-10-21'),
 ((SELECT id from families WHERE name LIKE 'Salade'),'Salade d''hiver','2019-10-01','2019-01-31'),
 ((SELECT id from families WHERE name LIKE 'Salade'),'Salade de printemps','2019-02-01','2019-05-15'),
 ((SELECT id from families WHERE name LIKE 'Salade'),'Salade d''été','2019-05-15','2019-08-15'),
 ((SELECT id from families WHERE name LIKE 'Salade'),'Salade d''automne','2019-08-01','2019-10-15')
;

INSERT INTO plants (group_id,name,src_img)
 VALUES
 ((SELECT id from regroupments WHERE name LIKE 'Choux d''automne'),'Chou Fleur',@choufleu),        --Choux automne
 ((SELECT id from regroupments WHERE name LIKE 'Choux d''automne'),'Chou Frisé',@choufri),
 ((SELECT id from regroupments WHERE name LIKE 'Choux d''hiver'),'Chou Fleur',@choufleu),        --Choux hiver
 ((SELECT id from regroupments WHERE name LIKE 'Choux d''hiver'),'Chou Frisé',@choufri),
 ((SELECT id from regroupments WHERE name LIKE 'Choux de printemps'),'Chou Fleur',@choufleu),        --Choux printemps
 ((SELECT id from regroupments WHERE name LIKE 'Choux de printemps'),'Chou Frisé',@choufri),
 ((SELECT id from regroupments WHERE name LIKE 'Salade d''hiver'),'Batavia Blonde',@batabl),      --Salade hiver
 ((SELECT id from regroupments WHERE name LIKE 'Salade d''hiver'),'Batavia Brune',@batabr),
 ((SELECT id from regroupments WHERE name LIKE 'Salade d''hiver'),'Mache',@mache),
 ((SELECT id from regroupments WHERE name LIKE 'Salade de printemps'),'Batavia Blonde',@batabl),      --Salade printemps
 ((SELECT id from regroupments WHERE name LIKE 'Salade de printemps'),'Batavia Brune',@batabr),
 ((SELECT id from regroupments WHERE name LIKE 'Salade d''été'),'Batavia Blonde',@batabl),      --Salade été
 ((SELECT id from regroupments WHERE name LIKE 'Salade d''été'),'Batavia Brune',@batabr),
 ((SELECT id from regroupments WHERE name LIKE 'Salade d''automne'),'Batavia Blonde',@batabl),      --Salade automne
 ((SELECT id from regroupments WHERE name LIKE 'Salade d''automne'),'Batavia Brune',@batabr)
;

INSERT INTO generic_prices (family_id,price,quantité)
  VALUES
  ((SELECT id from families WHERE name LIKE 'Choux'),0.60,1),
  ((SELECT id from families WHERE name LIKE 'Choux'),5.50,10),
  ((SELECT id from families WHERE name LIKE 'Salades'),2.40,12)
;

INSERT INTO generic_prices (family_id,price,quantité)
  VALUES
  ((SELECT id from families WHERE name LIKE 'Choux'),0.60,1),
  ((SELECT id from families WHERE name LIKE 'Choux'),5.50,10),
  ((SELECT id from families WHERE name LIKE 'Salades'),2.40,12)
;

INSERT INTO specific_prices (family_id,price,quantité)
  VALUES
  ((SELECT id from plants WHERE name LIKE 'Mache'),2,12)
;