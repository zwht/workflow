/*
 Navicat Premium Data Transfer

 Source Server         : cfmy
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : workflow

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 02/09/2019 11:05:37 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bs_material`
-- ----------------------------
DROP TABLE IF EXISTS `bs_material`;
CREATE TABLE `bs_material` (
  `id` bigint(20) NOT NULL,
  `name` varchar(25) NOT NULL,
  `corporation_id` bigint(20) DEFAULT NULL,
  `value` varchar(25) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `flag` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
