package wrap.topinterviewmedium;

import java.util.Arrays;
import java.util.Comparator;
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input = {{1,3},{8,10},{15,18},{2,6}};
        int[][] ans = merge(input);
        for(int[] interval : ans){
            System.out.println(interval[0]+","+interval[1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int index = 0;

        for(int i=1;i<size;i++){
            if(intervals[index][1] >= intervals[i][0]){
                intervals[index][0] = Math.min(intervals[index][0], intervals[i][0]);
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            }
            else{
                index++;
                intervals[index] = intervals[i];
            }
        }
        int[][] ans = new int[index+1][2];
        for(int i=0;i<=index;i++){
            ans[i] = intervals[i];
        }
        return ans;
    }
}
