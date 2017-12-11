import java.io.*;

public class Main
{
    public static int maxSize = (int)Math.pow(10,5) + 1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int[][] mat = new int[maxSize][maxSize];
        String[] strArr = null;
        strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int q = Integer.parseInt(strArr[1]);
        int[] arr = new int[n];
        int[][] mat = new int[n + 1][maxSize];
        strArr = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int[] rangeSum = new int[maxSize];
        preprocess(arr,mat,n,rangeSum);
        for(int i = 0 ; i < q ; i++)
        {
            strArr = br.readLine().split(" ");
            int start = Integer.parseInt(strArr[0]);
            int end = Integer.parseInt(strArr[1]);
            //System.out.println(rangeSum[end] - rangeSum[start] + 1);
            if(mat[n][start] == 1)
            {
                System.out.println(rangeSum[end] - rangeSum[start] + 1);
            }
            else
            {
                System.out.println(rangeSum[end] - rangeSum[start]);
            }
        }

    }

    public static void preprocess(int[] arr,int[][] mat,int n,int[] rangeSum)
    {
        for(int i = 1 ; i < n + 1 ; i++)
        {
            for(int j = 1 ; j < maxSize ; j++)
            {
                if(j < arr[i - 1])
                {
                    mat[i][j] = mat[i - 1][j];
                }
                else if(j == arr[i - 1])
                {
                    //System.out.println("changed from second");
                    mat[i][j] = 1;
                }
                else
                {
                    if(mat[i - 1][j] == 1)
                    {
                        //System.out.println("changed from third");
                        mat[i][j] = 1;
                    }
                    else
                    {
                        mat[i][j] = (mat[i - 1][j - arr[i - 1]] == 1) ? 1 : 0;
                    }
                }
                //System.out.println("mat[i][j]")
            }
        }
        for(int i = 1 ; i < maxSize ; i++)
        {
            if(mat[n][i] == 1)
            {
                //System.out.println("increasing");
                //mat[n][i] = mat[n][i - 1] + 1;
                rangeSum[i] = rangeSum[i - 1] + 1;
            }
            else
            {
                //mat[n][i] = mat[n][i - 1];
                rangeSum[i] = rangeSum[i - 1];
            }
        }
    }
}
