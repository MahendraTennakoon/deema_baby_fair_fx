-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: deema_baby_fair
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `agreement`
--

DROP TABLE IF EXISTS `agreement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agreement` (
  `agreeId` int(11) NOT NULL AUTO_INCREMENT,
  `propId` int(11) NOT NULL,
  `startDate` varchar(10) NOT NULL,
  `endDate` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nature` varchar(10) NOT NULL,
  PRIMARY KEY (`agreeId`),
  UNIQUE KEY `propId_UNIQUE` (`propId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agreement`
--

LOCK TABLES `agreement` WRITE;
/*!40000 ALTER TABLE `agreement` DISABLE KEYS */;
/*!40000 ALTER TABLE `agreement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_payments`
--

DROP TABLE IF EXISTS `cash_payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cash_payments` (
  `cash_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `payee` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cash_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_payments`
--

LOCK TABLES `cash_payments` WRITE;
/*!40000 ALTER TABLE `cash_payments` DISABLE KEYS */;
INSERT INTO `cash_payments` VALUES (1,5000,'2016-08-03','Sun Lanka'),(3,40000,'2016-08-03','CNC'),(4,15000,'2016-08-17','CNC'),(5,33000,'2016-07-05','Gayan Gifts'),(7,13034,'2016-06-16','CNC'),(9,25000,'2016-06-07','Mahendra Center'),(10,14590,'2016-06-11','Shshi Tex'),(11,50000,'2016-08-03','CNC'),(14,1500,'2016-08-07','deema'),(15,3670,'2016-09-01','go carts'),(16,45000,'2016-09-14','Dinux'),(17,7890,'2016-05-31','CNC'),(18,2345,'2016-07-05','SNC');
/*!40000 ALTER TABLE `cash_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheque_payments`
--

DROP TABLE IF EXISTS `cheque_payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheque_payments` (
  `cheque_no` varchar(25) NOT NULL,
  `amount` double DEFAULT NULL,
  `payee` varchar(45) DEFAULT NULL,
  `issue_date` varchar(45) DEFAULT NULL,
  `valid_after` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cheque_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque_payments`
--

LOCK TABLES `cheque_payments` WRITE;
/*!40000 ALTER TABLE `cheque_payments` DISABLE KEYS */;
INSERT INTO `cheque_payments` VALUES ('cmb100',20000,'CNC','2016-08-02','2016-08-23'),('cmb102',78289,'New Gift','2016-08-30','2016-09-13'),('cmb105',15000,'CNS','2016-07-11','2016-07-25'),('cmb108',45000,'GiftCenter','2016-06-08','2016-07-19'),('cmb114',22500,'New Gift','2016-07-07','2016-07-20'),('cmb116',28000,'SNS','2016-07-05','2016-07-20'),('cmb117',13000,'CNC','2016-09-07','2016-09-21'),('cmb222',6700,'SNS','2016-09-01','2016-09-08');
/*!40000 ALTER TABLE `cheque_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` varchar(10) NOT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `contact_no` varchar(15) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('16111','','2016-09-17','','','',''),('16113','','2016-09-17','','','jnjn',''),('16114','','2016-09-17','','','jsnvjv',''),('16115','','2016-09-17','','','121212',''),('16116','','2016-09-17','','','jsvnjvwjgv',''),('16117','','2016-09-17','','','','sgsf'),('16118','yvuyv','2016-09-17','0987656789','ctucujty56789','vyuviyt','yvuyvyt');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily_expenses`
--

DROP TABLE IF EXISTS `daily_expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_expenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_expenses`
--

LOCK TABLES `daily_expenses` WRITE;
/*!40000 ALTER TABLE `daily_expenses` DISABLE KEYS */;
INSERT INTO `daily_expenses` VALUES (1,'2016-08-17',500,'Ice cream'),(3,'2016-08-05',300,'books'),(4,'2016-06-07',200,'pens'),(5,'2016-06-21',500,'lunch'),(7,'2016-07-05',450,'tea'),(8,'2016-08-05',250,'fruits'),(9,'2016-08-02',500,'donations'),(10,'2016-09-01',245,'pens'),(12,'2016-08-17',245,'books'),(13,'2016-09-01',4500,'goods'),(14,'2016-09-02',5000,'good'),(15,'2016-09-03',4590,'dent'),(16,'2016-09-04',3000,'dent'),(17,'2016-09-05',3600,'dent'),(18,'2016-09-01',146,'water bottle'),(19,'2016-09-14',234,'cool drinks');
/*!40000 ALTER TABLE `daily_expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery` (
  `delivery_id` varchar(10) NOT NULL,
  `oder_date` varchar(12) DEFAULT NULL,
  `delivery_cost` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES ('001','2016-08-27',1000,10),('002','2016-08-27',2000,20),('003','2016-08-27',3000,30),('004','2016-08-28',4000,40),('005','2016-08-29',5000,50),('006','2016-08-30',6000,60),('007','2016-09-9',7000,70),('008','2016-10-16',8000,80),('009','2016-10-20',9000,90),('010','2016-10-22',10000,10),('456','2016-09-17',3456,4);
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electricity_bill`
--

DROP TABLE IF EXISTS `electricity_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `electricity_bill` (
  `bill_no` varchar(10) NOT NULL,
  `Amount` double DEFAULT NULL,
  `units` int(3) DEFAULT NULL,
  `payment_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bill_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electricity_bill`
--

LOCK TABLES `electricity_bill` WRITE;
/*!40000 ALTER TABLE `electricity_bill` DISABLE KEYS */;
INSERT INTO `electricity_bill` VALUES ('e231',3456.89,33,'2016-08-05'),('e233',2450,35,'2016-09-16'),('e235',2450,34,'2016-09-16'),('e2500',12000,12,'2016-08-10'),('e278',2456,35,'2016-09-07'),('e302',63822,72,'2016-09-01'),('e330',1500,23,'2016-09-01'),('e333',3333.33,35,'2016-08-03'),('e334',1789,17,'2016-08-04'),('e389',2345,24,'2016-09-16'),('e456',6700,46,'2016-09-02'),('e467',2346,41,'2016-09-16'),('e500',5000,50,'2016-08-06'),('e678',1234,20,'2016-09-08');
/*!40000 ALTER TABLE `electricity_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` varchar(10) NOT NULL,
  `NIC` varchar(10) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `phone1` varchar(15) DEFAULT NULL,
  `phone2` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `effective_date_from` varchar(10) DEFAULT NULL,
  `effective_date_to` varchar(10) DEFAULT NULL,
  `employeecol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('1600000000','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-27','2019-04-17',NULL),('1600000001','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-27','2019-04-17',NULL),('1600000002','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-27','2019-04-17',NULL),('1600000003','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-27','2019-04-17',NULL),('1600000004','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-27','2019-04-17',NULL),('1600000005','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-27','2019-04-17',NULL),('1600000006','787878789V','Cashier',45000,'Nimal','Perera','Nimal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-28','2019-04-17',NULL),('1600000007','978778765v','Administrator',20000,'Saman','Silva','Saman sunil Perera','2016-08-17','Male',29,'Tamil','0987898765','0978767656','78,\nKaduwela','sunilperera@gmail.com','2016-08-17','2016-08-18',NULL),('1600000008','787878789V','Cashier',45000,'Sarath','Silva','Sarath aponso silva','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-28','2019-04-17',NULL),('1600000009','957878789V','Administrator',45000,'Waruna','Wijesundara','Waruna gayashan wijesundara','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','waruna@gmail.com','2016-08-10','2019-04-17',NULL),('1600000010','947878789V','Cashier',45000,'Akalanka','Kudagama','Dunika Akalanka Kudagama','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-28','2019-04-17',NULL),('1600000011','967878789V','Cashier',45000,'Kalana','Geethanjana','Kalana geethanjana kumarawadu','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-28','2019-04-17',NULL),('1600000012','787878789V','Cashier',45000,'Isuru','Avishka','Isuru Avishka Deshan','1989-04-17','Male',23,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-08-28','2019-04-17',NULL),('1600000013','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-09-14','2019-04-17',NULL),('1600000014','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-09-14','2019-04-17',NULL),('1600000015','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-09-14','2019-04-17',NULL),('1600000016','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-09-14','2019-04-17',NULL),('1600000017','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-09-15','2019-04-17',NULL),('1600000018','787878789V','Cashier',45000,'Kamal','Perera','Kamal aponso perera','1989-04-17','Male',45,'Sinhalese','0712323234','0722345641','no78, \n kandy, \n sri lanka','Kamal@gmail.com','2016-09-17','2019-04-17',NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exchange`
--

DROP TABLE IF EXISTS `exchange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exchange` (
  `exchange_id` varchar(10) NOT NULL,
  `date` varchar(20) DEFAULT NULL,
  `invoice_no` varchar(100) DEFAULT NULL,
  `item_no` varchar(1000) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `ret_qty` int(11) DEFAULT NULL,
  `comment` varchar(300) DEFAULT NULL,
  `ret_cost` double DEFAULT NULL,
  `emp_id` varchar(10) DEFAULT NULL,
  `cust_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`exchange_id`,`item_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exchange`
--

LOCK TABLES `exchange` WRITE;
/*!40000 ALTER TABLE `exchange` DISABLE KEYS */;
INSERT INTO `exchange` VALUES ('2','2016-09-12','8','543323','napkins pac',5,'',450,' ',' '),('3','2016-09-12','8','543323','napkins pac',3,'',270,' ',' '),('3','2016-09-12','8','598782','car',2,'',180,' ',' '),('5','2016-09-12','8','543323','napkins pac',2,'',180,' ',' '),('6','2016-09-12','8','543323','napkins pac',1,'break',90,' ',' '),('7','2016-09-12','8','546732','milk bottal',2,'break',180,' ',' ');
/*!40000 ALTER TABLE `exchange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `Item_code` varchar(20) NOT NULL,
  `Item_name` varchar(50) DEFAULT NULL,
  `Description` varchar(60) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Receive_from` varchar(30) DEFAULT NULL,
  `Receive_date` varchar(15) DEFAULT NULL,
  `Expire_date` varchar(15) DEFAULT NULL,
  `Unit_price` double DEFAULT NULL,
  `Minqty_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`Item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('ITM0003','Tricycle','',34,'Dinux pvt Ltd','2016-08-29','2016-08-30',2500,5),('ITM0010','Napkins','',5,'P&M Group','2016-09-26','2016-10-01',2000,10),('ITM0011','Carpets','',21,'CNC Company','2016-09-14','2016-09-22',524,5),('ITM0013','Pooh bears','',22,'Link Toys','2016-09-05','2016-10-01',250,5),('ITM0015','Babyloon Ball','',15,'Ariyarathna Sons','2016-09-13','2017-09-15',100,5),('ITM0020','Badminton Racket','low in price',20,'Namalaka','2015-02-09','2015-07-20',2500,5),('ITM0025','Baby powder','',5,'Unilieavers','2016-09-04','2016-09-16',900,10),('ITM0026','Dolly doll','',10,'Nirmal','2016-08-29','2016-09-30',250,5),('ITM0027','Baby oil','',5,'Unilieavers Group','2016-08-31','2016-09-30',200,10),('ITM0028','Baby Soap','',40,'Leema Toys','2016-08-28','2016-09-29',50,10),('ITM0029','Buildingblocks','Middle ages',30,'Nayana','2016-08-28','2016-09-30',750,10),('ITM0030','PlayGround Toy','',5,'Mahen Company','2016-08-28','2017-09-15',25000,2),('ITM0031','Electric car','above 13 ',4,'Gayan','2016-09-18','2017-09-22',750,2),('ITM0032','goCarts ','below 10',5,'kalpan company','2016-09-05','2020-09-04',15000,2);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `inv_no` varchar(6) NOT NULL,
  `date` date DEFAULT NULL,
  `gross_tot` double DEFAULT NULL,
  `sub_disc` double DEFAULT NULL,
  `net_tot` double DEFAULT NULL,
  `cash` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`inv_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES ('10','2016-09-16',1000,200,800,1000,200),('11','2016-09-17',1150,230,920,1000,80),('12','2016-09-17',1330,230,1100,2000,900),('13','2016-09-17',3750,1250,2500,3000,500),('14','2016-09-17',17250,2300,14950,15000,50),('15','2016-09-17',20350,1550,18800,20000,1200),('16','2016-09-18',1180,100,1080,1200,120),('17','2016-09-18',1740,340,1400,1500,100),('2','2016-09-11',7500,500,7000,10000,3000),('3','2016-09-11',7500,500,7000,10000,3000),('4','2016-09-11',7500,0,7500,10000,2500),('5','2016-09-11',1100,0,1100,2000,900),('6','2016-09-11',3500,500,3000,5000,2000),('7','2016-09-11',5500,500,5000,6000,1000),('8','2016-09-12',2900,410,2490,3000,510),('9','2016-09-15',5250,1750,3500,5000,1500);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offers` (
  `offer_id` varchar(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `effectivefrom` varchar(50) DEFAULT NULL,
  `effectiveto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`offer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
INSERT INTO `offers` VALUES ('','ss',12,'sss','2016-09-08','2016-09-23'),('001','Tharushi',20,'fgh','2016-09-16','2016-10-07'),('002','dfghjk',10,'dfghjkl','2016-09-02','2016-10-07'),('003','Anuradha Jayasinghe',15,'sdfghjk','2016-09-09','2016-10-08'),('004','Samadhi ',20,'fgh','2016-09-16','2016-10-07'),('006','rtyjk',57,'sdfghjk','2016-09-02','2016-10-07'),('007','Amila perera',25,'fghj','2016-09-16','2016-10-07'),('008','Rajitha',5,'fghnjm','2016-09-02','2016-09-30'),('009','mhjhfj',8,'bjhbh','2016-09-01','2016-10-07'),('011','fgh',41,'fgvbnm','2016-09-09','2016-10-08');
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `eBillId` int(11) NOT NULL,
  `wBillId` int(11) NOT NULL,
  `rental` float NOT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `eBillId_UNIQUE` (`eBillId`),
  UNIQUE KEY `pid_UNIQUE` (`pid`),
  UNIQUE KEY `wBillId_UNIQUE` (`wBillId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,54698,25635,19000),(8,54266,45862,20000),(10,8538,8359,2000);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentals`
--

DROP TABLE IF EXISTS `rentals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rentals` (
  `rental_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `payment_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rental_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentals`
--

LOCK TABLES `rentals` WRITE;
/*!40000 ALTER TABLE `rentals` DISABLE KEYS */;
INSERT INTO `rentals` VALUES (2,5000,'2016-08-02'),(3,8000,'2016-09-28'),(4,4000,'2016-05-18'),(6,5600,'2016-05-19'),(7,6500,'2016-07-12'),(8,6500,'2016-07-21'),(9,6800,'2016-09-07'),(10,9000,'2016-07-04'),(11,4500,'2016-06-27'),(13,4500,'2016-09-03'),(14,4500,'2016-09-05'),(15,2500,'2016-09-01'),(16,5000,'2016-09-16');
/*!40000 ALTER TABLE `rentals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reorder`
--

DROP TABLE IF EXISTS `reorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reorder` (
  `Item_code` varchar(20) NOT NULL,
  `Item_name` varchar(50) DEFAULT NULL,
  `Description` varchar(60) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Receive_from` varchar(30) DEFAULT NULL,
  `Receive_date` varchar(15) DEFAULT NULL,
  `Expire_date` varchar(15) DEFAULT NULL,
  `Unit_price` double DEFAULT NULL,
  `Minqty_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`Item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reorder`
--

LOCK TABLES `reorder` WRITE;
/*!40000 ALTER TABLE `reorder` DISABLE KEYS */;
INSERT INTO `reorder` VALUES ('ITM0011','carpets','',21,'kamal','2016-09-14','2016-09-22',524,324);
/*!40000 ALTER TABLE `reorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_details`
--

DROP TABLE IF EXISTS `salary_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary_details` (
  `employee_id` varchar(20) NOT NULL,
  `month` varchar(45) NOT NULL,
  `amount` float DEFAULT '0',
  `paid_date` date NOT NULL,
  PRIMARY KEY (`employee_id`,`month`,`paid_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_details`
--

LOCK TABLES `salary_details` WRITE;
/*!40000 ALTER TABLE `salary_details` DISABLE KEYS */;
INSERT INTO `salary_details` VALUES ('1600000000','APRIL',25000,'2014-05-18'),('1600000000','AUGUST',25000,'2014-01-18'),('1600000000','FEBRUARY',25000,'2015-02-18'),('1600000000','JANUARY',25000,'2015-05-18'),('1600000000','JULY',25000,'2015-04-18'),('1600000000','JUNE',25000,'2015-03-18'),('1600000000','MARCH',25000,'2015-01-18'),('1600000000','MAY',25000,'2016-01-18'),('1600000000','SEPTEMBER',25000,'2016-02-18'),('1600000000','SEPTEMBER',45000,'2016-03-18'),('1600000018','SEPTEMBER',45000,'2016-04-18');
/*!40000 ALTER TABLE `salary_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `date` date DEFAULT NULL,
  `inv_no` varchar(6) NOT NULL,
  `employee_id` varchar(10) DEFAULT NULL,
  `customerId` varchar(6) DEFAULT NULL,
  `item_no` varchar(1000) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `qty` int(10) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `tot_discount` double DEFAULT NULL,
  `net_amt` double DEFAULT NULL,
  PRIMARY KEY (`inv_no`,`item_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES ('2016-09-16','10',' ',' ','543323','napkins pac',5,110,550,50,500),('2016-09-15','10',' ',' ','546732','milk bottal',3,150,450,150,300),('2016-09-17','11',' ',' ','543323','napkins pac',5,110,550,150,400),('2016-09-17','11',' ',' ','546732','milk bottal',4,150,600,80,520),('2016-09-17','12',' ',' ','532276','baby frock',3,1500,4500,1500,3000),('2016-09-17','12',' ',' ','543323','napkins pac',5,110,550,50,500),('2016-09-17','12',' ',' ','546732','milk bottal',3,150,450,150,300),('2016-09-17','12',' ',' ','598782','car',5,350,1750,150,1600),('2016-09-17','13',' ',' ','532276','baby frock',2,1500,3000,1000,2000),('2016-09-17','13',' ',' ','546732','milk bottal',5,150,750,250,500),('2016-09-17','14',' ',' ','532276','baby frock',10,1500,15000,2000,13000),('2016-09-17','14',' ',' ','546732','milk bottal',10,150,1500,200,1300),('2016-09-17','15',' ',' ','598782','car',5,350,1750,150,1600),('2016-09-17','15',' ',' ','598783','baby set',5,700,3500,500,3000),('2016-09-17','15',' ',' ','598785','Baby towel',4,550,2200,200,2000),('2016-09-17','15',' ',' ','598787','Baby powder',10,150,1500,100,1400),('2016-09-17','15',' ',' ','598789','nappy pac',6,1350,8100,300,7800),('2016-09-18','16',' ',' ','543323','napkins pac',8,110,880,0,880),('2016-09-18','16',' ',' ','546732','milk bottal',2,150,300,100,200),('2016-09-18','17',' ',' ','543323','napkins pac',9,110,990,90,900),('2016-09-18','17',' ',' ','546732','milk bottal',5,150,750,250,500),('2016-09-11','7',' ',' ','543323','napkins pac',50,110,5500,500,5000),('2016-09-12','8',' ',' ','543323','napkins pac',10,110,1100,200,900),('2016-09-12','8',' ',' ','546732','milk bottal',5,150,750,150,600),('2016-09-12','8',' ',' ','598782','car',3,350,1050,60,990),('2016-09-15','9',' ',' ','532276','baby frock',3,1500,4500,1500,3000),('2016-09-15','9',' ',' ','598787','Baby powder',5,150,750,250,500);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `service_id` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `contact_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES ('12s','sdf','fg','34'),('4534y','ergth','3546h','4trh'),('6382','gdki','hedd','0978563578'),('bhbg','ses','ubh','ftftf');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `service_id` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `contact_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES ('100','','','');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `pr_code` varchar(1000) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `buy_price` double DEFAULT NULL,
  `qtyOnHand` int(11) DEFAULT NULL,
  PRIMARY KEY (`pr_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('532276','baby frock',1500,1100,120),('543323','napkins pac',110,80,100),('546732','milk bottal',150,140,150),('598782','car',350,250,80),('598783','baby set',700,600,50),('598785','Baby towel',550,450,60),('598787','Baby powder',150,125,180),('598789','nappy pac',1350,1250,50),('598790','cotton buds',200,220,80),('598791','Lotion',500,450,70);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `Supplier_ID` varchar(20) NOT NULL,
  `Supplier_name` varchar(45) DEFAULT NULL,
  `Description` varchar(60) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Tpnumber` varchar(12) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Date_joined` varchar(15) DEFAULT NULL,
  `Bank` varchar(40) DEFAULT NULL,
  `Branch` varchar(45) DEFAULT NULL,
  `Accnt_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Supplier_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('SUP0001','CNC Company','	','Makola South, Makola','0112387211','lamb@gmail.com','2016-09-12','Sampath Bank','Kiribathgoda','0120320122552'),('SUP0002','Dinux pvt ltd','','Rambukkana road, Kegalle','0112456232','dinux@gmail.com','2016-09-07','Peoples Bank','Kadawatha','2156564855427'),('SUP0003','Kalpan Company','','Kadawatha road, Kiribathgoda','0775484678','nir@gmail.com','2016-09-07','Bank of Ceylon','Kiribathgoda','654896496942684'),('SUP0004','Kumara & Sons','','Flower road, Ja-ela','0112045784','kumar@gmail.com','2016-09-19','Sampath Bank','Ja-ela','32894123214562'),('SUP0005','Ishara','','Galagedara road, nawala','0112458775','isha@gmail.com','2016-09-20','Peoples Bank','Nawala','256485496241586'),('SUP0006','Mahen Company','','Degaawatha road, ranala','0124584125','saha@gmail.com','2016-09-14','Commercial Bank','ranala','2458659462412458'),('SUP0007','99group pvt Ltd','','Kins road, Colombo 3','0325685472','grp99@gmail.com','2016-09-29','HSBC Bank','Kirillawala','215486859452'),('SUP0008','Devinda ','','Nawam mawatha, Galle','0112458455','dev22@gmail.com','2016-09-26','Sanasa Development','Galle','10215478120161'),('SUP0009','Link toys','','Mabola, Waththala','0114587544','links@gmail.com','2016-09-05','Peoples Bank','Waththala','01245846854621'),('SUP0010','P&M Groups','','Raja mawatha, Kelaniya','0124845741','pandm@yahoo.com','2016-09-20','DFCC Bank','Kelaniya','0124845765214'),('SUP0011','MAs groups pvt Ltd','','Malinda, Kapugoda','0114579845','masgroup@yahoo.com','2016-10-06','Bank Of Ceylon','Malinda','012458457652'),('SUP0012','Ariyarathna Sons','','Rawanagala,Kandana','0245845732','ariya@gmail.com','2016-09-21','Nations Trust Bank','Kandana','24587542195'),('SUP0013','123Toys pvt. Ltd ','','Rabukkana road, Kegalle','0112458472','123tys@gmail.com','2016-09-12','Bank Of Ceylon','Kegalle Town','02154784512'),('SUP0014','PowerToy','','Boyer road, Biyagama','0114578542','power@gmail.com','2016-09-19','HSBC Bank','Biyagama','0124578451269'),('SUP0015','Unilievers pvt ltd','','Colombo road, Meepe','0124857452','uniliev@gmail.com','2016-09-20','Commercial Bank','Meepe','01245875956');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `user_name` varchar(50) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `acc_type` varchar(45) DEFAULT 'Administrator',
  `access_privileges` varchar(45) DEFAULT '11111111111',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('akalanka','b991d4ddf704a5707a4fabb94285ba87','da@gmail.com','akalanka','kudagama','Cashier','10111111110'),('kalana','2ddb01f50eff73ecf6ec3b2372f2a7a6','kalana@gmail.com','kalana','kumara','Administrator','10000010001'),('mahendra','1c63129ae9db9c60c3e8aa94d3e00495','mahendrathennakoon@gmail.com','mahendra','tennakoon','Administrator','11111111111'),('saman','1c63129ae9db9c60c3e8aa94d3e00495','saman@gmail.com','saman','perera','Cashier','10111111110'),('sampath','9e77441693279b2265143308e0cc4d16','sampath@gmail.com','samapath','perera','Administrator','11111111111'),('waruna','f8907a62377f8efaa1df6268868cb56d','waruna@ymail.com','waruna','wijesundara','Custom','11110110000');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `water_bill`
--

DROP TABLE IF EXISTS `water_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `water_bill` (
  `bill_no` varchar(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `units` int(11) DEFAULT NULL,
  `payment_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bill_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `water_bill`
--

LOCK TABLES `water_bill` WRITE;
/*!40000 ALTER TABLE `water_bill` DISABLE KEYS */;
INSERT INTO `water_bill` VALUES ('w099',678,11,'2016-09-13'),('w101',1345.9,32,'2016-07-04'),('w102',1345.9,32,'2016-07-04'),('w103',679,19,'2016-07-04'),('w105',1350.34,21,'2016-07-05'),('w106',1450.34,20,'2016-07-20'),('w107',2468.9,34,'2016-06-28'),('w112',798.67,12,'2016-06-15'),('w123',2500,13,'2016-08-06'),('w234',6789,45,'2016-09-01'),('w451',3214,21,'2016-08-29');
/*!40000 ALTER TABLE `water_bill` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-18  4:08:44
