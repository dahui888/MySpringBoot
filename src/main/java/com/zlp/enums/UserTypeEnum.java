package com.zlp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型(0:超级管理员;1:普通用户)
 * @author admin
 *
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {


	ADMINISTRATOR("超级管理员", 0),
	GENERAL_USER("普通用户", 1),

	;

	final String name;
	final Integer value;
}
