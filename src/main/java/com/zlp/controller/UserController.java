package com.zlp.controller;


import com.zlp.dto.CacheInfo;
import com.zlp.dto.LoginUserReq;
import com.zlp.dto.UserQueryReq;
import com.zlp.dto.UserResp;
import com.zlp.service.UserService;
import com.zlp.common.api.Pager;
import com.zlp.common.api.Result;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 管理用户表 前端控制器
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-03-11
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Api(value = "user", tags = "用户模块")
public class UserController {

    private final UserService userService;


    @ApiOperation( "登录")
    @PostMapping(value = "login")
    public Result<CacheInfo> login(@Valid @RequestBody LoginUserReq loginReq){

        return Result.success(userService.login(loginReq));
    }


    @PostMapping("getUserPage")
    @ApiOperation("获取用户列表")
    public Result<Pager<UserResp>> getUserPage(@Valid @RequestBody UserQueryReq userQueryReq){
        return Result.success(userService.getUserPage(userQueryReq));
    }

    @GetMapping("getUserInfo")
    @ApiOperation("获取用户信息")
    public Result<UserResp> getUserInfo(
            @RequestParam(value="userId" )  @ApiParam(name="userId",value="用户ID",required = true) Long userId
    ){
        return Result.success(userService.getUserInfo(userId));
    }


    @GetMapping("getAdminUserInfo")
    @ApiOperation("获取管理员账号")
    public Result<List<UserResp>> getAdminUserInfo(@RequestParam(value ="status") @ApiParam(name ="status",value = "用户的状态leo",required = true) int status){
        return Result.success(userService.getAdminUserInfo(status));
    }


}

