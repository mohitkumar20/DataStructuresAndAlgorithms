import java.math.BigInteger;
import java.io.*;

public class Main
{
    public static int maxSize = 101;
    public static BigInteger[] arr = new BigInteger[maxSize];
    public static void main(String[] args) throws IOException
    {
        preprocess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
            t--;
        }

    }
    public static void preprocess()
    {
        arr[0] = arr[1] = BigInteger.ONE;
        for(int i = 2 ; i < maxSize ; i++)
        {
            arr[i] = arr[i - 1].multiply(new BigInteger(String.valueOf(i)));
        }
    }
}
