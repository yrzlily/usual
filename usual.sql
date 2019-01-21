/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : usual

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-01-21 11:37:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('39');

-- ----------------------------
-- Table structure for us_admin_nav
-- ----------------------------
DROP TABLE IF EXISTS `us_admin_nav`;
CREATE TABLE `us_admin_nav` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nav_name` varchar(255) NOT NULL COMMENT '导航名称',
  `nav_parent_id` int(11) NOT NULL COMMENT '上级id',
  `url` varchar(50) DEFAULT NULL COMMENT '地址栏',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int(5) NOT NULL DEFAULT '0' COMMENT '导航排序',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_admin_nav
-- ----------------------------
INSERT INTO `us_admin_nav` VALUES ('1', '内容', '0', null, 'layui-icon-list', '0', '2018-11-20 13:22:05');
INSERT INTO `us_admin_nav` VALUES ('2', '分类', '1', '/admin/cate/index', '', '0', '2018-11-21 09:47:08');
INSERT INTO `us_admin_nav` VALUES ('3', '用户', '0', null, 'layui-icon-user', '0', '2018-11-20 13:22:04');
INSERT INTO `us_admin_nav` VALUES ('4', '管理员列表', '3', '/admin/user/index', null, '0', '2018-11-20 13:21:37');
INSERT INTO `us_admin_nav` VALUES ('5', '配置', '0', null, 'layui-icon-set', '0', '2018-11-20 16:19:01');
INSERT INTO `us_admin_nav` VALUES ('6', '导航', '5', '/admin/nav/index', null, '0', '2018-11-20 16:20:15');
INSERT INTO `us_admin_nav` VALUES ('34', '帖子管理', '1', '/admin/posts/index', '', '1', '2019-01-18 09:58:39');
INSERT INTO `us_admin_nav` VALUES ('38', '在线用户', '3', '/admin/char/index', '', '1', '2019-01-18 11:12:06');

-- ----------------------------
-- Table structure for us_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `us_admin_user`;
CREATE TABLE `us_admin_user` (
  `id` int(11) NOT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_admin_user
-- ----------------------------
INSERT INTO `us_admin_user` VALUES ('1', '$2a$10$/LrR6E9O.44sTPf1d1IE/OtU1UP6wAs/pNT0TgqPf3WHsQe9i/yTe', 'admin');

-- ----------------------------
-- Table structure for us_category
-- ----------------------------
DROP TABLE IF EXISTS `us_category`;
CREATE TABLE `us_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '类型名称',
  `parent_id` int(11) NOT NULL COMMENT '父类 0=顶级',
  `sort` int(10) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_category
-- ----------------------------
INSERT INTO `us_category` VALUES ('1', '顶级分类', '0', '0');
INSERT INTO `us_category` VALUES ('2', '顶级分类2', '0', '0');
INSERT INTO `us_category` VALUES ('3', '子栏目1', '1', '0');
INSERT INTO `us_category` VALUES ('4', '子栏目2', '1', '1');
INSERT INTO `us_category` VALUES ('5', '子栏目1', '2', '0');
INSERT INTO `us_category` VALUES ('6', '三级栏目', '3', '0');
INSERT INTO `us_category` VALUES ('17', '子栏目3', '1', '2');

-- ----------------------------
-- Table structure for us_classify
-- ----------------------------
DROP TABLE IF EXISTS `us_classify`;
CREATE TABLE `us_classify` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '分类名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `pid` int(10) NOT NULL DEFAULT '0' COMMENT '分类父级id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='帖子分类';

-- ----------------------------
-- Records of us_classify
-- ----------------------------
INSERT INTO `us_classify` VALUES ('1', 'Discussion1', '2018-12-13 16:41:10', '2018-12-18 15:30:50', '0');
INSERT INTO `us_classify` VALUES ('2', 'Q&A', '2018-12-13 16:42:20', '2018-12-13 16:42:20', '1');
INSERT INTO `us_classify` VALUES ('3', 'Activity', '2018-12-13 16:42:20', '2018-12-18 08:26:51', '1');
INSERT INTO `us_classify` VALUES ('4', 'Flats', '2018-12-13 16:42:45', '2018-12-13 16:42:45', '0');
INSERT INTO `us_classify` VALUES ('5', 'Individual ', '2018-12-13 16:42:45', '2018-12-13 16:42:45', '4');
INSERT INTO `us_classify` VALUES ('6', 'Agent', '2018-12-13 16:43:36', '2018-12-13 16:43:36', '4');
INSERT INTO `us_classify` VALUES ('7', 'Jobs', '2018-12-13 16:43:36', '2018-12-14 09:47:48', '0');
INSERT INTO `us_classify` VALUES ('8', 'Buy & Sell', '2018-12-13 16:43:48', '2018-12-13 16:43:48', '0');

-- ----------------------------
-- Table structure for us_image
-- ----------------------------
DROP TABLE IF EXISTS `us_image`;
CREATE TABLE `us_image` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `name` varchar(500) CHARACTER SET utf8 NOT NULL COMMENT '图片名字',
  `src` varchar(500) CHARACTER SET utf8 NOT NULL COMMENT '图片路径',
  `size` int(11) NOT NULL COMMENT '图片大小',
  `posts_id` int(11) unsigned NOT NULL COMMENT '帖子id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `type` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '图片上传类型',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of us_image
