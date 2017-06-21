import java.util.*;
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        return find(arr);
    }
    
    public ArrayList<Integer> find(ArrayList<Integer> arr)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>(arr.size());
        ArrayList<Integer> toReturn = new ArrayList<Integer>(arr.size());
        int size = arr.size();
        for(int i = 0 ; i < size ; i++)
        {
            int num = arr.get(i);
            while(stack.size() != 0 && stack.peek() >= num)
            {
                stack.pollFirst();
            }
            if(stack.size() != 0)
            {
                toReturn.add(stack.peek());
            }
            else
            {
                toReturn.add(-1);
            }
            stack.addFirst(num);
        }
        return toReturn;
    }
}
