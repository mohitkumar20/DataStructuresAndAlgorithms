#include<iostream>
#include<cstdlib>
#include<string>
#include<vector>
#include<algorithm>
#include<cmath>
#include<cstdio>
#include<limits>

#define MAX 1000000001
#define MIN -1

void func(std::vector<int>&,int,int,int,int);

int main()
{
    int t;    
    scanf("%d",&t);
    while(t)
    {
        int n ,c ;
        scanf("%d %d",&n,&c);
        std::vector<int> arr;
        int max = MIN;
        int min = MAX;
        for(int i = 0 ; i < n ; i++)
        {
            int val;
            scanf("%d",&val);
            if(val < min)
                min = val;
            else if(val > max)
                max = val;
            arr.push_back(val);
        }
        func(arr,n,c,min,max);
        t--;
    }
    return 0;
}

bool check(std::vector<int>& arr,int n,int c ,int key)
{
    int count = 1;
    int i = 0;
    int j;
    //printf("checking for key = %d\n",key);
    //printf("select at i = %d , value = %d\n",i,arr[i]);
    while(i < n)
    {
        j = i + 1;
        while(j < n && arr[j] - arr[i] < key)
        {
            j++;
        }
        if(j < n)
        {
            count++;
            //printf("select at i = %d , value = %d\n",i,arr[i]);
            if(count == c)
            {
                return true;
            }
        }
        else
        {
            return false;
        }
        i = j;
    }
}

void func(std::vector<int>& arr,int n , int c,int low,int high)
{
    std::sort(arr.begin(),arr.end());
    int max_dis = high - low;
    low = 1;
    high = max_dis;
    while(low < high)
    {
        int mid = (low + high) / 2;
        //printf("low = %d , high = %d , mid = %d\n",low,high,mid);
        if(high == low + 1)
        {
            bool ans = check(arr,n,c,high);
            //printf("check from inside : %d\n",ans);
            if(ans == true)
            {
                low = high;
                break;
            }
            else
            {
                high = low;
            }
        }
        bool ans = check(arr,n,c,mid);
        //printf("check from outside : %d\n",ans);
        if(ans == true)
        {
            low = mid;
        }
        else
            high = mid - 1;

    }
    printf("%d\n",low);
    return;
}