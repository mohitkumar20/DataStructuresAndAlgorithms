class Solution(object):
    def maxProfit(self,arr):

        if not arr:
            return 0
        n = len(arr)
        if(n == 0):
            return 0
        if(n == 1):
            return 0
        if(n == 2):
            if(arr[1] > arr[0]):
                return arr[1] - arr[0]
            else:
                return 0
        dp = [0] * n
        dp[0] = 0
        total = 0
        for i in range(1,n):
            total += max(0,arr[i] - arr[i - 1])

        return total


