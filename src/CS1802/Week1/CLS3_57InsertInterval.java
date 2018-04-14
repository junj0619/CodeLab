/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
 
 /**
 *
 *   [ ] | [       ] | [ ]
 *    1        2        3 
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0, len = intervals.size();
        //Create part1
        while (i < len && intervals.get(i).end < newInterval.start)
            res.add(intervals.get(i++));
        //Create part2
        int start = newInterval.start, end = newInterval.end;
        while (i < len && intervals.get(i).start <= end) {  // corner case right boundary is same as new Interval.end 
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }
        res.add(new Interval(start, end));
        
        //Create part3
        while (i < len && intervals.get(i).start > end) 
            res.add(intervals.get(i++));
        
        return res;
    }
}
