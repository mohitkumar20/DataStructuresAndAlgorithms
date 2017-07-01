public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> arr, int target) {
	    int n = arr.size();
	    if(n == 1)
	    {
	        if(arr.get(0) == target)
	            return 0;
	        else
	            return -1;
	    }
	    if(n == 2)
	    {
	        if(arr.get(0) == target)
	            return 0;
	        else if(arr.get(1) == target)
	            return 1;
	        else 
	            return -1;
	    }
	    else
	    {
	        int left = 0;
	        int right = n - 1;
	        int mid;
	        int pivot = -1;
	        while(left < right)
	        {
	            mid = (left + right) / 2;
	            if(arr.get(mid) == target)
	                   return mid;
	            else if(arr.get(mid) > arr.get(mid - 1) && arr.get(mid + 1) > arr.get(mid))
	            {
	                if(arr.get(left) < arr.get(mid) && arr.get(mid) < arr.get(right))
	                    break;
	                else if(arr.get(left) > arr.get(mid))
	                {
	                    right = mid - 1;
	                }
	                else
	                {
	                    left = mid + 1;
	                }
	            }
	            else
	            {
	                if(arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1))
	                {
	                    pivot = mid + 1;
	                    break;
	                }
	                else
	                {
	                    pivot = mid;
	                    break;
	                }
	            }
	        }
	        if(pivot != -1)
	        {
	            if(arr.get(pivot) == target)
	            {
	                return pivot;
	            }
	            else if(target > arr.get(pivot) && target <= arr.get(n - 1))
	            {
	                left = pivot + 1;
	                right = n - 1;
	            }
	            else
	            {
	                left = 0;
	                right = pivot - 1;
	            }
	        }
	        else
	        {
	            left = 0;
	            right = n - 1;
	        }
	        while(left < right)
	        {
	            mid = (left + right) / 2;
	            if(arr.get(mid) == target)
	                return mid;
	                
	            else if(target < arr.get(mid))
	            {
	                right = mid - 1;
	            }
	            else
	            {
	                left = mid + 1;
	            }
	        }
	        if(left == right)
	        {
	            if(arr.get(left) == target)
	                return left;
	            else 
	                return -1;
	        }
	        else
	        {
	            return -1;
	        }
	    }
	}
}

