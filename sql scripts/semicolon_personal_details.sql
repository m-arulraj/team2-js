CREATE DATABASE  IF NOT EXISTS `semicolon` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `semicolon`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 172.25.229.37    Database: semicolon
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `personal_details`
--

DROP TABLE IF EXISTS `personal_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `CONTACT_NUMBER` bigint(20) DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `ADDRESS` varchar(50) DEFAULT NULL,
  `FATHER_NAME` varchar(50) DEFAULT NULL,
  `COUNTRY` varchar(30) DEFAULT NULL,
  `STATE` varchar(30) DEFAULT NULL,
  `PINCODE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  KEY `USER_PERSONAL_DETAILS_FK_idx` (`USERNAME`),
  CONSTRAINT `USER_PERSONAL_DETAILS_FK` FOREIGN KEY (`USERNAME`) REFERENCES `users` (`USERNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_details`
--

LOCK TABLES `personal_details` WRITE;
/*!40000 ALTER TABLE `personal_details` DISABLE KEYS */;
INSERT INTO `personal_details` VALUES (1,'himasri@gmail.com','Himasri','Varikuti','Female',7398576232,'0000-00-00','Vijayawada','Varikuti','India','Telangana',562125),(2,'shubam@outlook.com','Shubam','Sharma','Male',7309576232,'0000-00-00','Delhi','Sharma','India','Delhi',562125),(64,'hi@g.c','a','fg',NULL,834574075,'2013-12-12','DSDF','sdfsd','some','dsfd',34543),(70,'srini@gmail.com','a','fg','Male',834574075,'2013-12-11','DSDF','sdfsd','some','dsf',34543);
/*!40000 ALTER TABLE `personal_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 17:29:18
