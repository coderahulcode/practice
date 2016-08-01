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
-- Table structure for table `educational_qualification`
--

DROP TABLE IF EXISTS `educational_qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educational_qualification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `degree` int(11) DEFAULT NULL,
  `year_of_passing` int(11) DEFAULT NULL,
  `other_degree` varchar(45) DEFAULT NULL,
  `stream` varchar(45) DEFAULT NULL,
  `marks` decimal(4,2) DEFAULT NULL,
  `marks_type` int(11) DEFAULT NULL,
  `university` int(11) DEFAULT NULL,
  `extra` varchar(90) DEFAULT NULL,
  `ssc` decimal(4,2) DEFAULT NULL,
  `hsc` decimal(4,2) DEFAULT NULL,
  `postdegree` int(11) DEFAULT NULL,
  `post_marks` decimal(4,2) DEFAULT NULL,
  `post_marks_type` int(11) DEFAULT NULL,
  `college` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid_fk` (`user_id`),
  KEY `degreefk` (`degree`),
  KEY `marks_typefk` (`marks_type`),
  KEY `postdegreefk` (`postdegree`),
  KEY `postmarks_typefk` (`post_marks_type`),
  KEY `univfk` (`university`),
  KEY `college_id1` (`college`),
  CONSTRAINT `college_id1` FOREIGN KEY (`college`) REFERENCES `reference`.`college` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `degreefk` FOREIGN KEY (`degree`) REFERENCES `reference`.`degree` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `marks_typefk` FOREIGN KEY (`marks_type`) REFERENCES `reference`.`marks_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `postdegreefk` FOREIGN KEY (`postdegree`) REFERENCES `reference`.`degree` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `postmarks_typefk` FOREIGN KEY (`post_marks_type`) REFERENCES `reference`.`marks_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `univfk` FOREIGN KEY (`university`) REFERENCES `reference`.`university` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userid_fk` FOREIGN KEY (`user_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educational_qualification`
--

LOCK TABLES `educational_qualification` WRITE;
/*!40000 ALTER TABLE `educational_qualification` DISABLE KEYS */;
INSERT INTO `educational_qualification` VALUES (1,1,1,2014,'','CSE',8.87,2,1,'',87.00,82.00,NULL,NULL,NULL,1),(2,2,1,2014,'','CSE',8.87,2,1,'Hard Working',87.60,87.80,NULL,NULL,NULL,2),(3,4,1,2014,'null','CSE',6.50,2,1,'no',87.00,59.00,NULL,NULL,NULL,3),(4,5,1,2014,'','CSE',8.80,2,1,'',88.00,88.00,NULL,NULL,NULL,1),(5,8,1,2014,'','cse',83.00,1,2,'',80.00,80.00,NULL,NULL,NULL,7);
/*!40000 ALTER TABLE `educational_qualification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-07 17:29:46
