import java.util.Scanner;

public class GFG
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++)
            {
                arr[i] = sc.nextInt();
            }
            func(n,k,arr);
            t--;
        }
    }

    public static void func(int n,int k,int[] arr)
    {
        int maxValue = arr[0];
        int maxCount = 1; 
        int i = 0;
        
        while(i < n)
        {
            if(arr[i] < 0)
                i++;
            else
            {
                if(arr[arr[i]] < 0)
                {
                    //System.out.println("changing value for : " + arr[i]);
                    arr[arr[i]] = arr[arr[i]] - 1;
                    //System.out.println("changed for : " + arr[i] + "with value : " + arr[arr[i]] + ",i = " + i);
                    if(Math.abs(arr[arr[i]]) > maxCount)
                    {
                        maxCount = Math.abs(arr[arr[i]]);
                        maxValue = arr[i];
                        //System.out.println("called for : " + arr[i] + ",maxCount : " + maxCount);
                    }
                    else if(Math.abs(arr[arr[i]]) == maxCount && arr[i] < maxValue)
                    {
                        maxValue = arr[i];
                        //System.out.println("called for : " + arr[i]);
                    }
                    //System.out.println("maxValue = " + maxValue + ", maxCount " + maxCount);
                    i++;
                    
                }
                else
                {
                    if(arr[i] < i)
                    {
                        arr[arr[i]] = -1;
                        if(maxCount == 1 && arr[i] < maxValue)
                            maxValue = arr[i];
                        i++;
                    }
                    else
                    {
                        int temp = arr[i];
                        arr[i] = arr[arr[i]];
                        arr[temp] = -1;
                        if(maxCount == 1 && temp < maxValue)
                            maxValue = temp;

                    }
                }
            }
        }
        System.out.println(maxValue);
    }
    
}
