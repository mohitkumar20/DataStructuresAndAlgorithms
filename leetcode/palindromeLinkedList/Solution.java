
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution
{
    ListNode fromFront = null;
    public boolean isPalindrome(ListNode head)
    {

        fromFront = head;
        int ans = check(head);
        if(ans == 2 || ans == 1)
            return true;
        return false;
    }

    public int check(ListNode fromBack)
    {
        if(fromBack == null)
            return 1;

        int ans = check(fromBack.next);
        if(ans == 0 || ans == 2)
            return ans;

        if(fromBack.val != fromFront.val)
            return 0;

        if(fromBack == fromFront || fromFront.next == fromBack)
            return 2;

        fromFront = fromFront.next;
        return 1;

    }
}


