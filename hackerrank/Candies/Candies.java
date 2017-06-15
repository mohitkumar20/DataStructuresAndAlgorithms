import java.io.*;

public class Candies
{
      public static void main(String[] args) throws Exception
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++)
            {
                  arr[i] = Integer.parseInt(br.readLine());
            }
            func(arr,n);
      }
      public static void func(int[] arr,int n)
      {
            long[] processed = new long[n];
            long[] candies = new long[n];
            int i;
            for(i = 0 ; i < n ; i++)
            {
                  candies[i] = 1;
            }

            for(i = n - 2 ; i >= 0 ; i--)
            {
                  if(arr[i + 1] < arr[i])
                  {
                        processed[i] = processed[i + 1] + 1;
                  }
                  else
                  {
                        processed[i] = 0;
                  }
            }
            /*
            System.out.println("---------------------");
            for( i = 0 ; i < n ; i++)
            {
                  System.out.println(processed[i]);
            }
            */

            for(i = 0 ; i < n - 1 ; i++)
            {

                  if(processed[i] == 0 )
                  {
                        if(processed[i + 1] == 0)
                        {
                              if(arr[i + 1] != arr[i])
                              {
                                    candies[i + 1] = candies[i] + 1;
                              }
                        }
                  }
                  else
                  {
                        //System.out.println("i = " + i);
                        long numOfCandies = 1 + processed[i];
                        if(i != 0 &&  numOfCandies <= candies[i - 1]  && arr[i] > arr[i - 1])
                        {
                              //System.out.println("asdasd i = " + i);
                              numOfCandies = candies[i - 1] + 1;
                              candies[i] = numOfCandies;
                        }
                        else
                        {
                              candies[i] = numOfCandies;
                        }
                  }

            }
            //System.out.println("---------------");
            long total = 0;
            for( int j = 0 ; j < n ; j++)
            {
                  total = total + candies[j];
                  //System.out.println(candies[j]);
            }
            System.out.println(total);

      }
}
