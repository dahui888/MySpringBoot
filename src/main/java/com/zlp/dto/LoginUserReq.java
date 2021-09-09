package com.zlp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@ApiModel(value = "用户登录参数")
public class LoginUserReq {


    @NotNull(message = "用户名为空!")
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    
    @NotNull(message = "密码为空!")
    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
