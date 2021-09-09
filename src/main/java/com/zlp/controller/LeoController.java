package com.zlp.controller;


import com.zlp.common.api.Result;
import com.zlp.dto.LeoResp;
import com.zlp.dto.UserResp;
import com.zlp.service.LeoService;
import com.zlp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 管理用户表 前端控制器
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-09-09
 */
@RestController
@RequestMapping("/leo")
@AllArgsConstructor
@Api(value = "leo", tags = "李航的模块")
public class LeoController {

    private final LeoService leoService;

    @GetMapping("getLeoUsers")
    @ApiOperation("获取leo下的所有人")
    public Result<List<LeoResp>> getLeoUsers(){
        return Result.success(leoService.getLeoUsers());
    }

    @GetMapping("getLeoUserSex")
    @ApiOperation("根据性别获取leo下的人")
    public Result<List<LeoResp>> getLeoUserSex(@RequestParam(value ="sex") @ApiParam(name ="sex",value = "0:男的  1:女的",required = true) int sex){
        return Result.success(leoService.getLeoUserSex(sex));
    }

}

