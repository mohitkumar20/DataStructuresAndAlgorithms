import java.util.*;
import java.io.*;

//this class will be used to store a node's distance.
class entry
{
      int vertexNum;
      int distance;

      public entry(int vertexNum,int distance)
      {
            this.vertexNum = vertexNum;
            this.distance = distance;
      }
}

class node
{
      int vertexNum;
      node next;
      int weight;
}


 class graph
{
      ArrayList<node> list;
      int V;
      int E;
}

class MyComparator implements Comparator<entry>
{
       public int compare(entry e1,entry e2)
       {
             if(e1.distance < e2.distance)
             {
                   return -1;
             }
             if(e1.distance > e2.distance)
             {
                   return 1;
             }
             return 0;
       }
}

public class Djikstra
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
            entry[] distance = new entry[g.V];
            for(int i = 0 ; i < g.V ; i++)
            {
                  if(i != 0)
                  {
                        distance[i] = new entry(i,Integer.MAX_VALUE);
                  }
                  else
                  {
                        // i m making the program assuming source is 0th node only.
                        distance[i] = new entry(i,0);
                  }
            }
            djikstra(g,distance);
            for(int i = 0 ; i < g.V ; i++)
            {
                  System.out.println("node = " + i + ",distance = " + distance[i].distance);
            }
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

     public static void djikstra(graph g,entry[] distance)
     {
           PriorityQueue<entry> pq = new PriorityQueue<entry>(g.V,new MyComparator());
           pq.add(distance[0]);
           while(pq.size() != 0)
           {
                 int u = pq.poll().vertexNum;
                // System.out.println(u);
                 node adjacent = g.list.get(u).next;
                 while(adjacent != null)
                 {
                       int v = adjacent.vertexNum;
                       int newDist = distance[u].distance + adjacent.weight;
                       if(distance[v].distance == Integer.MAX_VALUE)
                       {
                             distance[v].distance = distance[u].distance + adjacent.weight;
                             pq.add(distance[v]);
                       }
                       else if(distance[v].distance > newDist)
                       {
                             pq.remove(distance[v]);
                             distance[v].distance = newDist;
                             pq.add(distance[v]);
                       }
                       adjacent = adjacent.next;
                 }
          }
     }
}
