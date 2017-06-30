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
* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
* find the minimum number of conference rooms required.
*
* For example,
* Given [[0, 30],[5, 10],[15, 20]],
* return 2.
*
*
* Logic : 
*        1) Flat the Intervals, dump all elements into new list with [isStart] identifier
*        2) Sort the new list by timeStamp ASC, Corner Case : [1,5,5,7] then sort by [isStart] put 5.end in font of 5.start
*        3) Loop new list if current element isStart then + 1, else  - 1. Record the max value during scan
*        4) Return max as MinMeetingRoom
*
*        [0, 5, 10, 15, 20, 30]
*         S  S  E   S   E    E
*        +1 +1 -1  +1  -1   -1
*         1  2  1   2   1    0  ==> Max = 2
**/
public class MeetingRoom {
    
    class Point {
        int timeStamp;
        int isStart;
        
        Point(int timeStamp, int isStart) {
            this.timeStamp = timeStamp;
            this.isStart = isStart;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
    
        int max = 0;
        int cur = 0;
        
        List<Point> list = new ArrayList<>();
        
        for(Interval interval : intervals) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, 0));
        }
        
       	//[[1,5],[5,6]]  only need 1 meeting room. So we should put 5.end in font of 5.start. 
        // Process will be like this: [1,0,1,0] then MinMeetingRoom = max element in the list so return 1;
        list.sort((a, b) -> (a.timeStamp == b.timeStamp ? a.isStart - b.isStart : a.timeStamp - b.timeStamp));
        
        for(Point li : list) {
            if(li.isStart == 1) {
                max = Math.max(++cur, max);
            } else {
                cur--;
            }
        }
        
        return max;
    }
}
