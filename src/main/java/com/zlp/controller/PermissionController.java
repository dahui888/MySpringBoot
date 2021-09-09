package com.zlp.controller;


import com.zlp.dto.PermissionForestTree;
import com.zlp.dto.PermissionTreeReq;
import com.zlp.dto.PermissionTreeResp;
import com.zlp.service.PermissionService;
import com.zlp.common.api.Result;
import com.zlp.common.node.ForestNodeMerger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/permission")
@Api(value = "permission", tags = "权限模块")
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("getPermissionTreeList")
    @ApiOperation(value = "获取树形权限列表", notes = "获取权限列表")
    public Result<List<PermissionTreeResp>> getPermissionTreeList(
            @RequestParam(value = "roleId") @ApiParam(name = "roleId", value = "角色ID") Long roleId
    ) {
        List<PermissionTreeResp> permissionResp = permissionService.getPermissionTreeList(roleId);
        return Result.success(permissionResp);
    }

    @PostMapping("savePermission")
    @ApiOperation(value = "保存权限", notes = "保存权限")
    public Result<List<PermissionTreeResp>> savePermission(@Valid @RequestBody  PermissionTreeReq permissionTreeReq) {
        permissionService.savePermission(permissionTreeReq);
        return getPermissionTreeList(permissionTreeReq.getRoleId());
    }

    @GetMapping("getPermissionForestTreeList")
    @ApiOperation(value = "获取深林树形权限列表", notes = "获取深林树形权限列表")
    public Result<List<PermissionForestTree>> getPermissionForestTreeList(
            @RequestParam(value = "roleId") @ApiParam(name = "roleId", value = "角色ID") Long roleId
    ) {
        List<PermissionForestTree> permissionForestTrees = permissionService.getPermissionForestTreeList(roleId);
        return Result.success(ForestNodeMerger.merge(permissionForestTrees));
    }
}


