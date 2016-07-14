CREATE DATABASE  IF NOT EXISTS `spa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spa`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: spa
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  `Prenume` varchar(45) NOT NULL,
  `Telefon` varchar(13) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Sex` varchar(1) NOT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `Telefon_UNIQUE` (`Telefon`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Nelson','Frank','955323768-1','fnelson0@google.com.br','F'),(2,'Howell','Adam','511422710-6','ahowell1@dedecms.com','F'),(3,'Perry','Kimberly','115243065-3','kperry2@hud.gov','M'),(4,'Grant','Joe','274391597-8','jgrant3@accuweather.com','M'),(5,'Gray','Shirley','257453845-5','sgray4@engadget.com','F'),(6,'Griffin','Catherine','363685388-0','cgriffin5@1688.com','M'),(7,'Wells','Jerry','060589852-9','jwells6@goodreads.com','M'),(8,'Johnson','Daniel','460505759-5','djohnson7@weibo.com','M'),(9,'Smith','Ryan','244358217-5','rsmith8@creativecommons.org','F'),(10,'Hunt','Nancy','820417037-8','nhunt9@mail.ru','M'),(11,'Hughes','Norma','919161625-5','nhughesa@example.com','M'),(12,'Wagner','Dennis','459888780-X','dwagnerb@reddit.com','F'),(13,'Green','Barbara','531689132-5','bgreenc@businessweek.com','M'),(14,'Morrison','Gloria','761995477-5','gmorrisond@netscape.com','M'),(15,'Harris','Bruce','228647683-7','bharrise@oakley.com','F'),(16,'Sanchez','Timothy','529665826-4','tsanchezf@nhs.uk','F'),(17,'Welch','Thomas','666910468-5','twelchg@pbs.org','M'),(18,'Cooper','Andrea','961217147-5','acooperh@imageshack.us','F'),(19,'Howard','Mary','868355358-2','mhowardi@cbsnews.com','F'),(20,'Ramirez','Bobby','562669754-3','bramirezj@spiegel.de','M'),(21,'Stevens','Bobby','032870271-4','bstevensk@addtoany.com','M'),(22,'Miller','Ryan','608877569-6','rmillerl@amazon.co.jp','F'),(23,'Riley','Kathryn','146082330-3','krileym@indiegogo.com','M'),(24,'Murphy','Benjamin','843498139-4','bmurphyn@cmu.edu','M'),(25,'Peterson','Paula','994691935-4','ppetersono@dmoz.org','F'),(26,'Andrews','Harry','405656052-8','handrewsp@aol.com','F'),(27,'Austin','Susan','848551141-7','saustinq@time.com','F'),(28,'Wheeler','Peter','283761604-4','pwheelerr@github.com','M'),(29,'Davis','Karen','202000155-1','kdaviss@ucoz.ru','M'),(30,'Adams','Fred','414863356-4','fadamst@wp.com','F'),(31,'Frazier','Amy','784831661-0','afrazieru@nhs.uk','M'),(32,'Fields','Diana','662256148-6','dfieldsv@ihg.com','M'),(33,'Reyes','Beverly','676975702-8','breyesw@wiley.com','F'),(34,'Carter','Bonnie','990083766-5','bcarterx@harvard.edu','F'),(35,'Hawkins','Paul','914341036-7','phawkinsy@jiathis.com','F'),(36,'Morrison','Tina','453856410-9','tmorrisonz@hugedomains.com','F'),(37,'Watkins','Matthew','121700277-4','mwatkins10@wunderground.com','M'),(38,'Harper','Sharon','993408898-3','sharper11@google.de','M'),(39,'Morales','Kathryn','210803213-4','kmorales12@sitemeter.com','M'),(40,'Black','Steven','163927861-3','sblack13@istockphoto.com','M'),(41,'Parker','Gerald','536205887-8','gparker14@bbb.org','F'),(42,'Medina','Ann','990025985-8','amedina15@bloglovin.com','F'),(43,'Frazier','Brenda','225604001-1','bfrazier16@examiner.com','F'),(44,'Lawson','Carol','853968859-X','clawson17@skype.com','M'),(45,'Hart','Tammy','040235185-1','thart18@paypal.com','M'),(46,'Clark','Jeremy','359443319-6','jclark19@businesswire.com','M'),(47,'Jacobs','Craig','167593405-3','cjacobs1a@indiatimes.com','F'),(48,'Brooks','Robin','618901664-2','rbrooks1b@washingtonpost.com','M'),(49,'Gutierrez','Jeffrey','392365159-7','jgutierrez1c@foxnews.com','M'),(50,'Torres','Louise','730227156-9','ltorres1d@live.com','F');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilitate`
--

