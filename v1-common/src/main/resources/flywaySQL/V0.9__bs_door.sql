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

 Date: 01/23/2019 21:11:01 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bs_door`
-- ----------------------------
DROP TABLE IF EXISTS `bs_door`;
CREATE TABLE `bs_door` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `img` varchar(245) DEFAULT NULL,
  `corporation_id` bigint(20) NOT NULL,
  `gx_ids` varchar(600) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` smallint(6) DEFAULT NULL,
  `gx_values` varchar(100) DEFAULT NULL,
  `number` varchar(50) NOT NULL,
  `colors` varchar(250) DEFAULT NULL,
  `info_id` bigint(20) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
