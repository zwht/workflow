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

 Date: 29/09/2019 09:49:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zs_ticket
-- ----------------------------
DROP TABLE IF EXISTS `zs_ticket`;
CREATE TABLE `zs_ticket` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL COMMENT '订单编号',
  `corporation_id` bigint(20) DEFAULT NULL COMMENT '公司',
  `dealers_id` bigint(20) DEFAULT NULL COMMENT '经销商',
  `market_id` bigint(20) DEFAULT NULL COMMENT '销售',
  `edit_id` bigint(20) DEFAULT NULL COMMENT '编辑人员',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌',
  `product_ids` varchar(450) DEFAULT NULL COMMENT '产品id列表',
  `odd` varchar(45) DEFAULT NULL,
  `address` varchar(450) DEFAULT NULL,
  `state` smallint(6) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL COMMENT '订单类型',
  `priority` smallint(6) DEFAULT NULL COMMENT '优先级',
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `over_time` timestamp NULL DEFAULT NULL,
  `pay` decimal(20,4) DEFAULT NULL,
  `sum_door` float DEFAULT NULL,
  `sum_taoban` float DEFAULT NULL,
  `sum_line` float DEFAULT NULL,
  `flag` smallint(6) DEFAULT NULL COMMENT '逻辑删除',
  `summary` varchar(150) DEFAULT NULL COMMENT '总结',
  `remarks` varchar(150) DEFAULT NULL COMMENT '备注',
  `edit_name` varchar(20) DEFAULT NULL COMMENT '编辑人名字',
  `earnest` decimal(20,4) DEFAULT NULL COMMENT '定金',
  `payment` decimal(20,4) DEFAULT NULL COMMENT '尾款',
  `back_describe` varchar(2000) DEFAULT NULL COMMENT '回单描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
