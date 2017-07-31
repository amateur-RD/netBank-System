/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2017-07-31 20:18:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `accountid` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `balance` decimal(18,2) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1016041135', '123456', '1200.00', '1');
INSERT INTO `account` VALUES ('2', 'B12110931', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('3', 'B12110901', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('4', 'B12110902', '123456', '1000.00', '2');
INSERT INTO `account` VALUES ('5', 'B12110903', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('6', 'B12110904', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('7', 'B12110905', '123456', '1000.00', '2');
INSERT INTO `account` VALUES ('8', 'B12110906', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('9', 'B12110907', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('10', 'B12110908', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('11', 'B12110909', '123456', '1000.00', '1');
INSERT INTO `account` VALUES ('15', 'B12110913', '123456', '900.00', '1');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for personinfo
-- ----------------------------
DROP TABLE IF EXISTS `personinfo`;
CREATE TABLE `personinfo` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `accountid` int(4) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `cardid` decimal(18,0) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personinfo
-- ----------------------------
INSERT INTO `personinfo` VALUES ('1', '1', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('2', '2', '赵强', '23', '男', '320542000000000002', '湖北武汉', '15810000002');
INSERT INTO `personinfo` VALUES ('3', '3', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('4', '4', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('5', '5', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('6', '6', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('7', '7', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('8', '8', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('9', '9', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('10', '10', '程阳', '22', '男', '320542000000000001', '南邮', '15810000001');
INSERT INTO `personinfo` VALUES ('15', '15', '张三', '23', '女', '320542000000000003', '江苏南京', '18362837211');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '启用');
INSERT INTO `status` VALUES ('2', '冻结');

-- ----------------------------
-- Table structure for transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE `transaction_log` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `accountid` int(4) DEFAULT NULL,
  `otherid` int(4) DEFAULT NULL,
  `tr_money` decimal(18,0) DEFAULT NULL,
  `datetime` varchar(50) DEFAULT NULL,
  `ta_type` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transaction_log
-- ----------------------------
INSERT INTO `transaction_log` VALUES ('1', '1', '1', '200', '2017-7-19 16:45:9', '1');

-- ----------------------------
-- Table structure for transaction_type
-- ----------------------------
DROP TABLE IF EXISTS `transaction_type`;
CREATE TABLE `transaction_type` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transaction_type
-- ----------------------------
INSERT INTO `transaction_type` VALUES ('1', '存款');
INSERT INTO `transaction_type` VALUES ('2', '取款');
INSERT INTO `transaction_type` VALUES ('3', '转账');
