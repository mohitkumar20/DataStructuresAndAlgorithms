import java.util.*;

public class Solution
{
	public int books(ArrayList<Integer> arr,int m)
	{
		int sum = 0;
		int n = arr.size();
		if(m > n)
		    return -1;
		for(int i = 0 ; i < n ; i++)
		{
			sum += arr.get(i);
		}
		int  start = 0;
		int end = sum;
		int ans = Integer.MAX_VALUE;
		while(start <= end)
		{
			int mid = (start + end) / 2;
			//System.out.println("mid : " + mid);
			int isPossible = isPossible(arr,m,mid);
			if(isPossible == 1)
			{
			    ans = Math.min(ans,mid);
				end = mid - 1;
			}
			else
			{
				start = mid + 1;
			}
		}
		return ans;
	}

	public int isPossible(ArrayList<Integer> arr,int m, int maxPartition)
	{
		int n = arr.size();
		int sum = 0;
		int students = 1;
		for(int i = 0; i < n ; i++)
		{
			if(arr.get(i) > maxPartition)
				return 0;
			else if(sum + arr.get(i) > maxPartition)
			{
				students++;
				sum = arr.get(i);
				if(students  > m)
					return 0;
			}
			else
			{
				sum = sum + arr.get(i);
			}
		}
	return 1;
	}
}





