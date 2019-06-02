/*
Navicat MySQL Data Transfer

Source Server         : localhost_3305
Source Server Version : 50636
Source Host           : localhost:3305
Source Database       : atm_simulator_system

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-07-12 11:32:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `acc_info`
-- ----------------------------
DROP TABLE IF EXISTS `acc_info`;
CREATE TABLE `acc_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`card_no`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`trans_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`date_time`  datetime NULL DEFAULT NULL ,
`amount`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=29

;

-- ----------------------------
-- Records of acc_info
-- ----------------------------
BEGIN;
INSERT INTO `acc_info` VALUES ('26', '5708761673964397', 'deposit', '2017-07-11 18:53:04', '10000'), ('27', '5708761673964397', 'withdraw', '2017-07-11 18:55:24', '5000'), ('28', '5708761673964397', 'withdraw', '2017-07-11 18:55:55', '100');
COMMIT;

-- ----------------------------
-- Table structure for `balance`
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`card_no`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`balance`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=25

;

-- ----------------------------
-- Records of balance
-- ----------------------------
BEGIN;
INSERT INTO `balance` VALUES ('24', '5708761673964397', '4900');
COMMIT;

-- ----------------------------
-- Table structure for `person_info`
-- ----------------------------
DROP TABLE IF EXISTS `person_info`;
CREATE TABLE `person_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`father`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dob`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`gender`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`email`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`marital`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`city`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`pincode`  int(11) NULL DEFAULT NULL ,
`state`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`religion`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`category`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`income`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`qualification`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`occupation`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`pan`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`adhar`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sc`  varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ea`  varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`acctype`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`card_no`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`password`  int(11) NULL DEFAULT NULL ,
`sr`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of person_info
-- ----------------------------
BEGIN;
INSERT INTO `person_info` VALUES ('2', 'payush', 'bhushan kumar', '1996-August-20', 'Male', 'payushbathla20aug@gmail.com', 'Unmarried', 'vpo khuian sarwar', 'abohar', '152128', 'Punjab', 'Hindu', 'General', 'Null', 'Non-Graduate', 'Student', '1234567891234567', '7894561231234567', 'no', 'no', 'saving acc', '5708761673964397', '4477', 'atm');
COMMIT;

-- ----------------------------
-- Auto increment value for `acc_info`
-- ----------------------------
ALTER TABLE `acc_info` AUTO_INCREMENT=29;

-- ----------------------------
-- Auto increment value for `balance`
-- ----------------------------
ALTER TABLE `balance` AUTO_INCREMENT=25;

-- ----------------------------
-- Auto increment value for `person_info`
-- ----------------------------
ALTER TABLE `person_info` AUTO_INCREMENT=3;
