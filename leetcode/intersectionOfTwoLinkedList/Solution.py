# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self,list1,list2):
        
        if(list1 is None or list2 is None):
            return None

        l1 = self.length(list1)
        l2 = self.length(list2)

        if(l1 > l2):
            counter = 0
            while(counter < l1 - l2):
                counter = counter + 1
                list1 = list1.next

        elif(l2 > l1):
            counter = 0
            while(counter < l2 - l1):
                counter = counter + 1
                list2 = list2.next


        while(list1 is not None): # not need to check for list2 to end as both will end at the same time now.
            if(list1 is list2):
                return list1
            list1 = list1.next
            list2 = list2.next

        return None



    def length(self,head):
        # returns the length of the linked list

        length = 0
        curr = head
        while(curr is not None):
            curr = curr.next
            length = length + 1

        return length
