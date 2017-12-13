import java.io.*;

public class Main
{
    public static char zero = '0';
    public static char nine = '9';
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            String num_str = br.readLine();
            func(num_str);
            t--;
        }
    }

    public static void func(String num_str)
    {
        if(num_str.length() == 0)
        {
            System.out.println(1);
            return;
        }
        int index = 0;
        for(; index < num_str.length(); index++)
        {
            if(num_str.charAt(index) != zero)
            {
                break;
            }
        }
        if(index == num_str.length())
        {
            System.out.println(1);
            return;
        }
        num_str = num_str.substring(index,num_str.length());
        char[] arr = num_str.toCharArray();
        int n = arr.length;
        if(n == 1)
        {
            if(arr[0] == nine)
            {
                System.out.println(11);
                //System.out.print(11 + " ");
                return;
            }
            else
            {
                arr[0]++;
                System.out.println(arr[0]);
                return;
            }
        }
        boolean hasChanged = false;
        int i,j;
        i = (0 + n - 1) / 2;
        if(n % 2 == 0)
        {
            j = i + 1;
        }
        else
        {
            j = i;
        }
        while(i >= 0 && j < n)
        {
            if(arr[i] == arr[j] && hasChanged)            
            {
                i--;
                j++;
            }
            else if(arr[i] == arr[j] && !hasChanged)
            {
                int x = i - 1;
                int y = j + 1;
                if(arr[i] != nine)
                {
                    while(x >= 0 && y < n && arr[x] == arr[y])
                    {
                        x--;
                        y++;
                    }
                    if(x < 0)
                    {
                        arr[i]++;
                        arr[j] = arr[i];
                        String newString = new String(arr);
                        System.out.println(newString);
                        //System.out.print(newString + " ");
                        return;
                    }
                    else
                    {
                        if(arr[x] > arr[y])
                        {
                            arr[y] = arr[x];
                        }
                        else
                        {
                            arr[i]++;
                            arr[j] = arr[i];
                            arr[y] = arr[x];
                        }
                        i = x - 1;
                        j = y + 1;
                        hasChanged = true;
                    }
                }
                else if(arr[i] == nine)
                {
                    while(x >= 0 && y < n && arr[x] == arr[y] && arr[x] == nine)
                    {
                        x--;
                        y++;
                    }
                    if(x < 0)
                    {
                        for(int ii = 0 ; ii < n - 1 ; ii++)
                        {
                            arr[ii] = zero;
                        }
                        arr[n - 1] = '1';
                        //String newString = "1" + new String(arr);
                        String newString = "1";
                        //System.out.println("here");
                        String str = new String(arr);
                        //System.out.println("arr = " + str);
                        newString += str;
                        System.out.println(newString);
                        //System.out.print(newString + " ");
                        return;
                    }
                    else
                    {
                        if(arr[x] <= arr[y])
                        {
                            while(i!= x && j != y)
                            {
                                arr[i] = zero;
                                arr[j] = zero;
                                i--;
                                j++;
                            }
                            arr[i]++;
                            arr[j] = arr[i];
                        }
                        else
                        {
                            arr[y] = arr[x];
                        }
                        i = x - 1;
                        j = y + 1;
                    }
                }
                        hasChanged = true;
            }
            else if(arr[i] != arr[j] && !hasChanged)
            {
                if(arr[i] > arr[j])
                {
                    arr[j] = arr[i];
                }
                else
                {
                    arr[i]++;
                    arr[j] = arr[i];
                }
                i--;
                j++;
                hasChanged = true;
            }
            else if(arr[i] != arr[j] && hasChanged)
            {
                arr[j] = arr[i];
                i--;
                j++;
            }
        }
        String newString = new String(arr);
        System.out.println(newString);
        //System.out.print(newString + " ");
    }
}
