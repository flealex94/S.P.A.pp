CREATE DATABASE  IF NOT EXISTS `SPA` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `SPA`;
-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: SPA
-- ------------------------------------------------------
-- Server version	5.6.30-0ubuntu0.15.10.1

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
-- Table structure for table `Client`
--

DROP TABLE IF EXISTS `Client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  `Prenume` varchar(45) NOT NULL,
  `Telefon` varchar(13) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Sex` varchar(1) NOT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `Telefon_UNIQUE` (`Telefon`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Client`
--

LOCK TABLES `Client` WRITE;
/*!40000 ALTER TABLE `Client` DISABLE KEYS */;
/*!40000 ALTER TABLE `Client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Facilitate`
--

DROP TABLE IF EXISTS `Facilitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Facilitate` (
  `idFacilitate` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  PRIMARY KEY (`idFacilitate`),
  UNIQUE KEY `Nume_UNIQUE` (`Nume`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Facilitate`
--

LOCK TABLES `Facilitate` WRITE;
/*!40000 ALTER TABLE `Facilitate` DISABLE KEYS */;
/*!40000 ALTER TABLE `Facilitate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Programare`
--

DROP TABLE IF EXISTS `Programare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Programare` (
  `idProgramare` int(11) NOT NULL AUTO_INCREMENT,
  `idSala` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `idTerapeut` int(11) NOT NULL,
  `idTerapie` int(11) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`idProgramare`),
  KEY `FK_SALA_idx` (`idSala`),
  KEY `Fk_Client_idx` (`idClient`),
  KEY `FK_Terapeut_idx` (`idTerapeut`),
  KEY `FK_Terapie_idx` (`idTerapie`),
  CONSTRAINT `FK_Client` FOREIGN KEY (`idClient`) REFERENCES `Client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SALA` FOREIGN KEY (`idSala`) REFERENCES `Sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Terapeut` FOREIGN KEY (`idTerapeut`) REFERENCES `Terapeut` (`idTerapeut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Terapie` FOREIGN KEY (`idTerapie`) REFERENCES `Terapie` (`idTerapie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Programare`
--

LOCK TABLES `Programare` WRITE;
/*!40000 ALTER TABLE `Programare` DISABLE KEYS */;
/*!40000 ALTER TABLE `Programare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sala`
--

DROP TABLE IF EXISTS `Sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(30) NOT NULL,
  PRIMARY KEY (`idSala`),
  UNIQUE KEY `nume_UNIQUE` (`Nume`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sala`
--

LOCK TABLES `Sala` WRITE;
/*!40000 ALTER TABLE `Sala` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sala_Facilitate`
--

DROP TABLE IF EXISTS `Sala_Facilitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sala_Facilitate` (
  `idSala` int(11) NOT NULL,
  `idFacilitate` int(11) NOT NULL,
  PRIMARY KEY (`idSala`,`idFacilitate`),
  KEY `FK_Facilitate_idx` (`idFacilitate`),
  KEY `fk_Sala_Facilitate_2_idx` (`idFacilitate`),
  CONSTRAINT `fk_Sala_Facilitate_1` FOREIGN KEY (`idSala`) REFERENCES `Sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sala_Facilitate_2` FOREIGN KEY (`idFacilitate`) REFERENCES `Facilitate` (`idFacilitate`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sala_Facilitate`
--

LOCK TABLES `Sala_Facilitate` WRITE;
/*!40000 ALTER TABLE `Sala_Facilitate` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sala_Facilitate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Terapeut`
--

DROP TABLE IF EXISTS `Terapeut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Terapeut` (
  `idTerapeut` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  `Sex` varchar(1) NOT NULL,
  PRIMARY KEY (`idTerapeut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Terapeut`
--

LOCK TABLES `Terapeut` WRITE;
/*!40000 ALTER TABLE `Terapeut` DISABLE KEYS */;
/*!40000 ALTER TABLE `Terapeut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Terapeut_Terapie`
--

DROP TABLE IF EXISTS `Terapeut_Terapie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Terapeut_Terapie` (
  `idTerapeut` int(11) NOT NULL,
  `idTerapie` int(11) NOT NULL,
  PRIMARY KEY (`idTerapeut`,`idTerapie`),
  KEY `fk_Terapeut_Terapie_2_idx` (`idTerapie`),
  CONSTRAINT `fk_Terapeut_Terapie_1` FOREIGN KEY (`idTerapeut`) REFERENCES `Terapeut` (`idTerapeut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Terapeut_Terapie_2` FOREIGN KEY (`idTerapie`) REFERENCES `Terapie` (`idTerapie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Terapeut_Terapie`
--

LOCK TABLES `Terapeut_Terapie` WRITE;
/*!40000 ALTER TABLE `Terapeut_Terapie` DISABLE KEYS */;
/*!40000 ALTER TABLE `Terapeut_Terapie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Terapie`
--

DROP TABLE IF EXISTS `Terapie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Terapie` (
  `idTerapie` int(11) NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) NOT NULL,
  `Prenume` varchar(45) NOT NULL,
  PRIMARY KEY (`idTerapie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Terapie`
--

LOCK TABLES `Terapie` WRITE;
/*!40000 ALTER TABLE `Terapie` DISABLE KEYS */;
/*!40000 ALTER TABLE `Terapie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Terapie_Facilitate`
--

DROP TABLE IF EXISTS `Terapie_Facilitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Terapie_Facilitate` (
  `idTerapie` int(11) NOT NULL,
  `idFacilitate` varchar(45) NOT NULL,
  PRIMARY KEY (`idTerapie`,`idFacilitate`),
  KEY `fk_Terapie_Facilitate_2_idx` (`idFacilitate`),
  CONSTRAINT `fk_Terapie_Facilitate_1` FOREIGN KEY (`idTerapie`) REFERENCES `Terapie` (`idTerapie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Terapie_Facilitate_2` FOREIGN KEY (`idFacilitate`) REFERENCES `Facilitate` (`Nume`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Terapie_Facilitate`
--

LOCK TABLES `Terapie_Facilitate` WRITE;
/*!40000 ALTER TABLE `Terapie_Facilitate` DISABLE KEYS */;
/*!40000 ALTER TABLE `Terapie_Facilitate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-02 14:57:04
