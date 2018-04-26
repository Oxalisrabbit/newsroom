/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : newsroom

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-04-26 17:18:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '公告标题',
  `cotent` text NOT NULL COMMENT '公告内容',
  `upload` text NOT NULL COMMENT '公告附件',
  `date_pub` datetime NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告';

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '稿件标题',
  `format` varchar(255) NOT NULL COMMENT '稿件格式，以分号串的格式存储',
  `academicsec` int(11) NOT NULL COMMENT '学术领域编号',
  `column` int(11) NOT NULL COMMENT '栏目',
  `keyword1_ch` varchar(255) NOT NULL,
  `keyword2_ch` varchar(255) DEFAULT NULL,
  `keyword3_ch` varchar(255) DEFAULT NULL,
  `keyword4_ch` varchar(255) DEFAULT NULL,
  `keyword1_en` varchar(255) DEFAULT NULL,
  `keyword2_en` varchar(255) DEFAULT NULL,
  `keyword3_en` varchar(255) DEFAULT NULL,
  `keyword4_en` varchar(255) DEFAULT NULL,
  `summary_ch` varchar(255) NOT NULL,
  `summary_en` varchar(255) DEFAULT NULL,
  `writer_id` int(11) NOT NULL COMMENT '投稿人id',
  `writers_info` text NOT NULL COMMENT '作者信息的格式化串',
  `writer_prefer` varchar(255) DEFAULT NULL COMMENT '作者倾向审稿人，以分号分割',
  `writer_avoid` varchar(255) DEFAULT NULL COMMENT '作者回避，以分号分割',
  `date_pub` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`),
  KEY `FK_articles_authors` (`writer_id`),
  KEY `FK_articles_academicsec` (`academicsec`),
  KEY `FK_articles_column` (`column`),
  CONSTRAINT `FK_articles_academicsec` FOREIGN KEY (`academicsec`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_articles_authors` FOREIGN KEY (`writer_id`) REFERENCES `authors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_articles_column` FOREIGN KEY (`column`) REFERENCES `type_column` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='稿件信息';

