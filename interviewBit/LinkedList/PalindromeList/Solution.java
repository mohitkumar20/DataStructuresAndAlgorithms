
 // comment out the definition of ListNode while submitting the code on interviewBit.
 // Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
public class Solution {
    public int lPalin(ListNode a) {
        
        if(a == null)
        {
            return 1;
        }
        else if(a.next == null)
        {
            return 1;
        }
        
        ListNode faster,slower,head1,head2,endOfFirstHalfLL;
        faster = slower = head1 = a;
        while(faster.next != null)
        {
            if(faster.next.next == null)
            {
                break;
            }
            faster = faster.next.next;
            slower = slower.next;
        }
        endOfFirstHalfLL = slower;
        head2 = slower.next;
        head2 = reverseSecondHalfLL(endOfFirstHalfLL,head2);
        while(head1.val == head2.val)
        {
            if(head1.next == head2.next)
            {
                return 1;
            }
            else if(head1.next == head2 || head2.next == head1)
            {
                return 1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return 0;
    }
    
    public ListNode reverseSecondHalfLL(ListNode endOfFirstHalfLL,ListNode head2)
    {
        ListNode prev,curr,next;
        prev = endOfFirstHalfLL;
        curr = head2;
        while(curr.next != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }
}
