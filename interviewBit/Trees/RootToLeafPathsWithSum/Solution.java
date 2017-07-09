 import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    
    ArrayList<Integer> arr = new ArrayList<Integer>();
    int checkSum;
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	    
	    checkSum = sum;
	    ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
	    check(root,mat,0,0);
	   return mat;
	}
	
	public void check(TreeNode a,ArrayList<ArrayList<Integer>> mat,long sum,int pos)
	{
	    arr.add(pos++,a.val);
	    //System.out.println("added in arr");
	    sum = sum + a.val;
	   // System.out.println("sum : " + sum);
	    if(a.left == null && a.right == null)
	    {
	        if(sum == checkSum)
	        {
	            //System.out.println("sum = cecksu");
	            mat.add(new ArrayList<Integer>());
	            int size = mat.size();
	            for(int i = 0 ; i < pos ; i++)
	            {
	                //System.out.println("adding " + arr.get(i));
	                mat.get(size - 1).add(arr.get(i));
	            }
	        }
	        return;
	    }
	    
	    if(a.left != null)
	    {
	        check(a.left,mat,sum,pos);
	    }
	    if(a.right != null)
	    {
	        check(a.right,mat,sum,pos);
	    }
	}
	
}

