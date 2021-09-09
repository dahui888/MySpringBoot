package com.zlp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlp.dto.*;
import com.zlp.entity.User;
import com.zlp.enums.UserTypeEnum;
import com.zlp.common.exception.CustomException;
import com.zlp.mapper.UserMapper;
import com.zlp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlp.utils.BeanToUtils;
import com.zlp.utils.MethodUtil;
import com.zlp.utils.RedisConstants;
import com.zlp.utils.RedisUtils;
import com.zlp.common.api.Pager;
import com.zlp.common.api.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 管理用户表 服务实现类
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-03-11
 */
@Service
@AllArgsConstructor
@Slf4j(topic = "UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final RedisUtils redisUtils;

    @Override
    public CacheInfo login(LoginUserReq loginReq) {

        log.info("login.req loginReq={}", JSON.toJSONString(loginReq));
        CacheInfo cacheInfo = new CacheInfo();
        String password = loginReq.getPassword();
        Wrapper<User> wapper = new QueryWrapper<>(new User())
                .eq("username",loginReq.getUsername())
//                .eq("password",loginReq.getPassword())
                ;
        User user = this.getOne(wapper);
        if (Objects.isNull(user)){
            throw new CustomException(ResultCode.SYS_10002, MethodUtil.getLineInfo());
        }
        bulidCache(cacheInfo, user);
        String key = RedisConstants.CACHE+ StrUtil.COLON+cacheInfo.getToken();
        // 设置登入用户缓存信息
        redisUtils.setKeyByHOURS(key,cacheInfo.getId().toString(),1);
        return cacheInfo;
    }

    @Override
    public Pager<UserResp> getUserPage(UserQueryReq userQueryReq) {

        log.info("getUserPage.req userQueryReq={}", JSON.toJSONString(userQueryReq));
        IPage<User> page = new Page<>(userQueryReq.getPageNumber(),userQueryReq.getPageSize());
        QueryWrapper<User> queryWapper = new QueryWrapper<>();
        IPage<User> pager = this.page(page, queryWapper);
        if (Objects.nonNull(pager) && CollectionUtil.isNotEmpty(pager.getRecords())) {
            List<User> records = pager.getRecords();
            List<UserResp> userRespList = BeanToUtils.entityToList(records, UserResp.class);
            return new Pager<>(userQueryReq.getPageNumber(),userQueryReq.getPageSize(),(int)pager.getPages(),pager.getTotal(),userRespList);
        }
        return new Pager<>();
    }

    @Override
    public UserResp getUserInfo(Long userId) {

        log.info("getUserInfo.req userId={}", userId);
        User user = this.getById(userId);
        if (Objects.isNull(user)){
            throw new CustomException(ResultCode.SYS_10003, MethodUtil.getLineInfo());
        }
        return BeanToUtils.doToDto(user,UserResp.class);
    }

    @Override
    public List<UserResp> getAdminUserInfo(int status) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(User::getStatus,status);
        List<User> users = this.list(queryWrapper);
        return BeanToUtils.entityToList(users,UserResp.class);
    }


    private void bulidCache(CacheInfo cacheInfo, User user) {

        cacheInfo.setId(user.getId());
        cacheInfo.setUsername(user.getUsername());
        cacheInfo.setNickName(user.getNickname());
        cacheInfo.setToken(UUID.randomUUID().toString());
        cacheInfo.setUserType(UserTypeEnum.ADMINISTRATOR.getValue());
    }
}
