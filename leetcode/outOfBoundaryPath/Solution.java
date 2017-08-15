public class Solution
{
    public int MOD = 1000000000 + 7;
    public int findPaths(int m,int n,int moves,int i,int j)
    {

        if(moves == 0)
            return 0;
        int[][][]  mat =  new int[m][n][moves + 1];
        for(int a = 0 ; a < m ; a++)
            for(int b = 0 ; b < n ; b++)
                for(int k = 0; k < moves + 1; k++)
                    mat[a][b][k] = -1;
        return func(i,j,moves,m,n,mat);

    }


    public int func(int i,int j,int moves,int m,int n,int[][][] mat)
    {
        if(i == -1 || i == m || j == -1 || j == n)
            return 1;
        if(moves == 0)
            return 0;
        if(mat[i][j][moves] != -1)
            return mat[i][j][moves];

        mat[i][j][moves] =  (((func(i - 1,j,moves - 1,m,n,mat) % MOD) + (func(i + 1,j,moves - 1,m,n,mat) % MOD)) % MOD + 
                               ((func(i,j - 1,moves - 1,m,n,mat) % MOD) + (func(i,j + 1,moves - 1,m,n,mat) % MOD)) % MOD) % MOD; 
        return mat[i][j][moves];
    }

    public static void main(String[] args)
    {
        Solution x = new Solution();
        System.out.println(x.findPaths(1,3,3,0,1));
    }
}
