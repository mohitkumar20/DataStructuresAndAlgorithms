class Solution:
    def combinationSum(self,arr,target):
        
        toReturn = []
        if(arr is None and len(arr) == 0):
            return toReturn
        n = len(arr)
        mat = [[0 for i in range(target + 1)] for j in range(n + 1)]

        for i in range(1,n + 1):
            for j in range(target + 1):
                if(j < arr[i - 1]):
                    mat[i][j] = mat[i - 1][j]

                elif(j == arr[i - 1]):
                    mat[i][j] = j


                else:
                    if(mat[i][j - arr[i - 1]] != 0):
                        mat[i][j] = arr[i - 1]
                    else:
                        mat[i][j] = mat[i - 1][j]

        myList = [0 for i in range(target)]
        self.func(mat,myList,arr,0,n,target,toReturn)
        return toReturn


    def func(self,mat,myList,arr,count,i,j,toReturn):
        # myList : acting as a buffer
        # count : number of elements in the buffer
        # i , j : row , column
        
        if(j == 0 ):
            tempList = []
            for i in range(count):
                tempList.append(myList[i])
            toReturn.append(tempList)
            return
        
        elif(mat[i][j] == 0):
            return 
        
        if(mat[i][j] == arr[i - 1]): # when this condition is not true, that means its copied from the above rows, that means its a duplicate
                                     # in ith row of mat, if the value is not equal to arr[i - 1], that means its valued is copied from the above row
            myList[count] = arr[i - 1]
            self.func(mat,myList,arr,count + 1,i,j - arr[i - 1],toReturn)

        self.func(mat,myList,arr,count,i - 1,j,toReturn)
        

if(__name__ == "__main__"):
    x = Solution()
    print(x.combinationSum([1,2],4))

