import java.util.*;
public class Solution
{
    public List<String> generateParenthesis(int n)
    {
        if(n == 0)
            return new ArrayList<String>();
        else
        {
            ArrayList<String> toReturn = new ArrayList<>();
            char[] arr = new char[2 * n];
            func(n,n,0,arr,toReturn);
            return toReturn;
        }
    }

    public void func(int openBrackets,int closeBrackets,int pos,char[] arr,ArrayList<String> toReturn)
    {
        if(openBrackets == 0)
        {
            while(closeBrackets > 0)
            {
                arr[pos] = ')';
                pos++;
                closeBrackets--;
            }
            toReturn.add(new String(arr));
            return;
        }
        else if(openBrackets == closeBrackets) //this is important condition to make note of
        {
            arr[pos] = '(';
            func(openBrackets - 1,closeBrackets,pos + 1,arr,toReturn);
        }
        else
        {
            arr[pos] = '(';
            func(openBrackets - 1,closeBrackets,pos + 1,arr,toReturn);
            arr[pos] = ')';
            func(openBrackets,closeBrackets - 1,pos + 1,arr,toReturn);
        }
    }
}
