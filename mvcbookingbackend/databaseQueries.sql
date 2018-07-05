CREATE TABLE category(
     
     id IDENTITY,
     name VARCHAR(50),
     description VARCHAR(255),
     image_url VARCHAR(50),
     is_active BOOLEAN,
     
     CONSTRAINT pk_category_id PRIMARY KEY (id)
);


INSERT INTO category(name, description, image_url, is_active) VALUES ('Hotel', 'This is a description for the hotel category', 'CAT_1.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Guest House', 'This is a description for the guest house category', 'CAT_2.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Lodge', 'This is a description for the lodge category', 'CAT_3.png', true);