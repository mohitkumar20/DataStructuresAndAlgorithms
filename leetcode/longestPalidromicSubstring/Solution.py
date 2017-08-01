class Solution:
    def longestPalindrome(self,s):

        # s = string
        #return type : int
        if(s is None or len(s) == 0):
            return 0
        n = len(s)
        if(n == 1):
            return s[0]
        if(n == 2):
            if(s[0] == s[1]):
                return s[0:2]
            else:
                return s[0]
        dp = [[0 for j in range(n)] for i in range(n)]

        max = 1
        ans = s[0]
        for i in range(n):
            dp[i][i] = 1
            if(i < n - 1):
                if(s[i] == s[i + 1]):
                    dp[i][i + 1] = 2
                    if(dp[i][i + 1] > max):
                        max = 2
                        ans = s[i : i + 2]
                else:
                    dp[i][i + 1] = 0
        

        for width in range(2,n):
            for i in range(0,n - width):
                j = i + width
                if(s[j] != s[i]):
                    dp[i][j] = 0
                else:
                    if(dp[i + 1][j - 1] == 0):
                        dp[i][j] = 0
                    else:
                        dp[i][j] = dp[i + 1][j - 1] + 2
                        if(dp[i][j] > max):
                            max = dp[i][j]
                            ans = s[i:i + max]
        return ans

if(__name__ == "__main__"):
    x = Solution()
    print(x.longestPalindrome("babad"))

