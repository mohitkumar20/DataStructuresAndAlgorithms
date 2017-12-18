import java.io.*;
//import java.util.BigInteger;
import java.util.*;

public class Main
{
    public static int maxSize = 2 * (int)Math.pow(10,7);
    public static long mod = (long)Math.pow(10,9) + 7;
    //BigInteger[] arr = new BigInteger[]
    public static long[] arr = new long[maxSize];
    public static long sum = 0;
    //public static ArrayList<Long> list = new ArrayList(maxSize);
    public static void main(String[] args) throws IOException
    {
        /*for(int i = 0 ; i < maxSize ; i++)
        {
            list.add(0L);
        }*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            String[] strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            long a = Long.parseLong(strArr[1]);
            long b = Long.parseLong(strArr[2]);
            long first = Long.parseLong(strArr[3]);
            func(n,a,b,first);
            t--;
        }
    }

    public static void func(int n,long a,long b,long first)
    {
        //long[] arr = new long[n];
        arr[0] = first;
        for(int i = 1 ; i < n ; i++)
        {
            arr[i] = ((a * arr[i - 1]) % mod + b) % mod;
        }
        sum = 0;
        /*System.out.println("before sort");
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print(arr[i] + " ");
        }*/
        quicksort(0,n - 1);
        /*System.out.println("after sort, sum " + sum);
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print(arr[i] + " ");
        }*/
        System.out.println(sum);
        /*for(int i = 1 ; i < n ; i++)
        {
            //System.out.print(arr[i] + " ");
            if(arr[i - 1] > arr[i])
            {
                System.out.println("not sorted, i = " + i);
                break;
            }
        }
        System.out.println();*/
    }

    public static void quicksort(int left,int right)
    {
        //System.out.println("quicksort called, left =  " + left + ", right " + right);
        if(left > right)
        {
            return;
        }
        else if(right == left + 1)
        {
            //System.out.println("sum changed from first");
            if(arr[left] <= arr[right])
            {
                sum = (sum + ((left + 1) * arr[left]) % mod) % mod;
                sum = (sum + ((right + 1) * arr[right]) % mod) % mod;
            }
            else
            {
                //System.out.println("sum changed from second");
                swap(left,right);
                sum = (sum + ((left + 1) * arr[left]) % mod) % mod;
                sum = (sum + ((right + 1) * arr[right]) % mod) % mod;
            }
            return;
        }
        else if(left == right)
        {
            //System.out.println("sum changed from third");
            sum = (sum + ((left + 1) * arr[left]) % mod) % mod;
            //System.out.println("left = right, sum = " + sum);
            return;
        }
        long pivot = arr[right];

        int i = left;
        int j = right - 1;
        while(i <= j)
        {
            while(i < right && arr[i] <= pivot)
            {
                i++;
            }
            while(j >= left && arr[j] >= pivot)
            {
                j--;
            }
            //System.out.println("left = " + left + ", right = " + right + ",i = " + i + ", j = " + j);
            if(i < j)
            {
                swap(i,j);
                /*i++;
                j--;*/
            }
            else
            {
                if(i == right)
                {
                    //System.out.println("changed from fifth");
                    sum = (sum + ((right + 1) * arr[right]) % mod) % mod;
                    quicksort(left,right - 1);
                    return;

                }
                else
                {
                    swap(i,right);
                    //System.out.println("changed from fourth");
                    sum = (sum + ((i + 1) * arr[i]) % mod) % mod;
                    quicksort(left,i - 1);
                    quicksort(i + 1,right);
                    return;
                }
                /*if(i != right && i != j)
                {
                    swap(i,right);
                    System.out.println("changed from fourth");
                    sum = (sum + ((i + 1) * arr[i]) % mod) % mod;
                    quicksort(left,i - 1);
                    quicksort(i + 1,right);
                }
                else
                {
                    System.out.println("changed from fifth");
                    sum = (sum + ((right + 1) * arr[right]) % mod) % mod;
                    quicksort(left,right - 1);
                    return;
                }*/

                //break;
            }
        }
        /*quicksort(left,i - 1);
        quicksort(i + 1,right);*/

    }

    public static void swap(int i,int j)
    {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
}

