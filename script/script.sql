CREATE DATABASE bitcoin;
SHOW DATABASES;
USE bitcoin;
CREATE TABLE `Usuario` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(50) NOT NULL,
	`cpf` VARCHAR(14) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	`role` VARCHAR(55),
	PRIMARY KEY(`id`)) ENGINE=InnoDB;
	
CREATE TABLE `Ordem` (
	`id` int NOT NULL AUTO_INCREMENT,
	`preco` decimal(6,2) NOT NULL,
	`tipo` VARCHAR(20) NOT NULL,
	`data` datetime NOT NULL,
	`status` VARCHAR(30) NOT NULL,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `Usuario` (`id`)) ENGINE=InnoDB;