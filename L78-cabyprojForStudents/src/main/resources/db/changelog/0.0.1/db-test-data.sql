-- Products:
INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (1,1, 'Товар 1 в сашкином магазине','Большое описание сашкиного товара 1, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 11);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (2,1,'Товар 2 в сашкином магазине','Большое описание сашкиного товара 2, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 21);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (3,1,'Товар 3 в сашкином магазине','Большое описание сашкиного товара 3, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 31);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (4,1,'Товар 4 в сашкином магазине','Большое описание сашкиного товара 4, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 41);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (5,1,'Товар 5 в сашкином магазине','Большое описание сашкиного товара 5, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 51);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (6,1,'Товар 6 в сашкином магазине','Большое описание сашкиного товара 6, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 61);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (7,1,'Товар 7 в сашкином магазине','Большое описание сашкиного товара 7, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 71);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (8,1,'Товар 8 в сашкином магазине','Большое описание сашкиного товара 8, какой он 
весь больщой и замечательный, и чтоб было побольше букв.', 81);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (9,2,'Hannas piece of beauty 1','Hanna 1. something good and useful, you can''t live without 
this stuff, don''t forget to buy it. Bla bla bla bla bla bla bla. Bye.', 92);

INSERT INTO catalog_products(id,shop_id,name,description,price)  
VALUES  (10,2,'Hannas piece of beauty 1','Hanna 2. The only good stuf with many pictures at test data. 
something good and useful, you can''t live without  this stuff, don''t forget to buy it. Bla bla bla bla bla bla bla. Bye.', 102);

-------------------------------
-- add images to every product:
-------------------------------
INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(1, 1, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(2, 2, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(3, 3, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(4, 4, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(5, 5, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(6, 6, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(7, 7, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(8, 8, '/resources/categories/cat_image_not_available.png');

INSERT INTO catalog_product_images(id,product_id,image_link)
VALUES(9, 9, '/resources/products/1.jpg');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(10, 10, '/resources/products/1.jpg');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(11, 10, '/resources/products/2.jpg');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(12, 10, '/resources/products/3.jpg');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(13, 10, '/resources/products/4.jpg');

INSERT INTO catalog_product_images(id,product_id,image_link)  
VALUES(14, 10, '/resources/products/5.jpg');

------------------------------------------------------------------------
-- Link every product to 2 categories and with some uncategorized label:
------------------------------------------------------------------------
INSERT INTO product_category_relation(product_id, label_id) VALUES (1,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (1,201);
INSERT INTO product_category_relation(product_id, label_id) VALUES (10,100000003);

INSERT INTO product_category_relation(product_id, label_id) VALUES (2,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (2,201);

INSERT INTO product_category_relation(product_id, label_id) VALUES (3,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (3,201);

INSERT INTO product_category_relation(product_id, label_id) VALUES (4,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (4,201);

INSERT INTO product_category_relation(product_id, label_id) VALUES (5,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (5,201);

INSERT INTO product_category_relation(product_id, label_id) VALUES (6,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (6,201);

INSERT INTO product_category_relation(product_id, label_id) VALUES (7,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (7,201);

INSERT INTO product_category_relation(product_id, label_id) VALUES (8,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (8,201);
INSERT INTO product_category_relation(product_id, label_id) VALUES (10,100000002);

INSERT INTO product_category_relation(product_id, label_id) VALUES (9,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (9,201);

INSERT INTO product_category_relation(product_id, label_id) VALUES (10,1);
INSERT INTO product_category_relation(product_id, label_id) VALUES (10,201);
INSERT INTO product_category_relation(product_id, label_id) VALUES (10,100000001);
INSERT INTO product_category_relation(product_id, label_id) VALUES (10,2004);















