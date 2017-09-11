'''
better approach would have been to first calculate the numeric values represented
by the lists and then add them and then create the list from the summation
'''



class Solution:

    def __init__(self):
        self.carry = 0
        self.head = None

    def addTwoNumbers(self,list1,list2):

        m = self.length(list1)
        n = self.length(list2)
        if(m >= n): # the first parameter to the func will always be the bigger list
            return self.func(list1,m,list2,n)
        else:
            return self.func(list2,n,list1,m)


    def func(self,list1,m,list2,n):
        
        counter = 0
        start = list1

        #the length of list1 from the pointer start to its end has the same length as of list2

        while(counter < m - n):
            counter = counter + 1
            start = start.next

        # first we will calculate the summation from pointer start to the end of list1 with list2
        # after that we will calculate summation for the remaining part of the list1 


        self.head = self.add1(start,list2)
        self.head = self.add2(list1,start)

        if(self.carry > 0):
            newRoot = ListNode(self.carry)
            newRoot.next = self.head
            self.head = newRoot
 
        return self.head

    
    #calculates the summation of remaining(remaining most significate digits) of list1 with carry
    def add2(self,list1,start):

        if(list1 is start):
            return self.head

        root = self.add2(list1.next,start)
        summation = list1.val + self.carry
        val = summation % 10
        self.carry = (summation - val) // 10
        newRoot = ListNode(val)
        newRoot.next = root
        return newRoot
    

 
    #calculates the summation of list2 and the list1(from pointer start to the end of list1)
    def add1(self,list1,list2):
        
        if(list1 is None and list2 is None):
            return None

        root = self.add1(list1.next,list2.next)
        summation = list1.val + list2.val + self.carry
        val = summation % 10
        self.carry = (summation - val) // 10
        newRoot = ListNode(val)
        newRoot.next = root
        return newRoot


    def length(self,head):

        length = 0
        while(head is not None):
            length = length + 1
            head = head.next
        
        return length
