INSERT INTO usr (id, activation_code, active, email, file_name, password, phone_number, username)
    VALUES (1, '', true, '', NULL, 'admin', '', 'admin');

INSERT INTO user_role (user_id, roles) VALUES (1, 'ADMIN');
