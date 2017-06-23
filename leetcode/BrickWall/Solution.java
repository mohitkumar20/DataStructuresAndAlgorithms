import java.util.*;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int numOfRows = wall.size();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        int maxCount = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> row = null;
        for(int i = 0 ; i < numOfRows ; i++)
        {
            row = wall.get(i);
            edges.add(new ArrayList<Integer>());
            int countOfEdges = 0;
            int n = row.size();
            for(int j = 0 ; j < n - 1 ; j++)
            {
                countOfEdges += row.get(j);
                edges.get(i).add(countOfEdges);
            }
        }
        
        for(int i = 0 ; i < numOfRows ; i++)
        {
            row = edges.get(i);
            int n = row.size();
            for(int j = 0 ; j < n ; j++)
            {
                map.put(row.get(j),0);
            }
        }
        
        for(int i = 0 ; i < numOfRows ; i++)
        {
            row = edges.get(i);
            int n = row.size();
            for(int j = 0 ; j < n ; j++)
            {
                int count = map.get(row.get(j)) + 1;
                map.put(row.get(j),count);
                if(count > maxCount)
                    maxCount = count;
            }
        }
        
        return numOfRows - maxCount;
        
       
    }
}