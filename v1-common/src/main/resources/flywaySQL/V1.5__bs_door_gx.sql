/*
 Navicat Premium Data Transfer

 Source Server         : cfmy
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : cfmy

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 01/24/2019 23:02:31 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bs_door_gx`
-- ----------------------------
DROP TABLE IF EXISTS `bs_door_gx`;
CREATE TABLE `bs_door_gx` (
  `id` bigint(20) NOT NULL,
  `gx_id` bigint(20) DEFAULT NULL,
  `door_id` bigint(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `index_key` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
