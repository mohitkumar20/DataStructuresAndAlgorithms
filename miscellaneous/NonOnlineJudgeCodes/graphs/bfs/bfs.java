import java.util.*;
class node
{
    int vertexNum;
    node next;
    public node(int vertexNum)
    {
        this.vertexNum = vertexNum;
        this.next = null;
    }
}
class graph
{
    node[] adjList;
    int V;
    int E;
    int[] visited;
    int[] distance;
    public graph(int V,int E)
    {
        this.V = V;
        this.E = E;
        adjList = new node[V];
        visited = new int[V];
        distance = new int[V];
        for(int i = 0; i < V ; i++)
        {
            adjList[i] = new node(i);
            distance[i] = -1;// -1 indicates infinity distance.
        }
    }
    
    //default bfs that assumes starting point at 0 node
    public void bfs()
    {
        initializeDistance();
        queue q = new queue(V);
        q.enqueue(adjList[0]);
        distance[0] = 0;
        visited[0] = 1;
        while(!q.isEmpty())
        {
            node u = q.dequeue();
            node adj = adjList[u.vertexNum].next;
            while(adj != null)
            {
                int v = adj.vertexNum;
                if(visited[v] == 0)
                {
                    visited[v] = 1;
                    distance[v] = distance[u.vertexNum] + 1;
                    q.enqueue(adjList[v]);
                }
                adj = adj.next;
            }
        }
        for(int i = 0 ; i < V ; i++)
        {
            System.out.println("vertex : " + i + ", distance = " + distance[i]);
        }
    }

    private void initializeDistance()
    {
        for(int i = 0 ; i < V ; i++)
            distance[i] = -1;
    }

    //starting node is start
    public void bfs(int start)
    {
        initializeDistance();
        queue q = new queue(V);
        q.enqueue(adjList[start]);
        distance[start] = 0;
        visited[start] = 1;
        while(!q.isEmpty())
        {
            node u = q.dequeue();
            node adj = adjList[u.vertexNum].next;
            while(adj != null)
            {
                int v = adj.vertexNum;
                if(visited[v] == 0)
                {
                    visited[v] = 1;
                    distance[v] = distance[u.vertexNum] + 1;
                    q.enqueue(adjList[v]);
                }
                adj = adj.next;
            }
        }
        for(int i = 0 ; i < V ; i++)
        {
            System.out.println("vertex : " + i + ", distance = " + distance[i]);
        }

    }
    
    public void addEdge(int u,int v)
    {
        node newNode = new node(v);
        newNode.next = adjList[u].next;
        adjList[u].next = newNode;

        newNode = new node(u);
        newNode.next = adjList[v].next;
        adjList[v].next = newNode;
    }

    public void printGraph()
    {
        for(int i = 0; i < V ; i++)
        {
            System.out.print(i + "->");
            node adj = adjList[i].next;
            while(adj != null)
            {
                System.out.print(adj.vertexNum + "->");
                adj = adj.next;
            }
            System.out.println("null");
        }
    }
}
 class queue
{
   node[] arr;
   int front;
   int rear;
   public queue(int capacity)
   {
       arr = new node[capacity];
       this.front = this.rear = -1;
   }
   public boolean isEmpty()
   {
       if(front == -1 || front > rear)
       {
           return true;
       }
       else
           return false;
   }

   public void enqueue(node n)
   {
       if(front == -1)
       {
           front = rear = 0;
           arr[rear] = n;
       }
       else
       {
           arr[++rear] = n;
       }
   }

   public node dequeue()
   {
       return arr[front++];
   }
} 

public class bfs
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Enter space separated V and E
		System.out.println("Enter space separated V and E");
        int V;
        int E;
        V = sc.nextInt();
        E = sc.nextInt();
        graph g = new graph(V,E);
        int u,v;
        //Enter space separated u-v edges
		System.out.println("Enter space separated u-v edges");
        for(int i = 0 ; i < E ; i++)
        {
            u = sc.nextInt();
            v = sc.nextInt();
            g.addEdge(u,v);
        }
        g.printGraph();
		System.out.println("Enter the start vertex(starting from 0)");
		int start = sc.nextInt();
        g.bfs(start); 
    }
}


