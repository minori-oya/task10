DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  age int NOT NULL,
  phoneNumber VARCHAR(15) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO clients (name, age, phoneNumber) VALUES ("田中一郎", 20, "09011111111");
INSERT INTO clients (name, age, phoneNumber) VALUES ("鈴木二郎", 15, "08022222222");
INSERT INTO clients (name, age, phoneNumber) VALUES ("佐藤三郎", 30, "08033333333");

UPDATE clients SET name = "田中一郎", age = 20, phoneNumber = "09011111111" WHERE id = 1;
UPDATE clients SET name = "鈴木二郎", age = 15, phoneNumber = "08022222222" WHERE id = 2;
UPDATE clients SET name = "佐藤三郎", age = 30, phoneNumber = "08033333333" WHERE id = 3;
UPDATE clients SET name = "山田四郎", age = 40, phoneNumber = "09044444444" WHERE id = 4;

UPDATE clients SET age = 31, phoneNumber = "08055555555" WHERE id = 3;

