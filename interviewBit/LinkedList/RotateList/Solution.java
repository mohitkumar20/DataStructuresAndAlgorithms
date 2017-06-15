// comment out the definition of ListNode while submitting the code on interviewBit.
 // Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
public class Solution {
	public ListNode rotateRight(ListNode a, int k) {
	    
	    int length = length(a);
	    if(length == 0)
	        return a;
	    k = k % length;
	    if(k == 0)
	        return a;
	    int toMove = length - k;
	    ListNode head,temp;
	    head = a;
	    while(toMove > 0)
	    {
	        head = head.next;
	        toMove--;
	    }
	    temp = head;
	    while(temp.next != null)
	    {
	        temp = temp.next;
	    }
	    temp.next = a;
	    while(a.next != head)
	    {
	        a = a.next;
	    }
	    a.next = null;
	    return head;
	}
	
	public int length(ListNode a)
	{
	    int length = 0;
	    while(a != null)
	    {
	        length++;
	        a = a.next;
	    }
	    return length;
	}
}
