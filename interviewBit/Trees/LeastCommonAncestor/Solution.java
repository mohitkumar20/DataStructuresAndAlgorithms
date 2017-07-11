
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    int count = 0;
    TreeNode lca;
	public int lca(TreeNode a, int val1, int val2) {
	    
	    if(find(a,val1) && find(a,val2))
	    {
	        TreeNode ans = FindLCA(a,val1,val2);
	        return ans.val;
	    }
	    else 
	        return -1;
	   
	}
	
	public TreeNode FindLCA(TreeNode a,int val1,int val2)
	{
	    if(a == null)
	    {
	        return null;
	    }
	    if(a.val == val1 || a.val == val2)
	        return a;
	   
	    TreeNode leftSub = FindLCA(a.left,val1,val2);
	    TreeNode rightSub = FindLCA(a.right,val1,val2);
	    if(leftSub != null && rightSub != null)
	        return a;
	    return leftSub != null ? leftSub : rightSub;
	}
	
    public boolean find(TreeNode a,int num)
    {
        if(a == null)
        {
            return false;
        }
        if(a.val == num)
            return true;
        boolean ans = find(a.left,num);
        if(ans == true)
            return true;
        else
        {
            return find(a.right,num);
        }
    }
}

