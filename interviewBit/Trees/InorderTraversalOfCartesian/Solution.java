import java.util.*;
// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> a) {
        
        int n = a.size();
        if(n == 0)
            return null;
        
        TreeNode head = func(a,0,n - 1);
        return head;
        
    }
    
    TreeNode func(ArrayList<Integer> arr,int left,int right)
    {
        if(left > right)
            return null;
        else if(left == right)
        {
            return new TreeNode(arr.get(left));
        }
        else
        {
            int index = findMaxIndex(arr,left,right);
            TreeNode toReturn = new TreeNode(arr.get(index));
            toReturn.left = func(arr,left,index - 1);
            toReturn.right = func(arr,index + 1,right);
            return toReturn;
        }
    }
    
    public int findMaxIndex(ArrayList<Integer> arr,int left,int right)
    {
        int maxIndex = left;
        for(int i = left + 1 ; i <= right ; i++)
        {
            if(arr.get(i) > arr.get(maxIndex))
            {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

