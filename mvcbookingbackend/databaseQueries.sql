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

CREATE TABLE user_detail(
     id IDENTITY,
     first_name VARCHAR(50),
     last_name VARCHAR(50),
     role VARCHAR(50),
     enabled BOOLEAN,
     password VARCHAR(50),
     email VARCHAR(100),
     contact_number VARCHAR(15),
     CONSTRAINT pk_user_id PRIMARY KEY(id),
);

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('George','Sikhundla', 'ADMIN', true, '201356', 'sikhundla100@gmail.com', '0839133050');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('John','Smith', 'USER', true, '12345', 'jsmith@gmail.com', '0123456789');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Sam','Mahlangu', 'USER', true, '54321', 'smahlangu10@gmail.com', '0718934796');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Jenny','Williams', 'USER', true, '88888', 'jennyw@gmail.com', '0931234768');



CREATE TABLE property(
    
    id IDENTITY,
    address VARCHAR(200),
    name VARCHAR(50),
    code VARCHAR(20),
    description VARCHAR(1000),
    booking_price DECIMAL (10,2),
    quantity INT,
    is_active BOOLEAN,
    category_id INT,
    client_id INT,
    bookings INT DEFAULT 0,
    views INT DEFAULT 0,
    CONSTRAINT pk_property_id PRIMARY KEY (id),
    CONSTRAINT fk_property_category_id FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT fk_property_client_id FOREIGN KEY (client_id) REFERENCES user_detail (id),
);

INSERT INTO property (address, name, code, description, booking_price, quantity, is_active, category_id, client_id)
VALUES ('Corner of Rivonia Road and Daisy Street, Sandton, 2010 Johannesburg, South Africa', 'Radisson Blu Hotel Sandton', 'PROABC123DEFX', 'The Radisson Blu Sandton hotel is situated in the Sandton business district with close proximity to the JSE and Sandton City Shopping Centre. Access to our iconic hotel is easy via the Sandton Gautrain Station which is located 400m from the property. We offer the largest fitness megaplex in Sandton spanning over 5500sqm coupled with an indoor running track.',
1611, 10, true, 1, 2);

INSERT INTO property (address, name, code, description, booking_price, quantity, is_active, category_id, client_id)
VALUES ('15A Marion Street, Sandown, Sandton, Sandton, 2196. Johannesburg, South Africa', 'Marion Lodge', 'PRODEF123DEFX', 'This 4-star lodge has a scenic garden with a pool and is located a 5-minute drive from Sandton City. All air-conditioned accommodation offers free Wi-Fi and garden views.',
1611, 10, true, 3, 3);

INSERT INTO property (address, name, code, description, booking_price, quantity, is_active, category_id, client_id)
VALUES ('13, 4th street, Linden, Randburg, 2195 Johannesburg, South Africa', 'Linden Guest House', 'PROPQR123WGTX', 'Randburg is a great choice for travelers interested in city trips, restaurants and nightlife.',
548.35, 10, true, 2, 4);

CREATE TABLE address(

	id IDENTITY,
	user_id INT,
	address_line_one VARCHAR(250),
	address_line_two VARCHAR(250),
	city VARCHAR(50),
	state VARCHAR(50),
	country VARCHAR(50),
	postal_code VARCHAR(50),
	booked BOOLEAN,
	billing BOOLEAN,
	
	CONSTRAINT pk_address_id PRIMARY KEY (id),
	CONSTRAINT fk_user_address_id FOREIGN KEY (user_id) REFERENCES user_detail (id),

);

CREATE TABLE booking(

	id IDENTITY,
	user_id INT,
	grand_total DECIMAL(10, 2),
	booking_lines INT,
	
	CONSTRAINT pk_booking_id PRIMARY KEY (id),
	CONSTRAINT fk_user_booking_id FOREIGN KEY (user_id) REFERENCES user_detail (id),

);


