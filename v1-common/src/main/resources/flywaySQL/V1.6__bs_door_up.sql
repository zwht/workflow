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

 Date: 14/11/2019 17:33:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

ALTER TABLE `bs_door` ADD `depth` int(4) DEFAULT NULL COMMENT '深度';
ALTER TABLE `bs_door` ADD `parent_id` bigint(20) DEFAULT NULL COMMENT '上级ID';
ALTER TABLE `bs_door` ADD `special` varchar(600) DEFAULT NULL COMMENT '特殊属性';

SET FOREIGN_KEY_CHECKS = 1;
