import java.io.*;
import java.util.*;

public class MissingNumbers
{
      public static void main(String[] args) throws IOException
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            st = new StringTokenizer(br.readLine());
            int[] A = new int[n];
            int i = 0 ;
            while(st.hasMoreTokens())
            {
                  A[i++] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            i = 0 ;
            while(st.hasMoreTokens())
            {
                  B[i++] = Integer.parseInt(st.nextToken());
            }

            func(A,n,B,m);
      }
      public static void func(int[] A,int n , int[] B , int m)
      {
            HashMap<Integer,Integer> mapA = new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> mapB = new HashMap<Integer,Integer>();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            int i;
            for(i = 0 ; i < n ; i++)
            {
                  mapA.put(A[i],0);
            }
            for(i = 0 ; i < m ; i++)
            {
                  mapB.put(B[i],0);
            }
            //System.out.println("---------");
            for(i = 0 ; i < n ; i++)
            {
                  Integer value = mapA.get(A[i]);
                  int val = value.intValue();
                  //System.out.println(val);
                  val++;
                  mapA.put(A[i],val);
            }
            for(i = 0 ; i < m ; i++)
            {
                  /*
                  Integer value = mapB.get(B[i]);
                  int val = value.intValue();
                  val++;
                  mapB.put(B[i],mapB.get(val));
                  */
                  /*
                  if(mapB.containsKey(B[i]) == false)
                  {
                        //System.out.println("MapB doesnt contain " + B[i]);
                  }
                  */
                  Integer value = mapB.get(B[i]);
                  int val = value.intValue();
                  val++;
                  mapB.put(B[i],val);
                  //System.out.println(val);

            }
            /*
            for(i = 0 ; i < m ; i++)
            {
                  if(mapA.containsKey(B[i]) == false)
                  {
                        arr.add(B[i]);
                        System.out.println("Inside first b, for value B[i] = " + B[i]);
                  }
                  else
                  {
                        if(mapA.get(B[i]).intValue() != mapB.get(B[i]).intValue())
                        {
                              arr.add(B[i]);
                              System.out.println("Inside second b, for value B[i] = " + B[i]);
                              System.out.println("cCount in A = " + mapA.get(B[i]) + " count in B = " + mapB.get(B[i]));
                        }
                  }
            }
            */
            //System.out.println("Here");
            Set<Integer> set = mapB.keySet();
            Iterator<Integer> it = set.iterator();
            //System.out.println("Just above");
            while(it.hasNext())
            {
                  Integer key = it.next();
                  if(mapA.containsKey(key) == false)
                  {
                        arr.add(key);
                  }
                  else
                  {
                        if(mapA.get(key).intValue() != mapB.get(key).intValue())
                        {
                              arr.add(key);
                              //System.out.println("Inside second b, for value B[i] = " + B[i]);
                              //System.out.println("cCount in A = " + mapA.get(B[i]) + " count in B = " + mapB.get(B[i]));
                        }
                  }
                  //System.out.println("Again");

            }
            //System.out.println("Heere?");
            Collections.sort(arr);
            int size = arr.size();
            for(i = 0 ; i < size ; i++)
            {
                  System.out.print(arr.get(i) + " ");
            }
            /*
            for(i = 0 ; i < n ; i++)
            {
                  System.out.println(A[i] + " count = "  + mapA.get(A[i]));
            }
            System.out.println("--------------");
            for(i = 0 ; i < m ; i++)
            {
                  System.out.println(B[i] + " Count = " + mapB.get(B[i]));
            }
            System.out.println("--------------");
            System.out.println("Size = " + arr.size());
            */
      }
}
