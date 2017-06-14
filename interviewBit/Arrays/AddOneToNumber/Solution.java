import java.util.*;

public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
	    ArrayList<Integer> toReturn = null;
	    int carry = 1;
	    int overflow = 0;
	    int length = arr.size();
	    for(int i = length - 1; i >= 0 ; i--)
	    {
	        if(carry != 1)
	        {
	            //System.out.println("break at i = " + i);
	            break;
	        }
	        else
	        {
	            int sum = arr.get(i) + 1;
	            if(sum == 10)
	            {
	                arr.set(i,0);
	                if(i == 0)
	                {
	                    overflow = 1;
	                }
	            }
	            else
	            {
	                arr.set(i,sum);
	                //System.out.println("added : " + sum + ", at i = " + i);
	                carry = 0;
	            }
	        }
	    }
	    
	    if(overflow == 1)
	    {
	        //System.out.println("in first, size = " + arr.size());
	        arr.add(0,1);
	        return arr;
	    }
	    else if(arr.get(0) == 0)
	    {
	        int i = 0;
	        while(i < arr.size() && arr.get(i) == 0)
	        {
	            //System.out.println("removing : " + arr.get(i) + " at i = " + i);
	            arr.remove(i);
	        }
	        return arr;
	    }
	    else
	    {
	        //System.out.println("in last, size = " + arr.size());
	        return arr;
	    }
	  
	}
}
