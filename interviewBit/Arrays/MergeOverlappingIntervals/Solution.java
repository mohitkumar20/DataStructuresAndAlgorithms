
import java.util.*;

  //Definition for an interval.
//comment out the definition of interval when running the code on interviewBit.
 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
   Interval(int s, int e) { start = s; end = e; }
  }
 
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        int n = intervals.size();
        if( n < 2)
            return intervals;
            
        Collections.sort(intervals,new Comparator<Interval>(){
            
            public int compare(Interval first,Interval second)
            {
                return Integer.valueOf(first.start).compareTo(Integer.valueOf(second.start));
            }
        });
        
        int i,j,newEnd,start,end;
        ArrayList<Interval> toReturn = new ArrayList<Interval>();
        i = 0;
        while(i < n)
        {
            start = intervals.get(i).start;
            end = intervals.get(i).end;
            j = i + 1;
            while(j < n && intervals.get(j).start <= end)
            {
                newEnd = intervals.get(j).end;
                end = newEnd > end ? newEnd : end;
                j++;
            }
            toReturn.add(new Interval(start,end));
            i = j;
        }
        return toReturn;
    }
}
