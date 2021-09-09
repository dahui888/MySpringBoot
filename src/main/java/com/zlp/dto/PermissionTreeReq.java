package com.zlp.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "权限树形请求信息")
public class PermissionTreeReq {


    @NotNull(message = "角色ID为空")
    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "权限树形请求信息")
    private List<PermissionTreeResp> permissionTreeResps;





}
