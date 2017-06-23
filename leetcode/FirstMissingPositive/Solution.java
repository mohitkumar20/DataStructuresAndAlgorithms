public class Solution {
    public int firstMissingPositive(int[] arr) {
        
        int n = arr.length;
        int i = 0;
        while(i < n)
        {
            if(arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i])// third condition is crucial as if it is not mentioned, it can go in a indefinite loop.
            {
                swap(arr,i,arr[i] - 1);
            }
            else
            {
                i++;
            }
        }
        
        i = 0;
        while(i < n)
        {
            if(arr[i] != i + 1 )
            {
                return i + 1;
            }
            i++;
        }
        return n + 1;
    }
    
    public void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}