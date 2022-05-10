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
                        `user_id` int NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(25)  NULL,
                        `last_name` varchar(25)  NULL,
                        `user_name` varchar(25) NOT NULL,
                        `email` varchar(25)  NULL,
                        `password` varchar(25) NULL,
                        PRIMARY KEY (`user_id`),
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

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `category` varchar(100) DEFAULT NULL,
                           `brand` varchar(100) DEFAULT NULL,
                           `price` varchar(100) DEFAULT NULL,
                           `user_id` int NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `product_id_uindex` (`id`),
                           KEY `product_user_id_fk` (`user_id`),
                           CONSTRAINT `product_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

INSERT INTO product (id,user,category,brand,price) VALUES (1,'Sam','Cream','Cerave','10.95');
INSERT INTO product (id,user,category,brand,price) VALUES (2,'Fred','Cosmetic','Revlon','15.00');
INSERT INTO product (id,user,category,brand,price) VALUES (3,'Rose','Cream','Cracked cream','3.00');
INSERT INTO product (id,user,category,brand,price) VALUES (4,'Tom','Cream','Aveeno','11.00',1);
INSERT INTO product (id,user,category,brand,price) VALUES (5,'Karen','Cosmetic','Eyeliner','7.00');
INSERT INTO product (id,user,category,brand,price) VALUES (6,'Shean','Cream','Nivea','9.00');



















DROP TABLE IF EXISTS `order_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_products` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `quantity` int DEFAULT NULL,
                                  `order_id` int NOT NULL,
                                  `product_id` int NOT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `order_products_id_uindex` (`id`),
                                  KEY `order_products_product_fk` (`product_id`),
                                  KEY `order_products_order_fk` (`order_id`),
                                  CONSTRAINT `order_products_order_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
                                  CONSTRAINT `order_products_product_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_products`
--

LOCK TABLES `order_products` WRITE;
/*!40000 ALTER TABLE `order_products` DISABLE KEYS */;
INSERT INTO `order_products` VALUES (1,2,4,1),(2,1,4,2),(3,6,4,4),(4,1,5,1),(5,7,5,7);
/*!40000 ALTER TABLE `order_products` ENABLE KEYS */;
UNLOCK TABLES;
