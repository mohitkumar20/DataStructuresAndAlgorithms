 import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
	    return morrisTraversal(a);
	}
	
	public ArrayList<Integer> morrisTraversal(TreeNode a)
	{
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    TreeNode curr = a;
	    while(curr != null)
	    {
	        if(curr.left == null)
	        {
	            arr.add(curr.val);
	            curr = curr.right;
	        }
	        else
	        {
	            TreeNode inorderPrev = curr.left;
	            while(inorderPrev.right != null && inorderPrev.right != curr)
	            {
	                inorderPrev = inorderPrev.right;
	            }
	            if(inorderPrev.right == null)
	            {
	                inorderPrev.right = curr;
	                curr = curr.left;
	            }
	            else if(inorderPrev.right == curr)
	            {
	                arr.add(curr.val);
	                curr = curr.right;
	            }
	        }
	    }
	    return arr;
	}
}

