
//Google Foobar question.


import java.io.*;

public class GrandestStairCase
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(answer(n));

	}
	public static int answer(int n) { 

        // Your code goes here.
	       	int[][] mat = new int[n][n + 1];
	       	for(int i = 0 ; i < n + 1 ; i++)
	       	{
	       		if(i == 0)
	       		{
	       			mat[0][i] = 1;
	       			mat[1][i] = 1;
	       			mat[2][i] = 1;

	       		}
	       		else if(i == 1)
	       		{
	       			mat[0][i] = 0;
	       			mat[1][i] = 1;
	       			mat[2][i] = 1;
	       		}
	       		else if(i == 2 || i == 3)
	       		{
	       			mat[0][i] = 0;
	       			mat[1][i] = 0;
	       			mat[2][i] = 1;
	       		}
	       		else
	       		{
	       			mat[0][i] = 0;
	       			mat[1][i] = 0;
	       			mat[2][i] = 0;
	       		}
	       	}

	       	for(int i = 3 ; i < n ; i++)
	       	{
	       		for(int j = 0 ; j < n + 1 ; j++)
	       		{
	       			if(j <= i)
	       			{
	       				mat[i][j] = mat[i - 1][j];
	       			}
	       			else
	       			{
	       			 	if(i > j - i && (j - i) != 1 && (j - i) != 2)
	       			 	{
	       			 		mat[i][j] = mat[i - 1][j] +  1 + mat[i - 1][j - i];
	       			 	}
	       			 	else 
	       			 	{
	       			 		mat[i][j] = mat[i - 1][j] + mat[i - 1][j - i];
	       			 	}
	       			}
	       		}
	       	}
	       	// for(int i = 0 ; i < n ; i++)
	       	// {
	       	// 	for(int j = 0 ; j < n + 1 ; j++)
	       	// 	{
	       	// 		System.out.print(mat[i][j] + " ");
	       	// 	}
	       	// 	System.out.println("");
	       	// }
	        return mat[n - 1][n];
    } 
    
    public static int func(int n,int[] arr)
    {
        if(n < 3)
        {
            return 0;
        }
        else if(arr[n] != 0)
        {
            return arr[n];
        }
        else
        {
            for(int i = n - 1; i >= n - i ; i--)
            {
            	//System.out.println("fsf");
                if(i > n - i)
                {
                	//System.out.println("here.. n - i = " + (n - i) + ", n = " + n);
                    arr[n] += 1 + func(n - i,arr);
                }
                else if(i == n - i)
                {
                	//System.out.println("last");
                    arr[n] += func(n - i,arr);
                }
                else
                {
                	int secondPartition = n - i;
                	int thirdPartition = i - 1;
                	int fourthPartition = secondPartition - thirdPartition;
                	if(thirdPartition < i && fourthPartition < i)
                	{
                		//arr[n] += 
                	}
                }
            }
            return arr[n];
        }
    }
}