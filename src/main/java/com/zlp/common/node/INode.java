package com.zlp.common.node;

import java.util.List;

/**
 * Created by Blade.
 *
 */
public interface INode {

	/**
	 * 主键
	 *
	 * @return
	 */
	Long getId();

	/**
	 * 排序 1,2,3,4 (从小到大排序)
	 *
	 * @return
	 */
	Integer getSort();

	/**
	 * 父主键
	 *
	 * @return
	 */
	Long getPid();

	/**
	 * 子孙节点
	 *
	 * @return
	 */
	List<INode> getChildren();

}
