

public class Solution {
    public int maxProfit(int[] arr) {
        
        int n = arr.length;
        if(n == 0)
            return 0;
        int max = 0;
        int minSoFar = arr[0];
        for(int i = 0 ; i < n ; i++)
        {
            minSoFar = Math.min(minSoFar,arr[i]);
            max = Math.max(max,arr[i] - minSoFar);
        }
        return max;

    }
    
}