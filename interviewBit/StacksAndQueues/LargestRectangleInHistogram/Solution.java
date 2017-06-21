import java.util.*;
public class Solution {
	public int largestRectangleArea(ArrayList<Integer> a) {
	    
	    Integer[] arr = new Integer[a.size()];
	    arr = a.toArray(arr);
	    int maxArea = -1;
	    int length = a.size();
	    ArrayDeque<Integer> st = new ArrayDeque<Integer>();
	    for(int i = 0 ; i < length ; i++)
	    {
	        if(!st.isEmpty())
	        {
	            if(arr[st.peek()] <= arr[i])
	            {
	                st.addFirst(i);
	            }
	            else
	            {
	                while(!st.isEmpty() && arr[st.peek()] > arr[i])
	                {
	                    int index = st.poll();
	                    if(st.isEmpty())
	                    {
	                        int area = arr[index] * (i);//see the notes for this.
	                        if(area > maxArea)
	                        {
	                            maxArea = area;
	                        }
	                    }
	                    else
	                    {
	                        int area = arr[index] * (i - st.peek() - 1);//see the notes for this.
	                        if(area > maxArea)
	                        {
	                            maxArea = area;
	                        }
	                    }
	                }
	                st.addFirst(i);
	            }
	        }
	        else
	        {
	            st.addFirst(i);
	        }
	    }
	    int i = length;
	    while(!st.isEmpty())
	    {
	         int index = st.poll();
	       if(st.isEmpty())
	       {
	           int area = arr[index] * (i);
	           if(area > maxArea)
	           {
	                maxArea = area;
	           }
	       }
	       else
	       {
	           int area = arr[index] * (i - st.peek() - 1);
	           if(area > maxArea)
	           {
	               maxArea = area;
	            }
	       }
	    }
	    return maxArea;
	}
}
