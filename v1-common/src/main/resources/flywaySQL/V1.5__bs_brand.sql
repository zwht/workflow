/*
 Navicat Premium Data Transfer

 Source Server         : localhost-密码：123456
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : workflow

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 14/11/2019 17:33:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bs_brand
-- ----------------------------
DROP TABLE IF EXISTS `bs_brand`;
CREATE TABLE `bs_brand` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `corporation_id` bigint(20) DEFAULT NULL COMMENT '公司',
  `describe_word` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_brand
-- ----------------------------
BEGIN;
INSERT INTO `bs_brand` VALUES (392408486597758976, '重庆川峰门业', 274257007794589696, '重庆川峰门业');
INSERT INTO `bs_brand` VALUES (392408591988035584, '重庆御驰门业', 274257007794589696, '重庆御驰门业');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
