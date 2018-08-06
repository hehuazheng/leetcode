import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
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

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}

public class P56 {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        Interval prev = null;
        Iterator<Interval> itor = intervals.iterator();
        while (itor.hasNext()) {
            if (prev == null) {
                prev = itor.next();
            } else {
                Interval current = itor.next();
                if (prev.end >= current.start) {
                    if (prev.end < current.end) {
                        prev.end = current.end;
                    }
                    itor.remove();
                } else {
                    prev = current;
                }
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,4));
        list.add(new Interval(4,5));
        System.out.println(new P56().merge(list));

        list.clear();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        System.out.println(new P56().merge(list));
    }
}
