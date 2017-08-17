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
class stack
{
	int top;
	int capacity;
	node[] arr;
	public stack(int capacity)
	{
		top = -1;
		arr = new node[capacity];
		this.capacity = capacity;
	}
	public boolean isEmpty()
	{
		if(top == -1)
			return true;
		else
			return false;
	}

	public void push(node vertex)
	{
		arr[++top] = vertex;
	}
	public node pop()
	{
		return arr[top--];
	}

}
class graph
{
    node[] adjList;
    int V;
    int E;
    int[] visited;
    public graph(int V,int E)
    {
        this.V = V;
        this.E = E;
        adjList = new node[V];
        visited = new int[V];
        for(int i = 0; i < V ; i++)
        {
            adjList[i] = new node(i);
			visited[i] = 0;
        }
    }
    
	public graph makeReverse()
	{
		graph gr = new graph(V,E);
		
		for(int u = 0 ; u < V ; u++)
		{
			node adj = adjList[u].next;
			while(adj != null)
			{
				int v = adj.vertexNum;
				gr.addEdge(v,u);
				adj = adj.next;
			}
		}
		return gr;
	}

	public int countSCC()
	{
		graph gr = makeReverse();
		gr.printGraph();
		stack st = new stack(V);
		dfsOnReverseGraph(gr,st);
		int count = 0;
		while(!st.isEmpty())
		{
			node n = st.pop();
			if(visited[n.vertexNum] == 0)
			{
				count++;
				explore(n.vertexNum);
			}
		}

		return count;
	}
	
	public void explore(int u)
	{
		visited[u] = 1;
		node adj = adjList[u].next;
		while(adj != null)
		{
			int v = adj.vertexNum;
			if(visited[v] == 0)
				explore(v);
			adj = adj.next;
		}
	}
	
	public void dfsOnReverseGraph(graph gr,stack st)
	{
		int i = 0;
		while(i < gr.V)
		{
			if(gr.visited[i] == 0)
			{
				explore(gr,i,st);
			}
			
			i++;
		}
	}

	public void explore(graph gr,int u,stack st)
	{
		gr.visited[u] = 1;
		node adj = gr.adjList[u].next;
		while(adj != null)
		{
			int v = adj.vertexNum;
			if(gr.visited[v] == 0)
				explore(gr,v,st);
			adj = adj.next;
		}
		st.push(gr.adjList[u]);
	}


    public void addEdge(int u,int v)
    {
        node newNode = new node(v);
        newNode.next = adjList[u].next;
        adjList[u].next = newNode;

    }

    public void printGraph()
    {
		System.out.println("-----------");
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
		System.out.println("-----------");
    }
}
public class SCC
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
        //Enter space separated u-v edges
		System.out.println("Enter space separated u-v edges");
        for(int i = 0 ; i < E ; i++)
        {
            u = sc.nextInt();
            v = sc.nextInt();
            g.addEdge(u,v);
        }
        g.printGraph();
		System.out.println(g.countSCC());

    }

}


