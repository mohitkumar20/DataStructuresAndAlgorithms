import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;


class Node
{
    public int vertexNum;
    public Node next;
    public Node(int vertexNum)
    {
        this.vertexNum = vertexNum;
        this.next = null;
    }
}

class Graph
{
    int U;
    int V;
    int E;
    int target;
    Node[] u_set = null;
    Node[] v_set = null;

    public Graph(int U,int V,int E)
    {
        this.U = U;
        this.V = V;
        this.E = E;
        //target is the terminating dummy vertex;
        this.target = 0;
        //0 in U set represents the one Unique(extra) node.
        u_set = new Node[U + 1];
        //v_set = new Node[V + 1];
        for(int i = 1 ; i < U + 1 ; i++)
            u_set[i] = new Node(i);
        
        /*for( int i = 1 ; i < V + 1 ; i++)
            v_set[i] = new Node(i);*/
    }
}


public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int U = Integer.parseInt(strArr[0]);
        int V = Integer.parseInt(strArr[1]);
        int E = Integer.parseInt(strArr[2]);
        Graph g = new Graph(U,V,E);
        for(int i = 1 ; i <= E; i++)
        {
            strArr = br.readLine().split(" ");
            int u = Integer.parseInt(strArr[0]);
            int v = Integer.parseInt(strArr[1]);
            addEdge(g,u,v);
        }
        System.out.println(hopcroft(g));
    }

    public static void addEdge(Graph g,int u,int v)
    {
        Node n = new Node(v);
        Node temp = g.u_set[u].next;
        g.u_set[u].next = n;
        n.next = temp;

        /*n = new Node(u);
        temp = g.v_set[v].next;
        g.v_set[v].next = n;
        n.next = temp;*/
    }

    public static int hopcroft(Graph g)
    {
        int matching = 0;
        int[] pairU = new int[g.U + 1];
        int[] pairV = new int[g.V + 1];
        int[] dist = new int[g.U + 1];
        for(int i = 1 ; i < g.U + 1 ; i++)
            pairU[i] = 0;
        for(int i = 1 ; i < g.V + 1 ; i++)
            pairV[i] = 0;
        
        while(bfs(g,pairU,pairV,dist))
        {
            for(int i = 1 ; i < g.U + 1 ; i++)
            {
                if(pairU[i] == 0)
                {
                    if(dfs(i,g,pairU,pairV,dist) == true)
                    {
                        //System.out.println("here first");
                        matching++;
                    }
                }
            }
            for(int i = 1 ; i < g.U + 1 ; i++)
            {
                //System.out.println("u = " + i + ", pair[u] = " + pairU[i]);
            }
        }
        return matching;
    }

    public static boolean dfs(int u,Graph g,int[] pairU,int[] pairV,int[] dist)
    {
        if(u == 0)
            return true;
        else
        {
            Node adj = g.u_set[u].next;
            while(adj != null)
            {
                int v = adj.vertexNum;
                if(dist[pairV[v]] == dist[u] + 1)
                {
                    if(dfs(pairV[v],g,pairU,pairV,dist) == true)
                    {
                        pairU[u] = v;
                        pairV[v] = u;
                        return true;
                    }
                }
                adj = adj.next;
            }
            dist[u] = Integer.MAX_VALUE;
            return false;
        }
    }

    public static boolean bfs(Graph g,int[] pairU,int[] pairV,int[] dist)
    {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        for(int i = 1 ; i < g.U + 1 ; i++)
        {
            if(pairU[i] == 0)
            {
                dist[i] = 0;
                queue.addLast(i);
            }
            else
                dist[i] = Integer.MAX_VALUE;
        }
        dist[g.target] = Integer.MAX_VALUE;
        //System.out.println("bfs start");
        while(queue.size() != 0)
        {
            int u = queue.pollFirst();
            //System.out.println("here, u = " + u + ",pair[u] = " + pairU[u]);
            if(dist[u] < dist[g.target])
            {
                Node adj = g.u_set[u].next;
                while(adj != null)
                {
                    int v = adj.vertexNum;
                    //System.out.println("u = " + u + ", v = " + v + ", pair[v] = " + pairV[v] + ", dist[pair[v]] = " + dist[pairV[v]]);
                    //System.out.println("v = " + v + ", pair[v] = " + pairV[v]);
                    if(dist[pairV[v]] == Integer.MAX_VALUE)
                    {
                        //System.out.println("changing the dist of " + pairV[v]);
                        dist[pairV[v]] = dist[u] + 1;
                        queue.addLast(pairV[v]);
                    }
                    adj = adj.next;
                }
            }
        }
        //System.out.println("dist[target] = " + dist[g.target]);
        return dist[g.target] != Integer.MAX_VALUE;
    }
}
