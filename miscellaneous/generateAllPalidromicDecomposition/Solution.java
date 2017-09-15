import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.next();
        int n = str.length();
       generate(str,n);
    }

    public static void generate(String str,int n)
    {
        String[] aux = new String[n];
        func(0,str,aux,n,0);
    }

    public static void func(int start,String str,String[] aux,int n,int pos)
    {
        /*pos is the index in aux array, where the next 
        palindromic substring will be stored    */

        if(start >= n)
        {
            for(int i = 0 ; i < pos ; i++)
            {
                System.out.print(aux[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i < n ; i++)
        {
           if(check(str,start,i) == true) 
           {
               aux[pos] = str.substring(start,i + 1);
               func(i + 1,str,aux,n,pos + 1);
           }
        }
        return;

    }
    
    public static boolean check(String str, int left,int right)
    {
        while(left < right )    
        {
           if(str.charAt(left) != str.charAt(right)) 
               return false;
           left++;
           right--;
        }
        return true;
    }
}
