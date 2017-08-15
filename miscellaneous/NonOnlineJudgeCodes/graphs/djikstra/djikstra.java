import java.util.Scanner;

class node
{
    int vertexNum;
    node next;
    int cost;
    public node(int vertexNum)
    {
        this.vertexNum = vertexNum;
        this.cost = Integer.MAX_VALUE;
        next = null;
    }

    public node(int vertexNum,int cost)
    {
        this.vertexNum = vertexNum;
        this.cost = cost;
    }
}

class priorityQueue
{
    int size;
    node[] arr;
    int[] pos;
    public priorityQueue(int capacity)
    {
        size = 0;
        arr = new node[capacity];
        pos = new int[capacity];
    }

    public void enqueue(node newNode)
    {
        arr[size] = newNode;
        int i = size;
        size++;
        pos[arr[i].vertexNum] = i;
        while((i - 1)/ 2 >= 0)
        {
            if(arr[(i - 1) / 2].cost <= arr[i].cost)
            {
                pos[arr[i].vertexNum] = i;
                return;
            }
            else
            {
                pos[arr[(i - 1) / 2].vertexNum] = i;
                pos[arr[i].vertexNum] = (i - 1) / 2;
                swap(i,(i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    public node dequeue()
    {
        node toReturn = arr[0];
        arr[0] = arr[size - 1];
        pos[arr[0].vertexNum] = 0;
        size--;
        int i = 0;
        while(true)
        {
            if(2 * i + 2 < size)
            {
                if(arr[i].cost <= arr[2 * i + 1].cost && arr[i].cost <= arr[2 * i + 2].cost)
                {
                    pos[arr[i].vertexNum] = i;
                    return toReturn;
                }
                else
                {
                    int smaller = findSmaller(2 * i + 1,2 * i + 2);
                    pos[arr[smaller].vertexNum] = i;
                    pos[arr[i].vertexNum] = smaller;
                    swap(i,smaller);
                    i = smaller;
                }
            }

            if(2 * i + 2 == size)
            {

                if(arr[i].cost <= arr[2 * i + 1].cost)
                {
                    pos[arr[i].vertexNum] = i;
                    return toReturn;
                }
                else
                {
                    pos[arr[2 * i + 1].vertexNum] = i;
                    pos[arr[i].vertexNum] = 2 * i + 1;
                    swap(i,2 * i + 1);
                    i = 2 * i + 1;
                }
            }
            else
            {
                pos[arr[i].vertexNum] = i;
                return toReturn;
            }
        }
    }


    public void update(int vertexNum)
    {
        int i = pos[vertexNum];
        while((i - 1)/ 2 >= 0)
        {
            if(arr[(i - 1) / 2].cost <= arr[i].cost)
            {
                pos[arr[i].vertexNum] = i;
                return;
            }
            else
            {
                pos[arr[(i - 1) / 2].vertexNum] = i;
                pos[arr[i].vertexNum] = (i - 1) / 2;
                swap(i,(i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    public void swap(int i,int j)
    {
        node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findSmaller(int i,int j)
    {
        if(arr[i].cost <= arr[j].cost)
            return i;
        else
            return j;
    }
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        else
            return false;
    }
}


class graph
{
    int V;
    int E;
    node[] adjList;
    int[] distance;
    public graph(int V,int E)
    {
        this.V = V;
        this.E = E;
        adjList = new node[V];
        distance = new int[V];
        for(int i = 0 ; i < V ; i++)
        {
            adjList[i] = new node(i);
            distance[i] = Integer.MAX_VALUE;
        }
    }

    public void djikstra(int start)
    {
        priorityQueue pq = new priorityQueue(V);
        distance[start] = 0;
        pq.enqueue(new node(start,0));
        while(!pq.isEmpty())
        {
            node u = pq.dequeue();
            node adj = adjList[u.vertexNum].next;
            while(adj != null)
            {
                int newDist = distance[u.vertexNum] + adj.cost; 
                if(distance[adj.vertexNum] == Integer.MAX_VALUE)
                {
                    distance[adj.vertexNum] = newDist;
                    pq.enqueue(new node(adj.vertexNum,newDist));
                }
                else if(distance[adj.vertexNum] > newDist)
                {
                    distance[adj.vertexNum] = newDist;
                    pq.update(adj.vertexNum);
                }
                adj = adj.next;
            }
        }
        for(int i = 0 ; i < V ; i++)
        {
            System.out.println("vertex : " + i + ",distance = " + distance[i]);
        }
    }
    
    public void addEdge(int u,int v,int cost)
    {
        node newNode = new node(v,cost);
        newNode.next = adjList[u].next;
        adjList[u].next = newNode;

        newNode = new node(u,cost);
        newNode.next = adjList[v].next;
        adjList[v].next = newNode; 
    } 
}



public class djikstra
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Enter space separated V and E
        System.out.println("Enter space separated V and E");
        int V = sc.nextInt();
        int E = sc.nextInt();
        graph g = new graph(V,E);
        //Enter space separated u v and cost of the edge  
        System.out.println("Enter space separated u v and cost of the edge ");
        for(int i = 0 ; i < E ; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            g.addEdge(u,v,cost);
        }
        System.out.println("Enter the starting node");
        int start = sc.nextInt();
        g.djikstra(start);
    }
}
