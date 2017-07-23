class Solution(object):
    def maxProfit(self,arr):

        n = len(arr)
        if(n == 0):
            return 0

        if(n == 1):
            return 0
        if(n == 2):
            if(arr[0] < arr[1]):
                return arr[1] - arr[0]
            else:
                return 0
        dp = [0] * n
        for i in range(n - 2,-1,-1):
            dp[i] = dp[i + 1]
            for j in range(i + 1,n):
                if(arr[i] < arr[j]):
                    if(j + 2 < n):
                        dp[i] = max(dp[i],arr[j] - arr[i] + dp[j + 2])
                    else:
                        dp[i] = max(dp[i],arr[j] - arr[i])
        return dp[0]
