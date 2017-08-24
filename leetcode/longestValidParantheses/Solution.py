class Solution:

    def longestValidParentheses(self,arr):

        if(arr is None or len(arr) == 0 or len(arr) == 1):
            return 0

        n = len(arr)
        i = 0
        
        st = []

        while(i < n):
            
            if(arr[i] == '('):
                st.append(i)

            else:
                if(len(st) == 0 or arr[st[-1]] == ')'):
                    st.append(i)
                else:
                    st.pop()
            i = i + 1


        maxCount = 0
        while(len(st) > 0):
            count = i - st[-1] - 1
            if(count > maxCount):
                maxCount = count

            i = st.pop()


        if(i > maxCount):
            maxCount = i

        return maxCount
