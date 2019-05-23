CREATE TABLE users (
    id bigserial NOT NULL,
    nickname varchar(64) NOT NULL,
    email varchar(128),
    phone varchar(32),
    registered timestamp,
    logged timestamp,
    password varchar(64),
    facebook_id varchar(64),
    google_id varchar(64),
    user_type varchar(32), --ANONYMOUS, GENERAL, TRADER, SHOP_OWNER
    PRIMARY KEY(id)
);

CREATE TABLE user_profiles (
    user_id bigint NOT NULL,
    birthdate date,
    location varchar(512),
    avatar_link varchar(512),
    about text,
    twitter_id varchar(64),
    instagram_id varchar(64),
    PRIMARY KEY(user_id),
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
    owner_id bigint NOT NULL,
    name varchar(128),
    opening_date date,
    location text,
    template_id bigint,
    PRIMARY KEY(id),
    FOREIGN KEY (owner_id) REFERENCES users(id),
    FOREIGN KEY (template_id) REFERENCES shop_templates(id)
);

CREATE TABLE subscription_list (
    user_id bigint,
    email varchar(128),
    PRIMARY KEY(user_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

