// comment out the definition of ListNode while submitting the code on interviewBit.
 // Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
public class Solution {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
	    
	    ListNode curr1 = a, curr2 = b;
	    ListNode h3,curr3;
	    h3 = curr3 = null;
	    if(a == null && b == null)
	    {
	        return null;
	    }
	   while(curr1 != null && curr2 != null)
	   {
	       while(curr1 != null && curr2 != null && curr1.val <= curr2.val)// in this line. make sure u check both, curr1 and curr2 for null. important
	       {
	           if(curr3 == null)
	           {
	               curr3 = new ListNode(curr1.val);
	               h3 = curr3;
	           }
	           else
	           {
	               curr3.next = new ListNode(curr1.val);
	               curr3 = curr3.next;
	           }
	           curr1 = curr1.next;
	       }
	       
	       while(curr1 != null && curr2 != null &&  curr2.val <= curr1.val)
	       {
	           if(curr3 == null)
	           {
	               curr3 = new ListNode(curr2.val);
	               h3 = curr3;
	           }
	           else
	           {
	               curr3.next = new ListNode(curr2.val);
	               curr3 = curr3.next;
	           }
	           curr2 = curr2.next;
	       }
	   }
	   
	   while(curr1 != null)
	   {
	       if(curr3 == null)
	       {
	           curr3 = new ListNode(curr1.val);
	           h3 = curr3;
	       }
	       else
	       {
	           curr3.next = new ListNode(curr1.val);
	           curr3 = curr3.next;
	       }
	       curr1 = curr1.next;
	   }
	    while(curr2 != null)
	   {
	       if(curr3 == null)
	       {
	           curr3 = new ListNode(curr2.val);
	           h3 = curr3;
	       }
	       else
	       {
	           curr3.next = new ListNode(curr2.val);
	           curr3 = curr3.next;
	       }
	       curr2 = curr2.next;
	   }
	   return h3;
	}
}
