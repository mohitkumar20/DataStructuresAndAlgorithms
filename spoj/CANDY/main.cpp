#include<cstdio>
#include<cmath>
#include<iostream>
#include<algorithm>
#include<string>
#include<cstring>
#include<vector>
#include<cstdlib>
//#include<stdlib>


int main()
{
    int n ;
    while(true)
    {
        scanf("%d",&n);
        if(n == -1)
        {
            return 0;
        }
        int max_size = 10000;
        std::vector<int> arr(max_size);
        unsigned int sum = 0;
        unsigned int value;
        for(int i = 0 ; i < n ; i++)
        {
            scanf("%u",&value) ;
            sum += value;
            arr[i] = value;
        }
        if(sum % n != 0)
        {
            printf("%d\n",-1);
        }
        else
        {
            unsigned int equal = sum / n;
            unsigned int steps = 0;
            for(int i = 0 ; i < n ; i++)
            {
                if(arr[i] < equal)
                    steps += (equal - arr[i]);
            }
            printf("%u\n",steps);
        }
    }
    return 0;
}