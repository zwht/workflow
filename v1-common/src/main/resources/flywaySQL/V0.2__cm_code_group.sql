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

 Date: 01/25/2019 10:47:47 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cm_code_group`
-- ----------------------------
DROP TABLE IF EXISTS `cm_code_group`;
CREATE TABLE `cm_code_group` (
  `id` bigint(20) NOT NULL,
  `value` tinyint(4) NOT NULL COMMENT '码组值',
  `name` varchar(20) NOT NULL COMMENT '码组名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cm_code_group`
-- ----------------------------
BEGIN;
INSERT INTO `cm_code_group` VALUES ('273239076856008704', '1', '角色'), ('273239464485195776', '2', '权限'), ('274257288099926016', '10', '用户状态'), ('274257342596517888', '11', '公司状态'), ('286121853485977600', '12', '工序状态');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
