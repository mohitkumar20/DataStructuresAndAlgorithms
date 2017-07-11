public class Solution {
	public int sqrt(int num) {
	    if(num == 0 || num == 1)
	        return num;
	    long high = num / 2;
	    long low = 0;
	    while(low < high)
	    {
	        long mid = (low + high) / 2;
	        if(mid * mid == num)   
	            return (int)mid;
	        else if(mid * mid > num) 
	            high = mid - 1;
	        else
	            low = mid + 1;
	    }
	    
	    if(low * low  == num)
	        return (int)low;
	    else if(low * low > num)
	        return (int)low - 1;
	    else
	        return (int)low;
	}
}

