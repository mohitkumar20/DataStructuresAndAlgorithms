//hackerrank
import java.io.*;

class node
{
	int vertexNum;
	int cost;
	node next;
	public node(int i)
	{
		this.vertexNum = i;
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
			list[i] = new node(i);
		}
	}
}

public class EvenTree {

	static int count = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = null;
		str = br.readLine().split("\\s");
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		graph g = new graph(V,E);
		for(int i = 0 ; i < E ; i ++)
		{
			str = br.readLine().split("\\s");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			edgeInsertion(g,u - 1,v - 1);
		}
		
			dfs(g);
	}

	private static void dfs(graph g) {
		
		int[] visited = new int[g.V];
		int childInPath = 0;
		explore(g,0,visited);
		System.out.println(count);
		
	}

	private static int explore(graph g, int u, int[] visited) {
		
		visited[u] = 1;
		int childInPath = 0,totalchild = 0;
		node adj = g.list[u].next;
		while(adj != null)
		{
			int v = adj.vertexNum;
			if(visited[v] == 0)
			{
				childInPath = explore(g, v, visited);
				if(childInPath % 2 == 0)
				{
					count++;
				}
				totalchild += childInPath;
			}
			adj = adj.next;
		}
		return totalchild + 1;
	}

	private static void edgeInsertion(graph g, int u, int v) {
	
		node n = new node(v);
		node temp = g.list[u].next;
		g.list[u].next = n;
		n.next = temp;
		
		n = new node(u);
		temp = g.list[v].next;
		g.list[v].next = n;
		n.next = temp;
		
	}

}
