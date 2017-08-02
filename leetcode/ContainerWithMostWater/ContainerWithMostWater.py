class Solution:
    def maxArea(self,height):

        maximum = 0
        i = 0
        n = len(height)
        j = n - 1
        while(i < j):
            maximum = max(maximum,min(height[i],height[j]) * (j - i))
            if(height[i] <= height[j]):
                i = i + 1
            else:
                j = j - 1


        return maximum
        
