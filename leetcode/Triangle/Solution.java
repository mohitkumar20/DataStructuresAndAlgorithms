import java.util.*;
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
        int n = triangle.size();
        int[][] mat = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            mat[n - 1][i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2 ; i >= 0 ; i--)
        {
            for(int j = 0 ; j <= i ; j++)
            {
                mat[i][j] = triangle.get(i).get(j) + Math.min(mat[i + 1][j],mat[i + 1][j + 1]);
                //System.out.println("i : " + i + ", j = " + j + " mat[i][j] : " + mat[i][j]);
            }
        }
        /*
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j <= i ; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
        */
        return mat[0][0];
    }
}