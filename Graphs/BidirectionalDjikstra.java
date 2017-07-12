import java.util.*;
import java.io.*;


public class BidirectionalDjikstra
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
                  n.weight = -1;
                  g.list.add(n);
            }
            System.out.println("Enter Space separated directed Edges and corresponding weight(u v w): ");
            for(int i = 0 ; i < g.E ; i++)
            {
                  st = new StringTokenizer(br.readLine());
                  int u = Integer.parseInt(st.nextToken());
                  int v = Integer.parseInt(st.nextToken());
                  int w = Integer.parseInt(st.nextToken());
                  edgeInsertion(g,u,v,w);
            }
            printGraph(g);
            System.out.println("-------------");
	    System.out.println("Enter space separated source and destination node");
	    StringTokenizer st2 = new StringTokenizer(br.readLine());
		int source = Integer.parseInt(st2.nextToken());
		int dest = Integer.parseInt(st2.nextToken());
		System.out.println(shortestPath(g,source,dest));
            
	}

	

	public static void edgeInsertion(graph g,int u,int v,int w)
	{
		node n = new node();
		n.vertexNum = v;
		node temp = g.list.get(u).next;
		g.list.get(u).next = n;
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

	public static int shortestPath(graph g,int source,int dest)
	{
		graph gr = makeReverseGraph(g);
		System.out.println("--------------------Reverse Graph------------");
		printGraph(gr);
		//HashSet<Integer> visited = new HashSet<Integer>(g.V);//container for visited nodes in forward djikstra.
		int[] visited = new int[g.V];
		int[] visitedR = new int[g.V];
		//HashSet<Integer> visitedR = new HashSet<Integer>(g.V); //container for visited nodes in backward djikstra.
		entry[] distance = new entry[g.V] ; //array that stores distances for forward djikstra.
		entry[] distanceR = new entry[g.V]; //array that stores distances for backward djikstra.
		PriorityQueue<entry> pq = new PriorityQueue<entry>(g.V,new MyComparator());//priority queue for forward djikstra
		PriorityQueue<entry> pqr = new PriorityQueue<entry>(g.V,new MyComparator());//priority queue for backward djikstra.
		return bidirectionDjikstra(g,gr,source,dest,visited,visitedR,distance,distanceR,pq,pqr);
				
	}

	public static int bidirectionDjikstra(graph g,graph gr,int source,int dest,int[] visited,int[] visitedR,entry[] distance,entry[] distanceR,PriorityQueue<entry> pq,PriorityQueue<entry> pqr)
	{
		int pathLength = Integer.MAX_VALUE;
		for(int i = 0 ; i < g.V ; i++)
		{
			if(i != source && i != dest)
			{	
				distance[i] = new entry(i,Integer.MAX_VALUE);
				distanceR[i] = new entry(i,Integer.MAX_VALUE);
			}
			else if(i == source)
			{
				distance[i]= new entry(i,0);
				distanceR[i] = new entry(i,Integer.MAX_VALUE);
			}
			else
			{
				distance[i] = new entry(i,Integer.MAX_VALUE);
				distanceR[i] = new entry(i,0);
			}             
		        
		}
		pq.add(distance[source]);
		pqr.add(distanceR[dest]);
		while(pq.size() != 0 && pqr.size() != 0)
		{
			System.out.println("inside");
			entry u = pq.poll();
			int uNum = u.vertexNum;
			visited[uNum] = 1;
			node adjacent = g.list.get(uNum).next;
			while(adjacent != null)
			{
				int newDist = distance[uNum].distance + adjacent.weight;
				int vNum = adjacent.vertexNum;
				if(distance[vNum].distance == Integer.MAX_VALUE)
				{
					distance[vNum].distance = newDist;
					pq.add(distance[vNum]);
				}
				else
				{
					if(distance[vNum].distance > newDist)
					{
						pq.remove(distance[vNum]);
						distance[vNum].distance = newDist;
						pq.add(distance[vNum]);
					}
				}
   	                         adjacent = adjacent.next;
			}
			if(visitedR[uNum] == 1)
			{
				System.out.println("inside first visited block");
				pathLength = findPathLength(g,gr,distance,distanceR);
				return pathLength;	
			}
			//will do same steps for the backward djikstra
			//a is the source node of the edge and b is the end node of the edge.
			entry a = pqr.poll();
			int aNum = a.vertexNum;
			visitedR[aNum] = 1;
			node adj = gr.list.get(aNum).next;
			while(adj != null)
			{       
				int bNum = adj.vertexNum;
				int newDist = distanceR[aNum].distance + adj.weight;
				if(distanceR[bNum].distance == Integer.MAX_VALUE)
				{
					distanceR[bNum].distance = newDist;
					pqr.add(distanceR[bNum]);
				}
				else if(distanceR[bNum].distance > newDist)
				{
					pqr.remove(distanceR[bNum]);
					distanceR[bNum].distance = newDist;
					pqr.add(distanceR[bNum]);
				}
				adj = adj.next; 	
			}
			if(visited[aNum] == 1)
			{
				System.out.println("inside second visited block");
				pathLength = findPathLength(g,gr,distance,distanceR);
				return pathLength;	
			}
		}
		return pathLength;	
			
	}

	public static int findPathLength(graph g,graph gr,entry[] distance,entry[] distanceR)
	{
		int shortestPathLength = Integer.MAX_VALUE;
		System.out.println("-------distance--------------------------");
		for(int i = 0 ; i < g.V ; i++)
		{
			System.out.println("i = " + i + ", distance = " + distance[i].distance + " ");
		}
		System.out.println("--------------------");
		System.out.println("-----------distanceR---------");
		for(int i = 0 ; i < g.V ; i++)
		{
			System.out.println("i = " + i + ", distance = " + distanceR[i].distance + " ");
		}
		System.out.println("\n");
		for(int i = 0 ; i < g.V ; i++)
		{
			if(distance[i].distance != Integer.MAX_VALUE && distanceR[i].distance != Integer.MAX_VALUE)
			{
				int pathLength = distance[i].distance + distanceR[i].distance;
				System.out.println("pathLength = " + pathLength);
				if(pathLength < shortestPathLength)
				{
					shortestPathLength = pathLength;	
				}
			}
		}
		System.out.println("dsfffffff");
		System.out.println("shortest dist = " + shortestPathLength);
		return shortestPathLength;
	}	

	public static graph makeReverseGraph(graph g)
	{
		graph gr = new graph();
           gr.V = g.V;
           gr.E = gr.E;
           gr.list = new ArrayList<node>(gr.V);
           node n = null;
           for(int i = 0 ; i < g.V ; i++)
           {
                 n = new node();
                 n.vertexNum = i;
                 n.next = null;
                 gr.list.add(n);
           }
           //System.out.println("gr.v = " + gr.V + " list size = " + gr.list.size());
           for(int i = 0 ; i < gr.V ; i++)
           {
                  int v = i;
                  node adj = g.list.get(i).next;
                  while(adj != null)
                  {
                        int u = adj.vertexNum;
                        edgeInsertion(gr,u,v,adj.weight);
                        adj = adj.next;
                  }
           }
           return gr;
	}
}