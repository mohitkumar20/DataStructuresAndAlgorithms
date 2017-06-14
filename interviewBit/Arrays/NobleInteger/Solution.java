import java.util.*;


public class Solution {
    public int solve(ArrayList<Integer> arr) {
        
        if(arr.size() == 1 && arr.get(0) == 0)
            return 1;
        if(arr.size() < 2)
            return -1;
         
        int n = arr.size(),min,max,countOfGreaterNums;
        int countOfNonNegative = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++)
        {
            int num = arr.get(i);
            if(num > max)
            {
                max = num;
            }
        }
        if(max == 0)
            return 1;
        int[] bucket = new int[max + 1];
        
        for(int i = 0 ; i < n ; i++)
        {
            int num = arr.get(i);
            if(num > 0)
            {
                bucket[num]++;
                countOfNonNegative++;
            }
        }
        int done = 0;
        for(int i = 1 ; i < max + 1 ; i++)
        {
            if(bucket[i] != 0)
            {
                countOfGreaterNums = countOfNonNegative - done - bucket[i];
                if(countOfGreaterNums == i)
                    return 1;
                    
                done += bucket[i];
            }
        }
        return -1;
    }
}
