import java.io.*;

//Read through segmented seive if you want to understand this.
public class Main
{
    public static int size = 1000000000 + 1;
    public static int sieveLength = (int)Math.sqrt(size) + 1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[sieveLength + 1];
        for(int i = 0 ; i < sieveLength + 1 ; i++)
        {
            isPrime[i] = true;
        }
        //sieveOfEratosthanos(isPrime);
        simpleSieve(isPrime);
        //System.out.println(isPrime[2] + " " + isPrime[3] + " " + isPrime[5]);
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            String[] strArr = br.readLine().split(" ");
            int m = Integer.parseInt(strArr[0]);
            if(m < 2)
                m = 2;
            int n = Integer.parseInt(strArr[1]);
            boolean[] prime = new boolean[n - m + 1];
            for(int i = 0 ; i < (n - m + 1) ; i++)
            {
                prime[i] = true;
            }
            int limit = (int)Math.sqrt(n) + 1;
            for(int i = 2 ; i <= limit ; i++)
            {
                if(isPrime[i])
                {
                    //int start = (m - (m % i) + i) - m;
                    int start = 0;
                    //System.out.println("m = " + m + ", i = " + i);
                    /*
                     * Here I have taken these cases to initialize the start
                     * variable.
                     * */
                    if(m < i)
                    {
                        start = 2 * i - m;
                    }
                    else if (m == i)
                    {
                        start = 2 * i - m;
                    }
                    else
                    {
                        int offset = m % i;
                        if(offset == 0)
                        {
                            start = 0;
                        }
                        else
                        {
                            start = (m - (m % i) + i) - m;
                        }
                    }

                    while(start < (n - m + 1))
                    {
                        prime[start] = false;
                        start += i;
                    }
                }
            }
            /*for(int i = 0 ; i < n - m + 1 ; i++)
            {
                System.out.println("i = " + i + ", prime[i] = " + prime[i] + ", num = " + (m + i));
            }*/
            for(int i = 0 ; i < (n - m + 1) ; i++)
            {
                if(prime[i])
                {
                    System.out.println(m + i);
                }
            }
            System.out.println();
            t--;
        }
    }

    public static void simpleSieve(boolean[] arr)
    {
        arr[0] = false;
        arr[1] = false;
        for(int i = 2 ; i < sieveLength + 1 ; i++)
        {
            if(arr[i] == true)
            {
                int j = 2 * i;
                while(j < sieveLength + 1)
                {
                    arr[j] = false;
                    j += i;
                }
            }
        }
    }

}
