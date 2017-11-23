package com.sunrise.common.utils.tree;

import java.util.List;

public interface TreeNode {
	public String getId();
	public String getName();
	public String getAction();
	public boolean isLeaf();
	public String getNodeString();
	public TreeNode getParent();
	public List<TreeNode> getChilds();
	public int getOrder();
}
