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
-- Table structure for table `other_information`
--

DROP TABLE IF EXISTS `other_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `other_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `prefered_job_type` varchar(500) DEFAULT NULL,
  `prefered_job_location` int(11) DEFAULT NULL,
  `expected_salary_range` int(11) DEFAULT NULL,
  `extra` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkid` (`user_id`),
  KEY `job_locfk` (`prefered_job_location`),
  KEY `salary_rangefk` (`expected_salary_range`),
  KEY `fkloc` (`prefered_job_type`),
  CONSTRAINT `fkid` FOREIGN KEY (`user_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkloc` FOREIGN KEY (`prefered_job_location`) REFERENCES `reference`.`state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salary_rangefk` FOREIGN KEY (`expected_salary_range`) REFERENCES `reference`.`salary_range` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_information`
--

LOCK TABLES `other_information` WRITE;
/*!40000 ALTER TABLE `other_information` DISABLE KEYS */;
INSERT INTO `other_information` VALUES (1,1,'Software Engineer',1627,6,''),(2,2,'Assistant Software Engineer',1627,3,'Working hours between 9 to 7 preferred'),(3,8,'chandigarh',1627,1,'');
/*!40000 ALTER TABLE `other_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-07 17:29:09
