 import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public int minDepth = Integer.MAX_VALUE;
	public int minDepth(TreeNode a) {
	    if(a == null)
	    {
	        return 0;
	    }
	    findMinDepth(a,1);
	    return minDepth;
	}
	
	public void findMinDepth(TreeNode node,int depth)
	{
	    if(node == null)
	    {
	        return;
	    }
	    if(node.left == null && node.right == null)
	    {
	        if(depth < minDepth)
	        {
	            minDepth = depth;
	        }
	    }
	    else
	    {
	        if(depth >= minDepth)
	        {
	            return;
	        }
	        findMinDepth(node.left,depth + 1);
	        findMinDepth(node.right,depth + 1);
	    }
	}
}

