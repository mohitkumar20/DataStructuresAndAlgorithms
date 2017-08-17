import java.util.*;
class node
{
	int vertexNum;
	node next;
	int cost;
	public node(int vertexNum)
	{
		this.vertexNum = vertexNum;
		cost = Integer.MAX_VALUE;
		next = null;
	}

	public node(int vertexNum,int cost)
	{
		this.vertexNum = vertexNum;
		this.cost = cost;
		next = null;
	}
}

class priorityQueue
{
	node[] arr;
	int size;
	int[] pos;
	int capacity;
	public priorityQueue(int capacity)
	{
		this.capacity = capacity;
		arr = new node[capacity];
		size = 0;
		pos = new int[capacity];
	}

	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		else
			return false;
	}

	public void enqueue(node newNode)
	{
		arr[size] = newNode;
		pos[newNode.vertexNum] = size;
		int i = size;
		size++;
		while((i - 1) / 2 >= 0)
		{
			if(arr[(i - 1) / 2].cost <= arr[i].cost)
			{
				pos[arr[i].vertexNum] = i;
				return;
			}
			else
			{
				pos[arr[i].vertexNum] = (i - 1)/2;
				pos[arr[(i - 1)/2].vertexNum] = i;
				swap(i,(i - 1) / 2);
				i = (i - 1) / 2;
			}
		}
	}
	public node dequeue()
	{
		node toReturn = arr[0];
		arr[0] = arr[size - 1];
		int i = 0;
		size--;
		while(true)
		{
			if(2 * i + 2 < size)
			{
				if(arr[i].cost <= arr[2 * i + 1].cost && arr[i].cost <= arr[2 * i + 2].cost)
				{
					pos[arr[i].vertexNum] = i;
					return toReturn;
				}
				else
				{
					int smaller = findSmaller(2 * i + 1,2 * i + 2);
					pos[arr[i].vertexNum] = smaller;
					pos[arr[smaller].vertexNum] = i;
					swap(i,smaller);
					i = smaller;
				}
			}
			if(2 * i + 2 == size)
			{
				if(arr[i].cost <= arr[2 * i + 1].cost)
				{
					pos[arr[i].vertexNum] = i;
					return toReturn;
				}
				else
				{
					pos[arr[i].vertexNum] = 2 * i + 1;
					pos[arr[2 * i + 1].vertexNum] = i;
					swap(i,2 * i + 1);
					i = 2 * i + 1;
				}
			}
			else
			{
				pos[arr[i].vertexNum] = i;
				return toReturn;
			}
		}
	}

	public int findSmaller(int i,int j)
	{
		if(arr[i].cost <= arr[j].cost)
			return i;
		else
			return j;
	}
	public void update(int vertexNum,int newCost)
	{
		int i = pos[vertexNum];
        arr[i].cost = newCost; 
		while((i - 1) / 2 >= 0)
		{
			if(arr[(i - 1) / 2].cost <= arr[i].cost)
			{
				pos[arr[i].vertexNum] = i;
				return;
			}
			else
			{
				pos[arr[i].vertexNum] = (i - 1)/2;
				pos[arr[(i - 1)/2].vertexNum] = i;
				swap(i,(i - 1) / 2);
				i = (i - 1) / 2;
			}
		}

	}
	private void swap(int i,int j)
	{
		node temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
class graph
{
	int V;
	int E;
	node[] adjList;
	int[] distance;
	int[] path;
	long MSTCost = 0;
	public graph(int V,int E)
	{
		this.V = V;
		this.E = E;
		adjList = new node[V];
        distance = new int[V];
		path = new int[V];
		for(int i = 0 ; i < V ; i++)
		{
			distance[i] = Integer.MAX_VALUE;
			path[i] = -1;
			adjList[i] = new node(i);
		}
	}
	public void addEdge(int u,int v,int cost)
	{
		node newNode = new node(v);
		newNode.cost = cost;
		newNode.next = adjList[u].next;
		adjList[u].next = newNode;

		newNode = new node(u);
		newNode.cost = cost;
		newNode.next = adjList[v].next;
		adjList[v].next = newNode;
	}

	public void prim()
	{
		prim(0);
	}

	public void prim(int root)
	{
		priorityQueue pq = new priorityQueue(V);
        int[] added = new int[V];
		for(int i = 0 ; i < V ; i++)
		{
			if(i != root)
			{
				path[i] = -1;
				distance[i] = Integer.MAX_VALUE;
				pq.enqueue(new node(i,Integer.MAX_VALUE));
			}
			else
			{
				path[i] = i;
				distance[i] = 0;
				pq.enqueue(new node(i,0));
			}
		}

		while(!pq.isEmpty())
		{
			node n = pq.dequeue();
			int u = n.vertexNum;
            added[u] = 1;
			node adj = adjList[u].next;
			while(adj != null)
			{
                int newCost = adj.cost;
                if(distance[v] == Integer.MAX_VALUE)
                {
                    MSTCost += newCost;
                    distance[v] = newCost;
                    pq.update(v,newCost);
                }
                else if(distance[v] > newCost && added[v] == 0)
                {
                    MSTCost -= distance[v];
                    distance[v] = newCost;
                    MSTCost += distance[v];
                    pq.update(v,newCost);
                }
                adj = adj.next;
			}
		}
        System.out.println("MST Cost : " + MSTCost);
	}

}

public class prim
{
	public static void main(String[] args)
	{
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter space separated V and E");
       int V = sc.nextInt();
       int E = sc.nextInt();
       graph g = new graph(V,E);
       //Enter space separated u v and cost of the edge  
       System.out.println("Enter space separated u v and cost of the edge ");
       for(int i = 0 ; i < E ; i++)
       {
           int u = sc.nextInt();
           int v = sc.nextInt();
           int cost = sc.nextInt();
           g.addEdge(u,v,cost);
       }
       g.prim(0);

       

	}
}
