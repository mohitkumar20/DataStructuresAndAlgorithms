 import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
	public int isSameTree(TreeNode a, TreeNode b) {
	    if(a == null && b == null)
	    {
	        return 1;
	    }
	    
	    if((a != null && b == null) || (a == null && b != null))
	    {
	        return 0;
	    }
	    
	    if(a.val != b.val)
	    {
	        return 0;
	    }
	    
	    else
	    {
	        int leftSub = isSameTree(a.left,b.left);
	        if(leftSub == 0)
	            return 0;
	         else
	         {
	             return isSameTree(a.right,b.right);
	         }
	    }
	}
}

