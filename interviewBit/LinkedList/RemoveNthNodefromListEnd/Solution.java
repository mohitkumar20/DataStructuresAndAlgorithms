// comment out the definition of ListNode while submitting the code on interviewBit.
 // Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
public class Solution {
	public ListNode removeNthFromEnd(ListNode a, int b) {
	    return func(a,b);
	}
	
	public ListNode func(ListNode head,int n)
	{
	    if(head == null)
	        return head;
	   
	    if(n < 1)
	    {
	        return head;
	    }
	    int size = 0;
	    ListNode curr = head;
	    while(curr != null)
	    {
    	    size++;
    	    curr = curr.next;
	    }
	    if(n >= size)
	    {
	        head = head.next;
	        return head;
	    }
	    else{
	        curr = head;
	        ListNode prev = null;
	        int limit = size - n;
	        int count = 0;
	        while(count < limit)
	        {
	            prev = curr;
	            curr = curr.next;
	            count++;
	        }
	        prev.next = curr.next;
	        return head;
	    }
	}
}
