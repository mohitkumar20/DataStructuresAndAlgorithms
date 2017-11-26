import java.io.*;

public class Solution
{
    public static int size = 1000000 + 1;
    public static long[] colored = new long[size];
    public static long[] uncolored = new long[size];
    public static long mod = 1000000007;
    public static void main(String[] args) throws IOException
    {
        auxFunction();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while(q > 0)
        {
            int n = Integer.parseInt(br.readLine());
            long total = ((colored[n] + uncolored[n]) % mod  + uncolored[n] / 2) % mod;
            System.out.println(total);
            q--;
        }

    }

    public static void auxFunction()
    {
        colored[0] = 0;
        uncolored[0] = 1;
        for(int i = 1 ; i < size ; i++)
        {
            uncolored[i] = (uncolored[i - 1] * 4) % mod - uncolored[i - 1];
            colored[i] = (colored[i - 1] + uncolored[i - 1]) % mod;
        }
    }

}
