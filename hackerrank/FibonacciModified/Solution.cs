using System;
using System.Collections.Generic;
using System.IO;
using System.Numerics;
class Solution {
    static void Main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        String str = Console.ReadLine();
            Char delimiter = ' ';
            String[] tokens = str.Split(delimiter);
            int[] arr = new int[3];
            int i = 0;
            for (i = 0; i < 3; i++)
            {
                arr[i] = int.Parse(tokens[i]);
               // Console.WriteLine(arr[i]);
            }
            int first = arr[0], second = arr[1], n = arr[2];
            i = 2;
            BigInteger[] biggy = new BigInteger[n];
            for(i = 0; i < n; i++)
            {
                biggy[i] = new BigInteger(0);
            }
            i = 2;
            biggy[0] = first;
            biggy[1] = second;
            while(i < n)
            {
                biggy[i] = biggy[i - 1] * biggy[i - 1] + biggy[i - 2];
                i++;
            }
            Console.WriteLine(biggy[n - 1]);
    }
}