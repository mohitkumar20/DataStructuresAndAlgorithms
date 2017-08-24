class Solution(object):
	def uniquePathsWithObstacles(self,obstacles):
	
            if(obstacles is None):
                return 0

            rows = len(obstacles)
            cols = len(obstacles[0])
            dp = [[0 for j in range(cols)] for i in range(rows)] 
             
            i = 0
            while(i < cols and obstacles[0][i] == 0):
                dp[0][i] = 1
                i = i + 1

            while(i < cols):
                dp[0][i] = 0
                i = i + 1

            i = 0
            while(i < rows and obstacles[i][0] == 0):
                dp[i][0] = 1
                i = i + 1
            while(i < rows):
                dp[i][0] = 0
                i = i + 1

            for i in range(1,rows):
                for j in range(1,cols):
                    if(obstacles[i][j] == 1):
                        dp[i][j] = 0
                    else:
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

            return dp[rows - 1][cols - 1]



