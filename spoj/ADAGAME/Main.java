import java.io.*;

public class Main
{
    public static char nine = '9';
    public static char zero = '0';
    //3-d matrix for memoization.
    public static int[][][] dp = new int[10000][101][2];
    public static int size = 4;
    public static int[] buffer = new int[size];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        //initializing matrix used for memoization
        for(int i = 0 ; i < 10000 ; i++)
        {
            for(int j = 0 ; j < 101 ; j++)
            {
                //k = 0 will be used by Ada.
                //k = 1 will be used by Vinit.
                for(int k = 0 ; k < 2 ; k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }
        while(t > 0)
        {
            String[] strArr = br.readLine().split(" ");
            int num = Integer.parseInt(strArr[0]);
            int chance = Integer.parseInt(strArr[1]);
            int ans = f1(num,chance);
            if(ans > num)
            {
                System.out.println("Ada");
            }
            else
            {
                System.out.println("Vinit");
            }
            t--;
        }
    }

    //f1 function is used by Ada.
    public static int f1(int num,int chance)
    {
        //int num = Integer.parseInt(num);
        //if we have already calculated the solution once.
        
        if(chance <= 0)
        {
            return num;
        }

        if(dp[num][chance][0] != -1)
        {
            return dp[num][chance][0];
        }
        else
        {
            //changing the digit at all possible positions for a num.
            int firstChanged = changeString(num,0);
            int secondChanged = changeString(num,1);
            int thirdChanged = changeString(num,2);
            int fourthChanged = changeString(num,3);
            //f2 is used by Vinit.
            dp[num][chance][0] =  max(f2(firstChanged,chance - 1),f2(secondChanged,chance - 1),f2(thirdChanged,chance - 1),f2(fourthChanged,chance - 1));
            return dp[num][chance][0];
        }
    }

    //f2 is used by vinit.
    public static int f2(int num,int chance)
    {
        //int num = Integer.parseInt(num);
        //if we have already calculated the solution once.
        
        if(chance <= 0)
        {
            return num;
        }

        if(dp[num][chance][1] != -1)
        {
            return dp[num][chance][1];
        }
        else
        {
            int firstChanged = changeString(num,0);
            int secondChanged = changeString(num,1);
            int thirdChanged = changeString(num,2);
            int fourthChanged = changeString(num,3);
            dp[num][chance][1] =  min(f1(firstChanged,chance - 1),f1(secondChanged,chance - 1),f1(thirdChanged,chance - 1),f1(fourthChanged,chance - 1));
            return dp[num][chance][1];
            //return min(f1(firstChanged,chance - 1),f1(secondChanged,chance - 1),f1(thirdChanged,chance - 1),f1(fourthChanged,chance - 1));
        }

    }

    public static int max(int... arr)
    {
        int max = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
        {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static int min(int... arr)
    {
        int min = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
        {
            if(arr[i] < min)
                min = arr[i];
        }
        return min;

    }
    
    //changes the digit at position pos of string str.
    public static String changeString(String str,int pos)
    {
        char ch = str.charAt(pos);
        if(ch == nine)
        {
            return str.substring(0,pos) + String.valueOf(zero) + str.substring(pos + 1,str.length());
        }
        else
        {
            char next = (char)((int)ch + 1);
            //str.setCharAt(pos,next);
            return str.substring(0,pos) + String.valueOf(next) + str.substring(pos + 1,str.length());
        }
    }

    public static int changeString(int num,int pos)
    {
        int temp = num;
        for(int i = size - 1 ; i >= 0 ; i--)
        {
            buffer[i] = temp % 10;
            temp = temp - buffer[i];
            temp = temp / 10;
        }

        if(buffer[pos] == 9)
        {
            buffer[pos] = 0;
        }
        else
        {
            buffer[pos] = buffer[pos] + 1;
        }

        temp = 0;
        for(int i = 0 ; i < size ; i++)
        {
            temp = temp * 10 + buffer[i];
        }
        return temp;

    }

}
