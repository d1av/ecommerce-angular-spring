CREATE TABLE users_roles (
	id INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
	user_id INT NOT NULL,
	role_id INT NOT NULL,
	CONSTRAINT fk_usro_user_role_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_rosu_role_user_id FOREIGN KEY (role_id) REFERENCES roles (id)
);