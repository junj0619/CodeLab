/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
// 1) Brute force need to do without sort
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {     
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        //Step 1: add newInterval to the intervals
        intervals.add(newInterval);
        
        //Step 2: sort intervals by start point
        intervals.sort((x, y) -> x.start - y.start);
        
        //Step 3: merg intervals
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        int len = intervals.size();
      
        
        for(Interval interval : intervals) {            
            if (end >= interval.start)
                end = Math.max(end, interval.end);
            else {                  
                res.add(new Interval(start, end));            
                start = interval.start;
                end = interval.end;
            }
        }
        
        res.add(new Interval(start, end));
        
        return res;                                            
    }
}
