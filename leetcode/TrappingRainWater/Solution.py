class Solution(object):
	def trap(self,arr):

		#height : List[int]
		#return : int
		n = len(arr)
		st = [] #stack
		water = 0
		for i in range(0,n):
			if(not st):
				st.append(i)
			else:
				#highest = 0
				if(arr[st[-1]] >= arr[i]):
					st.append(i)
				else:
					highest = 0
					while(st and arr[st[-1]] <= arr[i]):
						topIndex = st.pop()
						water += arr[topIndex] * (i - topIndex - 1) - highest * (i - topIndex - 1)
						if(arr[topIndex] > highest):
							highest = arr[topIndex]
					if(st):
						water += arr[i] * (i - st[-1] - 1) - highest(i - st[-1] - 1)
					st.append(i)

		return water