-- ----------------------------
-- Table structure for authors
-- ----------------------------
DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `name_pinyin` varchar(255) NOT NULL COMMENT '姓名的全拼',
  `gender` int(11) NOT NULL COMMENT '性别',
  `address` text NOT NULL COMMENT '通信地址',
  `postcode` varchar(255) NOT NULL COMMENT '邮编',
  `workspace_ch` text NOT NULL COMMENT '单位中文名',
  `workspace_en` text COMMENT '单位英文名',
  `major` int(11) NOT NULL COMMENT '专业编号',
  `education` int(11) NOT NULL COMMENT '学历编号',
  `title` varchar(255) DEFAULT NULL COMMENT '职称',
  `officetel` varchar(255) NOT NULL COMMENT '办公室电话',
  `phonenum` varchar(255) DEFAULT NULL COMMENT '手机',
  `location` int(255) NOT NULL COMMENT '国家/地区编号',
  `researchdir` varchar(255) NOT NULL COMMENT '研究方向',
  `academicsec` int(11) NOT NULL COMMENT '学术领域编号',
  `introduction` text NOT NULL COMMENT '个人介绍',
  `safeque1` text NOT NULL COMMENT '密保问题1',
  `safeque2` text NOT NULL COMMENT '密保问题2',
  `safeque3` text NOT NULL COMMENT '密保问题3',
  PRIMARY KEY (`id`),
  KEY `FK_authors_type_major` (`major`),
  KEY `FK_authors_type_education` (`education`),
  KEY `FK_authors_type_location` (`location`),
  KEY `FK_authors_type_academicsec` (`academicsec`),
  CONSTRAINT `FK_authors_type_academicsec` FOREIGN KEY (`academicsec`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_education` FOREIGN KEY (`education`) REFERENCES `type_education` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_location` FOREIGN KEY (`location`) REFERENCES `type_location` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_major` FOREIGN KEY (`major`) REFERENCES `type_major` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='作者信息';

-- ----------------------------
-- Table structure for bank_safeque
-- ----------------------------
DROP TABLE IF EXISTS `bank_safeque`;
CREATE TABLE `bank_safeque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `safeque` text NOT NULL COMMENT '密保问题题目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for editors
-- ----------------------------
DROP TABLE IF EXISTS `editors`;
CREATE TABLE `editors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '工号',
  `password` varchar(255) NOT NULL DEFAULT '12345678' COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '编辑姓名',
  `gender` int(11) NOT NULL COMMENT '编辑性别',
  `role` int(11) NOT NULL COMMENT '编辑等级标记，包含两种状态：\r\n（1）主编：0\r\n（2）编辑：1\r\n',
  `safeque1` text NOT NULL COMMENT '密保问题',
  `safeque2` text NOT NULL COMMENT '密保问题2',
  `safeque3` text NOT NULL COMMENT '密保问题3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='编辑信息';

-- ----------------------------
-- Table structure for invoices
-- ----------------------------
DROP TABLE IF EXISTS `invoices`;
CREATE TABLE `invoices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_article` int(11) NOT NULL COMMENT '稿件id',
  `flag` int(11) DEFAULT NULL COMMENT '是否需要发票标记',
  `receipt_title` varchar(255) DEFAULT NULL COMMENT '发票抬头',
  `receipt_num` int(11) DEFAULT NULL COMMENT '发票税号',
  `address` text COMMENT '邮寄地址',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收件人',
  `type` int(11) NOT NULL COMMENT '费用类型',
  `expense` int(255) NOT NULL COMMENT '应缴金额',
  `date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `FK_invoices_articles` (`id_article`),
  CONSTRAINT `FK_invoices_articles` FOREIGN KEY (`id_article`) REFERENCES `articles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for newsroominfo
-- ----------------------------
DROP TABLE IF EXISTS `newsroominfo`;
CREATE TABLE `newsroominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL COMMENT '期刊年份',
  `standard` int(11) NOT NULL COMMENT '期刊制式，包含3个状态：\r\n（1）季刊：4\r\n（2）双月刊：6\r\n（3）月刊：12',
  `admin` varchar(255) NOT NULL COMMENT '管理员用户名',
  `password` varchar(255) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for professors
-- ----------------------------
DROP TABLE IF EXISTS `professors`;
CREATE TABLE `professors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '工号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '审稿人姓名',
  `gender` int(11) NOT NULL COMMENT '审稿人性别',
  `academicsec` int(255) NOT NULL COMMENT '审稿人学术领域编号',
  `safeque1` text NOT NULL COMMENT '密保问题1',
  `safeque2` text NOT NULL COMMENT '密保问题2',
  `safeque3` text NOT NULL COMMENT '密保问题3',
  PRIMARY KEY (`id`),
  KEY `FK_professors_academicsec` (`academicsec`),
  CONSTRAINT `FK_professors_academicsec` FOREIGN KEY (`academicsec`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='审稿人信息';

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_article` int(11) NOT NULL COMMENT '稿件id',
  `id_role` int(11) NOT NULL COMMENT '稿件处理人id',
  `content` text COMMENT '审核结果详细内容',
  `stat` int(11) NOT NULL COMMENT '稿件状态，包含7个状态：\r\n（1）：未分配：0\r\n（2）：审阅中：1\r\n（3）：未通过：2\r\n（4）：待修改：3\r\n（5）：通过：4\r\n（6）：格式确认：5\r\n（7）：缴费：6\r\n（8）：重审：7',
  `role` int(11) NOT NULL COMMENT '角色表名编号，包含4个值：\r\n（1）作者：1\r\n（2）主编：2\r\n（3）编辑：3\r\n（4）审稿人：4',
  `flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '任务状态，包含2种：\r\n（1）未完成：0\r\n（2）已完成：1',
  `date` datetime NOT NULL COMMENT '该记录产生的时间',
  PRIMARY KEY (`id`),
  KEY `FK_tasks_articles` (`id_article`),
  KEY `FK_tasks_type_role` (`role`),
  CONSTRAINT `FK_tasks_articles` FOREIGN KEY (`id_article`) REFERENCES `articles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tasks_type_role` FOREIGN KEY (`role`) REFERENCES `type_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for type_academicsec
-- ----------------------------
DROP TABLE IF EXISTS `type_academicsec`;
CREATE TABLE `type_academicsec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `academicsec` varchar(255) NOT NULL COMMENT '学术领域',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for type_column
-- ----------------------------
DROP TABLE IF EXISTS `type_column`;
CREATE TABLE `type_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `column` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='期刊栏目';

-- ----------------------------
-- Table structure for type_education
-- ----------------------------
DROP TABLE IF EXISTS `type_education`;
CREATE TABLE `type_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `education` varchar(255) NOT NULL COMMENT '学历',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for type_location
-- ----------------------------
DROP TABLE IF EXISTS `type_location`;
CREATE TABLE `type_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) NOT NULL COMMENT '国家/地区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for type_major
-- ----------------------------
DROP TABLE IF EXISTS `type_major`;
CREATE TABLE `type_major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major` varchar(255) NOT NULL COMMENT '专业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for type_role
-- ----------------------------
DROP TABLE IF EXISTS `type_role`;
CREATE TABLE `type_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roletable` varchar(255) DEFAULT NULL COMMENT '角色表名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
