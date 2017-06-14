import java.util.*;

class Interval
{
    Integer start;
    Integer end;
    public Interval(int start,int end)
    {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public boolean hotel(ArrayList<Integer> arrival, ArrayList<Integer> depart, int k) {
        
        /*
        this was one appproach. complexity : nlogn + nk.
        this was a good example when u want to sort one array and that
        array has a corresponding match array.
        In this type of case, make a new structure and sort then on the basis of
        one array. here i made the interval class for that.
        int n = arrive.size();
        if(n == 1)
            return true;
        ArrayList<Interval> list = new ArrayList<Interval>(n);
        for(int i = 0 ; i < n ; i++)
        {
            list.add(new Interval(arrive.get(i),depart.get(i)));
        }
        
        Collections.sort(list,new Comparator<Interval>(){
            
            public int compare(Interval first,Interval second)
            {
                return first.start.compareTo(second.start);
            }
            });
        int[] rooms = new int[k];
        
        for(int i = 0 ; i < n ; i++)
        {
            if(list.get(i).start != list.get(i).end)
            {
                int j = 0;
                while(j < k && rooms[j] != 0 && rooms[j] >= list.get(i).start)
                {
                    j++;
                }
                if(j == k)
                    return false;
                else if(rooms[j] == 0)
                {
                    rooms[j] = list.get(i).end - 1;
                }
                else
                {
                    rooms[j] = list.get(i).end - 1;
                }
            }
        }
        return true;
        */
        
        int n = arrival.size();
        if(n < 2)
            return true;
            
        int countOfElementsToBeRemoved = 0;
        int n2 = depart.size();
      //  System.out.println("size : " + n + ",size2 = " + n2);
        for(int i = 0 ; i < n ; i++)
        {
           // System.out.println("i = " + i);
            if(arrival.get(i) == depart.get(i))
            {
                countOfElementsToBeRemoved++;
                arrival.remove(i);
                depart.remove(i);
                n--;
            }
        }
       // System.out.println("here1");
        //n = n - countOfElementsToBeRemoved;
        Collections.sort(arrival,new Comparator<Integer>(){
            
            public int compare(Integer first,Integer second)
            {
                return first.compareTo(second);
            }
            });
            
        Collections.sort(depart,new Comparator<Integer>(){
           public int compare(Integer first,Integer second)
           {
               return first.compareTo(second);
           }
        });
        
        int i,j;
        i = j = 0;
        int rooms = 0;
        while(i < n && j < n)
        {
            while(i < n && arrival.get(i) < depart.get(j))
            {
                i++;
                rooms++;
                if(rooms > k)
                    return false;
            }
            if(i == n)
            {
                return true;
            }
            while(j < n && depart.get(j) <= arrival.get(i))
            {
                rooms--;
                j++;
            }
        }
        return true;
    }
}
