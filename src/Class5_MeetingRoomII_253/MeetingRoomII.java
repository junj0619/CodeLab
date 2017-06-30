/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
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
            }else {
                cur--;
            }
        }
        
        return max;
    }
}
