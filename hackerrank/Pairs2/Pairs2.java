import java.io.*;
import java.util.*;

public class Pairs2
{
      public static int count = 0;
      public static void main(String[] args) throws IOException
      {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            //long x = (long)Math.pow(2,31);
            //System.out.println(x);
            st = new StringTokenizer(br.readLine());
            int i = 0 ;
            long[] arr = new long[n];
            while(st.hasMoreTokens())
            {
                  arr[i++] = Long.parseLong(st.nextToken());
            }
            func(arr,n,k);
      }
      public static void func(long[] arr,int n,long k)
      {
            HashMap<Long,Integer> map = new HashMap<Long,Integer>(n);
            int i,pairs = 0;
            long  toSearch;
            //Arrays.sort(arr);
            for(i = 0 ; i < n ; i++)
            {
                  map.put(arr[i],0);
            }
            //System.out.println("Size = " + map.size());
            for(i = 0 ; i < n ; i++)
            {
                  /*
                  if(arr[i] < k)
                  {
                        toSearch = k + arr[i];
                  }
                  */

                   if(arr[i] > k)
                  {
                        toSearch = arr[i] - k;
                        if(map.containsKey(toSearch))
                        {


                              if(map.get(toSearch).intValue() < 2 || map.get(arr[i]).intValue() < 2)
                              {
                                    //System.out.println(++count + " arr[i] = " + arr[i] + " toSearch = " + toSearch );
                                    pairs++;
                                    map.put(arr[i],1);
                                    map.put(toSearch,1);
                              }

                        }
                  }
                  /*
                  toSearch = arr[i] - k;
                  long second = arr[i] + k;
                  if(map.containsKey(toSearch))
                  {
                        if(map.get(toSearch).intValue() == 0 || map.get(arr[i]).intValue() == 0)
                        {
                              pairs++;
                              map.put(arr[i],1);
                              map.put(toSearch,1);
                        }
                  }
                  else if(map.containsKey(second))
                  {
                        if(map.get(second).intValue() == 0 || map.get(arr[i]).intValue() == 0)
                        {
                              pairs++;
                              map.put(arr[i],1);
                              map.put(second,1);
                        }
                  }
                  */


            }
            System.out.println(pairs);
      }
}
