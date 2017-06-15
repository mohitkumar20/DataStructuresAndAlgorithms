// comment out the definition of ListNode while submitting the code on interviewBit.
 // Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
	    if(a == null)
	        return a;
	   
	   ListNode curr = a,prev = null;
	   while(curr != null && curr.next != null)
	   {
	       if(curr.val != curr.next.val)
	       {
	           prev = curr;
	           curr = curr.next;
	       }
	       else
	       {
	           while(curr != null && curr.next != null && curr.val == curr.next.val)
	           {
	               if(a == curr)
	               {
	                   curr = curr.next;
	                   a = curr;
	               }
	               else
	               {
	                   curr = curr.next;
	               }
	           }
	           if(prev != null)
	           {
	               prev.next = curr.next;
	               curr = curr.next;
	           }
	           else
	           {
	               if(a == curr)
	               {
	                   curr = curr.next;
	                   a = curr;
	               }
	               else
	               {
	                   curr = curr.next;
	               }
	           }
	       }
	   }
	   return a;
	}
}
