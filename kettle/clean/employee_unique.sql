/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50733
Source Host           : 127.0.0.1:3306
Source Database       : data_etl

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2022-11-01 10:33:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee_unique
-- ----------------------------
DROP TABLE IF EXISTS `employee_unique`;
CREATE TABLE `employee_unique` (
  `Name` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `E-Mail` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_unique
-- ----------------------------
INSERT INTO `employee_unique` VALUES ('张三', 'M', '20', 'zhangsan@163.com', 'ShanDong');
INSERT INTO `employee_unique` VALUES ('李四', 'F', '28', 'lisi@qq.com', 'BeiJing');
INSERT INTO `employee_unique` VALUES ('张三', null, '20', 'zhangsan@163.com', 'ShanDong');
INSERT INTO `employee_unique` VALUES ('李四', 'F', '28', 'lisi@qq.com', 'BeiJing');
