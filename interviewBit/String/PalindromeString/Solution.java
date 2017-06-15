public class Solution {
	public int isPalindrome(String a) {
	    
	    char[] arr = a.toCharArray();
	    int i,j;
	    i = 0;
	    j = arr.length - 1;
	    int n = arr.length;
	    while(i < j && i < n && j >= 0)
	    {
	        while(i < n && !((arr[i] >= 48 && arr[i] <= 57) || (arr[i] >= 65 && arr[i] <= 90) || (arr[i] >= 97 && arr[i] <= 120)))
	        {
	            i++;
	        }
	        if(i == n )
	        {
	            return 1;
	        }
	        while(j >= 0 && !((arr[j] >= 48 && arr[j] <= 57) || (arr[j] >= 65 && arr[j] <= 90) || (arr[j] >= 97 && arr[j] <= 120)))
	        {
	            j--;
	        }
	        if(j < 0)
	            return 1;
	        if(i < n && j >= 0)
	        {
	            //System.out.println(arr[i] + " " + arr[j]);
	            if((arr[i] >= 48 && arr[i] <= 57) || (arr[j] >= 48 && arr[j] <= 57))
	            {
	                if(arr[i] != arr[j])
	                {
	                      // System.out.println(arr[i] + " " + arr[j]);
	                       return 0;
	                }
	            }
	            else
	            {
	                
	                if(!((arr[i] == arr[j]) || (arr[i] == arr[j] + 32) || (arr[j] == arr[i] + 32)))
	                    {
	                        //System.out.println(j);
	                     //  System.out.println(arr[i] + " " + arr[j]);
	                       return 0;
	                }
	            }
	        }
	        i++;
	        j--;
	    }
	    return 1;
	}
}
