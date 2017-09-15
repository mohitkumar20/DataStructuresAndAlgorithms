# this question is from geeks for geeks

def func(arr,n):
    
    if(n == 1):
        print(-1)
        return
    next_larger = [-1 for i in range(n)]
    next_larger[n - 1] = -1
    st = [] # stack
    st.append(arr[n - 1])

    for i in range(n -2,-1,-1):
        
        while(len(st) > 0 and st[-1] <= arr[i]):
            st.pop()
        if(len(st) == 0):
            next_larger[i] = -1
        else:
            next_larger[i] = st[-1]
        st.append(arr[i])

    for i in range(0,n):
        print(next_larger[i],end=" ")

    print()


t = int(input())

for k in range(t):

    n = int(input())
    arr = input().split(sep=" ")
    arr = [int(arr[i]) for i in range(n)]
    func(arr,n)

