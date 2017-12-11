import java.io.*;
import java.util.*;

public class Main
{

    public static String end = "LAST CASE";
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = null;
        while(true)
        {
            int counter = Integer.parseInt(br.readLine());
            if(counter == 0)
                return;

            HashSet<String> set = new HashSet<String>();
            for(int i = 0 ; i < counter ; i++)
            {
                set.add(br.readLine());
            }
            
            while(true)
            {
                String str = br.readLine();
                if(str.equals(end))
                    break;
                strArr = str.split(" ");
                String abbr = strArr[0];
                ArrayList<String> list = new ArrayList<>();
                for(int i = 1 ; i < strArr.length ; i++)
                {
                    if(set.contains(strArr[i]) == false)
                        list.add(strArr[i]);
                }
                int m = abbr.length();
                int n = list.size();
                int[][][] dp = new int[m][n][150];
                
                for(int i = 0 ; i < m ; i++)
                    for(int j = 0 ; j < n ; j++)
                        for(int z = 0 ; z < 150 ; z++)
                            dp[i][j][z] = -1;
                int ans = func(0,0,0,abbr.toLowerCase(),list,dp,m,n);
                if(ans == 0)
                {
                    System.out.println(abbr + " is not a valid abbreviation");
                }
                else
                {
                    System.out.println(abbr + " can be formed in " + ans + " ways");
                }
            }

        }
    }

    public static int func(int i,int j,int startIndex,String abbr,ArrayList<String> list,int[][][] dp,int m,int n)
    {
        if(i >= m && j >= n)
        {
            return 1;
        }
        else if(i >= m)
        {
            return 0;
        }
        else if(j >= n)
        {
            return 0;
        }
        if(dp[i][j][startIndex] != -1)
        {
            return dp[i][j][startIndex];
        }
        int ans = 0;
        String word = list.get(j);
        int length = word.length(); 
        for(int index = startIndex; index < length;index++)
        {
            if(abbr.charAt(i) == word.charAt(index))
            {
                ans = ans + func(i + 1,j + 1,0,abbr,list,dp,m,n) + func(i + 1,j,index + 1,abbr,list,dp,m,n);
            }
        }
        return dp[i][j][startIndex] = ans;
    }
}
