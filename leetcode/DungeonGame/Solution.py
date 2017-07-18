import sys
class Solution(object):
    def calculateMinimumHP(self,dungeon):

        rows = len(dungeon)
        cols = len(dungeon[0])
        
        mat = []
        for i in range(0,rows):
            mat.append([sys.maxint]* cols)
        mat[rows - 1][cols - 1] = 1
        #print "rows" , rows,"cols", cols
        #print mat[0][0]
        for i in range(rows - 1,-1,-1):
            for j in range(cols - 1,-1,-1):
                #print "inside", i , j , mat[i][j]
                #print "mat 0 0" , mat[0][0]
                if(i - 1 >= 0):
                    val = mat[i][j] - dungeon[i][j]
                    #print val
                    if(val < mat[i - 1][j] and val > 0):
                        mat[i - 1][j] = val
                 #       print i,j,"in if"
                    elif(val <= 0):
                        mat[i - 1][j] = 1
                #        print i,j,"in elif"
                if(j - 1 >= 0):
                    val = mat[i][j] - dungeon[i][j]
                    if(val < mat[i][j - 1] and val > 0):
                        mat[i][j - 1] = val      
                    elif(val <= 0):
                        mat[i][j - 1] = 1
               # print mat[i][j]
       # print mat[0][0], mat[0][1]
        val = mat[0][0] - dungeon[0][0]
        if(val > 0):
            return val
        else:
            return 1


