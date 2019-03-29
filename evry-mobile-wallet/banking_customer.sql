-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: banking
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `balance` int(10) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `access` varchar(45) NOT NULL,
  `loan_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (22,'','','','','','',100,'','0',0),(100,'surya','kiran','bangalore','india','7654328764','hjs',10000,'kiran','1',NULL),(200,'ravi','kumar','bangalore','india','6783562765','dslkj@',15138,'kumar','0',8000),(300,'pradeep','kumar','hyderabad','india','7645387632','rei',2050,'kumar','0',NULL),(304,'h','h','h','h','hh','h',100,'h','0',0),(345,'','','','','','',100,'','0',0),(400,'ramesh','panth','delhi','india','9873456234','ljd',300,'ramesh','0',NULL),(500,'abc','abc','abc','abc','88998','sdfljsd',3800,'abc','0',89),(600,'test','test','test','test','test','test',219,'test','0',68),(700,'arun','kumar','bangalore','india','734567827','jljl',200,'arun','0',0),(909,'','','','','','',100,'','0',0),(1000,'aaa','aaa','aaa','aaa','aaaa','aaa',100,'aaa','0',0),(1001,'tt','ttt','ttt','tt','tt','tt',100,'ttt','0',0),(1002,'tt','jj','nn','hh','uu','ii',100,'ll','0',0),(1003,'tt','jj','nn','hh','uu','ii',100,'ll','0',0),(1004,'tt','jj','nn','hh','uu','ii',100,'ll','0',0),(1020,'y','y','y','y','y','y',100,'y','0',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-29  7:01:06
