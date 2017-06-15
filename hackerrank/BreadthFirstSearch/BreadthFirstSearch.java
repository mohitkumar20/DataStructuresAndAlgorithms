import java.io.*;
import java.util.*;


class node
{
	int vertexNum;
	node next;
	public node(int vertexNum)
	{
		this.vertexNum = vertexNum;
	}
}

public class BreadthFirstSearch
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		while(q > 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			ArrayList<node> list = new ArrayList<node>(v);
			for(int i = 0 ; i < v ; i++)
			{
				list.add(new node(i));
			}
			for(int i = 0 ; i < e ; i++)
			{
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st2.nextToken());
				int w = Integer.parseInt(st2.nextToken());
				edgeInsertion(list,u - 1,w - 1);	
			}
			int s = Integer.parseInt(br.readLine());
			shortestPath(list,v,e,s - 1);
			q--;
		}
	}

	public static void edgeInsertion(ArrayList<node> list,int u,int v)
	{
		node temp = list.get(u).next;
		node n = new node(v);
		list.get(u).next = n;
		n.next = temp;
		

		n = new node(u);
		temp = list.get(v).next ;
		list.get(v).next = n;
		n.next = temp;

	}

	public static void shortestPath(ArrayList<node> list,int v,int e,int s)
	{
		int[] distance = new int[v];
		for(int i = 0 ; i < v ; i++)
		{
			if(i != s)
			{
				distance[i] = -1;
			}
			else
			{
				distance[i] = 0;
			}
		}
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>(v);
		queue.addLast(s);
		while(queue.size() != 0)
		{
			int a = queue.pollFirst();
			node adjacent = list.get(a).next;
			while(adjacent != null)
			{
				int w = adjacent.vertexNum;
				if(distance[w] == -1)
				{
					distance[w] = distance[a] + 6;
					queue.addLast(w);
				}
				adjacent = adjacent.next;
			}
		}
		for(int i = 0 ; i < v ; i++)
		{
			if(i != s)
			{
				System.out.print(distance[i] + " ");
			}
		}
		System.out.println("");		
	}
	
}
