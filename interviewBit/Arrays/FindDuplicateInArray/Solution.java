import java.util.*;

public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    
	    int n = a.size();
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(n);
	    for(int i = 0 ; i < n ; i++)
	    {
	        int num = a.get(i);
	        map.put(num,0);
	    }
	    
	    for(int i = 0 ; i < n ; i++)
	    {
	        int num = a.get(i);
	        map.put(num,map.get(num) + 1);
	    }
	    
	    for(int i = 0 ; i < n ; i++)
	    {
	        int num = a.get(i);
	        int val = map.get(num);
	        if(val > 1)
	        {
	            return num;
	        }
	    }
	    return -1;
	}
}
