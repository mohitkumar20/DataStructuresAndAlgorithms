class Solution:
    
    def __init__(self):
        self.fromFront = None

        
    def isPalindrome(self,head):

        self.fromFront = head
        
        ans = self.check(head)
        if(ans == 2 or ans == 1):
            return True
        return False
        

    def check(self,fromBack):
        if(fromBack is None):
            return 1

        ans = self.check(fromBack.next)
        if(ans == 0):
            return ans
        if(ans == 2):
            return 2
        if(fromBack.val != self.fromFront.val):
            return 0
        if(fromBack is self.fromFront or self.fromFront.next is fromBack):
            return 2
        self.fromFront = self.fromFront.next
        return 1
