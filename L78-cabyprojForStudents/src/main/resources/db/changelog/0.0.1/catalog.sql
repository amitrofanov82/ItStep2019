CREATE TABLE catalog_labels (
    id bigserial NOT NULL,
    parent_id bigint,
    name varchar(128) NOT NULL,
    is_category boolean DEFAULT false,
    description text,
    img_url varchar(128),
    PRIMARY KEY(id),
    FOREIGN KEY(parent_id) REFERENCES catalog_labels(id)
);

CREATE TABLE catalog_products (
    id bigserial NOT NULL,
    shop_id bigint NOT NULL,
    name varchar(128) NOT NULL,
    description text,
    price int,
    PRIMARY KEY(id),
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE catalog_product_images (
    id bigserial NOT NULL,
    product_id bigint NOT NULL,
    image_link varchar(512) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES catalog_products(id)
);
