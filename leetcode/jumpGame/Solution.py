class Solution:
    '''
    #first method
    def jump(self,arr):

        n = len(arr)
        if(n == 0):
            return 0

        steps = [-1 for i in range(n)]
        steps[0] = 0

        for i in range(0,n - 1):

            if(arr[i] == 0):
                continue

            j = arr[i]
            if(i + j >= n - 1):
                return steps[i] + 1


            while(steps[i + j] == -1):
                steps[i + j] = steps[i] + 1
                j = j - 1
        return steps[n - 1]
        '''


    #second and better method


    def jump(self,arr):

        n = len(arr)

        jumps = currEnd = furthest = 0

        for i in range(0,n - 1):

            furthest = max(furthest,i + arr[i])

            if(i == currEnd):
                jumps += 1
                currEnd = furthest

        return jumps


if(__name__ == '__main__'):

    x = Solution()
    print(x.jump([2,3,1]))
