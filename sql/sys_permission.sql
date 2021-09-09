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

 Date: 11/03/2021 19:43:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `permission_value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` int(1) NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `data_type` int(1) NULL DEFAULT 0 COMMENT '权限数据类型：0->查看全部；1->查看自己数据权限',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前端资源路径',
  `permission_status` int(1) NOT NULL DEFAULT 1 COMMENT '启用状态；0->启用；1->禁用',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台用户权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 0, '设备', NULL, 'el-icon-s-grid', 0, 0, NULL, 0, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (2, 0, '客户', NULL, 'el-icon-s-cooperation', 0, 0, NULL, 0, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (3, 0, '客户账号', NULL, 'el-icon-s-custom', 0, 0, NULL, 0, 3, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (4, 0, '权限管理', NULL, NULL, 0, 0, NULL, 1, 4, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (5, 1, 'Co-Brain', NULL, NULL, 1, 0, '/coBrain', 0, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (6, 2, '机构管理', NULL, NULL, 1, 0, '/organMgt', 0, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (7, 2, '机构审核', NULL, NULL, 1, 0, '/organAudit', 0, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (8, 3, '账号管理', NULL, NULL, 1, 0, '/accountMgt', 0, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (9, 4, '账号管理', NULL, NULL, 1, 0, '/user', 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (10, 4, '权限管理', NULL, NULL, 1, 0, '/roleMgt', 1, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (11, 5, '搜索', '\r\nequipment:search', NULL, 2, 0, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (12, 5, '添加设备', 'equipment:add', NULL, 2, 0, NULL, 0, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (13, 5, '删除设备', 'equipment:del', NULL, 2, 0, NULL, 0, 3, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (14, 5, '详情', 'equipment:info', NULL, 2, 0, NULL, 1, 4, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (15, 5, '维修设置', 'equipment:repair', NULL, 2, 0, NULL, 0, 5, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (16, 5, '启用设备', 'equipment:enable', NULL, 2, 0, NULL, 0, 6, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (17, 5, '(协议)-详情', 'equipment:agreementInfo', NULL, 2, 0, NULL, 1, 7, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (18, 6, '搜索', 'organ:search', NULL, 2, 0, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (19, 6, '添加机构', 'organ:add', NULL, 2, 0, NULL, 0, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (20, 6, '详情', 'organ:info', NULL, 2, 0, NULL, 1, 3, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (21, 6, '编辑资料', 'organ:update', NULL, 2, 0, NULL, 0, 4, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (22, 6, '创建协议', 'organ:createEquipment', NULL, 2, 0, NULL, 0, 5, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (23, 6, '(协议)-开启关闭', 'organ:agreement:enable', NULL, 2, 0, NULL, 1, 6, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (24, 6, '编辑协议', 'organ:agreement:update', NULL, 2, 0, NULL, 0, 7, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (25, 6, '(协议)-关联设备', 'organ:agreement:bulidEqu', NULL, 2, 0, NULL, 1, 8, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (26, 6, '(协议)-详情', 'organ:agreement:info', NULL, 2, 0, NULL, 1, 9, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (27, 6, '(协议)-确认关联', 'organ:agreement:union', NULL, 2, 0, NULL, 1, 10, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (28, 6, '(协议)-确认终止', 'organ:agreement:termination', NULL, 2, 0, NULL, 1, 11, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (29, 7, '搜索', 'organApprove:search', NULL, 2, 0, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (30, 7, '详情', 'organApprove:info', NULL, 2, 0, NULL, 1, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (31, 7, '账号信息', 'organApprove:accountInfo', NULL, 2, 0, NULL, 1, 3, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (32, 7, '编辑', 'organApprove:update', NULL, 2, 0, NULL, 1, 4, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (33, 8, '搜索', 'customer:search', NULL, 2, 0, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (34, 8, '修改', 'customer:update', NULL, 2, 0, NULL, 1, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (35, 9, '搜索', 'user:search', NULL, 2, 0, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (36, 9, '创建账号', 'user:create', NULL, 2, 0, NULL, 1, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (37, 9, '修改', 'user:update', NULL, 2, 0, NULL, 1, 3, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (38, 10, '搜索', 'role:search', NULL, 2, 0, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (39, 10, '创建马甲', 'role:create', NULL, 2, 0, NULL, 1, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (40, 10, '修改', 'role:update', NULL, 2, 0, NULL, 1, 3, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (41, 6, '搜索', 'organ:search', NULL, 2, 1, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (52, 6, '搜索', 'organ:search', NULL, 2, 1, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (53, 6, '添加机构', 'organ:add', NULL, 2, 1, NULL, 0, 2, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (54, 6, '详情', 'organ:info', NULL, 2, 1, NULL, 1, 3, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (55, 6, '编辑资料', 'organ:update', NULL, 2, 1, NULL, 0, 4, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (56, 6, '创建协议', 'organ:createEquipment', NULL, 2, 1, NULL, 0, 5, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (57, 6, '(协议)-开启关闭', 'organ:agreement:enable', NULL, 2, 1, NULL, 1, 6, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (58, 6, '编辑协议', 'organ:agreement:update', NULL, 2, 1, NULL, 0, 7, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (59, 6, '(协议)-关联设备', 'organ:agreement:bulidEqu', NULL, 2, 1, NULL, 1, 8, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (60, 6, '(协议)-详情', 'organ:agreement:info', NULL, 2, 1, NULL, 1, 9, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (61, 6, '(协议)-确认关联', 'organ:agreement:union', NULL, 2, 1, NULL, 1, 10, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (62, 6, '(协议)-确认终止', 'organ:agreement:termination', NULL, 2, 1, NULL, 1, 11, '2021-03-03 11:36:58', 'admin', NULL, NULL);
INSERT INTO `sys_permission` VALUES (63, 6, '搜索', 'organ:search', NULL, 2, 1, NULL, 1, 1, '2021-03-03 11:36:58', 'admin', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
