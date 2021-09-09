package com.zlp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态(0:正常,1:删除)
 * @author admin
 *
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

	/**
	 * 正常
	 */
	NORMAL("正常", 0),

	/**
	 * 删除
	 */
	DELETE("删除", 1),

	;

	final String name;
	final Integer value;
}
