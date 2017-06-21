import java.util.*;
public class Solution {
	// DO NOT MODIFY THE LIST
	public int trap(final List<Integer> a) {
	    if(a.size() <= 1)
	    {
	        return 0;
	    }
	    Integer[] arr = new Integer[a.size()];
	    arr = a.toArray(arr);
	    int n = arr.length;
	    int water = 0;
	    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	    stack.addFirst(0);
	    for(int i = 1 ; i < n ; i++)
	    {
	        if(arr[i] >= arr[stack.peek()])
	        {
	            int highest = 0;
	            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
	            {
	                int popped = stack.poll();
	                water += (arr[popped] - highest) * (i - popped - 1);
	                if(arr[popped] > highest)
	                {
	                    highest = arr[popped];
	                }
	            }
	            if(!stack.isEmpty())
	            {
	                water += (arr[i] - highest) * (i - stack.peek() - 1);
	            }
	            stack.addFirst(i);
	        }
	        else
	        {
	            stack.addFirst(i);
	        }
	    }
	    return water;
	}
}
