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

 Date: 01/23/2019 21:11:39 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `zs_product`
-- ----------------------------
DROP TABLE IF EXISTS `zs_product`;
CREATE TABLE `zs_product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `door_id` bigint(20) DEFAULT NULL,
  `process_ids` varchar(450) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `mark` varchar(450) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `corporation_id` bigint(20) DEFAULT NULL,
  `cover_width` int(11) DEFAULT NULL,
  `cover_height` int(11) DEFAULT NULL,
  `cover_depth` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `lb_width` int(11) DEFAULT NULL,
  `lb_height` int(11) DEFAULT NULL,
  `db_width` int(11) DEFAULT NULL,
  `db_height` int(11) DEFAULT NULL,
  `color_id` bigint(20) DEFAULT NULL,
  `line_id` bigint(20) DEFAULT NULL,
  `line_sum` int(11) DEFAULT NULL,
  `productcol` varchar(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `module_id` bigint(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `lb_sum` int(11) DEFAULT NULL,
  `db_sum` int(11) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `line_length` int(11) DEFAULT NULL,
  `ticket_id` bigint(20) DEFAULT NULL,
  `index_key` smallint(6) DEFAULT NULL,
  `flag` smallint(6) DEFAULT NULL COMMENT '逻辑删除',
  `cover_size` varchar(25) DEFAULT NULL,
  `door_size` varchar(25) DEFAULT NULL,
  `lb_size` varchar(25) DEFAULT NULL,
  `db_size` varchar(25) DEFAULT NULL,
  `door` varchar(1035) DEFAULT NULL,
  `color` varchar(1035) DEFAULT NULL,
  `material` varchar(1035) DEFAULT NULL,
  `material_id` bigint(20) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `line` varchar(1035) DEFAULT NULL,
  `unit` varchar(1035) DEFAULT NULL COMMENT '单位',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `money` decimal(10,2) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
