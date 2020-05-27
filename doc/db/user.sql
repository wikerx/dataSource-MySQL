/*
Navicat MySQL Data Transfer

Source Server         : 本机MySQL
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : master

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2019-10-10 09:28:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `age` int(11) default NULL COMMENT '年龄',
  `password` varchar(32) default NULL COMMENT '密码',
  `sex` int(11) default NULL COMMENT '性别',
  `username` varchar(32) default NULL COMMENT '用户名',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