DROP TABLE IF EXISTS `facilitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facilitate` (
  `idFacilitate` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  PRIMARY KEY (`idFacilitate`),
  UNIQUE KEY `Nume_UNIQUE` (`Nume`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilitate`
--

LOCK TABLES `facilitate` WRITE;
/*!40000 ALTER TABLE `facilitate` DISABLE KEYS */;
INSERT INTO `facilitate` VALUES (1,'Masa masaj'),(6,'Paravan intimitate'),(4,'Pilates reformer'),(2,'Spalier'),(5,'TRX'),(3,'Yoga mat');
/*!40000 ALTER TABLE `facilitate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programare`
--

DROP TABLE IF EXISTS `programare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programare` (
  `idProgramare` int(11) NOT NULL AUTO_INCREMENT,
  `idSala` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `idTerapeut` int(11) NOT NULL,
  `idTerapie` int(11) NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`idProgramare`),
  KEY `FK_SALA_idx` (`idSala`),
  KEY `Fk_Client_idx` (`idClient`),
  KEY `FK_Terapeut_idx` (`idTerapeut`),
  KEY `FK_Terapie_idx` (`idTerapie`),
  CONSTRAINT `FK_Client` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SALA` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Terapeut` FOREIGN KEY (`idTerapeut`) REFERENCES `terapeut` (`idTerapeut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Terapie` FOREIGN KEY (`idTerapie`) REFERENCES `terapie` (`idTerapie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programare`
--

LOCK TABLES `programare` WRITE;
/*!40000 ALTER TABLE `programare` DISABLE KEYS */;
INSERT INTO `programare` VALUES (1,1,17,6,6,'2016-07-12'),(2,1,43,8,1,'2016-06-28'),(3,2,20,1,6,'2016-07-25'),(4,4,3,4,6,'2016-07-04'),(5,4,39,10,2,'2016-07-11'),(6,3,37,4,5,'2016-07-03'),(7,4,25,10,1,'2016-06-06'),(8,1,6,6,4,'2016-06-07'),(9,1,5,6,6,'2016-07-13'),(10,1,29,4,3,'2016-07-01'),(11,1,3,9,2,'2016-07-12'),(12,5,50,12,1,'2016-07-10'),(13,3,35,10,3,'2016-06-14'),(14,2,2,8,6,'2016-06-27'),(15,1,20,3,5,'2016-06-12'),(16,6,4,12,6,'2016-07-24'),(17,1,1,11,1,'2016-06-17'),(18,4,18,13,1,'2016-06-19'),(19,1,16,4,2,'2016-07-22'),(20,1,17,6,7,'2016-07-26'),(21,4,45,1,6,'2016-06-10'),(22,4,19,2,4,'2016-07-26'),(23,1,32,5,2,'2016-07-16'),(24,2,29,1,3,'2016-07-16'),(25,1,15,3,5,'2016-06-13'),(26,2,23,6,6,'2016-06-16'),(27,1,48,9,3,'2016-07-03'),(28,6,9,1,3,'2016-07-19'),(29,5,15,7,1,'2016-06-28'),(30,1,2,7,3,'2016-07-05'),(31,6,45,13,2,'2016-06-19'),(32,4,49,8,6,'2016-06-08'),(33,3,1,5,1,'2016-06-29'),(34,1,3,11,3,'2016-07-21'),(35,2,12,6,3,'2016-07-14'),(36,6,30,3,3,'2016-06-10'),(37,4,40,7,4,'2016-06-22'),(38,5,45,6,2,'2016-06-02'),(39,1,48,5,2,'2016-06-03'),(40,4,49,1,2,'2016-06-01'),(41,3,14,7,1,'2016-07-25'),(42,2,3,13,6,'2016-07-18'),(43,6,28,6,1,'2016-06-18'),(44,6,19,11,2,'2016-07-10'),(45,1,18,1,5,'2016-06-01'),(46,2,29,12,4,'2016-07-15'),(47,1,24,5,3,'2016-06-24'),(48,6,46,12,3,'2016-06-05'),(49,1,8,12,4,'2016-07-08'),(50,6,23,8,3,'2016-06-17'),(51,2,48,13,2,'2016-06-23'),(52,6,29,10,4,'2016-07-24'),(53,6,13,5,5,'2016-06-23'),(54,4,33,4,1,'2016-07-07'),(55,4,8,4,5,'2016-07-23'),(56,1,20,4,4,'2016-07-22'),(57,3,34,11,3,'2016-07-15'),(58,6,36,11,7,'2016-06-26'),(59,5,36,10,1,'2016-06-18'),(60,3,35,5,6,'2016-06-29'),(61,6,25,12,6,'2016-07-21'),(62,6,44,9,7,'2016-07-17'),(63,3,29,4,3,'2016-07-11'),(64,4,26,6,1,'2016-07-12'),(65,5,37,1,6,'2016-06-04'),(66,4,44,9,3,'2016-07-22'),(67,5,25,4,2,'2016-07-18'),(68,5,9,10,5,'2016-06-11'),(69,1,10,1,3,'2016-07-11'),(70,2,1,10,7,'2016-07-12'),(71,2,15,6,5,'2016-06-14'),(72,6,38,4,1,'2016-06-20'),(73,5,49,7,3,'2016-06-27'),(74,1,11,12,5,'2016-07-13'),(75,5,22,2,1,'2016-07-11'),(76,2,44,4,2,'2016-06-06');
/*!40000 ALTER TABLE `programare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(30) NOT NULL,
  PRIMARY KEY (`idSala`),
  UNIQUE KEY `nume_UNIQUE` (`Nume`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (4,'Apa'),(3,'Foc'),(5,'Vant'),(6,'Yang'),(1,'Yin'),(2,'Zen');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala_facilitate`
--

DROP TABLE IF EXISTS `sala_facilitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala_facilitate` (
  `idSala` int(11) NOT NULL,
  `idFacilitate` int(11) NOT NULL,
  PRIMARY KEY (`idSala`,`idFacilitate`),
  KEY `FK_Facilitate_idx` (`idFacilitate`),
  KEY `fk_Sala_Facilitate_2_idx` (`idFacilitate`),
  CONSTRAINT `fk_Sala_Facilitate_1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sala_Facilitate_2` FOREIGN KEY (`idFacilitate`) REFERENCES `facilitate` (`idFacilitate`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala_facilitate`
--

LOCK TABLES `sala_facilitate` WRITE;
/*!40000 ALTER TABLE `sala_facilitate` DISABLE KEYS */;
INSERT INTO `sala_facilitate` VALUES (2,1),(3,2),(4,2),(5,3),(3,4),(4,4),(6,4),(1,5),(4,5),(5,5),(6,5),(1,6),(5,6),(6,6);
/*!40000 ALTER TABLE `sala_facilitate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terapeut`
--

DROP TABLE IF EXISTS `terapeut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terapeut` (
  `idTerapeut` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  `Prenume` varchar(45) NOT NULL,
  `Sex` varchar(1) NOT NULL,
  PRIMARY KEY (`idTerapeut`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terapeut`
--

LOCK TABLES `terapeut` WRITE;
/*!40000 ALTER TABLE `terapeut` DISABLE KEYS */;
INSERT INTO `terapeut` VALUES (1,'Payne','Anne','F'),(2,'Carpenter','Harold','M'),(3,'Long','Richard','M'),(4,'Torres','Richard','M'),(5,'Cook','Jonathan','F'),(6,'Torres','Robin','F'),(7,'Gonzales','Louise','M'),(8,'Moore','Heather','M'),(9,'Perry','Eric','F'),(10,'Castillo','Angela','F'),(11,'Kelly','Kathryn','F'),(12,'Pierce','Christina','F'),(13,'Henry','Paul','M');
/*!40000 ALTER TABLE `terapeut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terapeut_terapie`
--

DROP TABLE IF EXISTS `terapeut_terapie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terapeut_terapie` (
  `idTerapeut` int(11) NOT NULL,
  `idTerapie` int(11) NOT NULL,
  PRIMARY KEY (`idTerapeut`,`idTerapie`),
  KEY `fk_Terapeut_Terapie_2_idx` (`idTerapie`),
  CONSTRAINT `fk_Terapeut_Terapie_1` FOREIGN KEY (`idTerapeut`) REFERENCES `terapeut` (`idTerapeut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Terapeut_Terapie_2` FOREIGN KEY (`idTerapie`) REFERENCES `terapie` (`idTerapie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terapeut_terapie`
--

LOCK TABLES `terapeut_terapie` WRITE;
/*!40000 ALTER TABLE `terapeut_terapie` DISABLE KEYS */;
INSERT INTO `terapeut_terapie` VALUES (6,1),(7,1),(8,1),(9,1),(10,1),(7,2),(1,3),(7,3),(1,4),(3,4),(11,4),(8,5),(11,5),(2,6),(6,6),(7,7),(12,7);
/*!40000 ALTER TABLE `terapeut_terapie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terapie`
--

DROP TABLE IF EXISTS `terapie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terapie` (
  `idTerapie` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  PRIMARY KEY (`idTerapie`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terapie`
--

LOCK TABLES `terapie` WRITE;
/*!40000 ALTER TABLE `terapie` DISABLE KEYS */;
INSERT INTO `terapie` VALUES (1,'Masaj de relaxare'),(2,'Masaj reflexogen'),(3,'Drenaj limfatic'),(4,'Masaj anticelulitic'),(5,'Gimnastica medicala'),(6,'Kinetoterapie'),(7,'Masaj shiatsu');
/*!40000 ALTER TABLE `terapie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terapie_facilitate`
--

DROP TABLE IF EXISTS `terapie_facilitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terapie_facilitate` (
  `idTerapie` int(11) NOT NULL,
  `idFacilitate` varchar(45) NOT NULL,
  PRIMARY KEY (`idTerapie`,`idFacilitate`),
  KEY `fk_Terapie_Facilitate_2_idx` (`idFacilitate`),
  CONSTRAINT `fk_Terapie_Facilitate_1` FOREIGN KEY (`idTerapie`) REFERENCES `terapie` (`idTerapie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Terapie_Facilitate_2` FOREIGN KEY (`idFacilitate`) REFERENCES `facilitate` (`Nume`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terapie_facilitate`
--

LOCK TABLES `terapie_facilitate` WRITE;
/*!40000 ALTER TABLE `terapie_facilitate` DISABLE KEYS */;
/*!40000 ALTER TABLE `terapie_facilitate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-03  4:00:29
