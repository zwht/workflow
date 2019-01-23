/*
 Navicat Premium Data Transfer

 Source Server         : cfmy
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : cfmy1

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 01/23/2019 21:10:49 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bs_color`
-- ----------------------------
DROP TABLE IF EXISTS `bs_color`;
CREATE TABLE `bs_color` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `corporation_id` bigint(20) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `value` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
