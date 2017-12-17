import java.io.*;

public class Main
{
    public static int max_size = 2 * (int)Math.pow(10,7) + 1;
    //public static int max_size = 25;
    //public static int max_size = 2 * (int)Math.pow(10,6) + 1;
    public static boolean[] dp = new boolean[max_size];
    public static int[] somePrimeDivisor = new int[max_size];
    public static int[] numOfDivisors = new int[max_size];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preprocess();
        /*System.out.println(numOfDivisors[101]);
        System.out.println(numOfDivisors[100]);
        System.out.println(numOfDivisors[99]);*/
        /*System.out.println(numOfDivisors[13]);
        System.out.println(numOfDivisors[18]);
        System.out.println(numOfDivisors[9]);
        System.out.println(numOfDivisors[2]);
        System.out.println(numOfDivisors[12]);*/
        /*System.out.println(numOfDivisors[55447]);
        System.out.println(somePrimeDivisor[55447]);
        System.out.println(somePrimeDivisor[623]);
        System.out.println(somePrimeDivisor[89]);*/
        
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            int n = Integer.parseInt(br.readLine());
            if(dp[n] == true)
                System.out.println("Ada");
            else
                System.out.println("Vinit");
            t--;
        }
    }
    //this is a very important function that can be used in my problems 
    //Understand this thoroughly.
    public static void somePrimeDivisor()
    {
        for(int i = 0 ; i < max_size ; i++)
        {
            somePrimeDivisor[i] = 1;
        }
        for(int i = 2 ; i < max_size ; i += 2)
        {
            somePrimeDivisor[i] = 2;
        }
        int o = (int)Math.sqrt(max_size) + 1;
        for(int i = 3 ; i < max_size; i++)
        {
            if(somePrimeDivisor[i] != 1)
            {
                continue;
            }
            somePrimeDivisor[i] = i;
            if(i <= o)
            {
                for(int j = i * i ; j < max_size ; j += 2 * i)
                {
                    somePrimeDivisor[j] = i;
                }
            }
        }
        /*for(int i = 1 ; i < max_size ; i++)
            System.out.println("last prime of " + i + " is " + somePrimeDivisor[i]);*/
    }
    
    /*public static void countDivisors(int num)
    {
        int original = num;
        int result = 1;
        int currDivisorCount = 1;
        int currDivisor = somePrimeDivisor[num];
        int nextDivisor;
        while(currDivisor != 1)
        {
            num = num / currDivisor;
            nextDivisor = somePrimeDivisor[num];
            if(nextDivisor == currDivisor)
            {
                currDivisorCount++;
            }
            else
            {
                result = result * (currDivisorCount + 1);
                currDivisorCount = 1;
                currDivisor = nextDivisor;
            }
        }
        if(num != 1)
        {
            result = result * (currDivisorCount + 1);
        }
        //System.out.println("result for num : " + original + ", " + result);
        numOfDivisors[original] = result;
    }*/

    /*public static void countAllDivisors()
    {
        somePrimeDivisor();
        for(int i = 2 ; i < max_size ; i++)
        {
            countDivisors(i);
            //System.out.println("num of divisors of " + i + " = " + numOfDivisors[i]);
        }
    }*/
    
    public static void countAllDivisors() {

    // Fill the `somePrimeDivisor` array:
    /*computePrimeDivisors();*/
    somePrimeDivisor();

    numOfDivisors[1] = 1;
    for (int num = 2 ; num < max_size ; num++) {
        //int divisor = somePrimeDivisor[num];
        int divisor = somePrimeDivisor[num];
        if (divisor == num) {
            // `num` is a prime
            numOfDivisors[num] = 2;
        } else {
            int n = num / divisor;
            int count = 1;
            while (n % divisor == 0) {
                count++;
                n /= divisor;
            }
            // `divisor^count` contributes to `count + 1` in the number of divisors,
            // now use multiplicative property:
            numOfDivisors[num] = (count + 1) * numOfDivisors[n];
        }
    }
}



    public static void preprocess()
    {
        countAllDivisors();
        dp[0] = dp[1] = dp[2] = true;
        for(int i = 3 ; i < max_size ; i++)
        {
            int flag = 0;
            int limit = numOfDivisors[i];
            for(int j = 1 ; j <= limit; j++)
            {
                //If for any i - j, we get false,for playing optimally
                //the current opponent will choose to take j stones out of the
                //pile as for i - j stones, the other player is not winning.
                if(dp[i - j] == false)
                {
                    dp[i] = true;
                    flag  = 1;
                    break;
                }
            }
            if(flag == 0)
                dp[i] = false;
        }
        /*somePrimeDivisor[0] = somePrimeDivisor[1] = 1;
        /*for(int i = 2 ; i < max_size ;i++)
            somePrimeDivisor[i] = 1;*/
/*
        dp[0] = dp[1] = dp[2] = true;
        for(int i = 2 ; i < max_size ; i++)
        {
            for(int j = i ; j < max_size ; j += i)
            {
                if(somePrimeDivisor[j] == 0)
                {
                    somePrimeDivisor[j] += 2;
                }
                else
                    somePrimeDivisor[j]++;
            }
            if(i > 2)
            {
                int flag = 0;
                int divs = somePrimeDivisor[i];
                for(int j = 1; j <= divs ; j++)
                {
                    if(dp[i - j] == false)
                    {
                        dp[i] = true;
                        flag  = 1;
                        break;
                    }
                }
                if(flag == 0)
                {
                    dp[i] = false;
                }
            }
        }*/

    }
/*
    public static int countDivisors(int num)
    {
        int limit = (int)Math.sqrt(num);
        int count = 2;
        for(int i = 2 ; i <= limit ; i++)
        {
            if(num % i == 0)
            {
                count++;
                if(num / i != i)
                {
                    count++;
                }
            }
        }
        /*for(int i = limit ; i >= 1 ; i++)
        {
            if(num % i == 0)
            {
                
            }
        }
      
        return count;
    }*/
}
