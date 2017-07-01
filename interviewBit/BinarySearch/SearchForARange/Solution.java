import java.util.*;
public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    if(a.size() == 0)
	    {
	        ArrayList<Integer> toReturn = new ArrayList<Integer>();
	        toReturn.add(-1);
	        toReturn.add(-1);
	        return toReturn;
	    }
	    return func(a,b);
	}
	
	public ArrayList<Integer> func(final List<Integer> arr,int target )
	{
	    ArrayList<Integer> toReturn = new ArrayList<Integer>();
	    int firstOccurence = firstOccurence(arr,target);
	    if(firstOccurence == -1)
	    {
	        toReturn.add(-1);
	        toReturn.add(-1);
	        return toReturn;
	    }
	    else
	    {
	        toReturn.add(firstOccurence);
	        toReturn.add(lastOccurence(arr,target));
	        return toReturn;
	    }
	    
	}
	
	public int lastOccurence(final List<Integer> arr,int target)
	{
	    int n = arr.size();
	    int left = 0,right = n - 1;
	    int lastOccurence = -1;
	    while(left < right)
	    {
	        int mid = (left + right) / 2;
	        if(target < arr.get(mid))
	        {
	            right = mid - 1;
	        }
	        else if(target > arr.get(mid))
	        {
	            left = mid + 1;
	        }
	        else
	        {
	            if(mid < n - 1  && arr.get(mid + 1).equals(arr.get(mid)))
	            {
	                left = mid + 1;
	            }
	            else if(mid == n - 1)
	            {
	                return lastOccurence = n - 1;
	            }
	            else
	            {
	                return lastOccurence = mid;
	            }
	        }
	    }
	    if(arr.get(right).equals(target))
	        return lastOccurence = right;
	        

	        
	    return lastOccurence;
	}
	
	public int firstOccurence(final List<Integer> arr,int target)
	{
	    int n = arr.size();
	    int left = 0,right = n - 1;
	    int firstOccurence = -1;
	    while(left < right)
	    {
	        int mid = (left + right) / 2;
	        if(target < arr.get(mid))
	        {
	            right = mid - 1;
	        }
	        else if(target > arr.get(mid))
	        {
	            left = mid + 1;
	        }
	        else
	        {
	            if(mid > 0 && arr.get(mid - 1).equals(arr.get(mid)))
	            {
	                right = mid - 1;
	            }
	            else if(mid == 0)
	            {
	               return firstOccurence = 0;
	            }
	            else
	            {
	                return firstOccurence = mid;
	            }
	        }
	    }
	    if(arr.get(left).equals(target))
	    {
	        return firstOccurence = left;
	    }
	    return -1;
	}
}

