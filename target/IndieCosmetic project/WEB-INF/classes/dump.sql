-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
-- Host: 127.0.0.1    Database: Cosmetic
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `product`;


DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(25)  NULL,
                        `last_name` varchar(25)  NULL,
                        `user_name` varchar(25) NOT NULL,
                        `email` varchar(25)  NULL,
                        `password` varchar(25) NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `users_user_name_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO user (id,first_name, last_name, user_name, email, password) VALUES (1,'Sam','Toyne','jscoyne','Userone@gmail.com0','user123');
INSERT INTO user (id,first_name, last_name, user_name, email, password) VALUES (2,'Fred','Hensen','fhensen','Userone@gmail.com0','user123');
INSERT INTO user (id,first_name, last_name, user_name, email, password) VALUES (3,'Rose','Roy','rroy','Userone@gmail.com0','user123');
INSERT INTO user (id,first_name, last_name, user_name, email, password) VALUES (4,'Tom','Klien','tklien','Userone@gmail.com0','user123');
INSERT INTO user (id,first_name, last_name, user_name, email, password) VALUES (5,'Karen','Mack','kmack','Userone@gmail.com0','user123');
INSERT INTO user (id,first_name, last_name, user_name, email, password) VALUES (6,'Shean','Tillman','stillman','Userone@gmail.com0','user123');


/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `description` varchar(100) DEFAULT NULL,
                          `user_id` int(11) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `orders_id_uindex` (`id`),
                          KEY `orders_user_id_fk` (`user_id`),
                          CONSTRAINT `orders_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Cerave',1),(2,'Cetaphil',2),(3,'Cracked cream ',2),(4,'Aveeno',1),(5,'Hand Cream ',4),(6,'Nivea',1),(7,'EyeLiner',4);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

INSERT INTO orders (id,description, user_id) VALUES (1,'Cerave',1);
INSERT INTO orders (id,description, user_id) VALUES (2,'Cetaphil',2);
INSERT INTO orders (id,description, user_id) VALUES (3,'Cracked cream ',2);
INSERT INTO orders (id,description, user_id) VALUES (4,'Aveeno',1);
INSERT INTO orders (id,description, user_id) VALUES (5,'Hand Cream ',4);
INSERT INTO orders (id,description, user_id) VALUES (6,'Nivea',1);
INSERT INTO orders (id,description, user_id) VALUES (7,'EyeLiner',4);

--
-- Table structure for table `product`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `brand` varchar(70) DEFAULT NULL,
                           `type` varchar(70) DEFAULT NULL,
                           `user_name` varchar(70) not null,
                           `item_id` int(11) NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `product_id_uindex` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



select * from user;







--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO product (brand, type,user_name,item_id) VALUES ('paris', 'eyeshadow','samt','123');
INSERT INTO product (brand, type, user_name,item_id) VALUES ('milan', 'eyelash','attn1','77');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `item`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(70) DEFAULT NULL,
                        `description` varchar(70) DEFAULT NULL,
                        `product` varchar(70) not null,
                        `item_id` int(11) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `item_id_uindex` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Dumping data for table `product`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
Insert into item (name, description, product, item_id) values ('Clinique', 'Gold','Eyeliner','12');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
