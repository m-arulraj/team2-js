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
-- Table structure for table `posted_jobs_list`
--

DROP TABLE IF EXISTS `posted_jobs_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posted_jobs_list` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `POSTED_BY` varchar(50) DEFAULT NULL,
  `JOB_TITLE` varchar(50) DEFAULT NULL,
  `JOB_ID` varchar(20) DEFAULT NULL,
  `JOB_TYPE` varchar(20) DEFAULT NULL,
  `NUMBER_OF_VACANCIES` bigint(20) DEFAULT NULL,
  `SALARY` double DEFAULT NULL,
  `REQUIRED_SKILLS` varchar(100) DEFAULT NULL,
  `JOB_DESCRIPTION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_POSTED_JOBS_LIST_FK` (`POSTED_BY`),
  CONSTRAINT `USER_POSTED_JOBS_LIST_FK` FOREIGN KEY (`POSTED_BY`) REFERENCES `users` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posted_jobs_list`
--

LOCK TABLES `posted_jobs_list` WRITE;
/*!40000 ALTER TABLE `posted_jobs_list` DISABLE KEYS */;
INSERT INTO `posted_jobs_list` VALUES (0,'srini@gmail.com','SE','2121SE',NULL,25,35000,'Java,Spring','AGoodJob'),(2,'vamsi@gmail.com','UI','1212UI',NULL,25,35000,'Java,Spring,JSP','AnotherGoodJob'),(3,'vamsi@gmail.com','SE','1212SE',NULL,25,35000,'Java,Spring,JSP','OneMoreGoodJob'),(30,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(31,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(32,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(33,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(34,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(35,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(36,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(37,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(45,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(46,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(47,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(48,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(49,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(50,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(51,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(52,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(53,'vamsi@gmail.com','jobTitle','jobId',NULL,20,5000,'requiredSkills','jobDescription'),(54,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,'vamsi@gmail.com','Senior Java Developer','Java1010',NULL,5,50000000,'java,spring','candiadte need to develop API\'s');
/*!40000 ALTER TABLE `posted_jobs_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 17:29:19
