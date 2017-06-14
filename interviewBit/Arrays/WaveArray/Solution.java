import java.util.*;

public class Solution {
	public ArrayList<Integer> wave(ArrayList<Integer> arr) {
	    
	    int n = arr.size();
	    if(n < 2)
	        return arr;
	        
	   Comparator<Integer> comparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer left, Integer right) {
        return left - right; // use your logic
    }
    };
    
    Collections.sort(arr,comparator);
	   for(int i = 0 ; i < n - 1 ; i = i + 2)
	   {
	       swap(arr,i,i + 1);
	   }
	   return arr;
	        
	}
	public void swap(ArrayList<Integer> arr,int i,int j)
	{
	    int temp = arr.get(i);
	    arr.set(i,arr.get(j));
	    arr.set(j,temp);
	}
}
