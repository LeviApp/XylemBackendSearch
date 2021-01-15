-- MySQL dump 10.13  Distrib 8.0.22, for osx10.15 (x86_64)
--
-- Host: localhost    Database: xylem
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','PlantTable','SQL','V1__PlantTable.sql',1886879556,'leviapp','2020-11-11 19:25:20',26,1),(2,'2','LikedPlantTable','SQL','V2__LikedPlantTable.sql',-1902717658,'leviapp','2020-11-13 06:42:23',26,1),(3,'3','RecommendedPlantTable','SQL','V3__RecommendedPlantTable.sql',-2049090094,'leviapp','2020-11-13 06:42:23',27,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LIKEDPLANT`
--

DROP TABLE IF EXISTS `LIKEDPLANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LIKEDPLANT` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `plant_id` int NOT NULL,
  `liked` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`plant_id`),
  KEY `plant_id` (`plant_id`),
  CONSTRAINT `likedplant_ibfk_1` FOREIGN KEY (`plant_id`) REFERENCES `PLANT` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LIKEDPLANT`
--

LOCK TABLES `LIKEDPLANT` WRITE;
/*!40000 ALTER TABLE `LIKEDPLANT` DISABLE KEYS */;
INSERT INTO `LIKEDPLANT` VALUES (1,'4444',3,1),(3,'1',3,1),(4,'22',3,0),(13,'10',3,1),(14,'11',3,1),(15,'88',3,1),(16,'99',3,1),(24,'1a2b',3,1),(25,'xyz',3,1);
/*!40000 ALTER TABLE `LIKEDPLANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLANT`
--

DROP TABLE IF EXISTS `PLANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PLANT` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `common_name` varchar(100) NOT NULL,
  `scientific_name` varchar(100) NOT NULL,
  `family_common_name` varchar(100) NOT NULL,
  `family` varchar(100) NOT NULL,
  `genus` varchar(100) NOT NULL,
  `year` int DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `scientific_name` (`scientific_name`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLANT`
--

LOCK TABLES `PLANT` WRITE;
/*!40000 ALTER TABLE `PLANT` DISABLE KEYS */;
INSERT INTO `PLANT` VALUES (3,'4444','Venus flytrap','Dionaea muscipula','Sundew','Droseraceae','Dionaea',1768,'https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Venus_Flytrap_showing_trigger_hairs.jpg/1200px-Venus_Flytrap_showing_trigger_hairs.jpg'),(20,'1','Eagle-claw cactus','Echinocactus horizonthalonius','Trefle family','Cactaceae','Echinocactus',1839,'https://bs.floristic.org/image/o/551aeb1acca56dd71d1af908c4c19d3b4d733753'),(21,'22','Redwood','Sequoia sempervirens','Cypress family','Cupressaceae','Sequoia',1847,'https://bs.floristic.org/image/o/d5087bd269369bae6e3d200bf82193a2100f1217'),(22,'333','Carnation','Dianthus caryophyllus','Pink family','Caryophyllaceae','Dianthus',1753,'https://bs.floristic.org/image/o/f1e67501aee18ff099d29e47ac3f2a99c3fb42cf'),(23,'333','Sacred bamboo','Nandina domestica','Barberry family','Berberidaceae','Nandina',1781,'https://bs.floristic.org/image/o/c9ee505a8e9c3ff960972c9753e6b2b10f10e0f3'),(24,'4444','Eastern poison ivy','Toxicodendron radicans','Sumac family','Anacardiaceae','Toxicodendron',1891,'https://bs.floristic.org/image/o/86f1f2d7a13e76747334feee28e94f35f594503d'),(25,'4444','Castorbean','Ricinus communis','Spurge family','Euphorbiaceae','Ricinus',1753,'https://bs.floristic.org/image/o/b975bbd67f037c4784c6b14f5e3ad86caebd6b1f'),(26,'4444','Shepherd\'s tree','Boscia albitrunca','Caper family','Capparaceae','Boscia',1915,'https://bs.floristic.org/image/o/1fff30ef36666132f6c11fc4f3e8959c83aa4a9c'),(27,'55555','Spanish moss','Tillandsia usneoides','Bromeliad family','Bromeliaceae','Tillandsia',1762,'https://bs.floristic.org/image/o/c246c87d10f8ab1dba5ee4efc29b578aedc84c59'),(28,'666666','Kidney bean','Phaseolus vulgaris','Pea family','Fabaceae','Phaseolus',1753,'https://bs.floristic.org/image/o/46b23b23e98319531962424fb9d88a4656610a0b');
/*!40000 ALTER TABLE `PLANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RECOMMENDEDPLANT`
--

DROP TABLE IF EXISTS `RECOMMENDEDPLANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RECOMMENDEDPLANT` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recommended_by` varchar(100) NOT NULL,
  `recommended_to` varchar(100) NOT NULL,
  `plant_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `recommended_by` (`recommended_by`,`recommended_to`,`plant_id`),
  KEY `plant_id` (`plant_id`),
  CONSTRAINT `recommendedplant_ibfk_1` FOREIGN KEY (`plant_id`) REFERENCES `PLANT` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RECOMMENDEDPLANT`
--

LOCK TABLES `RECOMMENDEDPLANT` WRITE;
/*!40000 ALTER TABLE `RECOMMENDEDPLANT` DISABLE KEYS */;
INSERT INTO `RECOMMENDEDPLANT` VALUES (26,'007','1',21),(8,'1','999999999',20),(10,'123','1',25),(17,'22','1',24),(6,'22','333',3),(4,'22','333',26),(18,'333','1',24),(25,'4444','1',3),(19,'4444','1',24),(12,'4444','1',25),(16,'4444','243',28),(3,'4444','333',26),(24,'4444','88888888',20),(23,'4444','88888888',24),(20,'55555','1',24),(11,'666','1',25),(7,'7777777','55555',23),(21,'88888888','1',24),(22,'88888888','4444',24),(14,'987','243',28),(13,'987','4444',28),(9,'999999999','1',25);
/*!40000 ALTER TABLE `RECOMMENDEDPLANT` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05 16:06:47