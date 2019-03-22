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
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('20190318171500','virtusa','classpath:config/liquibase/changelog/semicolon_schema.xml','2019-03-18 17:19:44',1,'EXECUTED','8:363504964da6bbb20ed0de2cf35149d9','createTable tableName=USERS; createTable tableName=AUTHORITIES; addForeignKeyConstraint baseTableName=AUTHORITIES, constraintName=USER_AUTHORITY_FK, referencedTableName=USERS; createTable tableName=PERSONAL_DETAILS; addForeignKeyConstraint baseTab...','',NULL,'3.6.3',NULL,NULL,'2909781261'),('20190318180700','virtusa','classpath:config/liquibase/changelog/semicolon_schema.xml','2019-03-18 18:48:50',2,'EXECUTED','8:d1482d9e256e1e6e1804afb19ec96b18','createTable tableName=COMPANY_DETAILS; createTable tableName=POSTED_JOBS_LIST','',NULL,'3.6.3',NULL,NULL,'2915130223'),('20190318510700','virtusa','classpath:config/liquibase/changelog/semicolon_schema.xml','2019-03-18 18:51:23',3,'EXECUTED','8:f1c2667390906e8bfb2e87b9f22a9ba4','createTable tableName=COMPANY_DETAILS; addForeignKeyConstraint baseTableName=COMPANY_DETAILS, constraintName=USER_COMPANY_DETAILS_FK, referencedTableName=USERS; createTable tableName=POSTED_JOBS_LIST; addForeignKeyConstraint baseTableName=POSTED_J...','',NULL,'3.6.3',NULL,NULL,'2915282160');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 17:29:20
