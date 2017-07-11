import java.util.*;
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {

    TreeNode root;
    TreeNode curr;
    TreeNode inPrev;
    public Solution(TreeNode root) {
        if(root == null)
        {
            curr = null;
        }
       else
       {
            this.root = root;
        curr = root;
        while(curr.left != null)
        {
            inPrev = curr.left;
            while(inPrev.right != null)
            {
               inPrev = inPrev.right;
            }
            inPrev.right = curr;
            curr = curr.left;
        }
       }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(curr != null)
        {
            return true;
        }
        return false;
        
    }

    /** @return the next smallest number */
    public int next() {
        int toReturn = curr.val;
        curr = curr.right;
       // System.out.println("curr == " + curr.val);
        if(curr == null)
        {
            return toReturn;
        }
        while(curr.left != null)
        {
            inPrev = curr.left;
            while(inPrev.right != null && inPrev.right != curr)
            {
                inPrev = inPrev.right;
            }
            if(inPrev.right == null)
            {
                inPrev.right = curr;
                curr = curr.left;
            }
            else if(inPrev.right == curr)
            {
                inPrev.right = null;
                return toReturn;
            }
        }
        return toReturn;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */

