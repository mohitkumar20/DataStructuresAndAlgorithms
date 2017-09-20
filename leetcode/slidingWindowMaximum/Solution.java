import java.util.*;
public class Solution
{
    public int[] maxSlidingWindow(int[] arr,int k)
    {

        int n = arr.length;
        if(n <= 0)
            return new int[];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(n);
        int[] ans = new int[n - k + 1];
        int index = 0; // will keep track of index in ans array.
        for(int i = 0 ; i < n; i++) 
        {
            if(i < k - 1)
            {
                popFromFront(deque,arr,i,k);
                popFromEnd(deque,arr,i,k);
            }
            else
            {
                popFromFront(deque,arr,i,k);
                popFromEnd(deque,arr,i,k);
                ans[index++] = arr[deque.peek()];
            }
        }
        return ans;

    }

    public void popFromFront(ArrayDeque<Integer> deque,int[] arr,int i ,int k)
    {

        while(deque.size() > 0 && deque.peek() < i - k + 1)
        {
            deque.pollFirst();
        }

    }  




    public void popFromEnd(ArrayDeque<Integer> deque, int[] arr,int i,int k)
    {

        while(deque.size() > 0 && arr[deque.peekLast()] < arr[i])
        {
            deque.pollLast();
        }
        deque.addLast(i);
    }
}
