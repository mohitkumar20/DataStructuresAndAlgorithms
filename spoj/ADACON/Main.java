import java.io.*;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int largest = Integer.MIN_VALUE;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strArr = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = Integer.parseInt(strArr[i]);
            if(arr[i] > largest)
            {
                largest = arr[i];
            }
        }
        func(n,arr,largest);

    }

    public static void func(int n,int[] arr,int largest)
    {
        int[] primes = new int[(largest / 2 + 1)];
        //int primes = findPrimes(largest / 2 + 1,primeContainer);
        //int lenOfPrimes = primes.length;
        int lenOfPrimes = findPrimes(largest / 2 + 1,primes);
        //int[] mat = new int[lenOfPrimes];
        int[] mat = new int[lenOfPrimes];
        for(int j = 0 ; j < lenOfPrimes ; j++)
        {
                if(arr[0] < primes[j])
                {
                    mat[j] = primes[j] - arr[0];
                }
                else if(arr[0] % primes[j] == 0)
                {
                    mat[j] = 0;
                }
                else
                {
                    int rem = arr[0] % primes[j];
                    mat[j] = Math.min(rem,primes[j] - rem);
                }

        }
        for(int i = 1 ; i < n ; i++)
        {
            for(int j = 0 ; j < lenOfPrimes ; j++)
            {
                if(arr[i] < primes[j])
                {
                    mat[j] = mat[j] + primes[j] - arr[i];
                }
                else if(arr[i] % primes[j] == 0)
                {
                    mat[j] = mat[j] + 0;
                }
                else
                {
                    int rem = arr[i] % primes[j];
                    mat[j] += Math.min(rem,primes[j] - rem);
                }
            }
        }

        int smallest = Integer.MAX_VALUE;
        for(int i = 0 ; i < lenOfPrimes ;i++)
        {
            if(mat[i] < smallest)
                smallest = mat[i];
        }

        System.out.println(smallest);
    }

    public static int findPrimes(int upto,int[] primeContainer)
    {
        boolean[] primes = new boolean[upto + 1];
        for(int i = 0 ; i < upto + 1 ; i++)
            primes[i] = true;
        
        int count = 0;
        primes[0] = primes[1] = false;

        int limit = (int)Math.sqrt(upto + 1);
        for(int i = 2 ; i < upto + 1; i++)
        {
            if(primes[i] == true)
            {
                primeContainer[count] = i;
                count++;
                if(i <= limit)
                {
                    for(int j = i * i ; j < upto + 1 ; j += 2 * i)
                    {
                        primes[j] = false;
                    }
                }
            }
        }
/*
        int[] primeContainer = new int[count];
        int index = 0;
        for(int i = 2 ; i < upto + 1 ; i++)
        {
            if(primes[i] == true)
            {
                primeContainer[index++] = i;
                if(index == count)
                    break;
            }
        }*/
        return count;
    }
}
