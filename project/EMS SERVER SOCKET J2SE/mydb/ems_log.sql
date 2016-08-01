CREATE DATABASE  IF NOT EXISTS `ems` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ems`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: ems
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
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`logid`),
  KEY `username` (`user_name`),
  CONSTRAINT `user_name` FOREIGN KEY (`user_name`) REFERENCES `employee` (`emp_username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=219 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (94,'gur','2015-07-15','11:06:01','2015-07-15','11:06:43'),(97,'gur','2015-07-15','12:10:06','2015-07-15','12:10:14'),(98,'gur','2015-07-15','12:27:09',NULL,NULL),(100,'gur','2015-07-15','12:28:32','2015-07-15','12:30:17'),(102,'gur','2015-07-15','12:34:08','2015-07-15','12:36:52'),(103,'tar','2015-07-15','12:34:55','2015-07-15','12:36:45'),(104,'yash17','2015-07-15','12:36:36','2015-07-15','12:36:48'),(105,'gur','2015-07-15','12:40:22','2015-07-15','12:41:11'),(106,'gur','2015-07-15','13:13:11','2015-07-15','13:13:40'),(107,'gur','2015-07-15','13:14:16','2015-07-15','13:16:18'),(108,'tar','2015-07-15','13:15:20','2015-07-15','13:16:22'),(109,'gur','2015-07-15','13:31:28','2015-07-15','13:31:40'),(110,'tar','2015-07-15','13:31:50','2015-07-15','13:32:02'),(111,'gur','2015-07-15','13:35:41','2015-07-15','13:35:44'),(112,'tar','2015-07-15','13:35:53','2015-07-15','13:36:19'),(113,'tar','2015-07-15','13:36:29','2015-07-15','13:36:41'),(114,'gur','2015-07-15','22:23:20','2015-07-15','22:23:44'),(115,'gur','2015-07-15','22:24:39','2015-07-15','22:24:45'),(116,'tar','2015-07-15','22:24:52','2015-07-15','22:25:06'),(117,'gur','2015-07-15','22:26:26','2015-07-15','22:26:54'),(118,'gur','2015-07-15','22:27:59','2015-07-15','22:28:36'),(119,'gur','2015-07-15','22:30:09','2015-07-15','22:32:20'),(120,'gur','2015-07-16','10:03:26','2015-07-16','10:03:46'),(121,'gur','2015-07-16','10:49:30',NULL,NULL),(122,'tar','2015-07-16','10:50:05',NULL,NULL),(123,'gur','2015-07-16','11:17:01',NULL,NULL),(124,'gur','2015-07-16','11:21:47','2015-07-16','11:23:12'),(125,'tar','2015-07-16','11:21:59','2015-07-16','11:23:15'),(126,'gur','2015-07-16','11:28:04',NULL,NULL),(127,'gur','2015-07-16','11:28:50',NULL,NULL),(128,'gur','2015-07-16','11:30:34',NULL,NULL),(129,'gur','2015-07-16','11:47:38',NULL,NULL),(130,'gur','2015-07-16','12:02:57','2015-07-16','12:05:12'),(131,'tar','2015-07-16','12:03:49','2015-07-16','12:05:13'),(132,'gur','2015-07-16','12:06:52',NULL,NULL),(133,'tar','2015-07-16','12:10:08','2015-07-16','12:10:11'),(134,'tar','2015-07-16','12:14:23','2015-07-16','12:42:26'),(135,'gur','2015-07-16','12:43:37','2015-07-16','12:44:29'),(136,'gur','2015-07-16','12:44:47','2015-07-16','12:45:14'),(137,'gur','2015-07-16','12:51:32','2015-07-16','12:52:08'),(138,'gur','2015-07-16','12:53:44','2015-07-16','12:55:10'),(139,'tar','2015-07-16','12:56:25','2015-07-16','12:56:42'),(140,'gur','2015-07-16','13:01:01','2015-07-16','13:01:40'),(141,'gur','2015-07-16','13:03:42','2015-07-16','13:06:06'),(142,'gur','2015-07-16','13:13:56','2015-07-16','13:15:11'),(143,'gur','2015-07-16','13:46:16','2015-07-16','13:47:04'),(144,'tar','2015-07-16','13:47:12','2015-07-16','13:47:31'),(145,'tar','2015-07-16','13:47:54','2015-07-16','13:48:24'),(146,'gur','2015-07-16','15:40:57','2015-07-16','15:41:25'),(147,'gur','2015-07-16','15:53:16','2015-07-16','15:53:42'),(148,'gur','2015-07-16','15:55:09','2015-07-16','15:56:30'),(149,'gur','2015-07-16','15:57:30','2015-07-16','15:58:25'),(150,'gur','2015-07-16','16:22:26','2015-07-16','16:24:05'),(151,'tar','2015-07-16','16:23:10','2015-07-16','16:23:58'),(152,'gur','2015-07-16','16:27:31',NULL,NULL),(153,'gur','2015-07-16','17:05:12','2015-07-16','17:06:46'),(154,'gur','2015-07-16','17:08:50','2015-07-16','17:09:38'),(155,'gur','2015-07-16','17:11:06','2015-07-16','17:11:32'),(156,'gur','2015-07-16','17:55:42',NULL,NULL),(157,'gur','2015-07-16','17:56:40','2015-07-16','17:57:12'),(158,'gur','2015-07-16','18:05:44','2015-07-16','18:07:05'),(159,'gur','2015-07-16','18:08:21','2015-07-16','18:09:02'),(160,'gur','2015-07-16','20:10:40','2015-07-16','20:11:15'),(161,'tar','2015-07-16','20:12:53',NULL,NULL),(162,'gur','2015-07-16','20:44:24','2015-07-16','20:44:36'),(163,'gur','2015-07-16','20:51:24','2015-07-16','20:51:48'),(164,'gur','2015-07-16','20:57:01','2015-07-16','20:58:01'),(165,'tar','2015-07-17','11:45:27','2015-07-17','11:47:25'),(166,'yash17','2015-07-17','12:10:52','2015-07-17','12:11:17'),(167,'yash17','2015-07-17','12:11:51','2015-07-17','12:12:42'),(168,'yash17','2015-07-17','12:13:02','2015-07-17','12:13:28'),(169,'gur','2015-07-17','14:46:58','2015-07-17','14:47:36'),(170,'gur','2015-07-17','14:50:00','2015-07-17','14:53:05'),(171,'tar','2015-07-17','14:51:33','2015-07-17','14:52:27'),(172,'gur','2015-07-17','15:17:57',NULL,NULL),(173,'gur','2015-07-17','15:29:00','2015-07-17','15:29:31'),(174,'gur','2015-07-17','15:30:35',NULL,NULL),(175,'gur','2015-07-17','15:54:18',NULL,NULL),(176,'gur','2015-07-17','16:16:45','2015-07-17','16:19:28'),(177,'yash17','2015-07-17','16:21:32','2015-07-17','16:21:56'),(178,'gur','2015-07-17','16:23:57','2015-07-17','16:24:24'),(179,'gur','2015-07-17','16:28:53','2015-07-17','16:29:18'),(180,'gur','2015-07-17','16:31:22','2015-07-17','16:31:51'),(181,'gur','2015-07-17','17:58:57','2015-07-17','17:59:07'),(182,'gur','2015-07-17','18:01:12',NULL,NULL),(183,'tar','2015-07-17','18:01:46','2015-07-17','18:02:32'),(184,'gur','2015-07-17','18:08:27','2015-07-17','18:08:30'),(185,'gur','2015-07-17','19:59:10','2015-07-17','19:59:24'),(186,'gur','2015-07-17','20:07:37','2015-07-17','20:07:54'),(187,'tar','2015-07-18','11:10:46','2015-07-18','11:11:25'),(188,'tar','2015-07-18','11:11:36','2015-07-18','11:11:41'),(189,'yash17','2015-07-18','11:30:15','2015-07-18','11:30:20'),(190,'yash17','2015-07-18','11:43:32',NULL,NULL),(191,'yash17','2015-07-18','11:50:54',NULL,NULL),(192,'yash17','2015-07-18','11:52:21',NULL,NULL),(193,'yash17','2015-07-18','11:57:25',NULL,NULL),(194,'tar','2015-07-18','11:59:10','2015-07-18','12:00:51'),(195,'yash17','2015-07-18','12:00:05','2015-07-18','12:00:46'),(196,'gur','2015-07-18','12:10:51','2015-07-18','12:12:32'),(197,'yash17','2015-07-18','12:12:15','2015-07-18','12:12:29'),(198,'tar','2015-07-18','12:15:50','2015-07-18','12:17:46'),(199,'gur','2015-07-18','12:19:04','2015-07-18','12:21:19'),(200,'gur','2015-07-18','12:22:34','2015-07-18','12:23:27'),(201,'gur','2015-07-18','12:23:36','2015-07-18','12:23:40'),(202,'gur','2015-07-18','12:26:46',NULL,NULL),(203,'gur','2015-07-18','12:28:28',NULL,NULL),(204,'gur','2015-07-18','12:30:38',NULL,NULL),(205,'gur','2015-07-18','12:32:42',NULL,NULL),(206,'gur','2015-07-18','12:34:46','2015-07-18','12:36:03'),(207,'gur','2015-07-18','12:41:41',NULL,NULL),(208,'gur','2015-07-18','12:46:20','2015-07-18','12:47:10'),(209,'tar','2015-07-18','12:48:37','2015-07-18','12:49:02'),(210,'gur','2015-07-18','12:52:10','2015-07-18','12:52:16'),(211,'gur','2015-07-18','14:31:39','2015-07-18','14:32:53'),(212,'test','2015-07-18','14:34:36',NULL,NULL),(213,'gur','2015-07-18','14:39:54','2015-07-18','14:40:15'),(214,'gur','2015-07-18','14:42:58',NULL,NULL),(215,'gur','2015-07-18','14:57:21','2015-07-18','15:00:23'),(216,'gur','2015-07-18','15:06:44',NULL,NULL),(217,'gur','2015-07-18','15:09:03',NULL,NULL),(218,'gur','2015-07-18','15:16:42','2015-07-18','15:18:46');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-18 15:22:03
