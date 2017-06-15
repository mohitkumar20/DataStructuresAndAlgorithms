//hackerrrank

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
	int[] pos;
	public PriorityQueue(int capacity)
	{
		this.capacity = capacity;
		size = 0;
		arr = new node[capacity];
		pos = new int[capacity];
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
		pos[n.vertexNum] = i;
		while((i - 1) / 2 >= 0)
		{
			if(arr[(i - 1) / 2].cost <= arr[i].cost)
			{
				pos[n.vertexNum] = i;
				break;
			}
			else
			{
				pos[arr[(i - 1) / 2].vertexNum] = i;
				pos[arr[i].vertexNum] = (i - 1) / 2;
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
		pos[arr[i].vertexNum] = i;
		while(true)
		{
			if((2 * i) + 2 < size)
			{
				if(arr[i].cost <= arr[2 * i + 1].cost && arr[i].cost <= arr[2 * i + 2].cost)
				{
					pos[arr[i].vertexNum] = i;
					break;
				}
				else
				{
					int smaller = findSmaller(2 * i + 1,2 * i + 2);
					pos[arr[smaller].vertexNum] = i;
					pos[arr[i].vertexNum] = smaller;
					swap(i,smaller);
					i = smaller;
				}
			}
			else if(2 * i + 2 == size)
			{
				if(arr[i].cost <= arr[2 * i + 1].cost)
				{
					pos[arr[i].vertexNum] = i;
					break;
				}
				else
				{
					pos[arr[2 * i + 1].vertexNum] = i;
					pos[arr[i].vertexNum] = 2 * i + 1;
					swap(i, 2 * i + 1);
				}
				
				i = 2 * i + 1;
			}
			else
			{
				pos[arr[i].vertexNum] = i;
				break;
			}
		}
		return toReturn;
	}
	
	public void update(int vertexNum,int newCost)
	{
		int i;
		/*
		for(i = 0 ; i < size ; i++)
		{
			if(arr[i].vertexNum == vertexNum)
			{
				break;
			}
		}
		*/
		i = pos[vertexNum];
		arr[i].cost = newCost;
		while((i - 1) / 2 >= 0)
		{
			if(arr[(i - 1) / 2].cost <= arr[i].cost)
			{
				pos[arr[i].vertexNum] = i;
				break;
			}
			else
			{
				pos[arr[(i - 1) / 2].vertexNum] = i;
				pos[arr[i].vertexNum] = (i - 1) / 2;
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


public class JackGoesToRupture {

	public static void main(String[] args) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = null;
		str = br.readLine().split("\\s");
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		graph g = new graph(V, E);
		for(int i = 0 ; i < E ; i++)
		{
			str = br.readLine().split("\\s");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			int cost = Integer.parseInt(str[2]);
			edgeInsertion(g,u - 1,v - 1,cost);
		}
		//graph minGraph = makeMinSpanTree(g);
		//printGraph(g);
		//printGraph(minGraph);
		//djikstra(g);
		djikstra(g);
		
		/*PriorityQueue pq = new PriorityQueue(5);
		pq.enqueue(new node(0,6));
		pq.enqueue(new node(4,4));
		pq.enqueue(new node(2,5));
		pq.enqueue(new node(3,9));
		pq.enqueue(new node(1,2));
		for(int i = 0 ; i < 5 ; i++)
		{
			System.out.println("i : " + i + "pos : " + pq.pos[i]);
		}*/
	}
	
	
	public static void printGraph(graph g)
	{
		System.out.println("-------------------------");
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
		System.out.println("-------------------------");
	}
	
	private static graph makeMinSpanTree(graph g) {
		
		int[] distance = new int[g.V];
		int[] path = new int[g.V];
		PriorityQueue pq = new PriorityQueue(g.V);
		pq.enqueue(new node(0,0));
		distance[0] = 0;
		path[0] = 0;
		for(int i = 1 ; i < g.V ; i++)
		{
			distance[i] = Integer.MAX_VALUE;
			path[i] = -1;
			pq.enqueue(new node(i,Integer.MAX_VALUE));
		}
		graph minSpanTree = explore(g, 0, distance,path, pq);
		return minSpanTree;
	}


	public static void djikstra(graph g)
	{
		int[] distance = new int[g.V];
		distance[0] = 0;
		for(int i = 1 ; i < g.V ; i++)
		{
			distance[i] = -1;
		}
		explore(g,0,distance);
		if(distance[g.V - 1] == -1)
		{
			System.out.println("NO PATH EXISTS");
		}
		else
		{
			System.out.println(distance[g.V - 1]);
		}
	}

	private static void explore(graph g, int i, int[] distance) {
		// TODO Auto-generated method stub
		PriorityQueue pq = new PriorityQueue(g.V);
		pq.enqueue(g.list[0]);
		while(!pq.isEmpty())
		{
			//System.out.println("Inside");
			node n = pq.dequeue();
			int u = n.vertexNum;
			node adj = g.list[u].next;
			while(adj != null)
			{
				int v = adj.vertexNum;
				int newCost;
				int diff = adj.cost - distance[u];
				if(diff <= 0)
				{
					newCost = distance[u];
				}
				else
				{
					newCost = distance[u] + diff;
				}
				if(distance[v] == -1)
				{
					node m = new node(v,newCost);
					distance[v] = newCost;
					pq.enqueue(m);
				}
				
				else if(newCost < distance[v])
				{
					distance[v] = newCost;
					pq.update(v, newCost);
				}
				adj = adj.next;
			}
		}
	}


	public static graph explore(graph g,int source,int[] distance,int[] path,PriorityQueue pq)
	{
		graph minSpan = new graph(g.V,g.E);
		int[] added = new int[g.V];
		int totalWeight = 0;
		while(!pq.isEmpty())
		{
			node n = pq.dequeue();
			int u = n.vertexNum;
			//System.out.println("u : " + u);
			added[u] = 1;
			if(u != path[u])
			{
				edgeInsertion(minSpan, u, path[u], distance[u]);
			}
			node adj = g.list[u].next;
			while(adj != null)
			{
				int v = adj.vertexNum;
				//System.out.println("v  : " + v);
				int newCost = adj.cost;
				if(distance[v] == Integer.MAX_VALUE)
				{
					distance[v] = newCost;
					path[v] = u;
					totalWeight += newCost;
					pq.update(v, newCost);;
				}
				else if(distance[v] > newCost && added[v] == 0)
				{
					totalWeight = totalWeight - distance[v];
					distance[v] = newCost;
					path[v] = u;
					totalWeight += distance[v];
					pq.update(v, newCost);
				}
				adj = adj.next;
			}
		}
		return minSpan;
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
