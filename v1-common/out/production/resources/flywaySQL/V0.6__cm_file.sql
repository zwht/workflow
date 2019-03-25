/*
 Navicat Premium Data Transfer

 Source Server         : cfmy
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : conference

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 01/08/2019 21:35:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cm_file`
-- ----------------------------
DROP TABLE IF EXISTS `cm_file`;
CREATE TABLE `cm_file` (
  `id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `state` smallint(6) DEFAULT '1' COMMENT '状态',
  `user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `type` varchar(20) DEFAULT NULL COMMENT '文件类型',
  `other_id` bigint(20) DEFAULT NULL,
  `file_type` varchar(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cm_file`
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
