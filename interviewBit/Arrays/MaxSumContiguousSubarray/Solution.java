import java.util.*;

public class Solution {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	    int length = a.size();
	    Integer[] arr = new Integer[length];
	    arr = a.toArray(arr);
	    int[] sumArray = new int[length];
	    int sum = 0,maxSum;
	    for(int i = 0 ; i < length ; i++)
	    {
	        sum += arr[i];
	        if(sum < 0)
	        {
	            sum = 0;
	            sumArray[i] = arr[i];
	        }
	        
	        else if(sum == 0)
	        {
	            sumArray[i] = 0;
	        }
	        else
	        {
	            sumArray[i] = sum;
	        }
	    }
	    
	    maxSum = sumArray[0];
	    for(int i = 1 ; i < length ; i++)
	    {
	        if(sumArray[i] > maxSum)
	        {
	            maxSum = sumArray[i];
	        }
	    }
	    return maxSum;
	}
}
