DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS employee;

CREATE TABLE address (
  `id` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NULL,
  `country` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `employee` (
  `id` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `addressid` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
    CONSTRAINT `addressidfk`
    FOREIGN KEY (`addressid`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);