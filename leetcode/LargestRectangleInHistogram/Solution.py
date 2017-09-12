'''think like following for the problem. for having a rectangle we need to know the boundary limits.
'''
class Solution(object):
	def largestRectangleArea(self, arr):
		"""
		:type arr: List[int]
		:rtype: int
		"""
		st = [] # stack
		if(len(arr) == 0):
			return st
		i = 1;
		st.append(0)
		maxArea = 0
		area = 0
		for i in range(1,len(arr)):
			if(arr[st[-1]] <= arr[i]):
				st.append(i)
			else:
				while(st and arr[st[-1]] > arr[i]):
					topIndex = st.pop()
					if(not st):
						area = arr[topIndex] * i
						if(area > maxArea):
							maxArea = area
					else:
						area = arr[topIndex] * (i - st[-1] - 1)
						if(area > maxArea):
							maxArea = area
				st.append(i)	

		i = len(arr)
		while(st):
			topIndex = st.pop()
			if(not st):
				area = arr[topIndex] * i
				if(area > maxArea):
					maxArea = area
			else:
				area = arr[topIndex] * (i - st[-1] - 1)
				if(area > maxArea):
					maxArea = area

		return maxArea				
