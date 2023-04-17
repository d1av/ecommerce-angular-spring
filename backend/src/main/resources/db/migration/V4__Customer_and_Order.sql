CREATE TABLE orders (
	id INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
	order_tracking_number VARCHAR(255) NOT NULL,
	total_quantity INT NOT NULL,
	total_price BIGINT NOT NULL,
	status VARCHAR(255) NOT NULL,
	date_created DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
	last_updated DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
	user_id INT NOT NULL,
	shipping_address_id INT NOT NULL,
	billing_address_id INT NOT NULL,	
	CONSTRAINT fk_ordus_orders_user_id FOREIGN KEY (user_id) REFERENCES users (id),
	CONSTRAINT fk_orders_shipping_address_id FOREIGN KEY (shipping_address_id) REFERENCES addresses (id),
	CONSTRAINT fk_orders_billing_address_id FOREIGN KEY (billing_address_id) REFERENCES addresses (id)
);

CREATE TABLE order_items (
	id INT NOT NULL PRIMARY KEY UNIQUE,
	image_url VARCHAR(1000) NOT NULL,
	unit_price BIGINT NOT NULL,
	quantity INT NOT NULL,
	product_id INT NOT NULL,
	order_id INT NOT NULL,
	CONSTRAINT fk_order_orderitems_id FOREIGN KEY (order_id) REFERENCES orders (id),
	CONSTRAINT fk_product_orderitems_id FOREIGN KEY (product_id) REFERENCES products (id)
);