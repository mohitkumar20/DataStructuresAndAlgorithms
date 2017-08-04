class Solution(object):

    def threeSum(self,arr):
        toReturn = []
        if(arr == None or len(arr) < 3):
            return toReturn
        arr.sort()
        i = 0
        n = len(arr)
        high = n - 1
        low = 1
        while(i < n - 2 and arr[i] < 1):
            if(i != 0 and arr[i] == arr[i - 1]):
                i = i + 1
                continue
            else:
                low = i + 1
                high = n - 1
                toCheck = abs(arr[i])
                while(low < high):
                    sum = arr[low] + arr[high]
                    if(sum == toCheck):
                        toReturn.append([arr[i],arr[low],arr[high]])
                        low = low + 1
                        while(low < high and arr[low] == arr[low - 1]):
                            low = low + 1
                        if(low == high):
                            break
                        high = high - 1
                        while(high > low and arr[high] == arr[high + 1]):
                            high = high - 1
                        if(high == low):
                            break
                    elif(sum < toCheck):
                        low = low + 1
                    else:
                        high = high - 1
            i = i + 1
        return toReturn
if(__name__ == "__main__"):
    x = Solution()
    print(x.threeSum([-5,-4,-1,0,0,1,1,2,3,4]))
