/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.40 : Database - sgmdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sgmdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sgmdb`;

/*Table structure for table `t_absenteeism` */

DROP TABLE IF EXISTS `t_absenteeism`;

CREATE TABLE `t_absenteeism` (
  `abs_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '缺勤序号',
  `abs_code` varchar(40) NOT NULL COMMENT '缺勤序号缺勤编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程序号',
  `abC_id` int(11) DEFAULT NULL COMMENT '缺勤类型序号',
  `stu_id` int(11) DEFAULT NULL COMMENT '学生序号',
  `abs_week` int(11) NOT NULL COMMENT '周次',
  `abs_dayOfWeek` int(11) NOT NULL COMMENT '星期',
  `abs_section` int(11) NOT NULL COMMENT '节次',
  PRIMARY KEY (`abs_id`),
  KEY `FK_Reference_5` (`course_id`),
  KEY `FK_Reference_6` (`abC_id`),
  KEY `FK_Reference_7` (`stu_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`abC_id`) REFERENCES `t_absenteeismcategory` (`abC_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='缺勤表';

/*Data for the table `t_absenteeism` */

insert  into `t_absenteeism`(`abs_id`,`abs_code`,`course_id`,`abC_id`,`stu_id`,`abs_week`,`abs_dayOfWeek`,`abs_section`) values (1,'AB001',1,2,3,1,1,1),(6,'AB002',3,2,1,3,2,2),(8,'AB005',2,1,1,2,1,1),(9,'qwe',1,2,1,1,5,2),(10,'AB003',7,4,1,4,3,5);

/*Table structure for table `t_absenteeismcategory` */

DROP TABLE IF EXISTS `t_absenteeismcategory`;

CREATE TABLE `t_absenteeismcategory` (
  `abC_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '缺勤类型序号',
  `abC_code` varchar(40) NOT NULL COMMENT '缺勤类型编号',
  `abC_category` varchar(40) NOT NULL COMMENT '缺勤类型',
  `abC_deductMarks` decimal(4,1) NOT NULL COMMENT '扣分',
  PRIMARY KEY (`abC_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='缺勤类型表';

/*Data for the table `t_absenteeismcategory` */

insert  into `t_absenteeismcategory`(`abC_id`,`abC_code`,`abC_category`,`abC_deductMarks`) values (1,'KK','旷课','20.0'),(2,'CD','迟到','5.0'),(3,'SJ','事假','5.0'),(4,'BJ','病假','2.0'),(5,'ZT','早退','5.0'),(6,'QT','其他','1.0'),(7,'HJ','婚假-修改','0.5');

/*Table structure for table `t_academy` */

DROP TABLE IF EXISTS `t_academy`;

CREATE TABLE `t_academy` (
  `academy_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院序号',
  `academy_code` varchar(40) NOT NULL COMMENT '学院编号',
  `academy_name` varchar(40) NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`academy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='学院表';

/*Data for the table `t_academy` */

insert  into `t_academy`(`academy_id`,`academy_code`,`academy_name`) values (1,'10001','软件学院'),(2,'10002','地球物理与测控技术学院'),(3,'10003','水资源与环境工程学院'),(4,'10004','测绘工程学院'),(5,'10005','化学生物与材料科学学院'),(6,'10006','核科学与工程学院'),(7,'10007','机械与电子工程学院'),(8,'10008','信息工程学院'),(9,'10009','理学院'),(10,'10010','土木与建筑工程学院'),(11,'10011','创新创业教育学院'),(12,'10012','经济与管理学院'),(13,'10013','文法学院'),(14,'10014','外国语学院'),(15,'10015','马克思主义学院'),(16,'10016','体育学院'),(17,'10017','艺术学院'),(18,'10018','研究生院'),(19,'10019','国防教育学院'),(20,'10020','国防科技学院'),(21,'10021','地球科学学院'),(22,'10022','测试学院');

/*Table structure for table `t_classes` */

DROP TABLE IF EXISTS `t_classes`;

CREATE TABLE `t_classes` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级序号',
  `class_code` varchar(40) DEFAULT NULL COMMENT '班级编号',
  `class_name` varchar(40) DEFAULT NULL COMMENT '班级名称',
  `academy_id` int(11) DEFAULT NULL COMMENT '学院序号',
  `major_id` int(11) DEFAULT NULL COMMENT '专业序号',
  PRIMARY KEY (`class_id`),
  KEY `FK_Reference_2` (`academy_id`),
  KEY `FK_Reference_3` (`major_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`academy_id`) REFERENCES `t_academy` (`academy_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`major_id`) REFERENCES `t_major` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='班级表';

/*Data for the table `t_classes` */

insert  into `t_classes`(`class_id`,`class_code`,`class_name`,`academy_id`,`major_id`) values (1,'1621801','软件工程一班',1,1),(2,'1621802','软件工程二班',1,1),(3,'1621803','软件工程三班',1,1),(4,'1002200101','测试一班',22,11),(6,'test002','测试二班',22,11),(7,'test003','测试三班',22,11);

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程序号',
  `course_code` varchar(40) NOT NULL COMMENT '课程编号',
  `course_name` varchar(255) NOT NULL COMMENT '课程名',
  `course_period` int(11) NOT NULL COMMENT '学时',
  `course_credit` decimal(2,1) NOT NULL COMMENT '学分',
  `course_year` varchar(40) NOT NULL COMMENT '学年',
  `course_term` varchar(40) NOT NULL COMMENT '学期',
  `course_checking` decimal(3,2) DEFAULT NULL COMMENT '考勤比例',
  `course_answer` decimal(3,2) DEFAULT NULL COMMENT '回答问题',
  `course_task` decimal(3,2) DEFAULT NULL COMMENT '作业比例',
  `teac_id` int(11) DEFAULT NULL COMMENT '教师序号',
  PRIMARY KEY (`course_id`),
  KEY `fk_tc` (`teac_id`),
  CONSTRAINT `fk_tc` FOREIGN KEY (`teac_id`) REFERENCES `t_teacher` (`teac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='课程表';

/*Data for the table `t_course` */

insert  into `t_course`(`course_id`,`course_code`,`course_name`,`course_period`,`course_credit`,`course_year`,`course_term`,`course_checking`,`course_answer`,`course_task`,`teac_id`) values (1,'2020001','C语言',32,'4.0','2021','第二学期','0.20','0.60','0.20',1),(2,'2020002','JAVA课程设计',28,'4.0','2019-12-31T16:00:00.000Z','第一学期','0.30','0.40','0.30',1),(3,'2020003','web应用开发',34,'4.0','2019-12-31T16:00:00.000Z','第一学期','0.40','0.40','0.20',1),(4,'2020004','数据结构',32,'4.0','2020','第一学期','0.40','0.40','0.20',1),(5,'RJGC','软件工程',24,'4.0','2020','第一学期','0.30','0.40','0.30',1),(6,'C1020','大学数学',24,'4.0','2021','第一学期','0.20','0.30','0.50',1),(7,'VCPP','Visual C++-修改',28,'3.5','2020','第一学期','0.40','0.20','0.40',1),(8,'DXSX1','大学数学1',24,'3.0','2020','第二学期','0.40','0.40','0.20',1);

/*Table structure for table `t_major` */

DROP TABLE IF EXISTS `t_major`;

CREATE TABLE `t_major` (
  `major_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业序号',
  `major_code` varchar(40) NOT NULL COMMENT '专业编号',
  `major_name` varchar(40) NOT NULL COMMENT '专业名称',
  `academy_id` int(11) NOT NULL COMMENT '学院序号',
  PRIMARY KEY (`major_id`),
  KEY `FK_Reference_1` (`academy_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`academy_id`) REFERENCES `t_academy` (`academy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='专业表';

/*Data for the table `t_major` */

insert  into `t_major`(`major_id`,`major_code`,`major_name`,`academy_id`) values (1,'1000101','软件工程系',1),(2,'1000102','网络工程系',1),(3,'1000103','数字媒体系',1),(10,'1000104','234',1),(11,'1002201','测试专业',22);

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `linkUrl` varchar(128) DEFAULT NULL COMMENT '菜单链接',
  `path` varchar(128) DEFAULT NULL COMMENT '菜单路径',
  `priority` int(11) DEFAULT NULL COMMENT '菜单优先级',
  `icon` varchar(64) DEFAULT NULL COMMENT '菜单图标',
  `description` varchar(128) DEFAULT NULL COMMENT '菜单描述',
  `parentMenuId` int(11) DEFAULT NULL COMMENT '父菜单id',
  `level` int(11) DEFAULT NULL COMMENT '菜单级别',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_reference` (`parentMenuId`) USING BTREE,
  CONSTRAINT `FK_reference` FOREIGN KEY (`parentMenuId`) REFERENCES `t_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`name`,`linkUrl`,`path`,`priority`,`icon`,`description`,`parentMenuId`,`level`) values (1,'学生模块',NULL,'1',1,'el-icon-user-solid','student',NULL,1),(2,'个人信息','student_info.html','/1-1',1,NULL,'student',1,2),(3,'我的作业','student_task.html','/1-2',2,NULL,'student',1,2),(4,'教师模块',NULL,'2',2,'el-icon-s-custom','teacher',NULL,1),(5,'个人信息','teacher_info.html','/2-1',1,NULL,'teacher',4,2),(6,'批改作业','correcting.html','/2-2',2,NULL,'teacher',4,NULL),(7,'学生回答问题登记','stuAnswerQuestionRegistry.html','/2-3',3,NULL,'teacher',4,2),(8,'评分模块',NULL,'3',3,'el-icon-edit-outline','teacher',NULL,1),(9,'缺勤',NULL,'/3-1',1,NULL,'teacher',8,2),(10,'回答问题',NULL,'/3-2',2,NULL,'teacher',8,2),(11,'批改作业',NULL,'/3-3',3,NULL,'teacher',8,2),(12,'管理模块',NULL,'4',4,'el-icon-setting','all',NULL,1),(13,'学院管理','academy.html','/4-1',1,NULL,'all',12,2),(14,'专业管理','major.html','/4-2',2,NULL,'all',12,2),(15,'班级管理','classes.html','/4-3',3,NULL,'all',12,2),(16,'课程管理','course.html','/4-4',4,NULL,'all',12,2),(17,'教师管理','teacher.html','/4-5',5,NULL,'all',12,2),(18,'学生管理','student.html','/4-6',6,NULL,'all',12,2),(19,'缺勤类型管理','absenteeismCategory.html','/4-7',7,NULL,'all',12,2),(20,'缺勤管理','absenteeism.html','/4-8',8,NULL,'all',12,2),(21,'作业管理','task.html','/4-9',9,NULL,'all',12,2),(22,'问题管理','question.html','/4-10',10,NULL,'all',12,2),(23,'学生回答问题管理','stuAnswerQuestion.html','/4-11',11,NULL,'all',12,2),(24,'平时成绩管理','usualGrade.html','/4-12',12,NULL,'all',12,2),(25,'选课','chooseCourse.html','/1-3',3,NULL,'student',1,2),(26,'课程管理','teacCourse.html','/2-4',4,NULL,'teacher',4,2);

/*Table structure for table `t_question` */

DROP TABLE IF EXISTS `t_question`;

CREATE TABLE `t_question` (
  `que_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题序号',
  `que_code` varchar(40) NOT NULL COMMENT '问题编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程序号',
  `que_content` text NOT NULL COMMENT '问题内容',
  PRIMARY KEY (`que_id`),
  KEY `FK_Reference_15` (`course_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='问题表';

/*Data for the table `t_question` */

insert  into `t_question`(`que_id`,`que_code`,`course_id`,`que_content`) values (1,'Q001',3,'问题'),(3,'Q101',1,'问题1'),(4,'Q102',1,'指针的本质是什么？'),(5,'Q004',7,'问题四？修改'),(6,'Q005',8,'大学数学1');

/*Table structure for table `t_stuanswerquestion` */

DROP TABLE IF EXISTS `t_stuanswerquestion`;

CREATE TABLE `t_stuanswerquestion` (
  `que_id` int(11) NOT NULL,
  `que_getPoint` decimal(4,1) NOT NULL,
  `stu_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  KEY `FK_Reference_17` (`stu_id`),
  KEY `FK_Reference_18` (`course_id`),
  KEY `FK_Reference_16` (`que_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`que_id`) REFERENCES `t_question` (`que_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生回答问题表';

/*Data for the table `t_stuanswerquestion` */

insert  into `t_stuanswerquestion`(`que_id`,`que_getPoint`,`stu_id`,`course_id`) values (3,'100.0',1,1),(4,'100.0',1,1),(5,'100.0',1,7),(5,'100.0',1,7),(6,'80.0',1,8),(4,'60.0',1,1),(3,'5.0',1,1);

/*Table structure for table `t_stucourse` */

DROP TABLE IF EXISTS `t_stucourse`;

CREATE TABLE `t_stucourse` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课序号',
  `stu_id` int(11) DEFAULT NULL COMMENT '学生序号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程序号',
  PRIMARY KEY (`sc_id`),
  KEY `fk_sc_1` (`stu_id`),
  KEY `fk_sc_2` (`course_id`),
  CONSTRAINT `fk_sc_1` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`),
  CONSTRAINT `fk_sc_2` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `t_stucourse` */

insert  into `t_stucourse`(`sc_id`,`stu_id`,`course_id`) values (16,1,2),(17,1,1),(18,5,1),(19,5,2),(20,5,3),(21,5,4),(22,5,5),(23,1,3),(24,1,4),(25,1,5),(26,1,6),(27,1,8);

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生序号',
  `stu_code` varchar(40) NOT NULL COMMENT '学生编号',
  `class_id` int(11) NOT NULL COMMENT '班级序号',
  `stu_name` varchar(40) NOT NULL COMMENT '姓名',
  `stu_sex` smallint(6) NOT NULL COMMENT '性别',
  `stu_birthday` varchar(40) NOT NULL COMMENT '出生年月',
  `stu_nativePlace` varchar(100) NOT NULL COMMENT '籍贯',
  `stu_pwd` varchar(100) NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`stu_id`),
  KEY `FK_Reference_4` (`class_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`class_id`) REFERENCES `t_classes` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='学生表';

/*Data for the table `t_student` */

insert  into `t_student`(`stu_id`,`stu_code`,`class_id`,`stu_name`,`stu_sex`,`stu_birthday`,`stu_nativePlace`,`stu_pwd`) values (1,'201620180309',3,'明明',1,'1997-03-23','江西南昌','202cb962ac59075b964b07152d234b70'),(3,'201620180210',2,'默默',1,'1998-04-29','江西九江','202cb962ac59075b964b07152d234b70'),(4,'201620180307',3,'娜娜',1,'1999-01-03','江西上饶','9762c4dec5226d22abe0c0efcde20a52'),(5,'201620180305',3,'龙龙',1,'1997-02-13','江西高安','202cb962ac59075b964b07152d234b70');

/*Table structure for table `t_stutask` */

DROP TABLE IF EXISTS `t_stutask`;

CREATE TABLE `t_stutask` (
  `teac_id` int(11) NOT NULL COMMENT '教师序号',
  `stu_id` int(11) NOT NULL COMMENT '学生序号',
  `course_id` int(11) NOT NULL COMMENT '课程序号',
  `task_id` int(11) NOT NULL COMMENT '作业序号',
  `stuTask_answer` varchar(255) DEFAULT NULL COMMENT '答案图像',
  `stuTask_grade` decimal(4,1) DEFAULT NULL COMMENT '成绩',
  KEY `FK_Reference_11` (`teac_id`),
  KEY `FK_Reference_12` (`stu_id`),
  KEY `FK_Reference_13` (`course_id`),
  KEY `FK_Reference_14` (`task_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`teac_id`) REFERENCES `t_teacher` (`teac_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生作业表';

/*Data for the table `t_stutask` */

insert  into `t_stutask`(`teac_id`,`stu_id`,`course_id`,`task_id`,`stuTask_answer`,`stuTask_grade`) values (1,1,2,4,'','80.0'),(4,1,4,10,'201620180309_FH_answer.jpg',NULL),(1,1,4,16,'201620180309_T001_answer.jpg',NULL),(1,1,1,17,'201620180309_C01_answer.jpg','60.0'),(1,5,1,17,'','79.0'),(1,1,2,18,'201620180309_Java001_answer.jpg',NULL),(1,5,2,18,'',NULL),(1,5,3,19,'',NULL),(1,5,4,20,'',NULL),(1,1,1,23,'201620180309_hw01_answer.jpg','60.0'),(1,5,1,23,NULL,NULL),(1,1,6,26,NULL,NULL),(1,5,5,27,NULL,NULL),(1,1,5,27,NULL,NULL),(1,5,5,28,NULL,NULL),(1,1,5,28,'201620180309_T004_answer.jpg',NULL),(1,1,1,29,NULL,NULL),(1,5,1,29,NULL,NULL),(1,1,8,32,'201620180309_T203_answer.jpg','90.0');

/*Table structure for table `t_task` */

DROP TABLE IF EXISTS `t_task`;

CREATE TABLE `t_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业序号',
  `task_code` varchar(40) NOT NULL COMMENT '作业编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程序号',
  `task_title` text NOT NULL COMMENT '作业题目',
  `task_point` decimal(3,2) NOT NULL COMMENT '分数百分比',
  PRIMARY KEY (`task_id`),
  KEY `FK_Reference_8` (`course_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='作业表';

/*Data for the table `t_task` */

insert  into `t_task`(`task_id`,`task_code`,`course_id`,`task_title`,`task_point`) values (1,'123',3,'13','0.94'),(2,'qwe',1,'指针是什么','0.11'),(3,'abc',1,'c语言有哪些特点','0.10'),(4,'ert',2,'动态代理有哪几种代理方式？','0.50'),(10,'FH',1,'构造函数的意义？？？','0.02'),(11,'T001',4,'作业1','0.02'),(12,'T001',4,'作业1','0.02'),(13,'T001',4,'123','1.00'),(14,'T001',4,'111','1.00'),(15,'T001',4,'111','1.00'),(16,'T001',4,'111','1.00'),(17,'C01',1,'adsa','0.20'),(18,'Java001',2,'asda','0.30'),(19,'WEB001',3,'deda','0.40'),(20,'AA002',4,'qwda','0.60'),(21,'hw001',1,'123456','0.06'),(22,'hw001',1,'123456','0.06'),(23,'hw01',1,'hw01','0.03'),(26,'T102',6,'1+1=?','0.20'),(27,'T103',5,'CPU全称？','0.10'),(28,'T004',5,'瀑布模型介绍一下？','0.05'),(29,'T102',1,'++i 和 i++的区别？','0.04'),(30,'T202',7,'阿巴不得卡斯比？修改','0.05'),(31,'T203',8,'大学数学','1.00'),(32,'T203',8,'大学数学','1.00');

/*Table structure for table `t_teacher` */

DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE `t_teacher` (
  `teac_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师序号',
  `teac_code` varchar(40) NOT NULL COMMENT '教师编号',
  `teac_name` varchar(40) NOT NULL COMMENT '教师姓名',
  `teac_sex` smallint(6) DEFAULT NULL COMMENT '性别',
  `teac_birthday` varchar(40) DEFAULT NULL COMMENT '出生年月',
  `teac_level` varchar(40) DEFAULT NULL COMMENT '职称',
  `academy_id` int(11) NOT NULL COMMENT '学院序号',
  `major_id` int(11) NOT NULL COMMENT '专业序号',
  `teac_pwd` varchar(40) NOT NULL COMMENT '登陆密码',
  PRIMARY KEY (`teac_id`),
  KEY `fk1` (`academy_id`),
  KEY `fk2` (`major_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`academy_id`) REFERENCES `t_academy` (`academy_id`),
  CONSTRAINT `fk2` FOREIGN KEY (`major_id`) REFERENCES `t_major` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='教师表';

/*Data for the table `t_teacher` */

insert  into `t_teacher`(`teac_id`,`teac_code`,`teac_name`,`teac_sex`,`teac_birthday`,`teac_level`,`academy_id`,`major_id`,`teac_pwd`) values (1,'1990001','韩梅梅',0,'1990-02-02','助教',1,1,'cee38c2f77d73b4f5ae11da0423b93b6'),(4,'1980001','诸葛亮',1,'1987-01-29','讲师',1,2,'64c902e771b64236a1ae6267dd2e43fa'),(5,'1980002','庞统',1,'1980-03-13','正教授',22,11,'f96309fb8332dabad3398e5611076366'),(7,'1980003','郭嘉-修改',1,'1980-01-03','讲师',1,1,'676c15a67b4d4b2b9e6ca59d10c84191');

/*Table structure for table `t_usualgrade` */

DROP TABLE IF EXISTS `t_usualgrade`;

CREATE TABLE `t_usualgrade` (
  `stu_id` int(11) NOT NULL COMMENT '学生序号',
  `course_id` int(11) NOT NULL COMMENT '课程序号',
  `abs_point` decimal(4,1) DEFAULT NULL COMMENT '考勤得分',
  `que_point` decimal(4,1) DEFAULT NULL COMMENT '回答问题得分',
  `task_point` decimal(4,1) DEFAULT NULL COMMENT '作业得分',
  `other_point` decimal(4,1) DEFAULT NULL COMMENT '其他得分',
  `all_point` decimal(4,1) DEFAULT NULL COMMENT '总分',
  KEY `stu_id` (`stu_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`),
  CONSTRAINT `t_usualgrade_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`),
  CONSTRAINT `t_usualgrade_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_usualgrade` */

insert  into `t_usualgrade`(`stu_id`,`course_id`,`abs_point`,`que_point`,`task_point`,`other_point`,`all_point`) values (1,8,'100.0','80.0','90.0','0.0','90.0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
