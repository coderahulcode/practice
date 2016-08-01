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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `chatid` int(11) NOT NULL AUTO_INCREMENT,
  `msg_from` varchar(45) DEFAULT NULL,
  `msg_to` varchar(45) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `msg` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`chatid`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (62,'gur','server','2015-07-17 11:01:33','hello'),(63,'server','gur','2015-07-17 11:01:45','ki hal chL'),(64,'tar','server','2015-07-18 05:40:56','ifeijfne'),(65,'server','tar','2015-07-18 05:40:59','jfnwidw'),(66,'server','tar','2015-07-18 05:41:00','fiuwjfwuf'),(67,'tar','server','2015-07-18 05:41:03','fwjfiwf'),(68,'tar','server','2015-07-18 05:41:06','fnwiejd'),(69,'tar','server','2015-07-18 05:41:07','ornwifnw'),(70,'tar','server','2015-07-18 05:41:08','fbufbkwfnw'),(71,'tar','server','2015-07-18 05:41:09','jwbfw'),(72,'server','tar','2015-07-18 05:41:15','ekwjfnweudbuwed\\'),(73,'server','tar','2015-07-18 05:41:16','ndkwndwd'),(74,'server','tar','2015-07-18 05:41:16','nijwdnkwdn'),(75,'server','tar','2015-07-18 05:41:17','bwudbwe'),(76,'server','tar','2015-07-18 05:41:18','iwdnow'),(77,'server','tar','2015-07-18 05:41:19','nwdn'),(78,'tar','server','2015-07-18 06:29:28','today'),(79,'server','tar','2015-07-18 06:29:36','today'),(80,'yash17','server','2015-07-18 06:30:08','hello'),(81,'server','yash17','2015-07-18 06:30:23','hello'),(82,'yash17','server','2015-07-18 06:42:22','hi'),(83,'tar','server','2015-07-18 06:45:54','hii'),(84,'server','tar','2015-07-18 06:46:03','hey'),(85,'tar','server','2015-07-18 06:47:00','hello'),(86,'server','tar','2015-07-18 06:47:13','kk'),(87,'tar','server','2015-07-18 06:47:28','hgfhf'),(88,'gur','server','2015-07-18 06:49:28','hi'),(89,'gur','server','2015-07-18 06:52:51','helloqqqqq'),(90,'gur','server','2015-07-18 06:53:14','hi kal cha; bhai server'),(91,'gur','server','2015-07-18 06:53:21','fgffd'),(92,'gur','server','2015-07-18 06:53:22','df'),(93,'gur','server','2015-07-18 06:53:25','server'),(94,'server','gur','2015-07-18 07:04:55','hello'),(95,'gur','server','2015-07-18 07:05:02','hiii'),(96,'gur','server','2015-07-18 07:05:27','hey'),(97,'gur','server','2015-07-18 07:05:38','hey'),(98,'gur','server','2015-07-18 07:05:49','1'),(99,'gur','server','2015-07-18 07:11:46','kidan'),(100,'gur','server','2015-07-18 07:11:57','ki hal'),(101,'gur','server','2015-07-18 07:12:04','chall hai'),(102,'gur','server','2015-07-18 07:16:28','hi from gur'),(103,'server','gur','2015-07-18 07:16:36','hanji'),(104,'gur','server','2015-07-18 07:16:45','theek ha'),(105,'gur','server','2015-07-18 07:16:55','vadiya'),(106,'gur','server','2015-07-18 07:17:07','ohk'),(107,'tar','server','2015-07-18 07:18:43','acha'),(108,'tar','server','2015-07-18 07:18:59','lagh gaya pata'),(109,'server','gur','2015-07-18 09:01:57','hello'),(110,'gur','server','2015-07-18 09:10:04','hello'),(111,'server','gur','2015-07-18 09:10:07','hey'),(112,'gur','server','2015-07-18 09:13:22','hello'),(113,'server','gur','2015-07-18 09:13:28','hii'),(114,'gur','server','2015-07-18 09:13:44','ki hal chalahh:'),(115,'gur','server','2015-07-18 09:14:41','acha'),(116,'gur','server','2015-07-18 09:14:48','ok'),(117,'gur','server','2015-07-18 09:14:55','vadiya'),(118,'server','gur','2015-07-18 09:15:51','hey'),(119,'gur','server','2015-07-18 09:27:33','hello'),(120,'server','gur','2015-07-18 09:27:36','hey'),(121,'server','gur','2015-07-18 09:27:43','ki krda'),(122,'gur','server','2015-07-18 09:28:03','acha'),(123,'gur','server','2015-07-18 09:28:09','bye'),(124,'gur','server','2015-07-18 09:36:52','ohk'),(125,'server','gur','2015-07-18 09:36:55','hey'),(126,'gur','server','2015-07-18 09:37:38','hk');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-18 15:22:06
