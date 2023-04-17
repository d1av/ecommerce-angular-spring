-- -----------------------------------------------------
-- Users and Roles
-- -----------------------------------------------------

INSERT INTO roles(id, name) VALUES (1, 'ROLE_CUSTOMER'),(2, 'ROLE_ADMIN');

INSERT INTO users(id, email,first_name,last_name,password,username) VALUES (1, 'admin@admin.com','Admin','do Site','$2a$10$FUlO0odzUuxuv1KbGjOgE.Kr9Xuz3baIMsVlhTENkD9QPkB.ecRiK','admin');
INSERT INTO users(id, email,first_name,last_name,password,username) VALUES (2, 'davi@davi.com','Davi', 'Usuario','$2a$10$9B7YovC4owgOeiHTTny.PucbEx3pWX4KAEgX447vnOpjcfguLqsB6','davi');

INSERT INTO users_roles(id, user_id,role_id) VALUES (1,1,1),(2,1,2),(3,2,1);