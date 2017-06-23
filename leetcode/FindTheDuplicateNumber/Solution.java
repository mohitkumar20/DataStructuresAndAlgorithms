public class Solution {
    public int findDuplicate(int[] arr) {
        
        int i = 0 ;
        int length = arr.length;
        while(i < length)
        {
            if(arr[i] != i + 1)
            {
                if(arr[arr[i] - 1] == arr[i])
                    return arr[i];
                else
                {
                    swap(arr,i,arr[i] - 1);
                }
            }
            else
                i++;
        }
        return 0;
    }
    public void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}