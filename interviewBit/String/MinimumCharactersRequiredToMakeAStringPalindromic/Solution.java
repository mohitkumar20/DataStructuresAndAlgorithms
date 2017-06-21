public class Solution {
    public int solve(String A) {
        
        //first, the original string is concatenated with a sentinel character and after that reverse of it.
        //then we need to find LPS of the obtained string. answer is length of original string - LPS of the obtained string
        char[] c = A.toCharArray();
        int originalLength = c.length;
        char[] arr = new char[2 * originalLength + 1];
        int[] prefix = new int[2 * originalLength + 1];
        int i = 0 , j = 0;
        for(i = 0 ; i < c.length ; i++)
        {
            arr[j] = c[i];
            j++;
        }
        arr[j++] = ';';
        for(i = originalLength - 1 ; i >= 0 ; i--)
        {
            arr[j++] = c[i];
        }
        prefix[0] = 0;
        i = 1;
        j = 0;
        int n = 2 * originalLength + 1;
        while(i < n)
        {
            if(arr[i] == arr[j])
            {
                prefix[i] = j + 1;
                i++;
                j++;
            }
            else
            {
                if(j > 0)
                    j = prefix[j - 1];
                else
                {
                    prefix[i] = 0;
                    i++;
                }
            }
        }
        return originalLength - prefix[n - 1];
        
    }
}
