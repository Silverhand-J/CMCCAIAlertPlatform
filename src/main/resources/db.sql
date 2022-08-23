/*
 Navicat Premium Data Transfer

 Source Server         : @localhost
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : db_alert_platform

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 23/08/2022 21:14:02
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_alert
-- ----------------------------
DROP TABLE IF EXISTS `t_alert`;
CREATE TABLE `t_alert`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `location`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '监控设备位置',
    `equipment_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '监控设备ID',
    `position`     varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '预置点位',
    `time`         datetime NULL DEFAULT NULL COMMENT '预警时间',
    `img_src`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '预警图片存放位置',
    `state`        int NULL DEFAULT NULL COMMENT '预警处理结果:  1.误报 2.真实 3.未处理',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_alert
-- ----------------------------
INSERT INTO `t_alert`
VALUES (1, '杭州市-西湖区-三墩镇-西园七路中国移动创新研究院', '33102403001310319221', '预置位1', '2022-08-10 17:57:46', 'test-1.jpg', 3);
INSERT INTO `t_alert`
VALUES (2, '杭州市-西湖区-三墩镇-西园七路中国移动创新研究院', '33102403001310319221', '预置位1', '2022-08-11 15:06:29', 'test-2.jpg', 3);
INSERT INTO `t_alert`
VALUES (3, '杭州市-西湖区-三墩镇-西园七路中国移动创新研究院', '33102403001310319221', '预置位1', '2022-08-11 15:07:15', 'test-3.jpg', 3);
INSERT INTO `t_alert`
VALUES (4, '台州市-仙居县-白塔镇-上村街-白塔汇聚基站', '33102403002311326254', '预置位2', '2022-08-11 15:08:25', 'test-4.jpg', 3);
INSERT INTO `t_alert`
VALUES (5, '台州市-仙居县-白塔镇-上村街-白塔汇聚基站', '33102403002311326254', '预置位2', '2022-08-11 15:15:12', 'test-5.jpg', 3);
INSERT INTO `t_alert`
VALUES (6, '台州市-仙居县-白塔镇-上村街-白塔汇聚基站', '33102403002311326254', '预置位2', '2022-08-11 15:15:41', 'test-6.jpg', 3);
INSERT INTO `t_alert`
VALUES (36, 'test1', '33102403001310319221', 'test1', '2022-08-11 15:06:29', 'test-1.jpg', 1);

-- ----------------------------
-- Table structure for t_openid
-- ----------------------------
DROP TABLE IF EXISTS `t_openid`;
CREATE TABLE `t_openid`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `openid`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信用户的openid',
    `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信用户的昵称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_openid
-- ----------------------------

SET
FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `Counters`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `count`     int(11) NOT NULL DEFAULT '1',
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

