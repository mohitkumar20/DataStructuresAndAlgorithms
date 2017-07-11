/*
*This program displays "cycle is detected" if there is one,
*and displays nothing about cycle if there is none.
*/

import java.io.*;
import java.util.*;

public class DetectCycleInDirected
{
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
            System.out.println("Enter Space separated Edges(directed)");
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

	public static void detectCycle(graph g)
	{
		int[] visited = new int[g.V];
		int[] visiting = new int[g.V]; //visiting[u] is set when vertex u is in recursion stack i.e it has been visited and now its neighbours are getting visited.
		for(int i = 0 ; i < g.V ; i++)
		{
			if(visited[i] == 0)
			{
				 int ans = explore(g,i,visited,visiting);
				 if(ans == 1)
				{
					System.out.println("Cycle detected");
					return;
				}
			}
		}	
	}

	/*
	*Cycle in a directed graph exists only if we were 
	*exploring a vertex u and while exploring it we visit
	*it again.
	*/
	public static int explore(graph g,int u,int[] visited,int[] visiting)
	{
		visited[u] = 1;
		visiting[u] = 1;
		node adjacent = g.list.get(u).next;
		//System.out.println("u = " + u);
		while(adjacent != null)
		{
			int w = adjacent.vertexNum;
			if(visited[w] == 0)
			{
				int val = explore(g,w,visited,visiting);
				if(val == 1)
				{
					return 1;
				}
			}
			else if(visiting[w] == 1)//we were exploring w and we again found it.this means cycle
			{
				return 1;
			}
			else if(visited[w] == 1 && visiting[w] == 0)//we were done exploring w and after exploring it. we found it again.no cycle is there in this case.
			{
				
			}
			adjacent = adjacent.next;
		}
		visiting[u] = 0;
		return 0;
	}	
}















