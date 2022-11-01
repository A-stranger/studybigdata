/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50733
Source Host           : 127.0.0.1:3306
Source Database       : data_etl

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2022-11-01 10:33:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee_unique_incomplete
-- ----------------------------
DROP TABLE IF EXISTS `employee_unique_incomplete`;
CREATE TABLE `employee_unique_incomplete` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `EMail` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_unique_incomplete
-- ----------------------------
INSERT INTO `employee_unique_incomplete` VALUES ('1', 'Jasson', 'M', '20', 'Jasontest@gmail.com', 'ChongQing');
INSERT INTO `employee_unique_incomplete` VALUES ('2', 'Quick', 'F', '28', 'Quicktest@gmail.com', 'GuangZhou');
INSERT INTO `employee_unique_incomplete` VALUES ('3', 'Peter', 'M', '25', 'Petertest@gmail.com', 'Shanghai');
INSERT INTO `employee_unique_incomplete` VALUES ('4', 'Jason', 'M', '20', 'Jasontest@gmail.com', 'ChongQing');
INSERT INTO `employee_unique_incomplete` VALUES ('5', 'Peters', 'M', '25', 'Peterstest@gmail.com', 'Shanghai');
