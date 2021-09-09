package com.zlp.common.api;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 分页数据封装类
 * Created by macro on 2019/4/19.
 */
@Data
public class Pager<T> {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页显示多少条
     */
    private Integer pageSize;

    /**
     * 当前页总条数
     */
    private Integer totalPage;

    /**
     * 总记录数
     */
    private Long total;

    /**
     *  数据集 list
     */
    private List<T> list;

    public Pager(){}

    public Pager(Integer pageNum, Integer pageSize, Integer totalPage, Long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.total = total;
        this.list = list;
    }

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> Pager<T> restPage(List<T> list) {

        PageInfo<T> pageInfo = new PageInfo<>(list);
        Pager<T> result = new Pager<>();
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }


}
