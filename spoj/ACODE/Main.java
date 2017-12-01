import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            char[] charArr = br.readLine().toCharArray();
            if(charArr[0] == '0')
                return;
            int n = charArr.length;
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++)
            {
                arr[i] = Character.getNumericValue(charArr[i]);
            }
            System.out.println(func(arr,n));
        }
    }

    public static long func(int[] arr,int n)
    {
        if(n == 1)
        {
            return 1;
        }
        long[] dp = new long[n];

        if(arr[n - 1] > 0)
            dp[n - 1] = 1;
        else
            dp[n - 1] = 0;

        if(arr[n - 2] > 2)
            dp[n - 2] = dp[n - 1];

        else if(arr[n - 2] == 0)
            dp[n - 2] = 0;
        
        else
        {
            if(arr[n - 1] == 0)
                dp[n - 2] = 1;
            else
                dp[n - 2] = dp[n - 1] + 1;
        }

        for(int i = n - 3; i >= 0 ; i--)
        {
            if(arr[i] == 0)
                dp[i] = 0;
            
            else if(arr[i] > 2)
                dp[i] = dp[i + 1];

            else
            {
                //System.out.println("arr[i] = " + arr[i]);
                if(arr[i] == 1)
                    dp[i] = dp[i + 1] + dp[i + 2];
                
                else
                {
                    if(arr[i + 1] <= 6)
                        dp[i] = dp[i + 1] + dp[i + 2];
                    else
                        dp[i] = dp[i + 1];
                }
            }
        }
        //for(int i = 0 ; i < n ; i++)
            //System.out.print(dp[i] + " ");
        //System.out.println();
        return dp[0];
    }
}
