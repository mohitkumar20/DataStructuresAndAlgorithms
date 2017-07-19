class Solution(object):
    def wordBreak(self,s,wordDict):

        mySet = set()
        n = len(s)
        for i in range(len(wordDict)):
            mySet.add(wordDict[i])
        #brute force method 
        #return self.func(s,0,mySet,n)
        return self.func2(s,mySet,n)


    def func2(self,s,mySet,n):

        # s = string
        # mySet = dictionary(set)
        
        aux = [False for i in range(n)]
        if(s[n - 1] in mySet):
            aux[n - 1] = True
        for i in range(n - 2,-1,-1):
            arr = ""
            for j in range(i,n):
                arr += s[j]
                if(arr in mySet):
                    if(j + 1 < n and aux[j + 1] == True):
                        aux[i] = True
                        break
                    elif(j + 1 == n):
                        aux[i] == True
                        break
        print(aux)
        return aux[0]
            





    '''    
    #brute force method
    def func(self,s,pos,mySet,n):

        # s = string
        # pos = index in the string
        # mySet = dictionary(set)
        # n = length of the sttring
        if(pos == n):
            return True
        arr = ""
        for i in range(pos,n):
            arr += s[i]
            if(arr in mySet):
                ans = self.func(s,i + 1,mySet,n)
                if(ans == True):
                    return ans

        return False
    '''
