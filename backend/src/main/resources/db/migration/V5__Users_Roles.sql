CREATE TABLE users_roles (
	id INT NOT NULL PRIMARY KEY UNIQUE,
	user_id INT NOT NULL,
	role_id INT NOT NULL,
    CONSTRAINT fk_user_role_id FOREIGN KEY (user_id) REFERENCES roles (id),
    CONSTRAINT fk_role_user_id FOREIGN KEY (role_id) REFERENCES users (id),
);