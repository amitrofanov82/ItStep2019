-- TODO: fill with some stable initial data later:
INSERT INTO users(id,nickname,email,phone,user_type)  VALUES  (1,'amitrofanov82','amitrofanov82@gmail.com','+375291801706','ADMIN');
INSERT INTO users(id,nickname,email,phone,user_type)  VALUES  (2,'aakulchik','sasha@munchen.de','+4949494949','ADMIN');
INSERT INTO users(id,nickname,email,phone,user_type)  VALUES  (3,'aartius','sasha@toronto.ca','03','SHOP_OWNER');
INSERT INTO users(id,nickname,email,phone,user_type)  VALUES  (4,'kniazhna','anna@munchen.de','911','SHOP_OWNER');

-- initial shops:
INSERT INTO shops(id,owner_id,name,location)  VALUES  (1,3,'Сашкин шоп','Посреди торонтарии');
INSERT INTO shops(id,owner_id,name,location)  VALUES  (2,4,'Anna''s hidden place','In the skies above the Deutchland');
