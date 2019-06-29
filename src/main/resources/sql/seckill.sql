/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : seckill

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 27/06/2019 10:11:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `reciver_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `reciver_phone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '收货人电话',
  `reciver_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人详细地址',
  `post_no` int(11) NULL DEFAULT NULL COMMENT '邮编',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `goods_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goods_stock` int(10) NULL DEFAULT NULL COMMENT '商品库存',
  `goods_img` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '笔记本电脑', 1.00, '办公本', 1, 'product01.png');
INSERT INTO `goods` VALUES (2, '游戏耳机', 2.00, '游戏必备', 2, 'product02.png');
INSERT INTO `goods` VALUES (3, '办公笔记本', 3.00, '办公必备', 3, 'product03.png');
INSERT INTO `goods` VALUES (4, '平板', 4.00, '办公游戏两不误', 4, 'product04.png');
INSERT INTO `goods` VALUES (5, '耳机', 5.00, '闭耳试耳机', 5, 'product05.png');
INSERT INTO `goods` VALUES (6, '超级游戏本', 6.00, '游戏必备', 6, 'product06.png');
INSERT INTO `goods` VALUES (7, '三星手机', 7.00, '高端智能机', 7, 'product07.png');
INSERT INTO `goods` VALUES (8, '华硕笔记本', 8.00, '游戏必备', 8, 'product08.png');
INSERT INTO `goods` VALUES (9, '数码相机', 9.00, '光学变焦', 9, 'product09.png');

-- ----------------------------
-- Table structure for miaosha_goods
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_goods`;
CREATE TABLE `miaosha_goods`  (
  `miaoshagoods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `miaosha_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '秒杀价格',
  `miaosha_stock` int(10) NULL DEFAULT NULL COMMENT '秒杀库存',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`miaoshagoods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of miaosha_goods
-- ----------------------------
INSERT INTO `miaosha_goods` VALUES (1, 8, 1.00, 10, '2019-06-30 15:28:32', '2019-07-01 15:28:34');
INSERT INTO `miaosha_goods` VALUES (2, 3, 2.00, 10, '2019-06-12 19:03:20', '2019-06-30 19:03:24');
INSERT INTO `miaosha_goods` VALUES (3, 5, 3.00, 10, '2019-06-19 23:10:00', '2019-06-30 19:03:54');
INSERT INTO `miaosha_goods` VALUES (4, 6, 4.00, 10, '2019-06-21 14:36:21', '2019-07-04 14:36:23');
INSERT INTO `miaosha_goods` VALUES (5, 2, 5.00, 10, '2019-06-22 14:36:40', '2019-06-29 14:36:43');
INSERT INTO `miaosha_goods` VALUES (6, 7, 6.00, 10, '2019-06-22 14:36:48', '2019-07-02 14:36:51');
INSERT INTO `miaosha_goods` VALUES (7, 1, 7.00, 10, '2019-06-18 14:37:00', '2019-06-25 14:37:04');
INSERT INTO `miaosha_goods` VALUES (8, 9, 8.00, 10, '2019-06-23 14:37:10', '2019-06-25 14:37:14');
INSERT INTO `miaosha_goods` VALUES (9, 4, 9.00, 10, '2019-05-28 14:37:31', '2019-06-25 14:37:36');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '订单编号',
  `address_id` int(10) NULL DEFAULT NULL COMMENT '地址id',
  `goods_id` int(10) NULL DEFAULT NULL COMMENT '商品id',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `buy_count` int(10) NULL DEFAULT NULL COMMENT '商品数量',
  `order_pay_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '商品交易号',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户名 ',
  `user_pwd` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户密码',
  `regist_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  `user_email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
