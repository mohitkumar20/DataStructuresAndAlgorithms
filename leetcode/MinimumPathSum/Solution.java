import java.util.*;

class MyComparator implements Comparator<block>
{
	public int compare(block b1,block b2)
	{
		return b1.cost - b2.cost;
	}
}

class block
{
    int i;
    int j;
    int cost;
    public block(int i,int j,int cost)
    {
        this.i = i;
        this.j = j;
        this.cost = cost;
    }

}


public class Solution
{
	public int minPathSum(int[][] grid)
	{
		int rows = grid.length;
		int cols = grid[0].length;
		block[][] dist = new block[rows][cols];
		for(int i = 0; i < rows ; i++)
		{
			for(int j = 0; j < cols ; j++)
			{
				if(i == 0 && j == 0)
				{
					dist[i][j] = new block(i,j,grid[i][j]);
				}
				else
				{
					dist[i][j] = new block(i,j,-1);
				}
			}
		}

		int ans = func(grid,dist,rows,cols);
		return ans;
	}

	public int func(int[][]grid,block[][] dist,int rows,int cols)
	{
		PriorityQueue<block> pq = new PriorityQueue(rows * cols,new MyComparator());
		pq.add(dist[0][0]);
		while(!pq.isEmpty())
		{
			block b = pq.poll();
			int i = b.i;
			int j = b.j;
			if((i == rows - 1) && (j == cols - 1))
			{
				return dist[i][j].cost;
			}
			if(j < cols - 1)
			{
				int newDist = dist[i][j].cost + grid[i][j + 1];
				if(dist[i][j + 1].cost == -1)
				{
					dist[i][j + 1].cost = newDist;
					pq.add(dist[i][j + 1]);
				}

				else if(newDist < dist[i][j + 1].cost)
				{
					pq.remove(dist[i][j + 1]);
					dist[i][j + 1].cost = newDist;
					pq.add(dist[i][j + 1]);
				}
			}
			if(i < rows - 1)
			{
				int newDist = dist[i][j].cost + grid[i + 1][j];
				if(dist[i + 1][j].cost == -1)
				{
					dist[i + 1][j].cost = newDist;
					pq.add(dist[i + 1][j]);
				}
				else if(newDist < dist[i + 1][j].cost)
				{
					pq.remove(dist[i + 1][j]);
					dist[i + 1][j].cost = newDist;
					pq.add(dist[i + 1][j]);
				}

			}
		}
		return dist[rows - 1][cols - 1].cost;
	}
}

