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

 Date: 12/29/2018 22:11:30 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cm_user`
-- ----------------------------
DROP TABLE IF EXISTS `cm_user`;
CREATE TABLE `cm_user` (
  `id` bigint(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '真实名',
  `login_name` varchar(20) DEFAULT NULL COMMENT '登录名',
  `state` smallint(6) DEFAULT NULL COMMENT '状态',
  `ability` varchar(45) DEFAULT NULL COMMENT '权限能力',
  `roles` varchar(40) DEFAULT NULL COMMENT '角色',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `password_key` varchar(5) DEFAULT NULL COMMENT '密码Key',
  `corporation_id` varchar(45) DEFAULT NULL COMMENT '公司ID',
  `phone` varchar(11) DEFAULT NULL,
  `img_id` varchar(100) DEFAULT NULL COMMENT '头像',
  `flag` smallint(6) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cm_user`
-- ----------------------------
BEGIN;
INSERT INTO `cm_user` VALUES ('273817093102596096', '赵伟', 'zw', '1001', '1', '888888', 'gOuIeVBcEKg2bWDor0A2MA==', '99lC', '', '13540416116', null, null), ('273827093102596096', '何婷', 'ht', '1001', null, '103,101', 'FjvRDmxMD2A3DcnnsNfIjQ==', '1Qy3', '274257007794589696', '13540416116', null, null), ('274345799314444288', '赵静', 'zhaojing', '1001', null, '100', 'vT7jWpXyK8Gvzg8TfyGx2Q==', 'D14Q', '274257007794589696', '13540416116', null, null), ('274346273346293760', '销售', 'xiaoshou', '1001', null, '101', 'YBfZaw1GVKMnsGIAD1fcRg==', '4L9p', '274257007794589696', '13540416116', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
