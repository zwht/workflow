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

 Date: 01/23/2019 21:11:13 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bs_gx`
-- ----------------------------
DROP TABLE IF EXISTS `bs_gx`;
CREATE TABLE `bs_gx` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '工序名',
  `state` smallint(6) NOT NULL COMMENT '状态',
  `corporation_id` bigint(20) NOT NULL COMMENT '公司id',
  `price` float NOT NULL COMMENT '工序价格',
  `index_key` smallint(6) DEFAULT NULL COMMENT '顺序',
  `flag` smallint(6) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
