import java.io.*;
import java.util.*;

public class DetectCycleInUndirected
{

	public static int time = 1;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	System.out.println("Enter space separated in order : Number of Vertexes and Number of Edges");
            	StringTokenizer st = new StringTokenizer(br.readLine());
           	graph g = new graph();
            	g.V = Integer.parseInt(st.nextToken());
            	g.E = Integer.parseInt(st.nextToken());
            	System.out.println("V = " + g.V);
            	g.list = new ArrayList<node>(g.V);
            	node n = null;
            	for(int i = 0 ; i < g.V ; i++)
            	{
                	n = new node();
                  	n.vertexNum = i;
                  	n.next = null;
                  	g.list.add(n);
            	}
            	System.out.println("Enter Space separated Edges : ");
            	for(int i = 0 ; i < g.E ; i++)
            	{	
                	st = new StringTokenizer(br.readLine());
                  	int u = Integer.parseInt(st.nextToken());
                  	int v = Integer.parseInt(st.nextToken());
                  	edgeInsertion(g,u,v);
            	}
            	printGraph(g);
            	System.out.println("-------------");
		detectCycle(g);
	}

	public static void edgeInsertion(graph g,int u,int v)
	{
		node n = new node();
          	n.vertexNum = v;
          	node temp = g.list.get(u).next;
          	g.list.get(u).next = n;
          	n.next = temp;

		//this part is for undirected graph.
	   	n = new node();
           	n.vertexNum = u;
           	temp = g.list.get(v).next;
           	g.list.get(v).next = n;
           	n.next = temp;

	}
	public static void printGraph(graph g)
	{
		for(int i = 0 ; i < g.V ; i++)
           	{
                	System.out.print("Vertex :" + i );
                	node curr = g.list.get(i).next;
                	while(curr != null)
                	{
                       		System.out.print("--> " + curr.vertexNum);
                       		curr = curr.next;
                	}
                	System.out.println("--> null");
           	}
	}
	/*
	*program will print nothing if no cycle is there
	*it will print cycle is detected otherwise.
	*/
	public static void detectCycle(graph g)
	{
		int[] visited = new int[g.V];
		int[] parent = new int[g.V];
		for(int i = 0 ; i < g.V ; i++)
		{
			parent[i] = -1;
		} 
		for(int i = 0 ; i < g.V ; i++) // Here i m taking 0th node as source node but prog can be easily modified for general node.
		{
			if(visited[i] == 0)
			{
				explore(g,i,visited,parent);	
			}		
		}
			
	}

	public static int min(int a,int b)
	{
		return a <= b ? a : b;
	}

	public static int explore(graph g,int u,int[] visited,int[] parent)
	{
		visited[u] = 1;
		//discovered[u] = time++;
		//low[u] = discovered[u];
		node adjacent = g.list.get(u).next;
		//int child = 0;
		while(adjacent != null)
		{
			int w = adjacent.vertexNum;
			if(visited[w] == 0) // it is a tree edge.
			{
				//child++;
				parent[w] = u;
				int ans = explore(g,w,visited,parent);
				if(ans == 1)
				{
					return 1;
				}
				//low[u] = min(low[u],low[w]);
			}
			else if(parent[u] != w) // it checks for the back edge. u-w is a back edge only if either its has been visited and w is not the parent of u. if it is the parent of u. then also it a tree edge.
			{
				System.out.println("Cycle detected");
				return 1;
				//low[u] = min(low[u],low[w]);
			}
			
			adjacent = adjacent.next;
		}
		return 0;
	}
}
