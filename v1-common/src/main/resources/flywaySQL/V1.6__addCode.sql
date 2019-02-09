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
INSERT INTO `cm_code` VALUES ('291175793030205440', '1401', '291175579326222336', '使用中'), ('291175917697503232', '1402', '291175579326222336', '禁用中');
COMMIT;
BEGIN;
INSERT INTO `cm_code_group` VALUES ('291175579326222336', '14', '门状态');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
