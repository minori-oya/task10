DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  age int NOT NULL,
  phoneNumber VARCHAR(15) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO clients (name, age, phone_number) VALUES ("田中一郎", 20, "09011111111");
INSERT INTO clients (name, age, phone_number) VALUES ("鈴木二郎", 15, "08022222222");
INSERT INTO clients (name, age, phone_number) VALUES ("佐藤三郎", 30, "08033333333");


