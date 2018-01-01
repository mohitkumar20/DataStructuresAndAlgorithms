import java.io.*;

class Node
{
    int vertexNum;
    Node next;
    public Node(int vertexNum)
    {
        this.vertexNum = vertexNum;
        this.next = null;
    }
}

class Graph
{
    int V,E;
    Node[] list;
    public Graph(int V)
    {
        this.V = V;
        this.E = V - 1;
        list = new Node[V];
        for(int i = 0 ; i < V ; i++)
        {
            list[i] = new Node(i);
        }
    }
}

public class Main
{
    public static int longest = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Graph g = new Graph(n);
        String[] strArr = null;
        //System.out.println("kya bakchodi hai bc");
        for(int i = 0 ; i < n - 1 ; i++)
        {
            strArr = br.readLine().split(" ");
            int u = Integer.parseInt(strArr[0]) - 1;
            int v = Integer.parseInt(strArr[1]) - 1;
            insertEdge(g, u, v);
            //System.out.println("at index o " + strArr[0] + ", at index 1 " + strArr[1]);
        }
        boolean[] visited = new boolean[n];
        dfs(g,0,visited);
        System.out.println(longest);

    }

    public static int dfs(Graph g,int u,boolean[] visited)
    {
        int deepest = 0;
        visited[u] = true;
        Node adj = g.list[u].next;
        while(adj != null)
        {
            int v = adj.vertexNum;
            if(visited[v] == false)
            {
                int depth = dfs(g,v,visited);
                if(depth + deepest > longest)
                {
                    longest = depth + deepest;
                }
                if(depth > deepest)
                {
                    deepest = depth;
                }
            }
            adj = adj.next;
        }

        return deepest + 1;
    }

    public static void insertEdge(Graph g , int u ,int v)
    {
        Node temp = g.list[u].next;
        g.list[u].next = new Node(v);
        g.list[u].next.next = temp;

        temp = g.list[v].next;
        g.list[v].next = new Node(u);
        g.list[v].next.next = temp;
    }
}
