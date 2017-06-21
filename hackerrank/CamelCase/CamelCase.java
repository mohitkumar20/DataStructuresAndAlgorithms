import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class CamelCase
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        func(s);
    }

  public static void func(String str)
  {
    int count = 1,length = str.length();
    for(int i = 0 ; i < length ; i++)
    {
      char curr = str.charAt(i);
      boolean isLower = Character.isLowerCase(curr);
      if(isLower == false)
      {
        count++;
      }
    }
    System.out.println(count);
  }
}