package com.zlp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zlp.dto.LeoResp;
import com.zlp.dto.UserResp;
import com.zlp.entity.Leo;
import com.zlp.entity.User;
import com.zlp.mapper.LeoMapper;
import com.zlp.service.LeoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlp.utils.BeanToUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理用户表 服务实现类
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-09-09
 */
@Service
public class LeoServiceImpl extends ServiceImpl<LeoMapper, Leo> implements LeoService {

    @Override
    public List<LeoResp> getLeoUsers() {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
//        queryWrapper.in(User::getStatus,status);
        List<Leo> users = this.list();
        return BeanToUtils.entityToList(users, LeoResp.class);
    }

    @Override
    public List<LeoResp> getLeoUserSex(int sex) {
        LambdaQueryWrapper<Leo> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(Leo::getSex,sex);
        List<Leo> users = this.list(queryWrapper);
        return BeanToUtils.entityToList(users, LeoResp.class);
    }
}
