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
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `door_id` varchar(20) DEFAULT NULL,
  `process_ids` varchar(450) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `mark` varchar(450) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `corporation_id` varchar(45) DEFAULT NULL,
  `cover_width` int(11) DEFAULT NULL,
  `cover_height` int(11) DEFAULT NULL,
  `cover_depth` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `lb_width` int(11) DEFAULT NULL,
  `lb_height` int(11) DEFAULT NULL,
  `db_width` int(11) DEFAULT NULL,
  `db_height` int(11) DEFAULT NULL,
  `color_id` varchar(45) DEFAULT NULL,
  `line_id` varchar(45) DEFAULT NULL,
  `line_sum` int(11) DEFAULT NULL,
  `productcol` varchar(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `module_id` varchar(45) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `lb_sum` int(11) DEFAULT NULL,
  `db_sum` int(11) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `line_length` int(11) DEFAULT NULL,
  `ticket_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
