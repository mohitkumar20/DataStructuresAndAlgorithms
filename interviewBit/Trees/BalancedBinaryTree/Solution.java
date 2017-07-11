 import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
	public int isBalanced(TreeNode a) {
	    
	    return check(a) == -1 ? 0 : 1;
	   
	}
	
	public int check(TreeNode a)
	{
	     if(a == null)
	    {
	        return 0;
	    }
	    else
	    {
	        int leftHeight = check(a.left);
	        if(leftHeight == -1)
	        {
	            return -1;
	        }
	        int rightHeight = check(a.right);
	        if(rightHeight == -1)
	        {
	            return -1;
	        }
	        
	        if(leftHeight >= rightHeight)
	        {
	            return leftHeight - rightHeight < 2 ? leftHeight + 1: -1;
	        }
	        else
	        {
	            return rightHeight - leftHeight < 2 ? rightHeight + 1: -1;
	        }
	    }
	}
}

