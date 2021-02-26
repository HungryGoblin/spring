BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO product (title, price) VALUES
('Iphone X', 500),
('Iphone 11', 670),
('Iphone 11', 850);

COMMIT;