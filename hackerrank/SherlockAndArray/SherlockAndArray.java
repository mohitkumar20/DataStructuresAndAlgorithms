import java.io.*;
import java.util.*;

public class SherlockAndArray
{
      public static void main(String[] args) throws IOException
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t > 0)
            {
                  int n = Integer.parseInt(br.readLine());
                  StringTokenizer st = new StringTokenizer(br.readLine());
                  int i = 0 ;
                  int[] arr = new int[n];
                  while(st.hasMoreTokens())
                  {
                        arr[i++] = Integer.parseInt(st.nextToken());
                  }
                  func(arr,n);
                  t--;
            }
      }
      public static void func(int[] arr,int n)
      {
            if(n == 1)
            {
                  System.out.println("YES");
                  return;
            }
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];
            int i,sum = 0;
            for(i = 1 ; i < n ; i++)
            {
                  sum = sum + arr[i - 1];
                  leftSum[i] = sum;
            }
            sum = 0;
            for(i = n - 2 ; i >= 0 ; i--)
            {
                  sum = sum + arr[i + 1];
                  rightSum[i] = sum;
            }
            for(i = 0; i < n ; i++)
            {
                  if(leftSum[i] == rightSum[i])
                  {
                        System.out.println("YES");
                        return;
                  }
            }
            System.out.println("NO");
      }
}
