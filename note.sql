/*
 Navicat Premium Data Transfer

 Source Server         : Roxi
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : note

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 20/04/2019 21:56:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for entiy
-- ----------------------------
DROP TABLE IF EXISTS `entiy`;
CREATE TABLE `entiy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `counts` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entiy
-- ----------------------------
INSERT INTO `entiy` VALUES (1, '生物信息学院', 3);
INSERT INTO `entiy` VALUES (2, '通信信息学院', 1);
INSERT INTO `entiy` VALUES (3, '安法学院', 2);
INSERT INTO `entiy` VALUES (4, '外国语学院', 0);
INSERT INTO `entiy` VALUES (5, '先进制造学院', 0);
INSERT INTO `entiy` VALUES (6, '光电学院', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `openId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ticket` int(40) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_openid`(`openId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (17, 'orIag512Yx5TntNgAITKu67xK4yY', 5);

-- ----------------------------
-- Table structure for votes
-- ----------------------------
DROP TABLE IF EXISTS `votes`;
CREATE TABLE `votes`  (
  `id` int(80) NOT NULL AUTO_INCREMENT,
  `uid` int(50) NOT NULL,
  `entiyId` int(50) NOT NULL,
  `timestamp` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_uid`(`uid`) USING BTREE,
  INDEX `index_entiy_id`(`entiyId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of votes
-- ----------------------------
INSERT INTO `votes` VALUES (1, 17, 2, '1555766567510');
INSERT INTO `votes` VALUES (2, 17, 3, '1555767422020');
INSERT INTO `votes` VALUES (3, 17, 6, '1555767737063');

SET FOREIGN_KEY_CHECKS = 1;
