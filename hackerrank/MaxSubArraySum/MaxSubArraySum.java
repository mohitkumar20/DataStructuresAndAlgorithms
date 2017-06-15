import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxSubArraySum
{
      public static void main(String[] args) throws IOException
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t > 0)
            {
                  int n = Integer.parseInt(br.readLine());
                  int i;
                  long[] arr = new long[n];
                  StringTokenizer st = new StringTokenizer(br.readLine());
                  i = 0;
                  while(st.hasMoreTokens())
                  {
                        arr[i++] = Long.parseLong(st.nextToken());
                  }
                  func(arr,n);
                  t--;
            }
      }
      public static void func(long[] arr,int n)
      {
            if(n == 1)
            {
                  System.out.println(arr[0] + " " + arr[0]);
                  return;
            }
            long maxContSum,maxSum = 0;
            long[] mat = new long[n];
            mat[0] = arr[0];
            int i;
            if(arr[0] > 0)
            {
                  maxSum = arr[0];
            }
            else
            {
                  maxSum = 0;
            }
            for(i = 1 ; i < n ; i++)
            {
                  if(arr[i] > 0)
                  {
                        maxSum = maxSum + arr[i];
                  }
                  if(mat[i - 1] < 0 || mat[i - 1] + arr[i] < 0)
                  {
                        mat[i] = arr[i];
                  }
                  else
                  {
                        mat[i] = mat[i - 1] + arr[i];
                  }
            }
            maxContSum = mat[0];
            for( i = 1 ; i < n ; i++)
            {
                  if(maxContSum < mat[i])
                  {
                        maxContSum = mat[i];
                  }
            }
            if(maxSum == 0)
            {
                  maxSum = max(arr,n);
            }
            System.out.println(maxContSum + " " + maxSum);

      }
      public static long max(long[] arr,int n)
      {
            long maxElement = Integer.MIN_VALUE;
            for(int i = 0 ; i < n ; i++)
            {
                  if(arr[i] > maxElement)
                  {
                        maxElement = arr[i];
                  }
            }
            return maxElement;
      }
}
