//hackerrank

import java.io.*;


class node
	{
		int vertexNum;
		int cost;
		node next;
		public node(int vertexNum,int cost)
		{
			this.vertexNum = vertexNum;
			this.cost = cost;
			next = null;
		}
	}

class PriorityQueue
{
	int capacity;
	int size;
	node[] arr;
	public PriorityQueue(int capacity)
	{
		this.capacity = capacity;
		size = 0;
		arr = new node[capacity];
	}
	
	boolean isEmpty()
	{
		if(size == 0)
			return true;
		else
			return false;
	}
	public void enqueue(node n)
	{
		arr[size] = n;
		int i = size;
		while((i - 1) / 2 >= 0)
		{
			if(arr[(i - 1) / 2].cost <= arr[i].cost)
				break;
			else
			{
				swap(i,(i-1) / 2);
				i = (i - 1) / 2;
			}
		}
		size++;
	}

	public  node dequeue()
	{
		node toReturn = arr[0];
		arr[0] = arr[size - 1];
		size--;
		int i = 0;
		while(true)
		{
			if((2 * i) + 2 < size)
			{
				if(arr[i].cost <= arr[2 * i + 1].cost && arr[i].cost <= arr[2 * i + 2].cost)
					break;
				else
				{
					int smaller = findSmaller(2 * i + 1,2 * i + 2);
					swap(i,smaller);
					i = smaller;
				}
			}
			else if(2 * i + 2 == size)
			{
				if(arr[i].cost <= arr[2 * i + 1].cost)
					break;
				else
					swap(i, 2 * i + 1);
				
				i = 2 * i + 1;
			}
			else
			{
				break;
			}
		}
		return toReturn;
	}
	
	public void update(int vertexNum,int newCost)
	{
		int i;
		for(i = 0 ; i < size ; i++)
		{
			if(arr[i].vertexNum == vertexNum)
			{
				break;
			}
		}
		arr[i].cost = newCost;
		while((i - 1) / 2 >= 0)
		{
			if(arr[(i - 1) / 2].cost <= arr[i].cost)
				break;
			else
			{
				swap(i,(i-1) / 2);
				i = (i - 1) / 2;
			}
		}
	}
	
	private int findSmaller(int i, int j) {

		if(arr[i].cost <= arr[j].cost)
			return i;
		else
			return j;
		
	}

	private void swap(int i, int j) {
		
		node temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
}


class graph
{
	int V;
	int E;
	node[] list;
	public graph(int V,int E)
	{
		this.V = V;
		this.E = E;
		list = new node[V];
		for(int i = 0 ; i < V ; i++)
		{
			list[i] = new node(i, 0);
		}
	}
}
public class DijkstraShortestPath2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = null;
		int t = Integer.parseInt(br.readLine());
		while(t > 0)
		{
			str = br.readLine().split("\\s");
			int V = Integer.parseInt(str[0]);
			int E = Integer.parseInt(str[1]);
			graph g = new graph(V, E);
			int[][] mat = new int[V][V];
			
			for(int i = 0 ; i < E ; i++)
			{
				str = br.readLine().split("\\s");
				int u = Integer.parseInt(str[0]);
				int v = Integer.parseInt(str[1]);
				int cost = Integer.parseInt(str[2]);
				if(mat[u - 1][v - 1] == 0)
				{
					mat[u - 1][v - 1] = cost;
					edgeInsertion(g,u - 1,v - 1,cost);
				}
				else if(cost < mat[u - 1][v - 1])
				{
					mat[u - 1][v - 1] = cost;
					edgeInsertion(g,u - 1,v - 1,cost);
				}
			}
			int source = Integer.parseInt(br.readLine());
			//printGraph(g);
			djikstra(g,source - 1);
			t--;
		}
		
		

	}

private static void explore(graph g,int source, int[] distance) {
		
		PriorityQueue pq = new PriorityQueue(g.V);
		pq.enqueue(new node(source, 0));
		while(!pq.isEmpty())
		{
			
			node n = pq.dequeue();
			//System.out.println("node : " + n.vertexNum + " popped");
			int u = n.vertexNum;
			node adj = g.list[u].next;
			while(adj != null)
			{
				int v = adj.vertexNum;
				int newDist = distance[u] + adj.cost;
				//System.out.println("here ... V : " + adj.vertexNum);
				if(distance[v] == -1)
				{
					//System.out.println("insdie if");
					node m = new node(v,newDist);
					
					distance[v] = newDist;
					pq.enqueue(m);
				}
				else if(newDist < distance[v])
				{
					pq.update(v, newDist);
					
					distance[v] = newDist;
				}
				adj = adj.next;
			}
		}
		
	}

public static void printGraph(graph g)
{
	for(int i = 0 ; i < g.V ; i++)
	{
		System.out.print(i + "->");
		node adj = g.list[i].next;
		while(adj != null)
		{
			int v = adj.vertexNum;
			System.out.print(v + "->");
			adj = adj.next;
		}
		System.out.println("");
	}
}
private static void djikstra(graph g , int source) {
	int[] distance = new int[g.V];
	//int[] path = new int[g.V];
	distance[source] = 0;
	//path[0] = 0;
	for(int i = 0 ; i < g.V ; i++)
	{
		if(i != source)
		{
			distance[i] = -1;
		}
	}
	explore(g,source,distance);
	for(int i = 0 ; i < g.V ; i++)
	{
		if(i != source)
		{
			System.out.print(distance[i] + " ");
		}
	}
	System.out.println("");
}


private static void edgeInsertion(graph g, int u, int v, int cost) {
	
	node n = new node(v,cost);
	node temp = g.list[u].next;
	g.list[u].next = n;
	n.next = temp;
	
	n = new node(u,cost);
	temp = g.list[v].next;
	g.list[v].next = n;
	n.next = temp;
	
}

}
