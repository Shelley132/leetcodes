package leetcodes51_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

/**
 * @author JUANJUAN
 * @version 2017年7月12日下午7:46:48
 */
public class L56 {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        // java 8中，Lambda表达式的写法
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        Interval first = intervals.get(0);
        int lastStart = first.start, lastEnd = first.end;
        for (int i = 1; i < intervals.size(); i++) {

            Interval in = intervals.get(i);
            if (lastEnd >= in.start) {
                lastEnd = Math.max(lastEnd, in.end);
                lastStart = Math.min(lastStart, in.start);
            } else {
                res.add(new Interval(lastStart, lastEnd));
                lastStart = in.start;
                lastEnd = in.end;
            }
        }
        res.add(new Interval(lastStart, lastEnd));
        return res;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        L56 test = new L56();
        List<Interval> intervals = new ArrayList<Interval>();
        /*
         * intervals.add(new Interval(1,3)); intervals.add(new Interval(2,6));
         * intervals.add(new Interval(8,10)); intervals.add(new
         * Interval(15,18));
         */
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 0));
        List<Interval> list = test.merge(intervals);
        for (Interval in : list) {
            System.out.println(in.start + "," + in.end);
        }
    }

}
