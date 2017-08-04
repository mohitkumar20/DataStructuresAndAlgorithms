
class Solution:
    def __init__(self):
        self.numbersToString = [" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]

    def func(self,pos,listOfStrings,toReturn,n,myBuffer):
        # pos : position
        # listOfStrings : its the list of string corresponding the digits in the number
        # toReturn : list of strings to be returned as answer
        # n : length of the phone number
        #myBuffer : buffer
        
        if(pos == n):
            toAdd = ""
            for i in range(n):
                toAdd = toAdd + myBuffer[i]
            toReturn.append(toAdd)

        else:
            string = listOfStrings[pos]
            for i in range(len(string)):
                myBuffer[pos] = string[i]
                self.func(pos + 1,listOfStrings,toReturn,n,myBuffer)



    def letterCombinations(self,digits):
        toReturn = []
        if(digits is None or len(digits) == 0):
            return toReturn
        listOfStrings = []
        for i in range(len(digits)):
            index = int(digits[i])
            listOfStrings.append(self.numbersToString[index])
        n = len(digits)     
        myBuffer = [None for i in range(n)]
        self.func(0,listOfStrings,toReturn,n,myBuffer)
        return toReturn


    


if(__name__ == "__main__"):
    x = Solution()
    print(x.letterCombinations("23"))
