import java.util.*;


public class Solution
{
	public int searchInsert(ArrayList<Integer> arr,int target)
	{
		int right = arr.size() - 1;
		int mid,left = 0;
		while(left < right)
		{
			mid = (left + right) / 2;
			if(arr.get(mid) == target)
				return mid;
			else if(target < arr.get(mid))
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		if(left == right && arr.get(left) == target)
			return left;
		
		else if(left == right)
		{
			if(target < arr.get(left))
				return left;
			else
				return left + 1;
		}
		else
		{
			if(target < arr.get(left))
				return left;
			else
				return left + 1;
		}
	}
}
