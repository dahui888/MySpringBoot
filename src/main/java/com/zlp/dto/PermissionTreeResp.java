package com.zlp.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "权限树形返回信息")
public class PermissionTreeResp  {


    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "父级权限id")
    private Long pid;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "按钮权限值")
    private String permissionValue;

    @ApiModelProperty(value = "权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private Integer type;

    @ApiModelProperty(value = "权限操作类型 0->查看全部按钮权限值; 1->查看自己数据权限按钮权限值")
    private Integer dataType;

    @ApiModelProperty(value = "排序 1,2,3,4 (从小到大排序)")
    private Integer sort;

    @ApiModelProperty(value = "是否拥有权限标识：false->否 ; ture->是")
    private Boolean isHaveFlag = false;

    @ApiModelProperty(value = "子孙节点")
    private List<PermissionTreeResp> children = new ArrayList<>();




}
