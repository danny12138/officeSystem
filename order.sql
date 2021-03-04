/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - db_ssm_project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_ssm_project` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_ssm_project`;

/*Table structure for table `efunction` */

DROP TABLE IF EXISTS `efunction`;

CREATE TABLE `efunction` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fcode` varchar(20) DEFAULT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `furl` varchar(200) DEFAULT NULL,
  `flevel` varchar(20) DEFAULT NULL,
  `fparentid` int(11) DEFAULT NULL,
  `fremark1` varchar(30) DEFAULT NULL,
  `fremark2` varchar(30) DEFAULT NULL,
  `fremark3` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `efunction` */

insert  into `efunction`(`fid`,`fcode`,`fname`,`furl`,`flevel`,`fparentid`,`fremark1`,`fremark2`,`fremark3`) values (1,'001','系统管理','https://www.baidu.com','1',0,'fa-cogs','NO',''),(2,'002','人员管理','/employeeList.html','2',1,'fa-user','YES',NULL),(3,'003','角色管理','/roleList.html','2',1,'fa-user-secret','YES',NULL),(4,'004','功能权限','/functionList.html','2',1,'fa-wrench','YES',''),(5,'005','消息管理','https://www.baidu.com','1',0,'fa-envelope','NO',NULL),(6,'006','发件箱','/sendMessageList.html','2',5,'fa-comment','YES',NULL),(7,'007','发送消息','/sendNormalMsg.html','2',5,'fa-envelope-square','YES',''),(8,'008','推送消息','https://www.bilibili.com/','2',5,'fa-rss-square','YES',''),(9,'009','收件箱','/recieveMessageList.html','2',5,'fa-comment','NO',NULL),(10,'010','未读消息','/recieveMessageListNo.html','3',9,'fa-envelope','YES',''),(11,'011','已读消息','/recieveMessageListYes.html','3',9,'fa-envelope','YES',''),(12,'012','测试功能','https://www.google.com','1',0,'fa-cogs','NO',''),(16,'111','菜鸟教程','https://www.runoob.com/','2',12,NULL,'YES',NULL),(17,'112','AdminLTE','https://3vshej.cn/AdminLTE/AdminLTE-2.3.11/documentation/index.html','2',12,'','YES',''),(18,'013','测试父节点','','1',0,'','YES',''),(19,'113','二级功能','','2',12,'','NO',''),(20,'114','三级功能','','3',19,'','NO',''),(21,'115','四级功能','','4',20,'','NO',''),(23,'116','五级功能','','5',21,NULL,'YES',NULL);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(30) DEFAULT NULL,
  `esex` int(1) DEFAULT NULL,
  `eage` int(3) DEFAULT NULL,
  `ephoneno` varchar(20) DEFAULT NULL,
  `ehiredate` date DEFAULT NULL,
  `ejobno` varchar(20) DEFAULT NULL,
  `epassword` varchar(200) DEFAULT NULL,
  `eremark1` varchar(200) DEFAULT NULL,
  `eremark2` varchar(30) DEFAULT NULL,
  `eremark3` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`eid`,`ename`,`esex`,`eage`,`ephoneno`,`ehiredate`,`ejobno`,`epassword`,`eremark1`,`eremark2`,`eremark3`) values (1,'danny',0,22,'12138','2020-09-15','root','1a02ed7654632304b15bbf0decc48359','8e7b34259bf1b35853a67ad26aa51069','',''),(2,'郭靖',0,27,'123123','2021-02-01','e001','c348aa4bb3866fbe373e9ff8dbba69cd','e36918dac35e3b0ce5313cb25a256d49','',''),(3,'萧峰',0,32,'234234','2021-02-03','e002','626909561c1fdac9eafb243629ddfa13','68871cfa9645439016555925ca738803','',''),(4,'虚竹',0,25,'345345','2021-02-03','e003','9f21a1ad8813e05f3118325059a6adf2','1868b4a96795c7f7831a395a80c97608','',''),(5,'杨过',0,21,'456456','2021-02-03','e004','1578a05eb3f4cb8d6a85d15824edb754','227d02c4bbe89b8139612caa7633c8e6','',''),(6,'小龙女',1,26,'567567','2021-02-08','e005','7121da8411eed6050acbaff37e0409c6','efd9826186c8d4741049a9bd146a5db0','',''),(7,'段誉',0,21,'678678','2021-02-11','e006','5943a386b511b0774cb4599a3b4631a0','06e7cc5b077ebf23126330b905dbd4b9','',''),(8,'王语嫣',1,19,'789789','2021-02-11','e007','9a0b831aa72a2ac6eab9138707c6467f','3cd845da5bd4da58b82f5ef84f2c9a1b','',''),(9,'令狐冲',0,29,'89108910','2021-02-11','e008','19cff8919e17e31e577d12c918327afa','5e929be5be15b03c5ba49882e90cf730','',''),(10,'任盈盈',1,25,'10121012','2021-02-11','e009','de76f85f83cdd0a71b13691a7987bd39','063234cd1e4f57997df98526ec7b12cc','',''),(11,'张无忌',0,21,'11231123','2021-02-11','e010','da9697715bb1efd846523d32b8e0b8d1','4c8d12203290f37a9fa8925b0895ed27','',''),(12,'赵敏',1,20,'12341234','2021-02-13','e011','4c89ed109684e7d66126c62d79a42b25','357a5bf6736779ea2e1003d2ab862f81','',''),(13,'周芷若',1,21,'13451345','2021-02-13','e012','8c0c01293c335281fe135d2689a85ff4','b1decb00a8403de7c5f3422bc9f923a6','',''),(14,'admin',0,66,'666','2021-02-08','admin','cd24d3c0d8e8cf74a067ff3d4cc6a518','df542f694c1963fe8e59faae50e2c060','',''),(17,'张三丰',0,123,'123123123','2021-02-10','e013','3a540254ea637911f7da2f4809c5487a','0ff604fa1f59bf7b517e1104744d468c','',''),(26,'xxx',0,27,'111111','2021-03-04','xxx','1dc7c395e625c45a4cfb365a0a95c03c','2446e8957aa369fc3f7c6f707dd65ae6',NULL,NULL);

/*Table structure for table `employee_role` */

DROP TABLE IF EXISTS `employee_role`;

CREATE TABLE `employee_role` (
  `erid` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`erid`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

/*Data for the table `employee_role` */

insert  into `employee_role`(`erid`,`eid`,`rid`) values (55,26,1),(65,1,1),(66,1,2),(68,2,8),(69,3,2),(70,3,3),(74,6,8),(75,5,5),(76,4,6),(77,7,4),(79,8,9),(80,9,7),(81,10,12),(82,11,2),(83,12,11),(84,13,10),(85,14,1),(86,17,16);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rcode` varchar(20) DEFAULT NULL,
  `rname` varchar(20) DEFAULT NULL,
  `rremark1` varchar(30) DEFAULT NULL,
  `rremark2` varchar(30) DEFAULT NULL,
  `rremark3` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`rid`,`rcode`,`rname`,`rremark1`,`rremark2`,`rremark3`) values (1,'001','管理员',NULL,NULL,NULL),(2,'002','人力资源',NULL,NULL,NULL),(3,'003','项目经理','','',''),(4,'004','前端工程师',NULL,NULL,NULL),(5,'005','JAVA后端工程师',NULL,NULL,NULL),(6,'006','PHP后端工程师',NULL,NULL,NULL),(7,'007','Python后端工程师',NULL,NULL,NULL),(8,'008','UI设计工程师',NULL,NULL,NULL),(9,'009','软件测试工程师',NULL,NULL,NULL),(10,'010','运维工程师',NULL,NULL,NULL),(11,'011','算法工程师',NULL,NULL,NULL),(12,'012','产品经理',NULL,NULL,NULL),(16,'013','产品运营',NULL,NULL,NULL);

