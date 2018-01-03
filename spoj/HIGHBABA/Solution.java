import java.io.*;


public class Solution
{
    public static int max_n = 2500;
    public static int max_m = 80;
    public static int[][] mat = new int[max_m + 1][max_n + 1];
    public static int t;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine()) ;
        int i = 0; 
        while(i < t)
        {
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();
            int range = func(a,b);
            System.out.println("Case " + (i + 1) + ": " + range);
            if(i != t - 1)
                br.readLine();
            i++;
        }
    }

    public static int func(char[] a, char[] b)
    {
        int m = b.length;
        int n = a.length;
        for(int i = 1; i < m + 1 ; i++)
        {
            for(int j = 1 ; j < n + 1 ; j++)
            {
                if(b[i - 1] == a[j - 1])
                {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                }
                else
                {
                    mat[i][j] = Math.max(mat[i - 1][j],mat[i][j - 1]);
                }
            }
        }
        int row = m;
        int col = n ;
        int min_range = Integer.MAX_VALUE;
        while(mat[row][col] == m)
        {
            if(b[row - 1] == a[col - 1])
            {
                int range = find_range(a, b, row, col);
                if(range < min_range)
                {
                    min_range = range;
                }
            }
            col--;
        }
        if(min_range == Integer.MAX_VALUE)
        {
            //System.out.println(-1);
            return -1;
        }
        else
        {
            //System.out.println(min_range);
            return min_range;
        }
    }

    public static int find_range(char[] a, char[] b,int row,int col)
    {
        int range = 0;
        int i = row;
        int j = col;
        //System.out.println("finding range : row = " + row + ", col = " + col);
        while(i > 0)
        {
            //System.out.println("i = " + i + ", j = " + j);
            if(b[i - 1] == a[j - 1])
            {
                i--;
                j--;
            }
            else
                j--;
        }
        range = col - j;
        return range;
    }
}