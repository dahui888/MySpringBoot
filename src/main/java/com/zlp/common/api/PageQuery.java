package com.zlp.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author LiPing.Zou
 * @deprecated 分页需要的表单数据
 */

@Data
@ApiModel(value = "公共分页数据", description = "分页需要的表单数据")
public class PageQuery implements Serializable {


    @NotNull(message = "页码为空")
    @ApiModelProperty(value = "页码 从第一页开始 1")
    @Min(value = 1, message = "页码输入有误")
    private Integer pageNumber = 1;


    @NotNull(message = "每页显示的数量为空")
    @ApiModelProperty(value = "每页显示的数量 范围在1~100")
    @Range(min = 1, max = 100, message = "每页显示的数量输入有误")
    private Integer pageSize = 10;


}

