import java.io.*;
import java.util.StringTokenizer;

public class TheCoinChangeProblem
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(rd.readLine());
		long diff,temp;
		int i , j;
		long[] coin = new long[m];
		long[][] mat = new long[m + 1][n + 1];
		//System.out.println("n .. m" + n + " " + m);
		i = 0;
		while(st.hasMoreTokens())
		{
			coin[i++] = Long.parseLong(st.nextToken());
		}
		for(i = 0 ; i < m + 1 ; i++)
		{
			mat[i][0] = 0;
		}
		for(i = 0 ; i < n + 1 ; i++)
		{
			mat[0][i] = 0;
		}
		for(i = 1 ; i < m + 1 ; i++)
		{
			for(j = 1 ; j < n + 1 ; j++)
			{
				if(j < coin[i - 1] )
				{
					mat[i][j] = mat[i - 1][j];
				}
				else
				{
					diff = j - coin[i - 1];
					//System.out.println("sdffad i and j " + i + " " + j + " diff = " + diff); 
					if(diff == 0)
					{
						mat[i][j] = mat[i - 1][j] + 1;
						//System.out.println(" i and j " + i + " " + j + " diff = 0"); 
					}
					else
					{
						if(mat[i][(int)diff] == 0)
						{
							mat[i][j] = mat[i - 1][j];
						}
						else
							mat[i][j] = mat[i][(int)diff] + mat[i - 1][j];
					}
				}
			}
		}
		/*
		for(i = 0 ; i < m + 1 ; i++)
		{
			for(j = 0 ; j < n + 1 ; j++)
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
		*/
		System.out.println(mat[m][n]);
	}
}

