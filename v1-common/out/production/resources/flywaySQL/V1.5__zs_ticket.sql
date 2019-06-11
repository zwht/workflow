/*
 Navicat Premium Data Transfer

 Source Server         : cfmy
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : cfmy1

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 01/23/2019 21:11:47 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `zs_ticket`
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
