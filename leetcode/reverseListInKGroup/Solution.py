class ListNode:
    def __init__(self,x):
        self.next = None
        self.val = x

class Solution:

    def reverseKGroup(self,head,k):

        if(k < 2 or head is None or head.next is None):
            return head
        
        prevBlock = None
        curr = head
        while(curr != None):

            start = curr
            count = 0
            while(count < k - 1 and curr.next != None): #want to stop at the last element in the group
                count = count + 1
                curr = curr.next

            if(count < k - 1): # if the size of the last possible block is not sufficient, we need not to change anything except for changing prevBlock.next to start 

                if(prevBlock != None):
                    prevBlock.next = start
                return head

            end = curr
            nextBlock = end.next
            self.reverse(start,end)

            if(start == head):
                head = end
            
            temp = start #swapping start and end node
            start = end
            end = temp

            if(prevBlock != None):
                prevBlock.next = start

            prevBlock = end
            curr = nextBlock

        return head




    def swap(start,end):

        temp = start
        start = end
        end = temp

    def reverse(self,start,end):
        
        curr = start
        prev = None
        while(curr != None):

            nextNode = curr.next
            curr.next = prev
            prev = curr
            if(curr == end):
                return
            curr = nextNode



