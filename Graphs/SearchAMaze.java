/*
*the maze is represented using a 2-D matrix.
*it will be a N*N matrix always. i Have assumed
*source to be always maze[N-1][0]th element and exit
*to be always maze[0][N-1]th element. So please provide input
*accordingly.
**NOTE: this problem just finds a path if exists and not the shortest path.
*/
import java.io.*;
import java.util.*;

public class SearchAMaze
{	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of N in N*N matrix");
		int n = Integer.parseInt(br.readLine());
		int[][] maze = new int[n][n];
		createMaze(maze,n);
		printMaze(maze,n);
		findPath(maze,n);
		printMaze(maze,n);
	}
	public static void findPath(int[][] maze,int n)
	{
		maze[0][n - 1] = 2;//indicating exit;
		int[][] visited = new int[n][n];
		int ans = explore(maze,visited,n,n - 1,0);
		if(ans != 3)
		{
			System.out.println("No path found");
		}
		else
		{
			System.out.println("Found the path");
		}	
	}
	
	public static int explore(int[][] maze,int[][] visited,int n,int row,int col)
	{
		if(maze[row][col] == 2)
		{
			return 3;//success and using it to trace the path
		}
		else
		{
			int i = row, j = col;
			int toReturn = 0;
			System.out.println("i = " + i + " j = " + j);
			visited[row][col] = 1;
			
			if(i - 1 >= 0 && visited[i - 1][j] == 0 && (maze[i - 1][j] == 1 || maze[i - 1][j] == 2))
			{
				toReturn = explore(maze,visited,n,i - 1,j);
				if(toReturn == 3)
				{
					maze[row][col] = 3;
					return toReturn;
				} 
			}
			if(j + 1 < n && visited[i][j + 1] == 0 && (maze[i][j + 1] == 1 || maze[i][j + 1] == 2))
			{
				toReturn = explore(maze,visited,n,i,j + 1);
				if(toReturn == 3)
				{
					maze[row][col] = 3;
					return toReturn;	
				}
			}
			if(j - 1 >= 0 && visited[i][j - 1] == 0 && (maze[i][j - 1] == 1 || maze[i][j - 1] == 2))
			{
				toReturn = explore(maze,visited,n,i,j - 1) ;
				if(toReturn == 3)
				{
					maze[row][col] = 3;
					return toReturn;
				}
			}
		        if(i + 1 < n && visited[i + 1][j] == 0 && (maze[i + 1][j] == 1 || maze[i + 1][j] == 2) )
			{
				toReturn = explore(maze,visited,n,i + 1,j);
				if(toReturn == 3)
				{
					maze[row][col] = 3;
					return toReturn;
				}
			}
			
			
			
			return toReturn;
		}
	}
	/*
	*n spaced intergers in n lines;
	*/
	public static void createMaze(int[][] maze,int n) throws IOException
	{
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("n space separated integers in n lines");
		int j = 0;
		for(int i = 0 ; i < n ; i++)
		{
			st = new StringTokenizer(br.readLine());
			j = 0;
			while(st.hasMoreTokens())
			{
				maze[i][j] = Integer.parseInt(st.nextToken());
				j++;	
			}	
		}
	}
	
	public static void printMaze(int[][] maze,int n)
	{
		System.out.println("-----------------------");
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				System.out.print(maze[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("-------------------------");
	}

}


	




	                                        














                     