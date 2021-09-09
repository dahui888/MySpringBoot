package com.zlp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlp.dto.PermissionForestTree;
import com.zlp.dto.PermissionTreeReq;
import com.zlp.dto.PermissionTreeResp;
import com.zlp.entity.Permission;
import com.zlp.enums.StatusEnum;
import com.zlp.common.exception.CustomException;
import com.zlp.mapper.PermissionMapper;
import com.zlp.service.PermissionService;
import com.zlp.utils.BeanToUtils;
import com.zlp.utils.MethodUtil;
import com.zlp.common.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-03-09
 */
@Service
@Slf4j(topic = "PermissionServiceImpl")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
        implements PermissionService {

    @Override
    public List<PermissionTreeResp> getPermissionTreeList(Long roleId) {

        log.info("getPermissionTreeList.req roleId={}", roleId);
        Wrapper<Permission> wapper = new QueryWrapper<>(new Permission())
                .eq("permission_status", StatusEnum.NORMAL.getValue());
        List<Permission> permissionList = this.list(wapper);
        List<PermissionTreeResp> permissionTreeResps = new LinkedList<>();
        if (CollectionUtil.isNotEmpty(permissionList)) {
            List<PermissionTreeResp> permissionTreeList = BeanToUtils.entityToList(permissionList, PermissionTreeResp.class);
            // 查询一级目录
            permissionTreeResps = permissionTreeList.stream().filter(permission -> permission.getPid() == 0).collect(Collectors.toList());

            if (CollectionUtil.isNotEmpty(permissionTreeList)) {
                for (PermissionTreeResp permissionTreeResp : permissionTreeResps) {
                    permissionTreeResp.setChildren(getChildrenTree(permissionTreeResp, permissionTreeList));
                }
            }
        }
        // 降序排序
        permissionTreeResps = getPermissionSortedTree(permissionTreeResps);
        return permissionTreeResps;
    }

    @Override
    public Boolean savePermission(PermissionTreeReq permissionTreeReq) {

        log.info("savePermission.req permissionTreeReq={}", JSON.toJSONString(permissionTreeReq));
        if (Objects.nonNull(permissionTreeReq.getRoleId())) {
            throw new CustomException(ResultCode.SYS_10001, MethodUtil.getLineInfo());
        }
        List<PermissionTreeResp> permissionRespList = new LinkedList<>();
        List<PermissionTreeResp> permissionTreeList = permissionTreeReq.getPermissionTreeResps();

        treeToList(permissionRespList, permissionTreeList);
        log.info("treeToList={}",JSON.toJSONString(permissionRespList));
        return Boolean.TRUE;
    }

    @Override
    public List<PermissionForestTree> getPermissionForestTreeList(Long roleId) {

        log.info("getPermissionForestTreeList.req roleId={}", roleId);
        Wrapper<Permission> wapper = new QueryWrapper<>(new Permission())
                .eq("permission_status", StatusEnum.NORMAL.getValue());
        List<Permission> permissionList = this.list(wapper);
        List<PermissionForestTree> permissionTreeResps = new LinkedList<>();
        if (CollectionUtil.isNotEmpty(permissionList)) {
            permissionTreeResps = BeanToUtils.entityToList(permissionList, PermissionForestTree.class);
        }
        return permissionTreeResps;
    }

    /**
     * 数转换成List
     * @param permissionRespList
     * @param permissionTreeList
     * @date: 2021/3/9 22:23
     * @return: void
     */
    private void treeToList(List<PermissionTreeResp> permissionRespList, List<PermissionTreeResp> permissionTreeList) {
        
        for (PermissionTreeResp permissionTreeResp : permissionTreeList) {
            permissionRespList.add(permissionTreeResp);
            if (CollectionUtil.isNotEmpty(permissionTreeResp.getChildren())) {
                treeToList(permissionRespList,permissionTreeResp.getChildren());
            }
        }
    }

    /**
     * 递归遍历子树结构
     *
     * @param permissionTreeResp  父权限
     * @param permissionTreeResps 所有权限
     * @date: 2021/3/9 15:32
     * @return: java.util.List<com.zlp.dto.PermissionTreeResp>
     */
    private List<PermissionTreeResp> getChildrenTree(PermissionTreeResp permissionTreeResp, List<PermissionTreeResp> permissionTreeResps) {

        List<PermissionTreeResp> treeRespList;
        treeRespList = permissionTreeResps.stream().filter(permission -> permission.getPid().
                equals(permissionTreeResp.getId()))
                .collect(Collectors.toList());

        if (CollectionUtil.isNotEmpty(treeRespList)) {
            for (PermissionTreeResp treeResp : treeRespList) {
                treeResp.setChildren(getChildrenTree(treeResp, permissionTreeResps));
            }
        }
        // 降序排序
        treeRespList = getPermissionSortedTree(treeRespList);
        return treeRespList;
    }

    /**
     *  权限排序
     * @date: 2021/3/9 21:34
     * @return: java.util.List<com.zlp.dto.PermissionTreeResp>
     */
    private List<PermissionTreeResp> getPermissionSortedTree(List<PermissionTreeResp> treeRespList) {
        treeRespList = treeRespList.stream().sorted(Comparator.comparing(PermissionTreeResp::getSort)).collect(Collectors.toList());
        return treeRespList;
    }

}
