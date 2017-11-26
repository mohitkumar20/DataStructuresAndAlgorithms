import java.io.*;
import java.util.*;

public class Main
{
    //100000 could be the maximum money that can be paid. thats why choose this
    //as invalid.
    public static int invalid = 100001;
    public static int[] arr = null;
    public static int[][][] dp = null;
    public static int n;
    public static int k;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t  = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            String[] strArr = br.readLine().split(" ");
            n = Integer.parseInt(strArr[0]);
            k = Integer.parseInt(strArr[1]);
            arr = new int[k + 1];
            strArr = br.readLine().split(" ");
            for(int i = 0 ; i < k ; i++)
            {
                arr[i + 1] = Integer.parseInt(strArr[i]);
            }
            dp = new int[k + 1][n + 1][k + 1];
            for(int i = 0 ; i < k + 1 ; i++)
                for(int j = 0 ; j < n + 1 ; j++)
                    for(int z = 0 ; z < k + 1 ; z++ )
                        dp[i][j][z] = invalid;

            int ans = func2(1,n,k);
            if(ans >= invalid)
                System.out.println(-1);
            else
                System.out.println(ans);

            t--;
        }
    }

    //pos is the index
    //rp is the remaining number of maximum packets that can be bought
    //rw is remaining weight.
    public static int func2(int pos,int rp , int rw)
    {
        if(pos > k)
            return invalid;
        if(rw < 0)
            return invalid;
        if(dp[pos][rp][rw] != invalid)
            return dp[pos][rp][rw];
        if(rw == 0)
            return dp[pos][rp][rw] = 0;
        if(rp == 0)
            return invalid;
        if(pos > rw)
            return invalid;
        if(arr[pos] == -1)
            return dp[pos][rp][rw] = func2(pos + 1,rp,rw);

        //minimum of three scenarios. 
        //first scenario : we skip buying the packet at index pos and move to
        //pos + 1.
        //Second scenario : we buy at index pos and again try to buy packet at
        //index pos.
        //third scenario : we buy at index pos and move to pos + 1;
        
        return dp[pos][rp][rw] = min(func2(pos + 1,rp,rw),  arr[pos] + func2(pos , rp - 1, rw - pos) , arr[pos] + func2(pos + 1,rp - 1,rw - pos));
    }

    /*public static int func(int pos,int rp,int rw)
    {
        if(rw == 0)
            return 0;
        if(rp == 0)
            return invalid;
        if(pos > rw)
            return invalid;
        if(arr[pos] == -1)
            return func(pos + 1,rp,rw);
        return min(func(pos + 1,rp,rw),  arr[pos] + func(pos , rp - 1, rw - pos) , arr[pos] + func(pos + 1,rp - 1,rw - pos));
    }*/

    public static int min(int ... arr)
    {
        int min = arr[0];
        for(int num : arr)
            if(num < min)
                min = num;

        return min;
    }
}

