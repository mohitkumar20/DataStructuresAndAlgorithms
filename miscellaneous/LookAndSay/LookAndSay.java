//found the question on geeksForGeeks and Strings chapter of the book ElementsOfProgrammingInterviews.

import java.util.*;
import java.io.*;

public class LookAndSay
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String ans = func(2,n,"1");
		System.out.println(ans);
	}

	public static String func(int i, int n , String prev)
	{
		int j = 0;
		int length = prev.length();
		String ans = "";
		//System.out.println("prev = " + prev);
		while(j < length)
		{
			int count = 1;
			while(j + 1 < length && prev.charAt(j) == prev.charAt(j + 1))
			{
				j++;
				count++;
			}
			ans += Integer.toString(count) + helper(prev.charAt(j));

			//System.out.println("i = " + i + ", ans = " + ans);
			j++;
		}
		if(i == n)
			return ans;
		else
			return func(i + 1,n,ans);
	}

	public static String helper(char ch)
	{
		if(ch == '0')
			return "0";
		else if(ch == '1')
			return "1";
		else if(ch == '2')
			return "2";
		else if(ch == '3')
			return "3";
		else if(ch == '4')
			return "4";
		else if(ch == '5')
			return "5";
		else if(ch == '6')
			return "6";
		else if(ch == '7')
			return "7";
		else if(ch == '8')
			return "8";
		else
			return "9";
	}
}