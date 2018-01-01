import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;

class Node
{
    int[] arr;
    public Node(int[] arr)
    {
        this.arr = arr;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        boolean[] prime_container = segmented_sieve(1000, 9999);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            String[] strArr = br.readLine().split(" ");
            int start = Integer.parseInt(strArr[0]);
            int end = Integer.parseInt(strArr[1]);
            func(start,end,prime_container);
            t--;
        }
    }

    public static int parse_int(int[] arr)
    {
        int value = 0;
        for(int i = 0 ; i < 4 ; i++)
        {
            value = value * 10 + arr[i];
        }
        return value;
    }

    public static void func(int start,int end,boolean[] prime_container)
    {
        if(start == end)
        {
            System.out.println(0);
            return;
        }
        char[] char_arr = String.valueOf(start).toCharArray();
        int[] num_arr = new int[4];
        for(int i = 0 ; i < 4 ; i++)
        {
            num_arr[i] = Character.getNumericValue(char_arr[i]);
        }
        Node start_node = new Node(num_arr);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        HashMap<Integer,Integer> distance = new HashMap<>();
        queue.addLast(start_node);
        distance.put(start,0);
        while(!queue.isEmpty())
        {
            Node node = queue.pollFirst();
            int[] arr = node.arr;
            int value = parse_int(node.arr);
            int curr_distance = distance.get(value);
            for(int i = 0 ; i < 4 ; i++)
            {
                int original = arr[i];
                if(i != 0)
                {
                    arr[i] = 0;
                    int adj_value = parse_int(arr);
                    if(adj_value == end)
                    {
                        System.out.println(curr_distance + 1);
                        return;
                    }
                    
                    if(prime_container[adj_value - 1000] == true && distance.containsKey(adj_value) == false)
                    {
                        int[] new_num_arr = get_num_arr(adj_value);
                        distance.put(adj_value,curr_distance + 1);
                        queue.addLast(new Node(new_num_arr));
                    }
                    arr[i] = original;
                }
                for(int j = 1 ; j < 10 ; j++)
                {
                    arr[i] = j;
                    int adj_value = parse_int(arr);
                    if(adj_value == end)
                    {
                        System.out.println(curr_distance + 1);
                        return;
                    }
                    if(prime_container[adj_value - 1000] == true && distance.containsKey(adj_value) == false)
                    {
                        int[] new_num_arr = get_num_arr(adj_value);
                        distance.put(adj_value,curr_distance + 1);
                        queue.addLast(new Node(new_num_arr));
                    }
                }
                arr[i] = original;
            }
        }
        System.out.println("Impossible");
        return;
    }

    public static int[] get_num_arr(int value)
    {
        int[] arr = new int[4];
        for(int i = 3 ; value > 0 ; i--)
        {
            int rem = value % 10;
            arr[i] = rem;
            value = value - rem;
            value = value / 10;
        }
        return arr;
    }

    public static boolean[] segmented_sieve(int low,int high)
    {
        boolean[] prime_container = new boolean[high - low + 1];
        //finding small primes
        int high_root = (int) Math.sqrt(high);
        boolean[] is_prime = new boolean[high_root + 1];
        for(int i = 0 ; i < high_root + 1 ; i++)
        {
            is_prime[i] = true;
        }
        for(int i = 2 ; i < high_root + 1 ; i++)
        {
            if(is_prime[i] == true)
            {
                for(int j = i * i ; j < high_root + 1 ; j += i)
                {
                    is_prime[j] = false;
                }
            }
        }
        int n = high - low + 1;
        for(int i = 0 ; i < n ; i++)
        {
            prime_container[i] = true;
        }

        for(int i = 2 ; i < high_root + 1 ; i++)
        {
            if(is_prime[i] == true)
            {
                int remainder = low % i;
                int start_index;
                if(remainder == 0)
                    start_index = 0;
                else
                    start_index = i - (remainder);
                for(int j = start_index;j < n ; j += i)
                {
                    prime_container[j] = false;
                }
            }
        }
        /* int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(prime_container[i] == true)
            {
                //System.out.println((i + low) + ", is a prime");
                count++;
            }
        }
        System.out.println("count = " + count);
 */
        return prime_container;
    }
}