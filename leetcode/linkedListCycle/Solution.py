class Solution:
    
    def hasCycle(self,head):

        if(head is None):
            return False

        fast = slow = head

        while(fast is not None and fast.next is not None):

            fast = fast.next
            if(slow is fast):
                return True

            fast = fast.next
            if(slow is fast):
                return True
            slow = slow.next

        return False
    
