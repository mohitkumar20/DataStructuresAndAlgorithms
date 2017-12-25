import java.io.*;

/*
    First I tried with the linkedList approach in which I got
    TLE,Thats why much of the code is commented. This problem is 
    Josephus Problem. IF not able to understand the problem,
    I have saved a paper of josephus problem in evernote.Go through
    it once.
*/
/*
class Node
{
    int num;
    Node next;
    public Node(int num)
    {
        this.num = num;
    }
}
*/

public class Main
{
    /*
    public static Node head = null;
    public static Node end = null;
    */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            if(n == 0 && d == 0)
                return;
            /*
            else if(n == 1)
                System.out.println(1);
                */
            /*
            else if(d == 0)
            {
                System.out.println(n);
            }
            */
            else
            {
                josephus(n,d);
            }
            /*
            else
            {
                head = null;
                end = null;
                createList(n);
                func(n,d);
            }
            */
        }
    }
    public static void josephus(int n,int d)
    {
        int[] arr = new int[n];
        arr[0] = 0;
        for(int i = 1 ; i < n ; i++)
        {
            arr[i] = (d + arr[i - 1]) % (i + 1);
        }
        System.out.println(n + " " + d + " " + (arr[n - 1] + 1));
    }

    /*
    public static  void createList(int size)
    {
        for(int i = 1 ; i <= size ; i++)
        {
            if(head == null)
            {
                head = new Node(i);
                end = head;
            }
            else
            {
                Node newNode = new Node(i);
                end.next = newNode;
                end = end.next;
            }
        }
        end.next = head;

    }
    
    public static void func(int n,int d)
    {
        int count;
        Node curr = head;
        Node prev = end;
        for(int i = 1 ; i < n ; i++)
        {
            count = 1;
            while(count < d)
            {
                prev = curr;
                curr = curr.next;
                count++;
            }
            prev.next = curr.next;
            curr = curr.next;
        }
        System.out.println(n + " " + d + " " + curr.num);
    }
    */
        
}
