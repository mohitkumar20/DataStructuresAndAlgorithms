import java.util.*;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x)
	{
		val = x;
	}
}


public class Solution
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
		if(root == null)
			return toReturn;
		ArrayDeque<List<Integer>> st = new ArrayDeque<List<Integer>>();
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();

		queue.addLast(root);
		while(!queue.isEmpty())
		{
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			while(size-- > 0)
			{
				TreeNode curr = queue.pollFirst();
				list.add(curr.val);
				if(curr.left != null)
					queue.addLast(curr.left);
				if(curr.right != null)
					queue.addLast(curr.right);
			}
			st.addLast(list);
		}

		while(!st.isEmpty())
		{
			toReturn.add(st.pollLast());
		}
		return toReturn;
	}
}
