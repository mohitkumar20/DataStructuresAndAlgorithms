import java.util.*;
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    int pos = 0;
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
	    
	    if(preorder.size() == 0)
	        return null;
	        else
	            return func(inorder,preorder,0,preorder.size() - 1);
	}
	
	public TreeNode func(ArrayList<Integer> inorder,ArrayList<Integer> preorder,int left,int right)
	{
	    if(left > right || left < 0 || right >= inorder.size())
	    {
	        //System.out.println("left = " + left + ",right = " + right);
	        return null;
	    }
	    else if(left == right)
	    {
	        pos++;
	      // System.out.println("founddsfdf : " + left);
	        return new TreeNode(inorder.get(left));
	    }
	    else
	    {
	        int i = left;
	       // System.out.println("left = " + left + ",right = " + right);
	       //System.out.println("pos = " + pos);
	       int toMatch = preorder.get(pos);
	        for(; i <= right ; i++)
	        {
	            //System.out.println("i = " + i +  ",left = " + left + ",right = " + right);
	            if(inorder.get(i) == toMatch)
	            {
	                //System.out.println("found it : i = " + i);
	                break;
	            }
	        }
	       
	        TreeNode node = new TreeNode(preorder.get(pos));
	        pos++;
	       // System.out.println("before calling right");
	        node.left = func(inorder,preorder,left,i - 1);
	        node.right = func(inorder,preorder,i + 1,right);
	        return node;
	    }
	}
}

