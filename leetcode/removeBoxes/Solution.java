public class Solution
{
    public static void main(String[] args)
    {
        
    }

    public int removeBoxes(int[] boxes)
    {

        if(boxes == null || boxes.length == 0)
            return 0;
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                for(int z = 0; z < n ; z++)
                    dp[i][j][z] = -1;
        return func(0,n - 1,0,dp,boxes);


    }

    public int func(int i,int j,int k,int[][][]dp,int[] boxes)
    {

        if(i > j)
            return 0;
        if(i == j)
            return (k + 1)*(k + 1);
        if(dp[i][j][k] != -1)
            return dp[i][j][k];
        
        int left = i ;
        i++;
        while(i <= j && boxes[left] == boxes[i])
        {
            i++;
            k++;
        }
        int result = (k + 1) * (k + 1) + func(i,j,0,dp,boxes);

        i = i - 1;
        for(int m = i + 1 ; m <= j ; m++)
        {
            if(boxes[m] == boxes[i])
            {
                result = Math.max(result,func(i + 1,m - 1,0,dp,boxes) + func(m,j,k + 1,dp,boxes));
            }
        }
        dp[i][j][k] = result;
        return result;

    }
}
