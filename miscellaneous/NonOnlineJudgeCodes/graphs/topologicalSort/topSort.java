import java.util.*;


class node
{
    int vertexNum;
    node next;
    public node(int vertexNum)
    {
        this.vertexNum = vertexNum;
        this.next = null;
    }
}
class graph
{
    node[] adjList;
    int V;
    int E;
    int[] visited;
    int[] distance;
	int[] topsort;
	int pos;
    public graph(int V,int E)
    {
        this.V = V;
        this.E = E;
        adjList = new node[V];
        visited = new int[V];
        distance = new int[V];
		topsort = new int[V];
		pos = V - 1;
        for(int i = 0; i < V ; i++)
        {
            adjList[i] = new node(i);
            distance[i] = -1;// -1 indicates infinity distance.
        }
    }
    
    //default bfs that assumes starting point at 0 node
	private void initializeForTopSort()
	{
		for(int i = 0 ; i < V ; i++)
		{
			visited[i] = 0;
			topsort[i] = -1;
		}
		pos = V - 1;
	}
    public void topsort()
    {
		initializeForTopSort();
		int i =0;
		while(i < V)
		{
			if(visited[i] == 0)
				performDFS(visited,topsort,i);
			i++;
		}
		System.out.println("---------------topsort-----------------");
		for(i = 0 ; i < V ; i++)
			System.out.println(topsort[i] + " " );
    }  

	private void performDFS(int[] visited,int[] topsort,int u)
	{
		visited[u] = 1;
		System.out.println("visiting : " + u);
		node adj = adjList[u].next;
		while(adj != null)
		{
			int v = adj.vertexNum;
			if(visited[v] == 0)
				performDFS(visited,topsort,v);
			adj = adj.next;
		}
		topsort[pos--] = u;
	}
    private void performDFS(int u)
    {
        visited[u] = 1;
        System.out.println("visiting : " + u);
        node adj = adjList[u].next;
        while(adj != null)
        {
            int v = adj.vertexNum;
            if(visited[v] == 0)
                performDFS(v);
            adj = adj.next;
        }
    }

    private void initializeDistanceAndVisited()
    {
        for(int i = 0 ; i < V ; i++)
        {
            distance[i] = -1;
            visited[i] = 0;
        }
    }

    //starting node is start
    public void dfs(int start)
    {
        initializeDistanceAndVisited();
        performDFS(start);
    }
    
    public void addEdge(int u,int v)
    {
        node newNode = new node(v);
        newNode.next = adjList[u].next;
        adjList[u].next = newNode;
    }

    public void printGraph()
    {
        for(int i = 0; i < V ; i++)
        {
            System.out.print(i + "->");
            node adj = adjList[i].next;
            while(adj != null)
            {
                System.out.print(adj.vertexNum + "->");
                adj = adj.next;
            }
            System.out.println("null");
        }
    }
}

public class topsort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Enter space separated V and E
		System.out.println("Enter space separated V and E");
        int V;
        int E;
        V = sc.nextInt();
        E = sc.nextInt();
        graph g = new graph(V,E);
        int u,v;
		//Enter space separated u and v.Make sure the graph is a DAG.
		System.out.println("Enter space separated u and v.Make sure the graph is a DAG.");
        for(int i = 0 ; i < E ; i++)
        {
            u = sc.nextInt();
            v = sc.nextInt();
            g.addEdge(u,v);
        }
        g.printGraph();
        g.topsort(); 
    }
}


