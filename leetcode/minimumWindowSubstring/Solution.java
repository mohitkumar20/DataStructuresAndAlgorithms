import java.util.*;
public class Solution
{
    public static int minWindowSize = Integer.MAX_VALUE;
    public static int leftEnd = -1;
    public static int rightEnd = -1;
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

            for(int i = 0 ; i < arr.length ; i++)
            {
                if(pattern.contains(arr[i]))
                {
                    return S.substring(i,i + 1);
                }
            }

        }

        else
        {
            func(0,arr.length - 1,k,arr,pattern);
            //System.out.println("returned");
        }

        //System.out.println("left = " + leftEnd + ", right = " + rightEnd );
        if(leftEnd != -1 && rightEnd != -1)
            return S.substring(leftEnd,rightEnd + 1);
        else
            return "";

    }

    public static void func(int left,int right,int k,char[] arr,HashSet<Character> pattern)
    {
        if(right - left + 1 < k)
        {
            return;
        }

        else
        {
            //System.out.println("left = " + left + "..right = " + right);
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
                System.out.println("i = " + i + ", j = " + j);
                if(pattern.contains(arr[i]) && local.contains(arr[i]) == false)
                {
                    leftMost = i;
                    count++;
                    local.add(arr[i]);
                    System.out.println("count = " + count);
                    if(count == k &&  rightMost - leftMost + 1 < minWindowSize)
                    {
                        leftEnd = leftMost;
                        if(rightMost != -1)
                        {
                            rightEnd = rightMost;
                        }
                        else
                        {
                            rightMost = i;
                            rightEnd = i;
                        }
                        //System.out.println("changed , leftmost = " + leftMost + ", rightMost = " + rightMost);
                        minWindowSize = rightMost - leftMost + 1;
                    }
                }

                if(pattern.contains(arr[j]) && local.contains(arr[j]) == false)
                {
                    rightMost = j;
                    count++;
                    local.add(arr[j]);
                    System.out.println("count = " + count);
                    if(count == k  && rightMost - leftMost + 1 < minWindowSize)
                    {
                        System.out.println("here");
                        if(leftMost != -1)
                            leftEnd = leftMost;
                        else
                        {
                            leftMost = j;
                            leftEnd = j;
                        }
                        rightEnd = rightMost;
                        //System.out.println("changed , leftmost = " + leftMost + ", rightMost = " + rightMost);
                        minWindowSize = rightMost - leftMost + 1;
                    }
                }

                i--;
                j++;
            }

            while(i >= left)
            {
                System.out.println("i = " + i);
                if(pattern.contains(arr[i]) && local.contains(arr[i]) == false)
                {
                    leftMost = i;
                    count++;
                    local.add(arr[i]);
                    if(count == k && rightMost - leftMost + 1 < minWindowSize)
                    {
                        leftEnd = leftMost;
                        if(rightMost != -1)
                        {
                            rightEnd = rightMost;
                        }
                        else
                        {
                            rightMost = i;
                            rightEnd = i;
                        }
                        //System.out.println("changed , leftmost = " + leftMost + ", rightMost = " + rightMost);
                        minWindowSize = rightMost - leftMost + 1;
                    }
                } 
                i--;
            }

            while(j <= right)
            {
                System.out.println(", j = " + j);
                if(pattern.contains(arr[j]) && local.contains(arr[j]) == false)
                {
                    rightMost = j;
                    count++;
                    local.add(arr[j]);
                    if(count == k && rightMost != -1 && leftMost != -1 && rightMost - leftMost + 1 < minWindowSize)
                    {
                        if(leftMost != -1)
                            leftEnd = leftMost;
                        else
                        {
                            leftMost = j;
                            leftEnd = j;
                        }
                        rightEnd = rightMost;
                        //System.out.println("changed , leftmost = " + leftMost + ", rightMost = " + rightMost);
                        minWindowSize = rightMost - leftMost + 1;
                    }
                }
                j++;
            }


        }
        return ;
    }


    public static void main(String[] args)
    {
        Solution x = new Solution();
        System.out.println(x.minWindow("aa","aa"));
    }

}
