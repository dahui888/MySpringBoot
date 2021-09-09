package com.zlp.common.node;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 森林节点归并类
 *
 */
public class ForestNodeMerger {

	/**
	 * 将节点数组归并为一个森林（多棵树）（填充节点的children域）
	 * 时间复杂度为O(n^2)
	 *
	 * @param items 节点域
	 * @return 多棵树的根节点集合
	 */
	public static <T extends INode> List<T> merge(List<T> items) {
		ForestNodeManager<T> forestNodeManager = new ForestNodeManager<>(items);
		items.forEach(forestNode -> {
			if (forestNode.getPid() != 0) {
				// 获取父节点
				INode node = forestNodeManager.getTreeNodeAT(forestNode.getPid());
				if (node != null) {
					node.getChildren().add(forestNode);
				} else {
					forestNodeManager.addParentId(forestNode.getId());
				}
			}
		});
		List<T> root = forestNodeManager.getRoot();
		return root.stream().sorted(Comparator.comparing(T::getSort)).collect(Collectors.toList());
	}

}
