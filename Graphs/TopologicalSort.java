import java.util.*;
import java.io.*;

public class TopologicalSort
{
      public static graph g = null;
      public static int[] topSort = null;
      public static int pointer;
      public static void main(String[] main) throws IOException
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter space separated in order : Number of Vertexes and Number of Edges");
            StringTokenizer st = new StringTokenizer(br.readLine());
            g = new graph();
            g.V = Integer.parseInt(st.nextToken());
            g.E = Integer.parseInt(st.nextToken());
            System.out.println("V = " + g.V);
            g.list = new ArrayList<node>(g.V);
            topSort = new int[g.V];
            node n = null;
            for(int i = 0 ; i < g.V ; i++)
            {
                  n = new node();
                  n.vertexNum = i;
                  n.next = null;
                  g.list.add(n);
            }
            System.out.println("Enter Space separated Edges(directed),\nMake sure it is a DAG : ");
            for(int i = 0 ; i < g.E ; i++)
            {
                  st = new StringTokenizer(br.readLine());
                  int u = Integer.parseInt(st.nextToken());
                  int v = Integer.parseInt(st.nextToken());
                  edgeInsertion(u,v);
            }
            printGraph();
            System.out.println("-------------");
            //dfs();
            sort();
            for(int i = 0 ; i < g.V ; i++)
            {

                  System.out.println(topSort[i]);
            }
      }

      public static void edgeInsertion(int u,int v)
     {
           node n = new node();
           n.vertexNum = v;
           node temp = g.list.get(u).next;
           g.list.get(u).next = n;
           n.next = temp;

           /*
           *This part of code for Undirected Graph.
           n = new node();
           n.vertexNum = u;
           temp = g.list.get(v).next;
           g.list.get(v).next = n;
           n.next = temp;
           */
     }
     public static void printGraph()
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

     public static void sort()
     {
           int[] visited = new int[g.V];
           pointer = g.V - 1;
           for(int i = 0 ; i < g.V ; i++)
           {
                 if(visited[i] != 1)
                 {
                       explore(i,visited);
                 }
           }
     }

     public static void explore(int v,int[] visited)
     {
           visited[v] = 1;
          // System.out.println(v);
           node ad = g.list.get(v).next;
           while(ad != null)
           {
                if(visited[ad.vertexNum] == 0)
                {
                      explore(ad.vertexNum,visited);
                }
                ad = ad.next;
           }
           topSort[pointer] = v;
           pointer--;
     }

}
