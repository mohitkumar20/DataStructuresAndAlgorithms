import java.util.Scanner;
class node
{
	int vertexNum;
	node next;
	public node(int vertexNum)
	{
		this.vertexNum = vertexNum;
		next = null;
	}
}


class queue
{
	node[] arr;
	int front,rear;
	int capacity;
	public queue(int capacity)
	{
		this.capacity = capacity;
		front = rear = -1;
		arr = new node[capacity];
	}

	public boolean isEmpty()
	{
		if(front == -1 || front > rear)
			return true;
		else
			return false;
	}
	public void enqueue(node newNode)
	{
		if(front == -1)
		{
			front++;
			arr[++rear] = newNode;
		}
		else
			arr[++rear] = newNode;
	}
	public node dequeue()
	{
		return arr[front++];
	}
}

class graph
{
	int V;
	int E;
	node[] adjList;
	int[] color;// will work as visited array as well.
	public graph(int V,int E)
	{
		this.V = V;
		this.E = E;
		adjList = new node[V];
		color = new int[V];
		for(int i = 0 ; i < V ; i++)
		{
			color[i] = -1;//color not assigned yet
			adjList[i] = new node(i);
		}
	}

	boolean isBipartite()
	{
		queue q = new queue(V);
		color[0] = 0; // 0 represents red and 1 represents blue;
		q.enqueue(new node(0));
		while(!q.isEmpty())
		{
			node n = q.dequeue();
			int u = n.vertexNum;
			node adj = adjList[u].next;
			while(adj != null)
			{
				int v = adj.vertexNum;
				if(color[v] == -1)
				{
					color[v] = 1 - color[u];
					q.enqueue(new node(v));
				}
				else 
				{
					if(color[v] == color[u])
						return false;
				}
				adj = adj.next;
			}
		}
		return true;
	}
	public void addEdge(int u,int v)
	{
		node newNode = new node(v);
		newNode.next = adjList[u].next;
		adjList[u].next = newNode;	

		newNode = new node(u);
		newNode.next = adjList[v].next;
		adjList[v].next = newNode;	
	}

}

public class bipartite
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter space separated V and E");
		int V = sc.nextInt();
		int E = sc.nextInt();
		graph g = new graph(V,E);
		System.out.println("Enter space separated u and v");
		for(int i = 0 ; i < E ; i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			g.addEdge(u,v);
		}
		System.out.println(g.isBipartite());
	}
}
