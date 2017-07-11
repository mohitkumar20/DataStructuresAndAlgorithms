
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
	public int isSymmetric(TreeNode a) {
	    if(a == null)
	        return 1;
	        return check(a.left,a.right);
	}
	
	public int check(TreeNode a,TreeNode b)
	{
	    if(a == null && b == null)
	    {
	        return 1;
	    }
	    if((a == null && b != null) || (a != null && b == null))
	    {
	        return 0;
	    }
	    if(a.val != b.val)
	    {
	        return 0;
	    }
	    
	    else
	    {
	        int ans = check(a.left,b.right);
	        if(ans == 1)
	        {
	            return check(a.right,b.left);
	        }
	        else
	            return 0;
	    }
	}
}

