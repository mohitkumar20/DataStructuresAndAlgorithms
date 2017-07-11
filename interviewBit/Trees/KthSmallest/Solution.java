import java.util.*;
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    int n ;
    public int kthsmallest(TreeNode root, int k) {
        n = k;
        TreeNode ans = func(root);
        return ans.val;
        
    }
    
    public TreeNode func(TreeNode a)
    {
        if(a == null)
            return null;
        TreeNode leftSub,rightSub;
       // System.out.println(" before val : " + a.val + ", k = " + k);
         leftSub = func(a.left);
         if(leftSub != null)
         {
             return leftSub;
         }
        
         n--;
        if(n == 0)
        {
           // System.out.println("returning : " + a.val);
            return a;
        }
        // System.out.println(" after decreasing val : " + a.val + ", k = " + k);
            rightSub = func(a.right);
            if(rightSub != null)
                return rightSub;
                
                 //System.out.println(" after full val : " + a.val + ", k = " + k);
        return null;
    }
}

