package com.zlp.service;

import com.zlp.dto.CacheInfo;
import com.zlp.dto.LoginUserReq;
import com.zlp.dto.UserQueryReq;
import com.zlp.dto.UserResp;
import com.zlp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zlp.common.api.Pager;

import java.util.List;

/**
 * <p>
 * 管理用户表 服务类
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-03-11
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param loginReq
     * @date: 2021/3/11 14:06
     * @return: com.zlp.dto.CacheInfo
     */
    CacheInfo login(LoginUserReq loginReq);

    /**
     * 获取用户列表
     * @param userQueryReq
     * @date: 2021/3/11 14:44
     * @return: java.lang.Object
     */
    Pager<UserResp> getUserPage(UserQueryReq userQueryReq);

    
    /** 
     * 获取用户信息
     * @param userId
     * @date: 2021/3/11 15:19
     * @return: java.lang.Object 
     */
    UserResp getUserInfo(Long userId);

    /***
     * 获取admin用户信息
     * @param status
     * @return
     */
    List<UserResp> getAdminUserInfo(int status);
}
