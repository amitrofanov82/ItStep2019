CREATE TABLE users (
    id bigserial NOT NULL,
    nickname varchar(64) NOT NULL,
    email varchar(128),
    phone varchar(16),
    registered date,
    logged timestamp,
    password varchar(64),
    facebook_id varchar(50),
    google_id varchar(50),
    PRIMARY KEY(id)
);

CREATE TABLE user_profiles (
    id bigserial NOT NULL,
    user_id bigint NOT NULL,
    birthdate date,
    location text,
    avatar_link text,
    about text,
    twitter_id varchar(50),
    instagram_id varchar(50),
    PRIMARY KEY(id),
    UNIQUE(id, user_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE shop_templates (
    id bigserial NOT NULL,
    name varchar(64),
    html_template text,
    PRIMARY KEY(id)
);

CREATE TABLE shops (
    id bigserial NOT NULL,
    admin_id bigint NOT NULL,
    opening_date date,
    location text,
    template_id bigint,
    PRIMARY KEY(id),
    UNIQUE(admin_id),
    FOREIGN KEY (admin_id) REFERENCES users(id),
    FOREIGN KEY (template_id) REFERENCES shop_templates(id)
);

CREATE TABLE subscription_list (
    id bigserial NOT NULL,
    user_id bigint,
    email varchar(128),
    FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE labels (
    id bigserial NOT NULL,
    name varchar(128) NOT NULL,
    parent_id bigint,
    is_category boolean DEFAULT true,
    description text,
    PRIMARY KEY(id)
);

CREATE TABLE products (
    id bigserial NOT NULL,
    name varchar(128) NOT NULL,
    description text,
    shop_id bigint NOT NULL,
    price numeric,

    PRIMARY KEY(id),
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE product_images (
    id bigserial NOT NULL,
    product_id bigint NOT NULL,
    image_link text NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);


CREATE TABLE user_shop_management_relation (
    user_id bigint NOT NULL,
    shop_id bigint NOT NULL,
    PRIMARY KEY(user_id, shop_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE user_user_follow_relation (
    follower_id bigint NOT NULL,
    followee_id bigint NOT NULL,
    PRIMARY KEY(follower_id, followee_id),
    FOREIGN KEY (follower_id) REFERENCES users(id),
    FOREIGN KEY (followee_id) REFERENCES users(id)
);

CREATE TABLE user_shop_assesment_relation (
    user_id bigint NOT NULL,
    shop_id bigint NOT NULL,
    mark smallint CHECK (mark > 0 AND mark < 5),
    PRIMARY KEY (user_id, shop_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE user_product_wish_relation (
    user_id bigint NOT NULL,
    product_id bigint NOT NULL,
    PRIMARY KEY(user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO USERS(id,nickname, email)  VALUES  (12,'Kolya Vasin', 'kolya@mail.ru');
INSERT INTO USERS(id,nickname, email)  VALUES  (13,'Vasya Petin', 'vasya@gmail.com');
INSERT INTO USERS(id,nickname, email)  VALUES  (14,'Petya Kolin', 'petya-kolin@narod.ru');
INSERT INTO USERS(id,nickname, email)  VALUES  (15,'Ivan Drago', 'ivan.drago@kgb.ru');
INSERT INTO USERS(id,nickname)  VALUES  (16,'Alyosha');

INSERT INTO SHOPS(id, admin_id)  VALUES  (12,12);











