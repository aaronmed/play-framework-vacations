-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_vacations
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.11-MariaDB

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
-- Table structure for table `advert`
--

DROP TABLE IF EXISTS `advert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `published` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `guests` tinyint(4) DEFAULT NULL,
  `bathrooms` tinyint(4) DEFAULT NULL,
  `bedrooms` tinyint(4) DEFAULT NULL,
  `beds` tinyint(4) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  `photoName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sphjb2u4ng2cu1ktjd6pdnta1` (`user`),
  CONSTRAINT `FK_sphjb2u4ng2cu1ktjd6pdnta1` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `advert_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advert`
--

LOCK TABLES `advert` WRITE;
/*!40000 ALTER TABLE `advert` DISABLE KEYS */;
INSERT INTO `advert` VALUES (1,'Reformado hace muchos meses','Madrid','2020-02-15',20.5,2,2,1,40,32,'madrid.jpg'),(2,'Recién reformado','Barcelona','2020-11-15',10,2,1,2,1,32,'barcelona.jpg'),(4,'Reformado hace 2 meses','Madrid','2020-02-15',20.9,2,2,1,4,32,'madrid.jpg'),(7,'Baño reformado hace 2 días','Sevilla','2021-02-25',20.5,2,2,1,20,5,'0.19894946305737748109723.jpg'),(10,'Habitaciones reformadas recientemente','Malaga','2020-02-15',20,2,2,1,4,5,'malaga.jpg'),(26,'Ubicado en el centro','Sevilla','2021-02-25',50,2,2,2,2,5,'0.792593271756422que-ver-en-sevilla.jpg'),(27,'Muy bien comunicado por transporte público','Sevilla','2020-02-15',60,3,3,1,1,5,'SE_Catedral_01.jpg'),(78,'Amueblado clásico','Lugo','2020-12-15',1,1,1,1,1,30,'lugo.jpg'),(81,'Recién reformado hace unos meses','Las Palmas','2020-02-19',20.5,2,1,1,1,20,'achotel.jpg'),(94,'Perfecto','Madrid','2021-02-23',20,2,2,2,2,5,'hotel-presidente-4s.jpg'),(116,'En el centro de Madrid bien comunicado','Madrid','2021-02-23',20,5,2,3,10,5,'madrid.jpg'),(119,'Recién amueblado y reformado, bien comunicado y cerca del Camp Nou','Barcelona','2021-02-24',20,2,1,1,2,5,'barcelona.jpg'),(122,'Cercano a un bar de mariscos','Vigo','2021-02-24',20.5,3,2,2,10,5,'0.9306398284997756barcelona.jpg');
/*!40000 ALTER TABLE `advert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `advert` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hr7d96y5pvm166aeds0e3e0q5` (`advert`),
  KEY `FK_p72ngnwwqk624c5df3ggi6r5p` (`user`),
  CONSTRAINT `FK_hr7d96y5pvm166aeds0e3e0q5` FOREIGN KEY (`advert`) REFERENCES `advert` (`id`),
  CONSTRAINT `FK_p72ngnwwqk624c5df3ggi6r5p` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'2021-02-28','2021-02-25',2,5),(2,'2021-03-14','2021-03-12',78,5),(3,'2021-03-14','2021-02-25',81,5),(4,'2021-03-12','2021-02-25',1,20),(5,'2021-03-01','2021-02-25',7,20),(6,'2021-03-06','2021-02-25',10,4),(7,'2021-03-05','2021-02-25',4,4),(8,'2021-03-04','2021-02-25',7,4);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `published` varchar(255) DEFAULT NULL,
  `stars` int(11) NOT NULL,
  `advert` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tk7ge62h0g39aqx4wb23pqnsj` (`advert`),
  KEY `FK_loa99tps4qrncfeo3gur8wdfx` (`user`),
  CONSTRAINT `FK_loa99tps4qrncfeo3gur8wdfx` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_tk7ge62h0g39aqx4wb23pqnsj` FOREIGN KEY (`advert`) REFERENCES `advert` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'Todo perfecto','2021-02-25',5,1,5),(2,'Mal comunicado','2021-02-25',2,2,5),(3,'Temperatura envidiable y muy bien comunicado, cercano a la playa','2021-02-25',5,81,5),(4,'Demasiado ruido por la noche','2021-02-25',2,1,20),(5,'Muy bien amueblado','2021-02-25',4,7,20),(6,'Muy buen ambiente nocturno en la zona','2021-02-25',5,10,4),(7,'Todo perfecto','2021-02-25',5,4,4);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` longtext DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `dni` varchar(10) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'aaron','gnzLDuqKcGxMNKFokfhOew==','Aaron','Medina','123455','616205285'),(5,'carlos','gnzLDuqKcGxMNKFokfhOew==','Carlos','Sanchez','8913123','649875465'),(20,'miguel','gnzLDuqKcGxMNKFokfhOew==','Miguel','Santana','12345','603022032'),(30,'tiburcio','gnzLDuqKcGxMNKFokfhOew==','Tiburcio','Cruz','134562','1234234'),(32,'pedro','gnzLDuqKcGxMNKFokfhOew==','Pedro','Medina','12345','12345'),(35,'etienne','gnzLDuqKcGxMNKFokfhOew==','Etienne','Hernandez','45781816V','615458595'),(38,'eliel','gnzLDuqKcGxMNKFokfhOew==','Eliel','Bruna','123456','124549'),(39,'borja','gnzLDuqKcGxMNKFokfhOew==','Borja','Quintana','45465464V','62030322');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-26 15:56:59
