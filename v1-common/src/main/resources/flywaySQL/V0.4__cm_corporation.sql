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

 Date: 12/29/2018 22:14:26 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cm_corporation`
-- ----------------------------
DROP TABLE IF EXISTS `cm_corporation`;
CREATE TABLE `cm_corporation` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL COMMENT '公司名',
  `state` smallint(6) NOT NULL COMMENT '状态',
  `boss_id` bigint(20) DEFAULT NULL COMMENT '法人ID',
  `logo_id` bigint(20) DEFAULT NULL COMMENT '公司LOGO',
  `province_id` smallint(6) DEFAULT NULL COMMENT '省',
  `city_id` smallint(6) DEFAULT NULL COMMENT '市',
  `county_id` smallint(6) DEFAULT NULL COMMENT '县',
  `address` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `ability` varchar(255) DEFAULT NULL COMMENT '权限能力',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cm_corporation`
-- ----------------------------
BEGIN;
INSERT INTO `cm_corporation` VALUES ('274257007794589696', '重庆川峰门业', '1101', null, null, null, null, null, null, '201,202,203,204,205'), ('274260031111827456', '测试3', '1101', null, null, null, null, null, null, '202');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
