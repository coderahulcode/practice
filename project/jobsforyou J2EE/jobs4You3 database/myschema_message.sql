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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(10000) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `date_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `placement_fk` (`pid`),
  KEY `students_fk` (`studentid`),
  CONSTRAINT `placement_fk` FOREIGN KEY (`pid`) REFERENCES `placementdrive` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `students_fk` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'You have been employed Best of luck we will here from u soon.',1,1,'2014-05-14 08:56:29'),(2,'Good Exam given by you.Ver good performance',1,1,'2014-05-14 08:58:05'),(3,'Keep working hard be ready for Placements',1,1,'2014-05-14 09:10:13'),(4,'You will get your message which will have all details.',1,1,'2014-05-14 09:15:11'),(6,'hello Are u Ready For Placements',1,1,'2014-05-14 09:23:31'),(8,'You have been selected for Placement drive.',1,1,'2014-05-16 06:33:43'),(10,'Congrats, You Have Been Selected for Interview By TCS via Jobs4You.com',1,4,'2014-05-16 11:03:29'),(11,'Congrats, You Have Been Selected for Interview By TCS via Jobs4You.com',1,4,'2014-05-16 11:03:42'),(12,'Congrats, You Have Been Selected for Interview By TCS via Jobs4You.com',1,4,'2014-05-16 11:03:50'),(13,'Congrats, You Have Been Selected for Interview By TCS via Jobs4You.com',1,4,'2014-05-16 11:03:58'),(14,'Congrats, You Have Been Selected for Interview By TCS via Jobs4You.com',1,4,'2014-05-16 11:09:31'),(15,'Congrats, You have been selected by TCS via Jobs4You.com',1,4,'2014-05-16 11:18:49'),(16,'Congrats, You have been selected by TCS via Jobs4You.com',1,4,'2014-05-16 11:19:12'),(17,'asdsdk jhbsdkvjsbfkjfbwkeifbweiufbw',2,3,'2014-05-23 09:23:06'),(18,'hello you have been selected for the placement drive',1,3,'2014-05-29 05:18:46'),(19,'hello you have been selected for the placement drive',1,3,'2014-05-29 05:20:18'),(20,'You have been selected for Placement drive.',1,2,'2014-05-29 06:05:25'),(57,'Get Prepared For Personal Interview',1,1,'2014-05-29 07:02:11');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-07 17:29:20
