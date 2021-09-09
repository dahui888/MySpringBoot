package com.zlp.utils;



import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @description:dto 转换DO工具类 do转换DTO
 * @date: 2019年3月26日14:02:06
 * @version V1.0
 *
 */
public class BeanToUtils<Dto, Do> {

    private static Mapper MAPPER = DozerBeanMapperBuilder.buildDefault();
    /**
     * dto 转换为Do 工具类
     *
     * @param dtoEntity
     * @param doClass
     * @return
     */
    public static <Do> Do dtoToDo(Object dtoEntity, Class<Do> doClass) {
        // 判断dto是否为空!
        if (dtoEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (doClass == null) {
            return null;
        }
        try {
            Do newInstance = doClass.newInstance();
            BeanUtils.copyProperties(dtoEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * do 转换为Dto 工具类
     *
     * @param dtoClass
     * @param doEntity
     * @return
     */
    public static <Dto> Dto doToDto(Object doEntity, Class<Dto> dtoClass) {
        // 判断dto是否为空!
        if (doEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (dtoClass == null) {
            return null;
        }
        try {
            Dto newInstance = dtoClass.newInstance();
            BeanUtils.copyProperties(doEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> List<T> entityToList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        if (CollectionUtils.isEmpty(sourceList)) return destinationList;
        for (Object sourceObject : sourceList) {
            destinationList.add(MAPPER.map(sourceObject, destinationClass));
        }
        return destinationList;
    }

}

