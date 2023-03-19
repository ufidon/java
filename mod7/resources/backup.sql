-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Course` (
  `courseId` char(5) NOT NULL,
  `subjectId` char(4) NOT NULL,
  `courseNumber` int DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `numOfCredits` int DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('11111','CSCI',1301,'Introduction to Java I',4),('11112','CSCI',1302,'Introduction to Java Ii',3),('11113','CSCI',3720,'Database Systems',3),('11114','CSCI',4750,'Rapid Java Application Development',3),('11115','MATH',2750,'Calculus I',5),('11116','MATH',3750,'Calculus II',5),('11117','EDUC',1111,'Reading',3),('11118','ITEC',1344,'Database Administration',3);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enrollment`
--

DROP TABLE IF EXISTS `Enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Enrollment` (
  `ssn` char(9) NOT NULL,
  `courseId` char(5) NOT NULL,
  `dateRegistered` date DEFAULT NULL,
  `grade` char(1) DEFAULT NULL,
  PRIMARY KEY (`ssn`,`courseId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `Enrollment_ibfk_1` FOREIGN KEY (`ssn`) REFERENCES `Student` (`ssn`),
  CONSTRAINT `Enrollment_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `Course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enrollment`
--

LOCK TABLES `Enrollment` WRITE;
/*!40000 ALTER TABLE `Enrollment` DISABLE KEYS */;
INSERT INTO `Enrollment` VALUES ('111111110','11118','2023-01-05','A'),('111111111','11117','2023-01-06','B'),('111111112','11116','2023-01-05','A'),('111111113','11115','2023-01-07','C'),('111111114','11114','2023-01-05','B'),('111111115','11113','2023-01-07','D'),('111111116','11112','2023-01-08','F');
/*!40000 ALTER TABLE `Enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Student` (
  `ssn` char(9) NOT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `mi` char(1) DEFAULT NULL,
  `lastName` varchar(25) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `street` varchar(25) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `zipCode` char(5) DEFAULT NULL,
  `deptId` char(4) DEFAULT NULL,
  PRIMARY KEY (`ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES ('111111110','Joe','K','Biden','1940-04-05','White house ','9119101110','11110','CS'),('111111111','Donald','M','Trump','1941-06-15','Palm beach','9119101111','11111','POLT'),('111111112','Reagon','T','Kite','1931-07-16','Holly wood','9119101112','11112','ACT'),('111111113','Bill','N','Gate','1942-07-17','Sea Side','9119101113','11113','CS'),('111111114','Struat','A','Leiden','1943-08-18','Red land','9119101114','11114','MATH'),('111111115','Steve','B','Ada','1944-09-19','Black Sea','9119101115','11115','CHEM'),('111111116','Noah','C','Einstein','1945-10-20','Yakut Stree','9119101116','11116','BIOL');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-19  0:11:18
