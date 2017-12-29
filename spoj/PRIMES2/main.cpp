#include<stdio.h>
#include<iostream>
#include<vector>
#include<cmath>
#include<algorithm>
#include<cstring>


#define n 1000000000
//#define n 10000
//#define n 100

#define mod 500

#define L1_CACHE_SIZE 32768

void segmented_sieve(int limit);

using namespace std;
int main()
{
    segmented_sieve(n);
    return 0;
}

void segmented_sieve(int limit)
{
    int root_limit = (int)sqrt(limit);
    char *is_prime = (char*) malloc(sizeof(char) * (root_limit + 1));
    memset(is_prime,1,sizeof(char) * (root_limit + 1));

    //calculating small primes(less than root_limit + 1)
    for(int i = 2 ; i < root_limit + 1 ; i++)
    {
        if(is_prime[i] == 1)
        {
            for(int j = i * i ; j < root_limit + 1 ; j = j + i)
            {
                is_prime[j] = 0;
            }
        }
    }
    int count = 1;
    printf("%d\n",2);
    int segment_size = max(root_limit,L1_CACHE_SIZE);
    vector<char> sieve(segment_size,1);
    vector<int> primes;
    vector<int> next;
    int s = 3;
    int x = 3;
    int high;
    for(int low = 0 ; low <= limit ; low += segment_size)
    {
        fill(sieve.begin(),sieve.end(),1);
        high = min(limit,low + segment_size - 1);
        //cout << "low = " << low << ",high = " << high << endl;
        for(;s * s <= high ; s += 2)
        {
            if(is_prime[s] == 1)
            {
                primes.push_back(s);
                next.push_back(s * s - low);
            }
        }

        for(int i = 0 ; i < primes.size() ; i++)
        {
            int j = next[i];
            //for(int k = 2 * primes[i]; j < segment_size ; j += k)
            for(int k = 2 * primes[i]; j < segment_size ; j += k)
            {
                //*sieve[j] = 0;
                sieve[j] = 0;
                //sieve->
                //cout<< "setting sieve at j = " << j << "equal to 0" << endl;
            }
            next[i] = j - segment_size;
        }

        for(;x <= high ; x += 2)
        {
            if(sieve[x - low] == 1)
            {
                count++;
                //printf("%d\n",x);
                if(count % mod == 1)
                {
                    printf("%d\n",x);
                }
            }
        }
    }

}


