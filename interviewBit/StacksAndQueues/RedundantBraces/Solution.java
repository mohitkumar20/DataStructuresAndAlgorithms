import java.util.*;
public class Solution {
	public int braces(String a) {
	    
	    char[] arr = a.toCharArray();
	    ArrayDeque<Character> st = new ArrayDeque<Character>();
	    int length = arr.length;
	    for(int i = 0 ; i < length ; i++)
	    {
	        if(arr[i] != ')')
	        {
	            //System.out.println("pushed = " + arr[i]);
	            st.addFirst(arr[i]);
	        }
	        else
	        {
	            boolean isThereOperator = false,isTherePlaceHolder = false;
	            char popped;
	            int numOfNonOperators = 0;
	            //System.out.println("size = " + st.size());
	            while((popped = st.peek()) != '(')
	            {
	                popped = st.poll();
	               // System.out.println("popped element : " + popped);
	                if(popped == '+' || popped == '-' || popped == '*' || popped == '/')
	                {
	                    //System.out.println("Setting op");
	                    isThereOperator = true;
	                }
	                else
	                {
	                    numOfNonOperators++;
	                    if(popped == '$')
	                {
	                    //System.out.println("Setting ph");
	                    isTherePlaceHolder = true;
	                }
	                
	                }
	                
	            }
	            st.poll();
	            st.addFirst('$');
	           // System.out.println("ph = " + isTherePlaceHolder + ", op = " + isThereOperator);
	            if(isThereOperator == false && isTherePlaceHolder == true)
	            {
	                return 1;
	            }
	            
	            else if(isThereOperator == false && isTherePlaceHolder == false && numOfNonOperators == 1)
	            {
	                return 1;
	            }
	        }
	    }
	    return 0;
	}
}
