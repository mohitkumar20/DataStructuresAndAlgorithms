//Google foobar.


import java.math.BigInteger;
import java.io.*;
import java.util.*;

public class fuelInjectionPerfection
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(answer(br.readLine()));
		//BigInteger num = new BigInteger("10000000000");
		//System.out.println(num.longValue());

	}

	 // public static int minCount = Integer.MAX_VALUE;
   // public static BigInteger two = new BigInteger("2");
    
    public static int answer(String n) { 

        /*
        // Your code goes here.
        //First trying the recursive solution which is most likely to fail.
        fun(new BigInteger(n),0);
        return minCount;
        */
        
        //another approach which is also most likely to fail.
        /*
        HashMap<BigInteger,Integer> map = new HashMap<BigInteger,Integer>();
		BigInteger i = new BigInteger("1");
		map.put(i,0);
		i = i.add(BigInteger.ONE);
		BigInteger ten = new BigInteger("10");
		BigInteger two = new BigInteger("2");
		BigInteger num = new BigInteger(n);
		while(i.compareTo(num) != 1)
		{
			if(i.getLowestSetBit() != 0)
			{
				map.put(i,1 + map.get(i.divide(two)));
			}
			else
			{
				//System.out.println("i = " + i);
				int first = 1 + map.get(i.subtract(BigInteger.ONE));
				int second = 2 + map.get(i.add(BigInteger.ONE).divide(two));
				if(first <= second)
				{
					map.put(i,first);
				}
				else
				{
					map.put(i,second);
				}
			}
			i = i.add(BigInteger.ONE);
		}
		return map.get(num);
		*/
		//Third attempt;
			BigInteger num = new BigInteger(n);
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		int count = 0;
		while(num.compareTo(BigInteger.ONE) != 0)
		{
			//System.out.println(num);
			if(num.compareTo(three) == 0)
			{
				count += 2;
				break;
			}
			if(num.getLowestSetBit() != 0)
			{
				num = num.divide(two);
				count++;
			}
			else
			{
				BigInteger greater = num.add(BigInteger.ONE);
				BigInteger smaller = num.subtract(BigInteger.ONE);
				int trailingZeroesInGreater = greater.getLowestSetBit();
				int trailingZeroesInSmaller = smaller.getLowestSetBit();
				if(trailingZeroesInSmaller >= trailingZeroesInGreater)
				{
					num = smaller;
				}
				else
				{
					num = greater;
				}
				count++;
			}
		}
		//System.out.println("outside : " + num);
		return	count;
    } 
    
    //first trying the recursive solution which is most likely to fail.
    /*
    public static void fun(BigInteger num,int count)
    {
        if(num.equals(BigInteger.ONE))
        {
            if(count < minCount)
            {
                minCount = count;
            }
            return;
        }
        //else if(num.mod(two).equals(BigInteger.ZERO))
        else if(num.and(num.subtract(BigInteger.ONE)) == BigInteger.ZERO)
        {
            //fun(num.divide(two),count + 1);
            count = count + num.getLowestSetBit();
            if(count < minCount)
                minCount = count;
            return;
        }
        else if(num.mod(two).equals(BigInteger.ZERO))
        {
            fun(num.divide(two),count + 1);
        }                                                                                                                                           
        else
        {
            fun(num.add(BigInteger.ONE),count + 1);
            fun(num.subtract(BigInteger.ONE),count + 1);
        }
    }
    */
}