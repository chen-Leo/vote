/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : vote

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 21/04/2019 05:26:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for college_info
-- ----------------------------
DROP TABLE IF EXISTS `college_info`;
CREATE TABLE `college_info`  (
  `college_info_id` int(255) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `college_vote_num` int(11) NULL DEFAULT NULL,
  `score` double(11, 4) NULL DEFAULT NULL,
  `students_all_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`college_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_info
-- ----------------------------
INSERT INTO `college_info` VALUES (1, '先进制造工程学院', 0, 0.0000, 914);
INSERT INTO `college_info` VALUES (2, '体育学院', 5, 4.1322, 242);
INSERT INTO `college_info` VALUES (3, '国际半导体学院', 0, 0.0000, 835);
INSERT INTO `college_info` VALUES (4, '光电工程学院', 0, 0.0000, 1172);
INSERT INTO `college_info` VALUES (5, '外国语学院', 0, 0.0000, 302);
INSERT INTO `college_info` VALUES (6, '软件工程学院', 0, 0.0000, 1895);
INSERT INTO `college_info` VALUES (7, '计算机科学与技术学院', 0, 0.0000, 2368);
INSERT INTO `college_info` VALUES (8, '国际学院', 0, 0.0000, 764);
INSERT INTO `college_info` VALUES (9, '通信与信息工程学院', 0, 0.0000, 2502);
INSERT INTO `college_info` VALUES (10, '经济管理学院', 0, 0.0000, 1776);
INSERT INTO `college_info` VALUES (11, '现代邮政学院', 0, 0.0000, 370);
INSERT INTO `college_info` VALUES (12, '网络空间安全与学校法学院', 0, 0.0000, 744);
INSERT INTO `college_info` VALUES (13, '自动化学院', 0, 0.0000, 2214);
INSERT INTO `college_info` VALUES (14, '传媒艺术学院', 0, 0.0000, 2221);
INSERT INTO `college_info` VALUES (15, '理学院', 0, 0.0000, 730);
INSERT INTO `college_info` VALUES (16, '生物信息学院', 0, 0.0000, 660);

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `student_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (4, '2017213183', '体育学院');

-- ----------------------------
-- Table structure for vote_info
-- ----------------------------
DROP TABLE IF EXISTS `vote_info`;
CREATE TABLE `vote_info`  (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `vote_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`vote_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vote_info
-- ----------------------------
INSERT INTO `vote_info` VALUES (21, '2017213183', '体育学院', 1555788370);
INSERT INTO `vote_info` VALUES (22, '2017213183', '体育学院', 1555788699);
INSERT INTO `vote_info` VALUES (23, '2017213183', '体育学院', 1555788701);
INSERT INTO `vote_info` VALUES (24, '2017213183', '体育学院', 1555788702);
INSERT INTO `vote_info` VALUES (25, '2017213183', '体育学院', 1555788703);

SET FOREIGN_KEY_CHECKS = 1;
