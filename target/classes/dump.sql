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
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(25)  NULL,
                        `last_name` varchar(25)  NULL,
                        `user_name` varchar(25) NOT NULL,
                        `email` varchar(25)  NULL,
                        `password` varchar(25) NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_name_UNIQUE` (`user_name`)) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

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
