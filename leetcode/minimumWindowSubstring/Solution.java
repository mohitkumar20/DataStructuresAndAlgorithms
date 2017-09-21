import java.util.*;
public class Solution
{
    public static int minWindowSize = Integer.MAX_VALUE;
    public static int left = -1;
    public static int right = -1;
    public String minWindow(String S,String T)
    {
        if(S == null || S.length() == 0)
        {
            return "";
        }
        
        int k = T.length();
        char[] arr = S.toCharArray();
        HashSet<Character> pattern = new HashSet<>();
        for(int i = 0 ; i < T.length() ; i++)
        {
            pattern.add(T.charAt(i));
        }
        if(k == 1)
        {

        }

        return S.substring(left,right + 1);

    }

    public static void func(int left,int right,int k,char[] arr,HashSet<Character> pattern)
    {
        if(left - right + 1 < k)
        {
            return;
        }

        else
        {
            int mid = (left + right) / 2;
            func(left,mid,k,arr,pattern);
            func(mid + 1,right,k,arr,pattern);

            int i = mid, j = mid + 1;
            int leftMost = -1;
            int rightMost = -1;
            int count = 0;
            HashSet<Character> local = new HashSet<>();
            while(i >= left && j <= right)
            {
                if(pattern.contains(arr[i]) && local.contains(arr[i]) == false)
                {
                    leftMost = i;
                    count++;
                    local.add(arr[i]);
                    if(count == k && rightMost - leftMost + 1 < minWindowSize)
                    {
                        left = leftMost;
                        right = rightMost;
                    }
                }

                else if(pattern.contains(arr[j]) && local.contains(arr[j]) == false)
                {
                    rightMost = j;
                    count++;
                    local.add(arr[j]);
                    if(count == k && rightMost - leftMost + 1 < minWindowSize)
                    {
                        left = leftMost;
                        right = rightMost;
                    }
                }

                i--;
                j++;
            }

            while(i >= left)
            {
                if(pattern.contains(arr[i]) && local.contains(arr[i]) == false)
                {
                    leftMost = i;
                    count++;
                    local.add(arr[i]);
                    if(count == k && rightMost - leftMost + 1 < minWindowSize)
                    {
                        left = leftMost;
                        right = rightMost;
                    }
                } 
                i--;
            }

            while(j <= right)
            {
                if(pattern.contains(arr[j]) && local.contains(arr[j]) == false)
                {
                    rightMost = j;
                    count++;
                    local.add(arr[j]);
                    if(count == k && rightMost - leftMost + 1 < minWindowSize)
                    {
                        left = leftMost;
                        right = rightMost;
                    }
                }
                j++;
            }


        }
        return ;
    }

}
