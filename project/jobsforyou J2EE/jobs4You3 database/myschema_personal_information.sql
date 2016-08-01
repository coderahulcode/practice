CREATE DATABASE  IF NOT EXISTS `myschema` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `myschema`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: myschema
-- ------------------------------------------------------
-- Server version	5.5.13

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
-- Table structure for table `personal_information`
--

DROP TABLE IF EXISTS `personal_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `secondary_email` varchar(45) DEFAULT NULL,
  `mobile_no` varchar(12) DEFAULT NULL,
  `home_phone` varchar(12) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `address` int(11) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `resume` varchar(1000) DEFAULT NULL,
  `photo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `user_idfk` (`user_id`),
  KEY `addressfk` (`address`),
  CONSTRAINT `addressfk` FOREIGN KEY (`address`) REFERENCES `user_address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_idfk` FOREIGN KEY (`user_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_information`
--

LOCK TABLES `personal_information` WRITE;
/*!40000 ALTER TABLE `personal_information` DISABLE KEYS */;
INSERT INTO `personal_information` VALUES (1,1,'harpreet','Harpreet','Singh','Narula','harpreetnarula002@gmail.com','harpreetnarula001@gmail.com','7837234373','',NULL,1,NULL,'./Uploads/Resume/workshop feedback form.docx','./Uploads/Photos/Harpreet.Singh.Narula.000.jpg'),(2,2,'rishab','Rishab','','Gandhar','rishabgandhar@gmail.com','rishabgandhar@ymail.com','9779173008','9780183144',NULL,2,NULL,'./Uploads/Resume/final resume.doc','./Uploads/Photos/one.jpg'),(3,3,'sahil','Sahil',NULL,'Mahajan','mahajan@gmail.com',NULL,'9852144523',NULL,NULL,NULL,NULL,NULL,NULL),(4,4,'sidhu','Tejinder','Pal','Sidhu','tpsidhu91@yahoo.com','','9779461314','6497845131','M',3,'indian',NULL,NULL),(5,5,'vineet','Vineet','','Sharma','vineetsharma@gmail.com','','888999988','9855666252','M',4,'indian',NULL,NULL),(6,6,'pls',NULL,NULL,NULL,'sdg@sdg.com',NULL,'789',NULL,NULL,NULL,NULL,NULL,'./Uploads/Photos/1.png'),(7,7,'rahul',NULL,NULL,NULL,'mahajan.rahul1994@gmail.com',NULL,'8427478857',NULL,NULL,NULL,NULL,NULL,'./Uploads/Photos/1122.jpg'),(8,8,'rahul1','Rahul','','Mahajan','mahajan.rahul1994@gmail.com','','8427478857','','M',5,'indian','./Uploads/Resume/cv.docx','./Uploads/Photos/my.jpg'),(9,9,'r',NULL,NULL,NULL,'mahajan.rahul1994@gmail.com',NULL,'8427478857',NULL,NULL,NULL,NULL,NULL,'./Uploads/Photos/pic1.png');
/*!40000 ALTER TABLE `personal_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-07 17:29:22
