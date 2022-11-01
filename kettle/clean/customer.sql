/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50733
Source Host           : 127.0.0.1:3306
Source Database       : data_etl

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2022-10-28 09:31:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `Name` tinytext,
  `Gender` tinytext,
  `Code` tinytext,
  `City` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('Quick', 'M', '10000', 'BEIJING');
INSERT INTO `customer` VALUES ('Juliet', 'F', '10001', 'CHOGNQING');
INSERT INTO `customer` VALUES ('Peter', 'M', '10002', 'SHANTOU');
INSERT INTO `customer` VALUES ('Valentine', 'F', '11004', 'TIANJIN');