/*Table structure for table `role_function` */

DROP TABLE IF EXISTS `role_function`;

CREATE TABLE `role_function` (
  `rfid` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rfid`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;

/*Data for the table `role_function` */

insert  into `role_function`(`rfid`,`rid`,`fid`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,2,2),(11,2,3),(12,2,4),(13,2,5),(14,2,6),(15,2,7),(16,2,8),(17,2,9),(23,1,10),(24,1,11),(25,2,10),(26,2,11),(35,2,1),(36,4,5),(37,4,6),(38,4,7),(39,4,8),(40,4,9),(41,4,10),(42,4,11),(48,0,12),(49,0,16),(51,0,17),(52,6,5),(53,6,6),(54,6,7),(55,6,8),(56,6,9),(57,6,10),(58,6,11),(61,8,5),(62,8,6),(63,8,7),(64,8,8),(65,2,12),(67,2,17),(68,1,12),(69,1,16),(70,1,17),(71,1,19),(72,1,20),(73,1,21),(74,1,23),(75,1,18),(76,2,16),(77,2,19),(78,2,20),(79,2,21),(80,2,23),(82,3,5),(83,3,6),(84,3,7),(85,3,8),(86,3,9),(87,3,10),(88,3,11),(89,5,5),(90,5,6),(91,5,7),(92,5,8),(93,5,9),(94,5,10),(95,5,11),(96,7,5),(97,7,6),(98,7,7),(99,7,8),(100,7,9),(101,7,10),(102,7,11),(103,8,9),(104,8,10),(105,8,11),(106,9,5),(107,9,6),(108,9,7),(109,9,8),(110,9,9),(111,9,10),(112,9,11),(113,10,5),(114,10,6),(115,10,7),(116,10,8),(117,10,9),(118,10,10),(119,10,11),(120,11,5),(121,11,6),(122,11,7),(123,11,8),(124,11,9),(125,11,10),(126,11,11),(127,12,5),(128,12,6),(129,12,7),(130,12,8),(131,12,9),(132,12,10),(133,12,11),(134,16,5),(135,16,6),(136,16,7),(137,16,8),(138,16,9),(139,16,10),(140,16,11);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
