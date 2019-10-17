-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: reading
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(35) NOT NULL,
  `author` varchar(35) NOT NULL,
  `GENRE` varchar(35) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (2,'Ready Player One','Cline','science fiction'),(5,'The Hobbit','J.R.R Tolkien','science fantasy'),(6,'Beneath A Scarlet Sky','Sullivan','historical fiction'),(25,'Ambush','Patterson','Mystery'),(27,'Zookeeper\'s Wife','Ackerman','non-fiction'),(28,'Rules of Prey','Stanford','fiction'),(29,'Zookeeper\'s Wife','Ackerman','non-fiction'),(30,'Rules of Prey','Stanford','fiction'),(31,'Zookeeper\'s Wife','Ackerman','non-fiction'),(32,'Rules of Prey','Stanford','fiction'),(33,'Zookeeper\'s Wife','Ackerman','non-fiction'),(34,'Rules of Prey','Stanford','fiction'),(35,'Zookeeper\'s Wife','Ackerman','non-fiction'),(36,'Rules of Prey','Stanford','fiction'),(37,'Zookeeper\'s Wife','Ackerman','non-fiction'),(38,'Rules of Prey','Stanford','fiction'),(39,'Zookeeper\'s Wife','Ackerman','Non-fiction'),(40,'Rules of Prey','Stanford','mystery'),(41,'The Millionaire Next Door','Stanley','business'),(47,'My Child Is Sick','Schmitt','Health'),(49,'Test 1','NeilG','fiction');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_on_list`
--

DROP TABLE IF EXISTS `books_on_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_on_list` (
  `BOOK_ID` int(11) NOT NULL,
  `LIST_ID` int(11) NOT NULL,
  KEY `LIST_ID` (`LIST_ID`),
  KEY `BOOK_ID` (`BOOK_ID`),
  CONSTRAINT `books_on_list_ibfk_1` FOREIGN KEY (`LIST_ID`) REFERENCES `list_details` (`LIST_ID`),
  CONSTRAINT `books_on_list_ibfk_2` FOREIGN KEY (`BOOK_ID`) REFERENCES `books` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_on_list`
--

LOCK TABLES `books_on_list` WRITE;
/*!40000 ALTER TABLE `books_on_list` DISABLE KEYS */;
INSERT INTO `books_on_list` VALUES (28,4),(29,4),(40,10),(25,10),(25,4),(28,1),(41,4),(2,62);
/*!40000 ALTER TABLE `books_on_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_details`
--

DROP TABLE IF EXISTS `list_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_details` (
  `LIST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LIST_NAME` varchar(30) DEFAULT NULL,
  `READ_DATE` date DEFAULT NULL,
  `READER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LIST_ID`),
  KEY `READER_ID` (`READER_ID`),
  CONSTRAINT `list_details_ibfk_1` FOREIGN KEY (`READER_ID`) REFERENCES `reader` (`READER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_details`
--

LOCK TABLES `list_details` WRITE;
/*!40000 ALTER TABLE `list_details` DISABLE KEYS */;
INSERT INTO `list_details` VALUES (1,'Grandpa\'s List','2019-10-01',2),(4,'Neil\'s BookList','2019-10-03',1),(10,'Crime Books','2019-10-02',11),(62,'My list','2019-10-17',69);
/*!40000 ALTER TABLE `list_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reader` (
  `READER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `READER_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`READER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader`
--

LOCK TABLES `reader` WRITE;
/*!40000 ALTER TABLE `reader` DISABLE KEYS */;
INSERT INTO `reader` VALUES (1,'Neil'),(2,'Grandpa'),(3,'Grandpa'),(4,'Neil'),(5,'Neil'),(6,'Neil'),(7,'Neil'),(8,'Neil'),(9,'Neil'),(10,'Neil'),(11,'wife'),(12,'brother'),(13,'brother'),(14,'Brother Pat'),(15,'brother'),(16,'brother'),(17,''),(18,''),(19,''),(20,''),(21,''),(22,''),(23,''),(24,''),(25,''),(26,''),(27,''),(28,''),(29,''),(30,''),(31,''),(32,''),(33,''),(34,''),(35,''),(36,''),(37,''),(38,''),(39,'wilson'),(40,'bob'),(41,'willie'),(42,'Dave'),(43,'Mandy'),(44,''),(45,''),(46,'willow'),(47,''),(48,''),(49,''),(50,''),(51,'ggg'),(52,''),(53,''),(54,''),(55,'jjj'),(56,'hh'),(57,'hh'),(58,'jj'),(59,'jj'),(60,'ss'),(61,'test'),(62,'test'),(63,'tt'),(64,''),(65,''),(66,'rr'),(67,'there'),(68,'Neil'),(69,'Neil Geyerman');
/*!40000 ALTER TABLE `reader` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-17 15:18:05
