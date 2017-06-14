import java.util.*;

public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        /*
        int max = Integer.MIN_VALUE;
        Integer[] arr = new Integer[A.size()];
        arr = A.toArray(arr);
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                int num = Math.abs(arr[i] - arr[j]) + Math.abs(i - j);
                if(num > max)
                {
                    max = num; 
                }
            }
        }
        if(max < 0)
        {
            return 0;
        }
        return max;
        */
        
        int max1,max2,max3,max4,ans;
        max1 = max2 = max3 = max4 = ans = Integer.MIN_VALUE;
        Integer[] arr = new Integer[A.size()];
        arr = A.toArray(arr);
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            max1 = Math.max(max1,arr[i] + i);
            max2 = Math.max(max2,-arr[i] + i);
            max3 = Math.max(max3,arr[i] - i);
            max4 = Math.max(max4,-arr[i] - i);
        }
        
        for(int i = 0 ; i < n ; i++)
        {
            ans = Math.max(ans,max1 - arr[i] - i);
            ans = Math.max(ans,max2 + arr[i] - i);
            ans = Math.max(ans,max3 - arr[i] + i);
            ans = Math.max(ans,max4 + arr[i] + i);
        }
        
        return ans;
    }
}
