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

 Date: 01/25/2019 10:47:35 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cm_code`
-- ----------------------------
DROP TABLE IF EXISTS `cm_code`;
CREATE TABLE `cm_code` (
  `id` bigint(20) NOT NULL,
  `value` smallint(6) NOT NULL COMMENT '码值',
  `group_id` bigint(20) NOT NULL COMMENT '分组ID',
  `name` varchar(20) NOT NULL COMMENT '码值描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `cm_code`
-- ----------------------------
BEGIN;
INSERT INTO `cm_code` VALUES ('273970016683167744', '100', '273239076856008704', '公司管理员'), ('273970300419444736', '101', '273239076856008704', '销售'), ('273970374650236928', '102', '273239076856008704', '经销商'), ('273970674022879232', '103', '273239076856008704', '财务'), ('273975319248113664', '104', '273239076856008704', '仓库管理'), ('273975697893101568', '105', '273239076856008704', '管理'), ('274250166805073920', '201', '273239464485195776', '订单系统'), ('274250255703347200', '202', '273239464485195776', '生产管理系统'), ('274250407117721600', '203', '273239464485195776', '财务系统'), ('274250524184940544', '204', '273239464485195776', '仓库管理系统'), ('274250748047527936', '205', '273239464485195776', '任务追溯系统'), ('274257530920767488', '1101', '274257342596517888', '起用中'), ('274257652740132864', '1102', '274257342596517888', '禁用中'), ('274258689769213952', '1001', '274257288099926016', '起用中'), ('274258818551123968', '1002', '274257288099926016', '禁用中'), ('286122093509218304', '1201', '286121853485977600', '使用中'), ('286122167677095936', '1202', '286121853485977600', '禁用中');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
