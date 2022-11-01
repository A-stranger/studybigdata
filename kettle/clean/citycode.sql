/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50733
Source Host           : 127.0.0.1:3306
Source Database       : data_etl

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2022-10-28 09:31:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for citycode
-- ----------------------------
DROP TABLE IF EXISTS `citycode`;
CREATE TABLE `citycode` (
  `CodeRef` tinytext,
  `City` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of citycode
-- ----------------------------
INSERT INTO `citycode` VALUES ('10000', 'BEIJING');
INSERT INTO `citycode` VALUES ('10001', 'CHONGQING');
INSERT INTO `citycode` VALUES ('10002', 'SHANGHAI');
INSERT INTO `citycode` VALUES ('10003', 'TIANJIN');
INSERT INTO `citycode` VALUES ('10004', 'GUANGZHOU');
