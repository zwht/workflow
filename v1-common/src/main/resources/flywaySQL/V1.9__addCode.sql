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
--  Records of `cm_code`
-- ----------------------------
BEGIN;
INSERT INTO `cm_code` VALUES ('291996779824680960', '1301', '291996688304967680', '门'), ('291996888528457728', '1302', '291996688304967680', '门套'), ('292087903306256384', '1350', '291996688304967680', '颜色'), ('292087983421657088', '1360', '291996688304967680', '材质');
COMMIT;
BEGIN;
INSERT INTO `cm_code_group` VALUES ('291996688304967680', '13', '计价类型');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;