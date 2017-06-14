import java.util.*;


 //* Definition for an interval.
//comment out the definition of interval when running the code on interviewBit.
  class Interval {
      int start;
    int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 


public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        if(intervals == null)
        {
            ArrayList<Interval> toReturn = new ArrayList<Interval>();
            toReturn.add(newInterval);
            return toReturn;
        }
        else
        {
            int n = intervals.size();
           ArrayList<Interval> toReturn = new ArrayList<Interval>(n);
           int i,start,end;
           i = 0;
           while(i < n && newInterval.start > intervals.get(i).start && newInterval.start > intervals.get(i).end)
           {
               toReturn.add(intervals.get(i));
               i++;
           }
           if(i == n)
           {
               toReturn.add(new Interval(newInterval.start,newInterval.end));
               return toReturn;
           }
           else if(newInterval.start >= intervals.get(i).start && newInterval.end <= intervals.get(i).end)
           {
               return intervals;
           }
           if(newInterval.start < intervals.get(i).start)
           {
               start = newInterval.start;
               if(newInterval.end < intervals.get(i).end)
               {
                   end = newInterval.end;
               }
               else
                end = newInterval.end >= intervals.get(i).end ? newInterval.end : intervals.get(i).end;
           }
           else
           {
               start = newInterval.start <= intervals.get(i).start ? newInterval.start : intervals.get(i).start;
               end = newInterval.end >= intervals.get(i).end ? newInterval.end : intervals.get(i).end;
           }

               
               while(i < n && intervals.get(i).start <= end)
               {
                   end = end >= intervals.get(i).end ? end : intervals.get(i).end;
                   i++;
               }
               toReturn.add(new Interval(start,end));
               while(i < n)
               {
                   toReturn.add(intervals.get(i));
                   i++;
               }
               return toReturn;
           }

    }
}
