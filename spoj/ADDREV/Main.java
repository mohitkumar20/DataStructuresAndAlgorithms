import java.io.*;

public class Main
{
    public static char zero = '0';
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n > 0)
        {
            String[] strArr = br.readLine().split(" ");
            func(strArr[0].toCharArray(),strArr[1].toCharArray());
            n--;
        }

    }

    public static void func(char[] first,char[] second)
    {
        /*int m =  first.length;
        int n = second.length;*/
        int firstNum = num(first);
        int secondNum = num(second);
        int newNum = firstNum + secondNum;
        char[] toReturn = String.valueOf(newNum).toCharArray();
        int i = 0;
        int j = toReturn.length - 1;
        while(i < j)
        {
            swap(toReturn,i,j);
            i++;
            j--;
        }
        i = 0 ;
        while(i < toReturn.length && toReturn[i] == zero)
        {
            i++;
        }
        for(int index = i ; index < toReturn.length ; index++)
        {
            System.out.print(toReturn[index]);
        }
        System.out.println();
             
    }
    public static int num(char[] first)
    {
        int i = 0;
        int m = first.length;
        int firstNum = 0;
        while(i < m && first[i] == zero)
        {
            i++;
        }
        if(i == m)
        {
            return firstNum = 0;
        }
        else
        {
            int start = i;
            int j = m - 1;
            while(i < j)
            {
                swap(first,i,j);
                i++;
                j--;
            }
            firstNum = 0;
            i = start;
            while(i < m)
            {
                firstNum = firstNum * 10 + Character.getNumericValue(first[i]);
                i++;
            }
            return firstNum;
        }
    }

    public static void swap(char[] arr,int i,int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
