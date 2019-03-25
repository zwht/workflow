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

 Date: 12/29/2018 22:14:01 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cm_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `cm_user_info`;
CREATE TABLE `cm_user_info` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `province_id` smallint(6) DEFAULT NULL COMMENT '省',
  `city_id` smallint(6) DEFAULT NULL COMMENT '市',
  `county_id` smallint(6) DEFAULT NULL COMMENT '区县',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `flag` smallint(6) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
