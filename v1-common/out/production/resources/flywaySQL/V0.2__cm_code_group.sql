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

 Date: 12/05/2019 20:27:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cm_code_group
-- ----------------------------
DROP TABLE IF EXISTS `cm_code_group`;
CREATE TABLE `cm_code_group` (
  `id` bigint(20) NOT NULL,
  `value` tinyint(4) NOT NULL COMMENT '码组值',
  `name` varchar(20) NOT NULL COMMENT '码组名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cm_code_group
-- ----------------------------
BEGIN;
INSERT INTO `cm_code_group` VALUES (273239076856008704, 1, '角色');
INSERT INTO `cm_code_group` VALUES (273239464485195776, 2, '权限');
INSERT INTO `cm_code_group` VALUES (274257288099926016, 10, '用户状态');
INSERT INTO `cm_code_group` VALUES (274257342596517888, 11, '公司状态');
INSERT INTO `cm_code_group` VALUES (286121853485977600, 12, '工序状态');
INSERT INTO `cm_code_group` VALUES (291175579326222336, 14, '门状态');
INSERT INTO `cm_code_group` VALUES (291996688304967680, 13, '计价类型');
INSERT INTO `cm_code_group` VALUES (325046429502541824, 15, '工单状态');
INSERT INTO `cm_code_group` VALUES (325046560436129792, 16, '工单工序状态');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
