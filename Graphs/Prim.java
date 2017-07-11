import java.util.*;
import java.util.*;
import java.io.*;

public class Prim
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
            System.out.println("Enter Space separated Edges and weight(undirected): ");
	    for(int i = 0 ; i < g.E ; i++)
            {
                  st = new StringTokenizer(br.readLine());
                  int u = Integer.parseInt(st.nextToken());
                  int v = Integer.parseInt(st.nextToken());
		  int w = Integer.parseInt(st.nextToken());
                  edgeInsertion(g,u,v,w);
            }
            System.out.println("------Original Graph-----");
            printGraph(g);
            System.out.println("-------------");
	    prim(g);
	}
	 public static void edgeInsertion(graph g,int u,int v,int w)
	{
          node n = new node();
          n.vertexNum = v;
          node temp = g.list.get(u).next;
          g.list.get(u).next = n;
          n.next = temp;
	  n.weight = w;

		//this part is for undirected graph.
	   n = new node();
           n.vertexNum = u;
           temp = g.list.get(v).next;
           g.list.get(v).next = n;
           n.next = temp;
	   n.weight = w;

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
        public static void prim(graph g)
	{
		PriorityQueue<entry> pq = new PriorityQueue<entry>(g.V,new MyComparator());
		entry[] distance = new entry[g.V];
		int[] added = new int[g.V];//flag if the ith node has been added to the MST.
		for(int i = 0 ; i < g.V ; i++)
		{       //i m choosing the starting node as 0th node.can be easily modified to make a general node as starting node.
			added[i] = 0;
			if(i != 0)
			{
				distance[i] = new entry(i,Integer.MAX_VALUE);
				pq.add(distance[i]);
			}
			else
			{
				distance[i] = new entry(i,0);
				pq.add(distance[i]);
			}
		}
		int cost = 0;//keeping track of the cost of MST
		while(pq.size() != 0)
		{
			entry e = pq.poll();
			cost = cost + e.distance;
			int u = e.vertexNum;
			//System.out.println("edge cost : " + e.distance + "u = " + u);
			//System.out.println("u = " + u);
			added[u] = 1;
			node adjacent = g.list.get(u).next;
			while(adjacent != null)
			{
				int v = adjacent.vertexNum;
				if(distance[v].distance == Integer.MAX_VALUE)
				{
			        	pq.remove(distance[v]);
					distance[v].distance = adjacent.weight;
					pq.add(distance[v]);
				}
				else if(distance[v].distance > adjacent.weight && added[v] == 0)
				{
					pq.remove(distance[v]);
					distance[v].distance = adjacent.weight;
					pq.add(distance[v]);
				}
				adjacent = adjacent.next;
			}
		}
		System.out.println("Total cost of the MST: " + cost);
	}



}
