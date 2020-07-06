/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.34-MariaDB : Database - njt_sportska_oprema
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`njt_sportska_oprema` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `njt_sportska_oprema`;

/*Table structure for table `cenovnik` */

DROP TABLE IF EXISTS `cenovnik`;

CREATE TABLE `cenovnik` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumDo` datetime DEFAULT NULL,
  `datumOd` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `cenovnik` */

insert  into `cenovnik`(`id`,`datumDo`,`datumOd`,`status`) values 
(1,'2019-01-27 00:00:00','2019-01-27 00:00:00','aktivan');

/*Table structure for table `iznajmljivanje` */

DROP TABLE IF EXISTS `iznajmljivanje`;

CREATE TABLE `iznajmljivanje` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `datumDo` datetime DEFAULT NULL,
  `datumOd` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `klijent_id` bigint(20) NOT NULL,
  `oprema_id` bigint(20) NOT NULL,
  `radnik_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_a711683ayjo2nup8s76h5vlfg` (`klijent_id`),
  KEY `FK_w862g4p4b5ml84nh3njsg23x` (`oprema_id`),
  KEY `FK_63vyru2114uxby35ax5adlqjp` (`radnik_id`),
  CONSTRAINT `FK_63vyru2114uxby35ax5adlqjp` FOREIGN KEY (`radnik_id`) REFERENCES `korisnik` (`id`),
  CONSTRAINT `FK_a711683ayjo2nup8s76h5vlfg` FOREIGN KEY (`klijent_id`) REFERENCES `korisnik` (`id`),
  CONSTRAINT `FK_w862g4p4b5ml84nh3njsg23x` FOREIGN KEY (`oprema_id`) REFERENCES `oprema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `iznajmljivanje` */

insert  into `iznajmljivanje`(`id`,`cena`,`datumDo`,`datumOd`,`status`,`klijent_id`,`oprema_id`,`radnik_id`) values 
(1,2000,'2019-06-25 00:00:00','2019-06-23 00:00:00','razduzeno',3,5,1),
(2,1000,'2019-07-02 00:00:00','2019-07-01 00:00:00','razduzeno',2,5,1),
(3,700,'2019-07-04 00:00:00','2019-07-03 00:00:00','razduzeno',2,9,1),
(6,3000,'2019-07-09 00:00:00','2019-07-08 00:00:00','razduzeno',2,1,1),
(7,200,'2019-07-02 00:00:00','2019-07-01 00:00:00','razduzeno',2,13,1),
(8,200,'2019-07-09 00:00:00','2019-07-08 00:00:00','zaduzeno',2,13,1),
(9,700,'2019-07-09 00:00:00','2019-07-08 00:00:00','zaduzeno',3,10,1);

/*Table structure for table `jedinicamere` */

DROP TABLE IF EXISTS `jedinicamere`;

CREATE TABLE `jedinicamere` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `jedinicamere` */

insert  into `jedinicamere`(`id`,`naziv`) values 
(1,'dan'),
(2,'sat');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `DTYPE` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `brojRadneKnjizice` varchar(255) DEFAULT NULL,
  `datumZaposlenja` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `korisnik` */

insert  into `korisnik`(`DTYPE`,`id`,`ime`,`prezime`,`adresa`,`telefon`,`brojRadneKnjizice`,`datumZaposlenja`) values 
('Radnik',1,'Tijana','Ninkovic',NULL,NULL,'123456','2018-09-06 00:00:00'),
('Klijent',2,'Jovana','Mijalkovic','Bulevar Zorana Djindjica','123456789',NULL,NULL),
('Klijent',3,'Aleksandra','Maksimovic','Blok 45','444666777',NULL,NULL),
('Radnik',4,'Milos','Ninkovic',NULL,NULL,'777888','2019-06-12 14:16:50');

/*Table structure for table `oprema` */

DROP TABLE IF EXISTS `oprema`;

CREATE TABLE `oprema` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naStanju` int(11) NOT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `proizvodjac_id` bigint(20) NOT NULL,
  `vrsta_id` bigint(20) NOT NULL,
  `slika` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2fea47iasnaf1ibrpk5ev6k75` (`vrsta_id`),
  CONSTRAINT `FK_2fea47iasnaf1ibrpk5ev6k75` FOREIGN KEY (`vrsta_id`) REFERENCES `vrstaopreme` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `oprema` */

