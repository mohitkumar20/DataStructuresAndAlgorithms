import java.io.*;
import java.math.BigInteger;
public class RedJohnIsBack
{
      public static void main(String[] args) throws IOException
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t > 0)
            {
                  int n = Integer.parseInt(br.readLine());
                  func(n);
                  t--;
            }

      }
      public static void func(int n)
      {
            if(n == 1)
            {
                  System.out.println(0);
                  return;
            }
            else if(n == 2)
            {
                  System.out.println(0);
                  return;
            }
            else if(n == 3)
            {
                  System.out.println(0);
                  return;
            }
            else if(n == 4)
            {
                  System.out.println(1);
                  return;
            }
            int[] arr = new int[n + 1];
            arr[0] = 0;
            arr[1] = arr[2] = arr[3] = 1;
            arr[4] = 2;
            int i;
            for(i = 5 ; i < n + 1 ; i++)
            {
                  arr[i] = arr[i - 1] + arr[i - 4];
            }
            int total = arr[n];
            //System.out.println("total = " + total);
            /*
            int count = 1;
             i = 3;
             //System.out.println(total);
            while(i <= total)
            {
                  if(isPrime(i))
                  //if(checkPrime(i))
                  {
                        count++;
                  }
                  i++;
            }*/
            System.out.println(calcPrime(total));
      }
      public static boolean isPrime(int n) {
            /*
    for(int i=2;i<n;i++) {
        if(n%i==0)
            return false;
    }
    */

    int top = (int) Math.sqrt(n);
    //System.out.println(top);
    for(int i = 2 ; i <= (int)n / 2 ; i++)
    {
          if(n % i == 0)
            return false;
   }
   //System.out.println(n);
    return true;
}
static boolean checkPrime(int n)
   {
      if(n == 3)
      {
            return false;
      }
      if(n % 2 == 0)
      {
            return false;
      }
      int i = 5;
      int w = 2;
      while(i * i <= n)
      {
            if(n % i == 0)
            {
                  return false;
            }
            i = i + w;
            w = 6 - w;
      }
      return true;
   }
   public static int calcPrime(int n)
   {
         boolean[] isPrime = new boolean[n + 1];
         for(int i = 2 ; i <= n ;i++)
         {
               isPrime[i] = true;
         }
         for(int factor = 2 ; factor * factor <= n ; factor++)
         {
               if(isPrime[factor])
               {
                     for(int j = factor ; factor*j <= n ; j++)
                     {
                           isPrime[factor * j] = false;
                     }
               }
         }
         int count = 0;
         for( int i = 2 ; i <= n ;i++)
         {
               if(isPrime[i])
               {
                     count++;
               }
         }
         return count;
   }
}
