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
	
	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public void enqueue(node n)
	{
		//System.out.println("Value of size : " + size);
		arr[size] = n;
		int i = size;
		while((i - 1) / 2 >= 0)
		{
			if(arr[(i - 1) / 2].cost <= arr[i].cost)
				break;
			else
			{
				swap(i,(i - 1) / 2);
				i = (i - 1) / 2;
			}
		}
		size++;
	}

	public node dequeue()
	{
		node toReturn = arr[0];
		arr[0] = arr[size - 1];
		size--;
		int i = 0;
		while(true)
		{
			if(2 * i + 2 < size)
			{
				if(arr[i].cost <= arr[2 * i + 2].cost && arr[i].cost <= arr[2 * i + 1].cost)
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
				break;
		}
		return toReturn;
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


public class Prim {

	static long totalWeight = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = null;
		str = br.readLine().split("\\s");
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		graph g = new graph(V, E);
		int[][] mat = new int[V][V];
		
		for(int i = 0 ; i < g.V ; i++)
		{
			for(int j = 0 ; j < g.V ; j++)
			{
				mat[i][j] = -1;
			}
		}
		for(int i = 0 ; i < E ; i++)
		{
			str = br.readLine().split("\\s");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			int cost = Integer.parseInt(str[2]);
			if(mat[u - 1][v - 1] == -1)
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
		prim(g, source - 1);
		//printGraph(g);
	}

private static void explore(graph g,int source, int[] distance,PriorityQueue pq) {
		
		int[] added = new int[g.V];
		while(!pq.isEmpty())
		{
			node n = pq.dequeue();
			int u = n.vertexNum;
			//System.out.println("u : " + u);
			added[u] = 1;
			node adj = g.list[u].next;
			while(adj != null)
			{
				int v = adj.vertexNum;
				//System.out.println("v  : " + v);
				int newCost = adj.cost;
				if(distance[v] == Integer.MAX_VALUE)
				{
					distance[v] = newCost;
					totalWeight += newCost;
					pq.update(v, newCost);;
				}
				else if(distance[v] > newCost && added[v] == 0)
				{
					totalWeight = totalWeight - distance[v];
					distance[v] = newCost;
					totalWeight += distance[v];
					pq.update(v, newCost);
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
private static void prim(graph g , int source) {
	
	int[] distance = new int[g.V];
	PriorityQueue pq = new PriorityQueue(g.V);
	for(int i = 0 ; i < g.V ; i++)
	{
		if(i != source)
		{
			distance[i] = Integer.MAX_VALUE;
			pq.enqueue(new node(i,Integer.MAX_VALUE));
		}
		else
		{
			distance[i] = 0;
			pq.enqueue(new node(i,0));
		}
	}
	
	explore(g, source, distance,pq);
	System.out.println(totalWeight);
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
