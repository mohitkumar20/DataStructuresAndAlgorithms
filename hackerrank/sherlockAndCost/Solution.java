import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            int n = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++)
            {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            int[][] dp = new int[2][n];
            System.out.println(func(arr,n,dp));
            t--;
        }
    }

    /*
     *at ith position only 2 options are there, either it will be arr[i] or 1.
     *from there, try to make a recursive equation.
     */
    public static long func(int[] arr,int n, int[][]mat)
    {
        if(n <= 1)
            return 0;

        mat[0][0] = mat[1][0] = 0;

        for(int i = 1 ; i < n ; i++)
        {
            mat[0][i] = Math.max(mat[0][i - 1],Math.abs(arr[i - 1] - 1) + mat[1][i - 1]);
            mat[1][i] = Math.max(Math.abs(arr[i] - 1) + mat[0][i - 1], Math.abs(arr[i] - arr[i - 1]) + mat[1][i - 1]);
        }
        return Math.max(mat[0][n - 1],mat[1][n - 1]);
    }

}
