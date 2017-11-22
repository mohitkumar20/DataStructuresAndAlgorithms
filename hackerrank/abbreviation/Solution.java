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
        int[][] mat = new int[n + 1][m + 1];
        for(int i = 0 ; i < n + 1 ; i++)
            mat[i][0] = 0;
        for(int i = 0 ; i < m + 1 ; i++)
            mat[0][i] = 0;
        char capStart = 65;
        char capEnd = 90;
        char smallStart = 97;
        char smallEnd = 122;
        char diff = 32;
        for(int i = 1 ; i < n + 1 ; i++)
        {
            for(int j = 1 ; j < m + 1 ; j++)
            {
                if(a[i - 1] >= smallStart)
                {
                    if(a[i - 1] - diff == b[j - 1])
                    {
                        if(mat[i - 1][j] == j)
                            mat[i][j] = mat[i - 1][j];
                        else
                            mat[i][j] = 1 + mat[i - 1][j - 1];
                    }
                    else
                    {
                        if(mat[i - 1][j] == j || mat[i][j - 1] == j)
                            mat[i][j] = j;
                        else
                            mat[i][j] = Math.max(mat[i - 1][j],mat[i][j - 1]);
                    }
                }
                else
                {
                    if(a[i - 1] == b[j - 1])
                    {
                        mat[i][j] = 1 + mat[i - 1][j - 1];
                    }
                    else
                    {
                        mat[i][j] = mat[i][j - 1];
                    }
                }
            }
        }
        if(mat[n][m] == m)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
