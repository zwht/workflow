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
DROP TABLE IF EXISTS `bs_gx_type`;
CREATE TABLE `bs_gx_type` (
  `id` bigint(20) NOT NULL,
  `gx_id` bigint(20) DEFAULT NULL,
  `corporation_id` bigint(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `flag` smallint(6) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
