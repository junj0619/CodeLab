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
    
    
    //2) no sort insert interval base on overlap logic
    
     public List<Interval> insert(List<Interval> intervals, Interval newInterval) {     
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }            
        
        //Step 3: merg intervals
        int nStart = newInterval.start;
        int nEnd = newInterval.end;
        int start = 0;
        int end = 0;  
        
        int len = intervals.size() + 1; //worst case interval has no place to merg
        
        int i = 0;
        
        while (i < len - 1) {            
            int iStart = intervals.get(i).start;
            int iEnd = intervals.get(i).end;
                       
            if (nStart > iEnd)  { //No overlap newInterval larger than intervals
                res.add(intervals.get(i));       
                start = nStart;
                end = nEnd;
                i++;               
            } 
            else if (nEnd < iStart) { //No overlap newInterval smaller than intervals
                res.add(new Interval(nStart, nEnd));
                start = iStart;
                end = iEnd;
                i++;  
                break;
            }
            else if (nStart >= iStart || iEnd >= nStart) {  // Overlap                           
                start = Math.min(iStart, nStart);                               
                end = Math.max(iEnd, nEnd);               
                break;
            }            
        }
        
        
        while (i < len - 1) {    //Deal remaining intervals        
            int iStart = intervals.get(i).start;
            int iEnd = intervals.get(i).end;
            
            if (iStart > end) {
                res.add(new Interval(start, end));
                start = iStart;
                end = iEnd;
            } else 
                end = Math.max(end, iEnd);
            i++;
        }
        
        res.add(new Interval(start, end));
        
        return res;                                            
    }
}
