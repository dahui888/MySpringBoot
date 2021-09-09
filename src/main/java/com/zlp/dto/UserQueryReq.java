package com.zlp.dto;

import com.zlp.common.api.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;


@Data
@ApiModel("用户查询请求数据")
@EqualsAndHashCode(callSuper = false)
public class UserQueryReq extends PageQuery  {


    @NotNull(message = "用户状态不能为空")
    @ApiModelProperty("用户状态(0:正常;1:停用)")
    @Range(min =  0 , max = 1 , message = "用户状态有误,范围区间[0~1]")
    private Integer status;

}
