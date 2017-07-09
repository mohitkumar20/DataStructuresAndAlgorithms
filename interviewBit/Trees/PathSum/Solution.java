 import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    
    
	public int hasPathSum(TreeNode a,int sum)
	{
	    return check(a,0,sum);
	}
	
	public int check(TreeNode a,int sum,int checksum)
	{
	    sum = sum + a.val;
	    if(a.left == null && a.right == null)
	    {
	        if(sum == checksum)
	        {
	            return 1;
	        }
	        else
	        {
	            return 0;
	        }
	    }
	    if(a.left != null)
	    {
	        int ans = check(a.left,sum,checksum);
	        if(ans == 1)
	        {
	            return 1;
	        }
	    }
	    if(a.right != null)
	    {
	        return check(a.right,sum,checksum);
	    }
	    return 0;
	}
	
}

