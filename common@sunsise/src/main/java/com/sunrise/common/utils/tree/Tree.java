package com.sunrise.common.utils.tree;

import java.util.List;

public interface Tree extends TreeNode {
	public void setTopId();
	public <T> void setNodeList(List<T> nodeDatas);
	
}
