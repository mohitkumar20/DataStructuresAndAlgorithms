import java.util.*;
public class Solution {
	public String simplifyPath(String a) {
	   
	   if(a.equals("//") || a.equals("/"))
	   {
	       return "/";
	   }
	   String[] arr = a.split("/");
	   String ans = "/",popped;
	   ArrayDeque<String> st = new ArrayDeque<String>(arr.length);
	   int n = arr.length;
	   for(int i = 1 ; i < n ; i++)
	   {
	       //System.out.println("value : " + arr[i]);
	       if(arr[i].equals("."))
	       {
	           continue;
	       }
	       else if(arr[i].equals(".."))
	       {
	           //System.out.println("removing : " + st.peek());
	           if(!st.isEmpty())
	            st.poll();
	       }
	       else
	       {
	           
	           st.addFirst(arr[i]);
	          // System.out.println("adding : " + st.peek());
	       }
	   }
	   if(st.isEmpty())
	   {
	       return "/";
	   }
	   while(!st.isEmpty())
	   {
	       popped = st.poll();
	       //System.out.println("popped : " + popped);
	       if(ans.equals("/"))
	       {
	           ans = ans + popped;
	           continue;
	       }
	       if(popped.equals(""))
	       {
	           //System.out.println("caught nothing");
	       }
	       else
	       {
	           //System.out.println("appending : " + popped);
	           ans = "/" + popped + ans;
	       }
	      // System.out.println("ans : " + ans);
	   }
	   return ans;
	}
}
