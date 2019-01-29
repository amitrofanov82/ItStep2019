INSERT INTO users(id, nickname, email) VALUES(17, 'Admin', 'admin@mailspecialforadmins.com');
INSERT INTO shops(id, admin_id) VALUES (1, 17);

INSERT INTO products VALUES (1, 'car', 'Very good car', 1, 7000);
INSERT INTO products VALUES (2, 'phone', 'Very good phone', 1, 200);
INSERT INTO products VALUES (3, 'pc', 'Very good pc', 1, 500);

INSERT INTO user_product_wish_relation VALUES(15, 2);
INSERT INTO user_product_wish_relation VALUES(15, 3);

SELECT us.nickname, products.name, products.description, products.price 
FROM (users AS us INNER JOIN user_product_wish_relation AS wh ON us.id = wh.user_id) 
INNER JOIN products ON products.id = wh.product_id