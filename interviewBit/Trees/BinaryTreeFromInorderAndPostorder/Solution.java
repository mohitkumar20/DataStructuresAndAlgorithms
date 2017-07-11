import java.util.*;
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public int pos ;
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	    
	    if(inorder.size() == 0)
	        return null;
	     
	     pos = postorder.size() - 1;   
	    return func(inorder,postorder,0,postorder.size() - 1);
	    
	        
	}
	public TreeNode func(ArrayList<Integer> inorder,ArrayList<Integer> postorder,int left,int right)
	{
	    if(left > right || left < 0 || right >= inorder.size())
	    {
	        //System.out.println("left = " + left + ",right = " + right);
	        return null;
	    }
	    else if(left == right)
	    {
	        pos--;
	      // System.out.println("founddsfdf : " + left);
	        return new TreeNode(inorder.get(left));
	    }
	    else
	    {
	        int i = left;
	       // System.out.println("left = " + left + ",right = " + right);
	       //System.out.println("pos = " + pos);
	       int toMatch = postorder.get(pos);
	        for(; i <= right ; i++)
	        {
	            //System.out.println("i = " + i +  ",left = " + left + ",right = " + right);
	            if(inorder.get(i) == toMatch)
	            {
	                //System.out.println("found it : i = " + i);
	                break;
	            }
	        }
	       
	        TreeNode node = new TreeNode(postorder.get(pos));
	        pos--;
	       // System.out.println("before calling right");
	        node.right = func(inorder,postorder,i + 1,right);
	        node.left = func(inorder,postorder,left,i - 1);
	        return node;
	    }
	}
}

