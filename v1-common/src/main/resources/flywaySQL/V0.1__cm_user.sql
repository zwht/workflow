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

 Date: 12/05/2019 18:32:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cm_user
-- ----------------------------
DROP TABLE IF EXISTS `cm_user`;
CREATE TABLE `cm_user` (
  `id` bigint(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '真实名',
  `login_name` varchar(20) DEFAULT NULL COMMENT '登录名',
  `state` smallint(6) DEFAULT NULL COMMENT '状态',
  `ability` varchar(80) DEFAULT NULL COMMENT '权限能力',
  `roles` varchar(80) DEFAULT NULL COMMENT '角色',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `password_key` varchar(5) DEFAULT NULL COMMENT '密码Key',
  `corporation_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `phone` varchar(11) DEFAULT NULL,
  `img_id` varchar(100) DEFAULT NULL COMMENT '头像',
  `flag` smallint(6) DEFAULT NULL COMMENT '逻辑删除',
  `gx_ids` varchar(240) DEFAULT NULL COMMENT '员工工序ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cm_user
-- ----------------------------
BEGIN;
INSERT INTO `cm_user` VALUES (273817093102596096, '赵伟', 'zw', 1001, '1', '888888', 'gOuIeVBcEKg2bWDor0A2MA==', '99lC', NULL, '13540416116', NULL, NULL, NULL);
INSERT INTO `cm_user` VALUES (273827093102596096, '王君', '王君', 1001, NULL, '103,101', 'FjvRDmxMD2A3DcnnsNfIjQ==', '1Qy3', 274257007794589696, '13540416116', NULL, NULL, NULL);
INSERT INTO `cm_user` VALUES (274345799314444288, '赵静', 'zhaojing', 1001, NULL, '100', 'vT7jWpXyK8Gvzg8TfyGx2Q==', 'D14Q', 274257007794589696, '13540416116', NULL, NULL, NULL);
INSERT INTO `cm_user` VALUES (274346273346293760, '销售', 'xiaoshou', 1001, NULL, '101', 'YBfZaw1GVKMnsGIAD1fcRg==', '4L9p', 274257007794589696, '13540416116', NULL, NULL, NULL);
INSERT INTO `cm_user` VALUES (325019201095995392, '经销商', '经销商', 1001, NULL, '102', 'Vjlk74jgU3QSvVKg5q4HTg==', 'LIc0', 274257007794589696, '13540416116', NULL, NULL, NULL);
INSERT INTO `cm_user` VALUES (329966652353548288, '下料', '下料', 1001, NULL, '106', '+xp1OpQZoQaeo949Mqv5uQ==', 'yvg3', 274257007794589696, '13540416116', NULL, NULL, '[\"286212849657843712\"]');
INSERT INTO `cm_user` VALUES (329966882364985344, '单套', '单套', 1001, NULL, '106', 'eEKkjGjbZVNNfIX+w6ctkw==', 'b6ZW', 274257007794589696, '13540416116', NULL, NULL, '[\"286212903428820992\"]');
INSERT INTO `cm_user` VALUES (329967015764824064, '雕刻', '雕刻', 1001, NULL, '106', '32+ebDRIiKsiQbho2AK6ZQ==', 'lEd4', 274257007794589696, '13540416116', NULL, NULL, '[\"286212949171900416\"]');
INSERT INTO `cm_user` VALUES (329967172166225920, '抓架子', '抓架子', 1001, NULL, '106', 'ubcSDeX0IenSZsWUpHkJuw==', 'Pu93', 274257007794589696, '13540416116', NULL, NULL, '[\"286212998249451520\"]');
INSERT INTO `cm_user` VALUES (329967285232078848, '压机', '压机', 1001, NULL, '106', 'nh5+z7RPy6Gw4qIuDPM3wA==', '0WWT', 274257007794589696, '13540416116', NULL, NULL, '[\"286213045905133568\"]');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
