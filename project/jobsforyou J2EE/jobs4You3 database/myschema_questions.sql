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
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) DEFAULT NULL,
  `a` varchar(1000) DEFAULT NULL,
  `b` varchar(1000) DEFAULT NULL,
  `c` varchar(1000) DEFAULT NULL,
  `d` varchar(1000) DEFAULT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Which of the follwing is a low level language ?','JAVA','VB','.NET','C','C',1),(2,'Who invented C ?','Steve Jobs','Bill Gates','Larry Page','None of the Above','None of the Above',1),(3,'Memory, also called random access memory, or RAM.....',' contains the electronic circuits that cause processing to occur','makes the information resulting from processing available for use','allows data, programs, commands, and user responses to be entered into a computer','consists of electronic components that store data','consists of electronic components that store data',1),(4,'Correcting errors in a program is referred to as...','debugging',' bugging','rectifying','modifying','debugging',1),(5,'An assembler is used to translate a program written in....','a low level language','machine language','a high level language','assembly language','assembly language',1),(6,'The capability of the operating system to enable two or more than two programs to execute simultaneously in a single computer system by using a single processor is','Multiprocessing','Multitasking','Multiprogramming','Multiexecution','Multitasking',1),(7,'The basic goal of computer process is to convert data into','information','files','tables','graphs','information',1),(8,'A hard copy of a document is',' stored in the hard disk',' stored on a floppy','stored on a CD','printed on the printer','printed on the printer',1),(9,'What is the return type of printf ?','void','int','float','char[]','int',1),(10,'Character array ends with ?','\'\\0\'','\'\\n\'','\'\\\\\'','\'/\\\'','\'\\0\'',1),(11,'Which of the following points to i th index of array a ?','a[i]','i[a]','a(i+0)','All Of Above','All Of Above',1),(12,'Fastest Sorting Algorithm out of following ?','Insertion Sort','Selection Sort','Quick Sort','Merge Sort','Merge Sort',1),(13,'Math class is present in which package ?','util','lang','io','net','lang',1),(14,'Local variable in java cannot be ?','static','final','abstract','synchronised','static',1),(15,'Which of the following is possible in c ?','Polymorphism','Multithreading','Dynamic Memory Allocation','Database Handling','Dynamic Memory Allocation',1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-07 17:29:07
