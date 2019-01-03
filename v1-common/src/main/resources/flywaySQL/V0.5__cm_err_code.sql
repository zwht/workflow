/*
 Navicat Premium Data Transfer

 Source Server         : v1
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : v1

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 12/29/2018 22:14:18 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cm_err_code`
-- ----------------------------
DROP TABLE IF EXISTS `cm_err_code`;
CREATE TABLE `cm_err_code` (
  `id` bigint(20) NOT NULL,
  `value` int(4) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