-- ----------------------------
INSERT INTO `us_image` VALUES ('1', '666666666', '/static/upload/f96e2251-1699-4e32-a663-18e00dc9d53a.jpg', '32', '1', '2018-12-25 10:48:37', '2-0');
INSERT INTO `us_image` VALUES ('33', 'wxa34997c01638bb70.o6zAJs2uJyn8qPF-eyRcgO5oYAbQ.an09xu1ut16q47b3a6e0a2852cb6a72f3a1f6b1d2460.gif', '/static/upload/6b34408c-7e40-49bb-ba94-62a838c6b6d5.gif', '334834', '0', '2019-01-18 09:39:01', '');
INSERT INTO `us_image` VALUES ('21', 'wxa34997c01638bb70.o6zAJs2uJyn8qPF-eyRcgO5oYAbQ.96RybGrp0ylj47b3a6e0a2852cb6a72f3a1f6b1d2460.gif', '/static/upload/b5ce3d5f-bc26-46b0-a22d-0f02f5ff284d.gif', '334834', '24', '2019-01-16 17:49:17', '2-0');
INSERT INTO `us_image` VALUES ('22', 'wxa34997c01638bb70.o6zAJs2uJyn8qPF-eyRcgO5oYAbQ.X6pHrioDHVhE9e1a9d1d020131ace77306e8e5cc5d94.jpg', '/static/upload/f96e2251-1699-4e32-a663-18e00dc9d53a.jpg', '7689', '24', '2019-01-16 17:49:19', '2-0');

-- ----------------------------
-- Table structure for us_notification
-- ----------------------------
DROP TABLE IF EXISTS `us_notification`;
CREATE TABLE `us_notification` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `content` text CHARACTER SET utf8 NOT NULL COMMENT '通知内容',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '通知状态(1为正常，0为屏蔽)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of us_notification
-- ----------------------------
INSERT INTO `us_notification` VALUES ('1', '号外号外：火可以试金，金可以试女人，女人可以试男人。', '1', '2018-12-27 16:00:52');

-- ----------------------------
-- Table structure for us_posts
-- ----------------------------
DROP TABLE IF EXISTS `us_posts`;
CREATE TABLE `us_posts` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `classify_id` int(11) unsigned NOT NULL COMMENT '分类id',
  `title` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '帖子标题',
  `content` text CHARACTER SET utf8mb4 NOT NULL COMMENT '帖子内容',
  `start` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '帖子点赞数',
  `pageview` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '帖子阅读数',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '帖子审核状态(0未审核，1已审核)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `audit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '帖子审核时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1 COMMENT='帖子表';

-- ----------------------------
-- Records of us_posts
-- ----------------------------
INSERT INTO `us_posts` VALUES ('1', '7', '2', 'test', '最近很流行一句话：“如果我用你待我的方式来待你，恐怕你早已离去”。', '0', '0', '1', '2019-01-18 11:01:57', '2018-12-18 14:03:50', '2018-12-17 11:00:31');
INSERT INTO `us_posts` VALUES ('20', '7', '2', '', 'test', '0', '0', '1', '2019-01-18 11:01:56', '2019-01-16 17:48:55', '2019-01-16 17:48:55');
INSERT INTO `us_posts` VALUES ('23', '7', '2', '', 'test', '0', '0', '1', '2019-01-18 11:01:55', '2019-01-16 17:49:21', '2019-01-16 17:49:21');
INSERT INTO `us_posts` VALUES ('24', '7', '2', '', 'test', '0', '0', '3', '2019-01-18 11:09:08', '2019-01-16 17:50:34', '2019-01-16 17:50:34');

-- ----------------------------
-- Table structure for us_reply
-- ----------------------------
DROP TABLE IF EXISTS `us_reply`;
CREATE TABLE `us_reply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `posts_id` int(10) unsigned NOT NULL COMMENT '帖子id',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `content` text CHARACTER SET utf8mb4 COMMENT '回复内容',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of us_reply
-- ----------------------------
INSERT INTO `us_reply` VALUES ('1', '1', '7', '说的好', '1', '2019-01-17 08:58:36');
INSERT INTO `us_reply` VALUES ('2', '1', '7', '好吗', '1', '2019-01-17 08:58:37');
INSERT INTO `us_reply` VALUES ('3', '1', '7', '鸡汤要趁热', '0', '2019-01-18 09:49:45');
INSERT INTO `us_reply` VALUES ('32', '20', '7', '2323232323', '1', '2019-01-17 15:59:00');

-- ----------------------------
-- Table structure for us_user
-- ----------------------------
DROP TABLE IF EXISTS `us_user`;
CREATE TABLE `us_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '姓名',
  `openid` varchar(32) CHARACTER SET utf8mb4 NOT NULL COMMENT 'openid',
  `nickname` varchar(125) CHARACTER SET utf8mb4 NOT NULL COMMENT '微信昵称',
  `gender` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别',
  `city` varchar(125) CHARACTER SET utf8mb4 NOT NULL COMMENT '城市',
  `avatar` varchar(256) CHARACTER SET utf8mb4 NOT NULL COMMENT '头像',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '状态',
  `group_id` tinyint(1) unsigned NOT NULL DEFAULT '2' COMMENT '身份(是否为VIP)',
  PRIMARY KEY (`id`),
  KEY `openid` (`openid`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COMMENT='用户表';

-- ----------------------------
-- Records of us_user
-- ----------------------------
INSERT INTO `us_user` VALUES ('7', '', 'oWKoN0RPoAe7mWdXSTYAg_7s7_9s', '?', '1', '赣州', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJvX1cIkJ6nLjHgzjWs2YtwB5NECaibS3fqotHLM3nYdaC0fll1f5iarGe2cic18UsuwuxDN3pb25BpQ/132', '2019-01-16 11:32:33', '0000-00-00 00:00:00', '0', '2');
