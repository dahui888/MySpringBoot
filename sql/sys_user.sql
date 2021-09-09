/*
 Navicat Premium Data Transfer

 Source Server         : 47.103.20.21-zlp
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.103.20.21:3307
 Source Schema         : zlp-mall

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 11/03/2021 19:43:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_type` int(2) NOT NULL DEFAULT 1 COMMENT '用户类型 （0：管理员；1：普通用户）',
  `status` int(2) NOT NULL DEFAULT 0 COMMENT '状态(0:正常,1:删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', 0, 0, '2020-09-11 13:24:22', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2, '张明芬', 'e10adc3949ba59abbe56e057f20f883e', '张明芬', 1, 0, '2021-03-01 15:08:58', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (3, '张龙飞', 'e10adc3949ba59abbe56e057f20f883e', '张龙飞', 1, 0, '2021-03-01 15:09:38', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4, '18787676767', 'e10adc3949ba59abbe56e057f20f883e', 'wanglele', 1, 0, '2021-03-02 14:25:27', 'admin', NULL, NULL);
INSERT INTO `sys_user` VALUES (5, 'test', 'e10adc3949ba59abbe56e057f20f883e', 'test', 1, 0, '2021-03-02 14:35:12', 'admin', '2021-03-05 16:51:48', 'admin');
INSERT INTO `sys_user` VALUES (7, 'ztest', 'e10adc3949ba59abbe56e057f20f883e', 'zouliping02', 1, 0, '2021-03-08 10:01:22', 'admin', '2021-03-09 11:19:33', 'admin');
INSERT INTO `sys_user` VALUES (8, 'wangyy', '69fb53081154c087836324ef08c6b0fa', 'wangyy', 1, 0, '2021-03-08 10:05:56', 'admin', '2021-03-09 11:29:28', 'admin');
INSERT INTO `sys_user` VALUES (9, 'wangy', '202cb962ac59075b964b07152d234b70', 'ww', 1, 0, '2021-03-09 11:30:00', 'admin', '2021-03-09 11:30:08', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
