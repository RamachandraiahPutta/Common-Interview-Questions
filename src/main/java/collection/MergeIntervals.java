package collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Interval[] arr=new Interval[5];
        arr[0] = new Interval(6,8);
        arr[1] = new Interval(1,9);
        arr[2] = new Interval(2,4);
        arr[3] = new Interval(14,18);
        arr[4] = new Interval(4,12);

        List<Interval> intervals = mergeIntervals(arr);
        System.out.println(intervals);
    }
    public static List<Interval> mergeIntervals(Interval[] intervals){
        Arrays.sort(intervals, (i1, i2) -> i1.getStart() - i2.getStart() );
        List<Interval> result = new LinkedList<>();
        int start = intervals[0].getStart();
        int end = intervals[0].getEnd();
        for (Interval interval: intervals) {
            if(end >= interval.getStart()){
                end = Math.max(end, interval.getEnd());
            }else {
                result.add(new Interval(start, end));
                start = interval.getStart();
                end = interval.getEnd();
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Interval{
    private int start;
    private int end;
}
