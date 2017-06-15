
    //while running the code on leetcode, comment the definition of the class TreeNode
 // Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return func(t1,t2);
        
    }
    
    public TreeNode func(TreeNode n1,TreeNode n2)
    {
        if(n1 == null && n2 == null)
            return null;
            
        else if(n1 != null && n2 != null)
        {
            TreeNode n = new TreeNode(n1.val + n2.val);
            n.left = func(n1.left,n2.left);
            n.right = func(n1.right,n2.right);
            return n;
        }
        else if(n1 != null && n2 == null)
        {
            TreeNode n = new TreeNode(n1.val);
            n.left = func(n1.left,null);
            n.right = func(n1.right,null);
            return n;
        }
        else
        {
            TreeNode n = new TreeNode(n2.val);
            n.left = func(null,n2.left);
            n.right = func(null,n2.right);
            return n;
        }
    }
}