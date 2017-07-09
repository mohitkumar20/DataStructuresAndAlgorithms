import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
	public int maxDepth(TreeNode a) {
	    return postOrder(a);
	}
	
	public int postOrder(TreeNode a)
	{
	    if(a == null)
	    {
	        return 0;
	    }
	    else
	    {
	        int leftHeight = postOrder(a.left);
	        int rightHeight = postOrder(a.right);
	        return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
	    }
	}
}

