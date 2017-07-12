# Definition for singly-linked list.
class ListNode(object):
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution(object):
	def swapPairs(self, head):
		first = second = curr = currNext = prev = None
		curr = head
		while(curr and curr.next):
			first = curr
			second = curr.next
			if(first != head):
				nextCurr = second.next
				prev.next = second
				second.next = first
				first.next = nextCurr
				prev = curr
				curr = curr.next

			else:
				head = second
				nextCurr = second.next
				first.next = nextCurr
				second.next = first
				prev = curr
				curr = curr.next
		
		return head
