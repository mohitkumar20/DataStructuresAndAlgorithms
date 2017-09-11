class Solution:

    def __init__(self):

        self.slow = None
        self.fast = None



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



def detectCycle(self,head):

    cycle = self.hasCycle(head)

    if(cycle == False):
        return None

    self.slow = head

    while(self.slow is not self.fast):
        self.slow  = self.slow.next
        self.fast = self.fast.next

    return self 
