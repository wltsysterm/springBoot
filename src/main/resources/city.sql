/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-10-11 23:30:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) default NULL,
  `stats` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', '1');
INSERT INTO `city` VALUES ('2', '2', '2');
INSERT INTO `city` VALUES ('3', '3', '3');
INSERT INTO `city` VALUES ('4', '4', '4');
INSERT INTO `city` VALUES ('5', '5', '5');
INSERT INTO `city` VALUES ('6', '6', '6');
INSERT INTO `city` VALUES ('7', '7', '7');
INSERT INTO `city` VALUES ('8', '8', '8');
