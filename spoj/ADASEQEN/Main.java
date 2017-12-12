import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int m = Integer.parseInt(strArr[0]);
        int n = Integer.parseInt(strArr[1]);
        int[] value = new int[26];
        strArr = br.readLine().split(" ");
        for(int i = 0 ; i < 26 ; i++)
        {
            value[i] = Integer.parseInt(strArr[i]);
        }
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        func(a,m,b,n,value);
    }

    public static void func(char[] a,int m,char[] b,int n,int[] values)
    {
        int diff = 'a';
        long[][] mat = new long[m + 1][n + 1];
        for(int i = 0 ; i < m + 1 ; i++)
        {
            mat[i][0] = 0;
        }
        for(int i = 0 ; i < n + 1 ; i++)
        {
            mat[0][i] = 0;
        }


        for(int i = 1 ; i < m + 1 ; i++)
        {
            for(int j = 1 ; j < n + 1 ; j++)
            {
                //System.out.println("i : " + i + ", j = " + j);
                if(a[i - 1] != b[j - 1])
                {
                    mat[i][j] = Math.max(mat[i - 1][j],mat[i][j - 1]);
                }
                else
                {
                    mat[i][j] = values[a[i - 1] - diff] + mat[i - 1][j - 1];
                }
            }
        }
        System.out.println(mat[m][n]);
    }
}
