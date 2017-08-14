class Solution():
    def findTargetSumWays(self,arr,target):

        if(arr is None or len(arr) == 0):
            return 0

        self.negativeSum = 0
        n = len(arr)
        for i in range(n):
            self.negativeSum -= arr[i]

        self.shift = abs(self.negativeSum) 
        dp = [[self.negativeSum - 1 for j in range(2 * self.shift + 1)] for i in range(n)]
        
        '''
        for i in range(len(dp)):
            for j in range(len(dp[i])):

                print(dp[i][j],end = " ")

            print()
        '''
        target = target + self.shift
        return self.func(0,arr,dp,self.shift,target,n)







    def func(self,pos,arr,dp,sum,target,n):
        if(pos == n):
            if(target == sum):
                return 1
            else:
                return 0

        if(dp[pos][sum] > self.negativeSum - 1):
            return dp[pos][sum]

        else:
            dp[pos][sum] = self.func(pos + 1,arr,dp,sum + arr[pos],target,n) + self.func(pos + 1,arr,dp,sum - arr[pos],target,n)
            return dp[pos][sum]













if(__name__ == "__main__"):

    x = Solution()

    print(x.findTargetSumWays([1,1,1,1,1],3))
        
