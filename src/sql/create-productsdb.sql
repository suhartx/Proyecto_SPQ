DROP SCHEMA IF EXISTS productsDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA productsDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON productsDB.* TO 'spq'@'localhost';
