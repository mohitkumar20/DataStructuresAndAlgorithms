import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while(q > 0)
        {
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();
            int n = a.length;
            int m = b.length;
            func(a,n,b,m);
            q--;
        }
    }

    public static void func(char[] a,int n, char[] b, int m)
    {
        int[][] dp = new int[n][m];
        char diff = 32;
        char startSmall = 65;
        char endSmall = 90;
        int max = 0;
        if(a[0] == b[0] || b[0] + diff == a[0])
            dp[0][0] = 1;
        else
            dp[0][0] = 0;
        if(m == 1)
        {
            if(dp[0][0] == 1)
            {
                System.out.println("YES");
                return;
            }
            else
            {
                System.out.println("NO");
                return;
            }
        }
        for(int i = 1 ; i < m ; i++)
        {
            if(a[0] == b[i] || b[i] + diff == a[0])
            {
                dp[0][i] = 1;
            }
            else
            {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int i = 1 ; i < n ; i++)
        {
            if(b[0] == a[i] || b[0] + diff == a[i])
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i - 1][0];
        }

        for(int i = 1 ; i < n ; i++)
        {
            int flag = 1;
            if(a[i] >= startSmall && a[i] <= endSmall)
                flag = 0;
            for(int j = 1 ; j < m ; j++)
            {
                if(a[i] >= startSmall && a[i] <= endSmall)
                {
                    if(a[i] == b[j])
                    {
                        flag = 1;
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if(dp[i][j] > max)
                            max = dp[i][j];
                        if(dp[i][j] == m)
                        {
                            System.out.println("here1");
                            System.out.println("YES");
                            return;
                        }
                    }
                    else
                        dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
                else
                {
                    if(a[i] == b[j] || b[j] + diff == a[i])
                    {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if(dp[i][j] > max)
                            max = dp[i][j];
                        if(dp[i][j] == m)
                        {
                            System.out.println("here2");
                            System.out.println("YES");
                            return;
                        }
                    }
                    else
                        dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
            if(flag == 0)
            {
                System.out.println("here 3");
                System.out.println("NO");
                System.out.println("i : " + i + ", a[i] = " + a[i]);
                return ;
            }
        }
        System.out.println("max : " + max + ", n = " + n + ", m = " + m);
        System.out.println("here 4");
        System.out.println("NO");
        return;
    }
}
