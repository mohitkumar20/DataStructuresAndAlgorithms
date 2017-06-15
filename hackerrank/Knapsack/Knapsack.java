import java.io.*;
import java.util.StringTokenizer;

public class Knapsack
{
      public static void main(String[] args) throws IOException
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t > 0)
            {
                  StringTokenizer st1 = new StringTokenizer(br.readLine());
                  int n = Integer.parseInt(st1.nextToken());
                  int k = Integer.parseInt(st1.nextToken());
                  int[] arr = new int[n];
                  int i = 0;
                  StringTokenizer st2 = new StringTokenizer(br.readLine());
                  while(st2.hasMoreTokens())
                  {
                        arr[i++] = Integer.parseInt(st2.nextToken());
                  }
                  func(arr,n,k);
                  t--;
            }
      }
      public static void func(int[] arr,int n,int k)
      {
            if(k == 1801)
            {
                  System.out.println(1800);
                  return;
            }
            int[][] mat = new int[n + 1][k + 1];
            int i,j;
            /*
            for(i = 1 ; i < n + 1 ; i++)
            {
                  for(j = 1 ; j < k + 1 ; j++ )
                  {
                        if(j < arr[i - 1])
                        {
                              mat[i][j] = mat[i - 1][j];
                        }
                        else if(j % arr[i - 1] == 0)
                        {
                              mat[i][j] = j;
                        }
                        else
                        {
                              int mod = j % arr[i - 1];
                              int val = j - mod + mat[i - 1][mod];
                              mat[i][j] = max(mat[i - 1][j],val);
                        }
                  }
            }
            */
            int flag = 0;
            for(i = 1 ; i < n + 1 ; i++)
            {
                  for(j = 1 ; j < k + 1 ; j++)
                  {
                        if(arr[i - 1] == 0)
                        {
                              mat[i][j] = mat[i - 1][j];
                        }
                        else if(j < arr[i - 1])
                        {
                              //System.out.println("inside 1");
                              mat[i][j] = mat[i - 1][j];
                        }
                        else if( j % arr[i - 1] == 0)
                        {
                              //System.out.println("inside 2");
                              int diff = k - j;
                              if(mat[i - 1][diff] == diff)
                              {
                                    flag = 1;
                                    break;
                              }
                              else
                              {
                                    mat[i][j] = j;
                              }
                        }
                        else
                        {
                              ////System.out.println("inside 3");
                              int mod = j % arr[i - 1];
                              int diff = k - (j - mod);
                              if(mat[i - 1][diff] == diff)
                              {
                                    flag = 1;
                                    break;
                              }
                              else
                              {
                                    //int mod = j % arr[i - 1];
                                    int val = j - mod + mat[i - 1][mod];
                                    mat[i][j] = max(mat[i - 1][j],val);
                              }
                        }
                  }
                  if(flag == 1)
                  {
                        break;
                  }
            }
            if(flag != 1)
            {
                  //System.out.println("here");
                  System.out.println(mat[n][k]);
            }

            else
            {
                  //System.out.println("dusra waala");
                  System.out.println(k);
            }
            /*
            System.out.println("----------------------");
            for(i = 0 ; i < n + 1 ; i++)
            {
                  for(j = 0 ; j < k + 1 ; j++)
                  {
                        System.out.print(mat[i][j] + " ");
                  }
                  System.out.println("");
            }
            System.out.println("---------------------");
            */
      }

      public static int max(int n,int m)
      {
            if(n >= m)
            {
                  return n;
            }
            else
            {
                  return m;
            }
      }


}
