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

 Date: 12/29/2018 22:14:12 PM
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
  `corporation_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `type` varchar(20) DEFAULT NULL COMMENT '文件类型',
  `other_id` bigint(20) DEFAULT NULL,
  `file_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cm_file`
-- ----------------------------
BEGIN;
INSERT INTO `cm_file` VALUES ('274708819454595072', '274708819454595072.png', null, null, null, 'head', '134443', 'png');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
