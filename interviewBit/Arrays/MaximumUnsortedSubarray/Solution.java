import java.util.*;

public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> arr) {
        
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        
        if(arr.size() < 2)
        {
            toReturn.add(-1);
            return toReturn;
        }
        int n = arr.size();
        int i,j,num,start,end;
        for(i = 0; i < n - 1 ; i++)
        {
            if(arr.get(i + 1) < arr.get(i))
                break;
        }
        if(i == n - 1)
        {
            toReturn.add(-1);
            //System.out.println("size : " + arr.size());
            return toReturn;
        }
        for(j = n - 1; j > 0 ; j--)
        {
            if(arr.get(j - 1) > arr.get(j))
                break;
        }
        start = i;
        end = j;
        int flag = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int counter = i ; counter <= j ; counter++)
        {
            //System.out.println("val : " + arr.get(counter));
            if(arr.get(counter) < min)
                min = arr.get(counter);
            if(arr.get(counter) > max)
                max = arr.get(counter);
        }
        flag = 0; // this flag is set only when the control gets inside the while loop. 
        //it wont go inside the loop only if the initial value only is min. 
       // System.out.println("max : " + max + ",min : " + min);
        while(start >= 0 && arr.get(start) > min)
        {
            start--;
            flag = 1;
        }
        if(flag != 0)
            start++;
            
        flag = 0;
        //System.out.println("initial end : " + end);
        while(end < n && arr.get(end) < max)
        {
            flag = 1;
            end++;
            //System.out.println("end incremented : " + end);
        }
        if(flag != 0)
        {
            end--;
        }
        toReturn.add(start);
        toReturn.add(end);
        return toReturn;
    }
}
