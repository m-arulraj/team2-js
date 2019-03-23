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
-- Table structure for table `educational_details`
--

DROP TABLE IF EXISTS `educational_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educational_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `HIGHEST_DEGREE` varchar(50) DEFAULT NULL,
  `COLLEGE` varchar(50) DEFAULT NULL,
  `SPECIALIZATION` varchar(50) DEFAULT NULL,
  `YEAR_OF_PASSOUT` bigint(20) DEFAULT NULL,
  `PERCENTAGE` double DEFAULT NULL,
  `YEAR_GAP` bigint(20) DEFAULT NULL,
  `NUMBER_OF_BACKLOGS` bigint(20) DEFAULT NULL,
  `SKILLS` varchar(100) DEFAULT NULL,
  `RESUME` blob,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  CONSTRAINT `USER_EDUCATIONAL_DETAILS_FK` FOREIGN KEY (`USERNAME`) REFERENCES `users` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educational_details`
--

LOCK TABLES `educational_details` WRITE;
/*!40000 ALTER TABLE `educational_details` DISABLE KEYS */;
INSERT INTO `educational_details` VALUES (1,'shubam@outlook.com','BE','SomeCollege','CSE',2018,75.5,0,0,'java,spring,hibernate',''),(2,'himasri@gmail.com','BE','SomeOtherCollege','CSE',2018,75.5,0,0,'java,c#,ajax','');
/*!40000 ALTER TABLE `educational_details` ENABLE KEYS */;
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
