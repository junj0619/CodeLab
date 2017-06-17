package Class2_MergeIntervals_56;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by junjin on 6/12/17.
 * <p>
 * <p>
 * <p>
 * Input :[]
 * Output:[]
 * <p>
 * Input :[(1,3),(2,4),(5,9),(9,20)]
 * Output:[(1,4),(5,20)]
 * <p>
 * Input :[(1,2),(1,5),(5,10)]
 * Output:[(1,10)]
 * <p>
 * Input :[(1,2),(3,4),(5,6)]
 * Output:[(1,2),(3,4),(5,6)]
 * <p>
 * Input :[(5,7),(9,9),(1,5)]
 * Output:[(1,7),(9,9)]
 * <p>
 * Time Complexity : O(nlogn) (Sorting Interval) + o(n) (Iterate Intervals) => O(nlogn)
 * Space Complexity: O(n) return list
 */
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> list = new LinkedList<>();
        list.add(new Interval(5, 7));
        list.add(new Interval(9, 9));
        list.add(new Interval(1, 5));

        List<Interval> intervals = merge(list);

        for (Interval interval : intervals) {
            System.out.println("[ " + interval.start + ", " + interval.end + " ]");
        }

    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) return intervals;

        List<Interval> list = new LinkedList<>();
        intervals.sort((a, b) -> (a.start - b.end)); //sort interval base on start element;

        /*Initial Start,End */
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;


        for (Interval interval : intervals) {
            if (interval.start <= end) {            //if current interval.start<= last.end;
                end = Math.max(end, interval.end);  //then update end;
            } else {                                //[1,3],[2,5]=>  end=5
                list.add(new Interval(start, end)); //[1,3],[3,5]=>  end=5
                start = interval.start;             //[1,3],[1,5]=>  end=5
                end = interval.end;                 //else current interval.start>last.end
            }                                       //means [1,3],[4,5] no merge
        }                                           //add previous Interval


        /*Since for loop only add previous Interval
        * such as: [1,3],[4,5] => [1,3], [1,3],[2,5] => no insertion
        * so that we have to add the last interval into the list
        * */
        list.add(new Interval(start, end));
        return list;
    }
}
