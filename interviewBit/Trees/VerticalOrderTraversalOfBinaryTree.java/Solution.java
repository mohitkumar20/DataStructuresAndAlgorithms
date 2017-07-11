
 import java.util.*;
 // Definition for binary tree
  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

 
 class queueNode{
     TreeNode a;
     int verticalIndex;
     queueNode(TreeNode a ,int verticalIndex)
     {
         this.a = a;
         this.verticalIndex = verticalIndex;
     }
 }
public class Solution {
    public int leftMostIndex = 0,rightMostIndex = 0,shift = 0;
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        if(A == null)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        preorder(A,0);
        shift = leftMostIndex * -1;
        int n = rightMostIndex + shift + 1;
        ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>(n);
        for(int i = 0 ; i < n ; i++)
        {
            mat.add(new ArrayList<Integer>());
        }
        //System.out.println("leftmost = " + leftMostIndex + "right = " +  rightMostIndex);
       // System.out.println(mat.size());
        process(A,mat);
        return mat;
    }
    public void process(TreeNode a,ArrayList<ArrayList<Integer>> mat)
    {
        ArrayDeque<queueNode> queue = new ArrayDeque<queueNode>();
        queue.addFirst(new queueNode(a,0));
        while(!queue.isEmpty())
        {
            queueNode node = queue.poll();
            //System.out.println("vindex = " + node.verticalIndex + ",data = " + node.a.val);
            mat.get(node.verticalIndex + shift).add(node.a.val);
            if(node.a.left != null)
            {
                queue.addLast(new queueNode(node.a.left,node.verticalIndex - 1));
            }
            if(node.a.right != null)
            {
                queue.addLast(new queueNode(node.a.right,node.verticalIndex + 1));
            }
        }
    }
    
    public void preorder(TreeNode a,int index)
    {
        if(a == null)
            {
                return;
            }
        else
        {
            if(index < leftMostIndex)
            {
                leftMostIndex = index;
            }
            else if(index > rightMostIndex)
            {
                rightMostIndex = index;
            }
            preorder(a.left,index - 1);
            preorder(a.right,index + 1);
        }
    }
}