insert  into `oprema`(`id`,`naStanju`,`opis`,`proizvodjac_id`,`vrsta_id`,`slika`) values 
(1,4,'Elektricni bicilk, model: experience, bele boje, 9 brzina, prednji i zadnji amortizeri, disk kocnice, velicina rama L',2,1,'https://www.mojabicikla.rs/wp-content/uploads/2019/04/bck8507a00000_2_original_experience5-460x350.jpg'),
(5,2,'Drumski trkacki bicikl, model: Firebird, muski, velicina tocka 28\'\', bez amortizera, aluminijumski ram, drumske kocnice, broj brzina 2x9',3,1,'https://www.mojabicikla.rs/wp-content/uploads/2019/03/bck0947a00000_1_original_dsc_6075-460x350.jpg'),
(6,3,'Muske, crne boje, velicina 43',4,4,'https://www.mojabicikla.rs/wp-content/uploads/2019/06/ski1015a00000_1_original_ski50c1001100_1-460x350.jpg'),
(8,2,'Trekking bicikl, model: SUB CROSS 40, muski, velicina tocka 28\'\', crne boje, broj brzina 3x8, velicina rama L, prednji amortizeri',5,1,'https://www.mojabicikla.rs/wp-content/uploads/2019/03/bck8188a00000_1_original_sc270037-460x350.jpg'),
(9,2,'Model: Salomon Pulse, unisex, drveno jezgro, dobar i za freeride i freestyle terene',6,3,'https://www.snowinn.com/f/13687/136878930/salomon-pulse.jpg'),
(10,2,'Model: Jibsaw Heavy Duty, velicina 157cm, oblik Twin',7,3,'https://www.snowinn.com/f/13699/136997893/rossignol-jibsaw-heavy-duty-wide-cuda-m-l.jpg'),
(11,3,'Model: Salomon X-Max X12, unisex, crne boje, duzina 170cm, oblozene duplom titanijumskom plocom, puno drveno jezgro',6,2,'https://www.snowinn.com/f/13654/136547375/salomon-x-max-x12-xt12.jpg'),
(12,3,'Model: Experience 80 CI, duzina 174cm, HD core, progressive sidecut, unisex, sive boje',7,2,'https://www.snowinn.com/f/13694/136949295/rossignol-experience-80-ci-xpress-11-b83.jpg'),
(13,3,'Salomon Hacker S3 ski stap od aluminijuma sa bezbednosnim kaisevima, precnik 18mm',6,5,'https://rs.beosport.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/3/7/377815_01.jpg'),
(15,3,'Velicina 165, model Experience',5,3,'snowboard.jpg');

/*Table structure for table `profil` */

DROP TABLE IF EXISTS `profil`;

CREATE TABLE `profil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `korisnickoIme` varchar(255) DEFAULT NULL,
  `sifra` varchar(255) DEFAULT NULL,
  `korisnik_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_80nat3fd4gv7x1o4fpvytcx81` (`korisnik_id`),
  CONSTRAINT `FK_80nat3fd4gv7x1o4fpvytcx81` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `profil` */

insert  into `profil`(`id`,`korisnickoIme`,`sifra`,`korisnik_id`) values 
(2,'tix','tix',1),
(3,'maki','maki',3),
(4,'joja','joja',2),
(5,'milos','milos',4);

/*Table structure for table `proizvodjac` */

DROP TABLE IF EXISTS `proizvodjac`;

CREATE TABLE `proizvodjac` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `proizvodjac` */

insert  into `proizvodjac`(`id`,`naziv`) values 
(1,'Haibike'),
(2,'E-Prime'),
(3,'Capriolo'),
(4,'Nordica'),
(5,'Scott'),
(6,'Salomon'),
(7,'Rossignol');

/*Table structure for table `stavkacenovnika` */

DROP TABLE IF EXISTS `stavkacenovnika`;

CREATE TABLE `stavkacenovnika` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `jm_id` bigint(20) NOT NULL,
  `oprema_id` bigint(20) NOT NULL,
  `valuta_id` bigint(20) NOT NULL,
  `cenovnik_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6r8q7uwvug0yfhg3f6lk9niob` (`cenovnik_id`),
  CONSTRAINT `FK_6r8q7uwvug0yfhg3f6lk9niob` FOREIGN KEY (`cenovnik_id`) REFERENCES `cenovnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `stavkacenovnika` */

insert  into `stavkacenovnika`(`id`,`cena`,`jm_id`,`oprema_id`,`valuta_id`,`cenovnik_id`) values 
(1,3000,1,1,1,1),
(2,1000,1,5,1,1),
(3,1500,1,8,1,1),
(4,700,1,11,1,1),
(5,700,1,12,1,1),
(6,200,1,13,1,1),
(7,700,1,10,1,1),
(10,700,1,9,1,1);

/*Table structure for table `valuta` */

DROP TABLE IF EXISTS `valuta`;

CREATE TABLE `valuta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `valuta` */

insert  into `valuta`(`id`,`naziv`) values 
(1,'RSD'),
(2,'EUR'),
(3,'USD');

/*Table structure for table `vrstaopreme` */

DROP TABLE IF EXISTS `vrstaopreme`;

CREATE TABLE `vrstaopreme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `vrstaopreme` */

insert  into `vrstaopreme`(`id`,`naziv`) values 
(1,'Bicikl'),
(2,'Skije'),
(3,'Snowboard'),
(4,'Pancerice'),
(5,'Stap za skijanje');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
