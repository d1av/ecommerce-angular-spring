CREATE TABLE product_categories (
	id INT NOT NULL PRIMARY KEY UNIQUE,
	category_name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
	id INT NOT NULL PRIMARY KEY UNIQUE,
	category_id INT NOT NULL,
	sku VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	description TEXT NOT NULL,
	unit_price BIGINT NOT NULL,
	image_url VARCHAR(255) NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	units_in_stock INT NOT NULL,
	date_created DATETIME(6) NOT NULL,
	last_updated DATETIME(6) NOT NULL,
	CONSTRAINT fk_states_country_id FOREIGN KEY (category_id) REFERENCES product_categories (id),
);

CREATE TABLE roles (
	id INT NOT NULL PRIMARY KEY UNIQUE,
	name VARCHAR(255) NOT NULL UNIQUE
);