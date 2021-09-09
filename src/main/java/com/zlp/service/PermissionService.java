package com.zlp.service;

import com.zlp.dto.PermissionForestTree;
import com.zlp.dto.PermissionTreeReq;
import com.zlp.dto.PermissionTreeResp;
import com.zlp.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务类
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-03-09
 */
public interface PermissionService extends IService<Permission> {

    /** 
     * 获取权限树结构
     * @param roleId
     * @date: 2021/3/9 14:33
     * @return: java.util.List<com.zlp.dto.PermissionTreeResp> 
     */
    List<PermissionTreeResp> getPermissionTreeList(Long roleId);

    /**
     * 保存权限
     * @param permissionTreeReq
     * @date: 2021/3/9 21:32
     * @return: java.lang.Boolean
     */
    Boolean savePermission(PermissionTreeReq permissionTreeReq);

    /**
     * 获取深林树形权限列表
     * @param roleId
     * @date: 2021/3/10 10:23
     * @return: java.util.List<com.zlp.dto.PermissionForestTree>
     */
    List<PermissionForestTree> getPermissionForestTreeList(Long roleId);
}
