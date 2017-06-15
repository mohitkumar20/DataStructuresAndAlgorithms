import java.io.*;
import java.util.*;
public class Bricks
{
public static void main(String[] args) throws IOException
{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      while(t > 0)
      {
            int n  = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            long[] friend = new long[n];
            long[] me = new long[n];
            int i = 0 ;
            while(st.hasMoreTokens())
            {
                  arr[i] = Long.parseLong(st.nextToken());
                  friend[i] = -1;
                  me[i] = -1;
                  i++;
            }
            System.out.println(func(friend,me,n,arr,0,0));
            t--;
      }
}
      public static long func(long[] friend,long[] me,int n,long[] arr,int index,int turn)
      {
            if(index >= n - 3)
            {
                  if(turn == 1)
                {
                    if(friend[index] != -1)
                    {
                        return friend[index];
                    }
                    else
                    {
                        friend[index] = 0;
                        return friend[index];
                    }
                 }
                 else
                 {
                       if(me[index] != -1)
                    {
                        return me[index];
                    }
                    else
                    {
                        long sum = 0;
                        for (int i = index; i < n; i++)
                        {
                            sum = sum + arr[i];
                        }
                        me[index] = sum;
                        return me[index];
                    }
                 }
            }
            else
            {
                  long buyOne,buyTwo,buyThree;
                  if(turn == 0)
                  {
                        if(friend[index + 1] != -1)
                    {
                        buyOne = friend[index + 1];
                    }
                    else
                    {
                        buyOne = func(friend, me, n, arr, index + 1, 1);
                    }
                    if(friend[index + 2] != -1)
                    {
                        buyTwo = friend[index + 2];
                    }
                    else
                    {
                        buyTwo = func(friend, me, n, arr, index + 2, 1);
                    }
                    if(friend[index + 3] != -1)
                    {
                        buyThree = friend[index + 3];
                    }
                    else
                    {
                        buyThree = func(friend, me, n, arr, index + 3, 1);
                    }
                    me[index] = max(buyOne + arr[index], buyTwo + arr[index] + arr[index + 1], arr[index] + arr[index + 1] + arr[index + 2] + buyThree);
                    return me[index];
                  }
                  else
                  {
                        if(me[index + 1] != -1)
                    {
                        buyOne = me[index + 1];
                    }
                    else
                    {
                        buyOne = func(friend, me, n, arr, index + 1, 0);
                    }
                    if(me[index + 2] != -1)
                    {
                        buyTwo = me[index + 2];
                    }
                    else
                    {
                        buyTwo = func(friend, me, n, arr, index + 2, 0);
                    }
                    if(me[index + 3] != -1)
                    {
                        buyThree = me[index + 3];
                    }
                    else
                    {
                        buyThree = func(friend, me, n, arr, index + 3, 0);
                    }
                    friend[index] = min(buyOne, buyTwo, buyThree);
                    return friend[index];
                  }
            }
      }
      public static long max(long first,long second,long third)
      {
            long max = first;
            if (second > max)
            {
                max = second;
            }
            if (third > max)
            {
                max = third;
            }
            return max;
      }
      public static long min(long first,long second,long third)
      {
            long min = first;
            if (second < min)
          {
             min = second;
          }
          if (third < min)
          {
             min = third;
          }
          return min;
      }
}
