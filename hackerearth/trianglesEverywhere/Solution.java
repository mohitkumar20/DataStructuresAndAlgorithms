import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*
 * triangles can be made in following ways.
 * 1) when divided they can be colored.
 * 2) when divided they can be uncolored.
 * 3) also when we have divided all the triangles upto nth step. we can combine
 * them(colored and uncolored) to form new triangles.
 * for counting uncolored triangles after ith steps, the recursive function is
 * uncolor(i) = uncolor(i - 1) * 4 - uncolor(i - 1)
 * for counting colored triangles after ith steps, the recursive function is 
 * color(i) = color(i - 1) + uncolor(i - 1)
 * after solving for ith steps, the total number of triangles will be, sum of
 * colored triangles plus uncolored triangles plus the triangles we get from
 * combinging colored and uncolored. if you look carefully the number of
 * combined triangles will be equal to colored triangles only.
*/
public class Solution
{
    public static int size = 1000000 + 1;
    public static BigInteger[] colored = new BigInteger[size];
    public static BigInteger[] uncolored = new BigInteger[size];
    //public static long mod = 1000000007;
    public static BigInteger mod = new BigInteger("1000000007");
    public static BigInteger four = new BigInteger("4");
    public static BigInteger two = new BigInteger("2");
    public static void main(String[] args) throws IOException
    {
        /*Arrays.fill(colored,BigInteger.ZERO);
        Arrays.fill(uncolored,BigInteger.ZERO);*/
        auxFunction();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while(q > 0)
        {
            int n = Integer.parseInt(br.readLine());
            //BigInteger total = ((colored[n] + uncolored[n]) % mod  + uncolored[n] / 2) % mod;
            //BigInteger total =  colored[n].add( uncolored[n].mod(mod).add(uncolored[n].divide(two)).mod(mod));
            BigInteger total = colored[n].add(uncolored[n]).mod(mod).add(colored[n]).mod(mod);
            System.out.println(total);
            q--;
        }

    }

    public static void auxFunction()
    {
        colored[0] = BigInteger.ZERO;
        uncolored[0] = BigInteger.ONE;
        /*for(int i = 1 ; i < size ; i++)
        {
            uncolored[i] = (uncolored[i - 1] * 4) % mod - uncolored[i - 1];
            colored[i] = (colored[i - 1] + uncolored[i - 1]) % mod;
        }*/

        for(int i = 1 ; i < size ; i++)
        {
            uncolored[i] = uncolored[i - 1].multiply(four).mod(mod).subtract(uncolored[i - 1]);
            colored[i] = colored[i - 1].add(uncolored[i - 1]).mod(mod);
        }
    }

}
