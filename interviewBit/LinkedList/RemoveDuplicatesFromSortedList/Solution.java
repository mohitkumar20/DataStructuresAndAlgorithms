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
	   
	   ListNode curr,local;
	   local = null;
	   curr = a;
	   while(curr != null && curr.next != null)
	   {
	       local = curr.next;
	       while(local != null && local.val == curr.val)
	       {
	           local = local.next;
	       }
	       curr.next = local;
	       curr = local;
	   }
	   return a;
	}
}
