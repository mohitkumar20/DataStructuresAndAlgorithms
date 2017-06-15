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






public class JourneyToTheMoon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = null;
		str = br.readLine().split("\\s");
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		graph g = new graph(V,E);
		for(int i = 0 ; i < E ; i++)
		{
			str = br.readLine().split("\\s");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			edgeInsertion(g,u,v);
		}

		dfs(g);
		
	}

	private static void dfs(graph g) {
		
		int[] visited = new int[g.V];
		int[] components = new int[g.V];
		int pointer = 0;
		int count = 0;
		for(int i = 0 ; i < g.V ; i++)
		{
			if(visited[i] == 0)
			{
				count++;
				explore(g,i,visited,components,pointer);
				pointer++;
			}
		}
		long ans = 0;
		for(int i = 0 ; i < count ; i++)
		{
			for(int j = i + 1 ; j < count ; j++)
			{
				ans  = ans + components[i] * components[j];
			}
		}
		System.out.println(ans);
	}

	private static void explore(graph g, int u, int[] visited, int[] components, int pointer) {
		// TODO Auto-generated method stub
		visited[u] = 1;
		components[pointer]++;
		node adj = g.list[u].next;
		while(adj != null)
		{
			int v = adj.vertexNum;
			if(visited[v] == 0)
			{
				explore(g,v,visited,components,pointer);
			}
			
			adj = adj.next;
		}
		
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
