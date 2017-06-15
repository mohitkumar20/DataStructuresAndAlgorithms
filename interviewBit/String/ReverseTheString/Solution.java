public class Solution {
	public String reverseWords(String a) {
	    
	    if(a == null || a.length() == 1)
	        return a;
	    
	    char[] arr = a.toCharArray();
	    int i = 0;
	    int j = arr.length - 1;
	    reverse(arr,i,j);
	    int n = arr.length;
	    while(i < n)
	    {
	        while(i < n && arr[i] == ' ')
	        {
	            i++;
	        }
	        int start = i;
	        i++;
	        while(i < n && arr[i] != ' ')
	        {
	            i++;
	        }
	        reverse(arr,start,i - 1);
	    }
	    return new String(arr);
	    
	}
	
	public void reverse(char[] arr,int start,int end)
	{
	    while(start < end)
	    {
	        swap(arr,start,end);
	        start++;
	        end--;
	    }
	}
	
	public void swap(char[] arr,int i,int j)
	{
	    char temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}
