import java.util.*;
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    
	    return func(a,0,a.size() - 1);
	}
	
	public TreeNode func(List<Integer> a,int left,int right)
	{
	    if(left > right)
	       {
	           return null;
	       }
	       
	    else{
	        int center = (left + right) / 2;
	        TreeNode node = new TreeNode(a.get(center));
	        node.left = func(a,left,center - 1);
	        node.right = func(a,center + 1,right);
	        return node; 
	    }
	}
}

