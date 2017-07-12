import java.util.*;
import java.util.*;
import java.io.*;

public class StronglyCC
{
      //public static graph g = null;
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
            System.out.println("Enter Space separated Edges(directed): ");
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
            graph gr = makeReverseGraph(g);
            printGraph(gr);
            countStronglyConnectedComponents(g);
      }
      /*
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
   //  }

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
                        edgeInsertion(gr,u,v);
                        adj = adj.next;
                  }
           }
           return gr;
     }

     public static int countStronglyConnectedComponents(graph g)
     {
           graph gr = makeReverseGraph(g);
           ArrayDeque<Integer> stack = dfs(gr);
           int count = 0;
           int[] visited = new int[g.V];
           while(stack.size() != 0)
           {
                // System.out.println(stack.pop() + " ");
                int v = stack.pop();
                if(visited[v] == 0)
                {
                      explore(v,visited,g);
                      count++;
                }
          }
          System.out.println(count);
          return 0;
     }

     public static ArrayDeque<Integer> dfs(graph g)
     {
           int[] visited = new int[g.V];
           ArrayDeque<Integer> stack = new ArrayDeque<Integer>(g.V);
           //pointer = g.V - 1;
           for(int i = 0 ; i < g.V ; i++)
           {
                 if(visited[i] != 1)
                 {
                       explore(i,visited,g,stack);
                 }
           }
           return stack;
     }

     public static void explore(int v,int[] visited,graph g)
    {
          //System.out.println("Exploring: " + v);
          visited[v] = 1;
         // System.out.println(v);
          node ad = g.list.get(v).next;
          while(ad != null)
          {
               if(visited[ad.vertexNum] == 0)
               {
                     explore(ad.vertexNum,visited,g);
               }
               ad = ad.next;
          }
         // System.out.println("Visited : " + v);

    }
     public static void explore(int v,int[] visited,graph g,ArrayDeque<Integer> stack)
     {
           //System.out.println("Exploring: " + v);
           visited[v] = 1;
          // System.out.println(v);
           node ad = g.list.get(v).next;
           while(ad != null)
           {
                if(visited[ad.vertexNum] == 0)
                {
                      explore(ad.vertexNum,visited,g,stack);
                }
                ad = ad.next;
           }
          // System.out.println("Visited : " + v);
           stack.push(v);
     }
}
