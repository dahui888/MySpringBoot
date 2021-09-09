package com.zlp.service;

import com.zlp.dto.LeoResp;
import com.zlp.dto.UserResp;
import com.zlp.entity.Leo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 管理用户表 服务类
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-09-09
 */
public interface LeoService extends IService<Leo> {

    /**
     * 获取数据库里的所有人
     * @return
     */
    List<LeoResp> getLeoUsers();

    /**
     * 根据性别去筛选人
     * @param sex
     * @return
     */
    List<LeoResp> getLeoUserSex(int sex);
}
