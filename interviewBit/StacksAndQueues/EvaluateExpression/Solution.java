import java.util.*;
public class Solution {
	public int evalRPN(ArrayList<String> arr) {
	    
	    int op1,op2,val;
	    int n = arr.size();
	    ArrayDeque<Integer> stack = new ArrayDeque<Integer>(n);
	    for(int i = 0 ; i < n ; i++)
	    {
	        String temp = arr.get(i);
	        if(temp.equals("+"))
	        {
	            op2 = stack.poll();
	            op1 = stack.poll();
	            val = op1 + op2;
	            stack.addFirst(val);
	        }
	        else if(temp.equals("-"))
	        {
	            op2 = stack.poll();
	            op1 = stack.poll();
	            val = op1 - op2;
	            stack.addFirst(val);
	        }
	        
	        else if(temp.equals("*"))
	        {
	            op2 = stack.poll();
	            op1 = stack.poll();
	            val = op1 * op2;
	            stack.addFirst(val);
	        }
	        
	        else if(temp.equals("/"))
	        {
	            op2 = stack.poll();
	            op1 = stack.poll();
	            val = op1 / op2;
	            stack.addFirst(val);
	        }
	        else
	        {
	           // System.out.println("temp : " + temp);
	            stack.addFirst(Integer.parseInt(temp));
	        }
	    }
	    return stack.poll();
	}
}
