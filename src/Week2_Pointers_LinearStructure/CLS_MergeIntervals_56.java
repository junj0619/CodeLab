/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

//Code can be simplify
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return intervals;
        
        List<Interval> res = new ArrayList<>();
        
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
            
        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            
            Interval cur = new Interval(start, end);
            
            if (res.size() == 0)
                res.add(cur);
            else {
                int len = res.size();
                int last = len - 1;
                int resEnd = res.get(last).end;
                
                if (resEnd >= interval.start && resEnd < interval.end)                    
                    res.set(last, new Interval(res.get(last).start, interval.end));
                else if (resEnd < interval.start)
                    res.add(interval);                
            }                                                
        }
        return res;        
    }
}
