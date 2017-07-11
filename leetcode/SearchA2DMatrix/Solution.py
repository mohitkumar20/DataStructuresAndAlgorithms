class Solution(object):
    def searchMatrix(self,matrix,target):
        rows = len(matrix)
        if(rows == 0):
            return False
        cols = len(matrix[0])
        i = 0
        j = cols - 1
        while(i < rows and j >= 0):
            if(matrix[i][j] == target):
                return True 
            elif(target < matrix[i][j]):
                j = j - 1
            else:
                i = i + 1
        return False 
