import java.util.*;
import java.io.*;

public class BFS
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
            System.out.println("Enter Space separated Edges(Undirected) : ");
            for(int i = 0 ; i < g.E ; i++)
            {
                  st = new StringTokenizer(br.readLine());
                  int u = Integer.parseInt(st.nextToken());
                  int v = Integer.parseInt(st.nextToken());
                  edgeInsertion(g,u,v);
            }
            System.out.println("------Original Graph-----");
            printGraph(g);
            System.out.println("-------------");
            shortestPath(g);
      }

      public static void edgeInsertion(graph g,int u,int v)
     {
           node n = new node();
           n.vertexNum = v;
           node temp = g.list.get(u).next;
           g.list.get(u).next = n;
           n.next = temp;


           //*This part of code for Undirected Graph.
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

     public static void shortestPath(graph g)
     {
           /*
           i have written code for shortest path from 0th node only.
           * but it is very simple to convert this for general uth node.
           */

           int[] distance = new int[g.V];
           int[] path = new int[g.V];
           for(int i = 0 ; i < g.V ; i++)
           {
                 if(i != 0)
                 {
                       distance[i] = -1;
                       path[i] = -1;
                 }
                 else
                 {
                       distance[i] = 0;
                       path[i] = i; // showing the path from souce to source is source only.
                 }
          }
           System.out.println("Here");
           bfs(g,distance,path,0);
           for(int i = 0 ; i < g.V ; i++)
           {
                 System.out.println("i = " + i + " ,distance =  " + distance[i] + " ,path = " + path[i]);
          }
     }

     public static void bfs(graph g,int[] distance,int[] path,int u)
     {
           ArrayDeque<node> queue = new ArrayDeque<node>();
           queue.addLast(g.list.get(u));
           while(!queue.isEmpty())
           {
                 node n = queue.pollFirst();
                 int j = n.vertexNum;
                 System.out.println(n.vertexNum);
                 node adjacent = g.list.get(n.vertexNum).next;
                 while(adjacent != null)
                 {
                       if(distance[adjacent.vertexNum] == -1)
                       {
                             queue.addLast(adjacent);
                             distance[adjacent.vertexNum] = distance[j] +  1;
                             int v = adjacent.vertexNum;
                             path[v] = j;
                       }
                       adjacent = adjacent.next;
                 }
           }
     }
}
