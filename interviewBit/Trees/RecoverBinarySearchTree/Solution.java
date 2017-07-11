import java.util.*;
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
	public ArrayList<Integer> recoverTree(TreeNode a) {
	    return morrisTraversal(a);
	}
	
	public ArrayList<Integer> morrisTraversal(TreeNode head)
	{
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    TreeNode curr = head,inorderPrev = null;
	    while(curr != null)
	    {
	        if(curr.left == null)
	        {
	            if(inorderPrev == null)
	            {
	                
	            }
	            else
	            {
	                if(inorderPrev.val > curr.val)
	                {
	                    arr.add(inorderPrev.val);
	                    arr.add(curr.val);
	                    if(arr.size() > 2)
	                    {
	                        break;
	                    }
	                }
	            }
	            inorderPrev = curr;
	            curr = curr.right;
	        }
	        else
	        {
	            TreeNode localPrev = curr.left;
	            while(localPrev.right != null && localPrev.right !=curr)
	            {
	                localPrev = localPrev.right;
	            }
	            if(localPrev.right == null)
	            {
	                localPrev.right = curr;
	                curr = curr.left;
	            }
	            else if(localPrev.right == curr)
	            {
	                if(localPrev.val > curr.val)
	                {
	                    arr.add(localPrev.val);
	                    arr.add(curr.val);
	                    if(arr.size() > 2)
	                    {
	                        break;
	                    }
	                }
	                inorderPrev = curr;
	                curr = curr.right;
	            }
	        }
	    }
	    /*
	    for(int i = 0 ; i < arr.size(); i++)
	    {
	        System.out.println(arr.get(i));
	    }
	    */
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    for(int i = 0 ; i < arr.size() ; i++)
	    {
	        int num = arr.get(i);
	        if(num < min)
	        {
	            min = num;
	        }
	       if(num > max)
	        {
	            max = num;
	        }
	    }
	    ArrayList<Integer> toReturn = new ArrayList<Integer>();
	    toReturn.add(min);
	    toReturn.add(max);
	    return toReturn;
	}
}



























