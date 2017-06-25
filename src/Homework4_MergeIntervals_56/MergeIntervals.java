/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        //Step 1: Sort Intervals by start
        //Step 2: Compare current Intervals end with next Intervals start
        //   2.1: If curr.end >= next.start => can merg => updated the end to next.end
        //   2.2: Else insert current Intervals into the result list
        //Step 3: Insert last intervals into the result
        
        if(intervals.size() <= 1) return intervals;
        
        List<Interval> res = new ArrayList<>();
        
        //Step 1:
        intervals.sort((a, b) ->  (a.start - b.start));
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        //Step 2:
        for(Interval interval : intervals) {
            if(end >= interval.start) {
                end = Math.max(interval.end, end); //<== [[1,4],[2,3]]
            }else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        //Step 3:
        res.add(new Interval(start, end));
        
        return res;
    }
}
