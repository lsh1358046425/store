/*
Navicat MySQL Data Transfer

Source Server         : wampMysql
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-07-27 11:17:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `admin_password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `store`.`admin`(`admin_name`, `admin_password`) VALUES ('admin', 'ba858a7d5ae115fa8f937ffbea53b360');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `cart_num` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `cart_user_id` (`user_id`) USING BTREE,
  KEY `cart_good_id` (`good_id`) USING BTREE,
  CONSTRAINT `cart_good_id` FOREIGN KEY (`good_id`) REFERENCES `good` (`good_id`),
  CONSTRAINT `cart_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `category_hot` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `focus_id` int(11) NOT NULL AUTO_INCREMENT,
  `good_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `focus_time` datetime DEFAULT NULL,
  PRIMARY KEY (`focus_id`),
  KEY `focu_good_id` (`good_id`) USING BTREE,
  KEY `focu_user_id` (`user_id`) USING BTREE,
  CONSTRAINT `focus_good_id` FOREIGN KEY (`good_id`) REFERENCES `good` (`good_id`),
  CONSTRAINT `focus_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `good_id` int(11) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `good_price` double DEFAULT NULL,
  `good_picture` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`good_id`),
  KEY `good_category_id` (`category_id`) USING BTREE,
  CONSTRAINT `good_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `notice_content` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `notice_time` datetime DEFAULT NULL,
  `notice_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `orderDetail_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(43) COLLATE utf8_unicode_ci NOT NULL,
  `good_id` int(11) NOT NULL,
  `orderDetail_num` int(11) NOT NULL,
  PRIMARY KEY (`orderDetail_id`),
  KEY `orderdetail_order_id` (`order_id`) USING BTREE,
  KEY `orderdetail_good_id` (`good_id`) USING BTREE,
  CONSTRAINT `orderDetail_good_id` FOREIGN KEY (`good_id`) REFERENCES `good` (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(43) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `order_amount` double NOT NULL,
  `order_status` tinyint(4) NOT NULL DEFAULT '0',
  `order_date` datetime NOT NULL,
  `order_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_user_id` (`user_id`) USING BTREE,
  CONSTRAINT `orders_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `store`.`user`(`user_id`, `user_name`, `user_password`, `user_email`, `user_status`) VALUES (1, 'user', 'ba858a7d5ae115fa8f937ffbea53b360', NULL, 1);

