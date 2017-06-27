//From the Dynamic Programming chapter in Elements of Programming book.

//try to use this approach in questions, where partitions are needed to be calculated.
//also where a combination matters and not the permutation, use this approach. eg : 
//1 2 1 , 1 1 2 , 2 1 1 etc are all counted as one.



import java.util.*;
import java.io.*;

public class CountTheNumberOfScoreCombinations
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");// Enter the individual Scores.
		int n = arr.length;
		int[] scores = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			scores[i] = Integer.parseInt(arr[i]);
		}
		int finalScore = Integer.parseInt(br.readLine());
		func(scores,finalScore,n);
	}


	public static void func(int[] scores,int finalScore,int n)
	{
		int[][] mat = new int[n + 1][finalScore + 1];

		for(int i = 0 ; i < n + 1 ; i++)
		{
			mat[i][0] = 1;
		}

		for(int i = 1 ; i < finalScore + 1 ; i++)
		{
			mat[0][i] = 0;
		}

		for(int i = 1 ; i < n + 1 ; i++)
		{
			for(int j = 1 ; j < finalScore + 1 ; j++)
			{
				if(j < scores[i - 1])
				{
					mat[i][j] = mat[i - 1][j];
				}
				else 
				{
					mat[i][j] = mat[i - 1][j] + mat[i][j - scores[i - 1]];
				}
			}
		}

		System.out.println(mat[n][finalScore]);
	}
}







