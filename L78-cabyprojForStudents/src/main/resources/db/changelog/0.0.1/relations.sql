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
    mark integer CHECK (mark > 0 AND mark < 5),
    PRIMARY KEY (user_id, shop_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE user_product_wish_relation (
    user_id bigint NOT NULL,
    product_id bigint NOT NULL,
    PRIMARY KEY(user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES catalog_products(id)
);

CREATE TABLE product_category_relation (
    label_id bigint NOT NULL,
    product_id bigint NOT NULL,
    PRIMARY KEY(label_id, product_id),
    FOREIGN KEY (label_id) REFERENCES catalog_labels(id),
    FOREIGN KEY (product_id) REFERENCES catalog_products(id)
);

