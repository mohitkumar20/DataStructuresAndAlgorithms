//from codeforces. was not getting submitted, because of space complexity was
//not satisfied.for larger inputs, space was a problem. but the time complexity was okay.

import java.io.*;

public class MisterBAndBoringGame
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int l = Integer.parseInt(arr[2]);
		int r = Integer.parseInt(arr[3]);
		func(a,b,l,r);
	}

	public static void func(int a,int b,int l,int r)
	{
		char[] arr = new char[r];
		char x = 97;
		for(int i = 0 ; i < a ; i++)
		{
			arr[i] = x;
			x++;
		}
		int count = 0;
		int[] check = new int[26];
		if(l <= a)
		{
			for(int i = l - 1 ; i < a ; i++)
			{
				check[arr[i] - 97] = 1;
				count++;
			}
		}
		int i = a - 1;
		int k = a;
		while(k < r)
		{
			int j = 0;
			//int k = i + 1;
			i = k - 1;

			while(k < r && j < b)
			{
				//System.out.println("this loop");
				arr[k] = arr[i];
				if((k >= l - 1) && k < r && check[arr[k] - 97] == 0)
					{
						check[arr[k] - 97] = 1;
						count++;

						//System.out.println("from first, x = " + x);
					}
				k++;
				j++;
			}
			int m = k - a;
			int localCount = 0;
			x = 97;
			//System.out.println("before");
			while(k < r && localCount < a)
			{

				//System.out.println("this loosdfsfp");
				if(arr[m] != x)
				{
					arr[k] = x;
					//System.out.println("x = " + x);
					if((k >= l - 1) && k < r && check[x - 97] == 0)
					{
						check[x - 97] = 1;
						count++;
						//System.out.println("from firstsdfdsf , x = " + x);
					}
					x++;
					k++;
					//m++;
					localCount++;
				}
				else
				{
					x++;
					m++;
				}
			}
			//i = k - 1;
		}
		// for(int z = 0 ; z < k ; z++)
		// {
		// 	System.out.print(arr[z] + " ");
		// }
		System.out.println(count);
	}
}