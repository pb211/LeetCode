package Lecode.Greedy;

import java.util.Arrays;

public class RP435_NonOverlappingIntervals {
    public static void main(String[] args) {
//         int[][] intervals = { {1,2}, {2,3}, {3,4}, {1,3} };
         int[][] intervals = { {1,100},{11,22},{1,11},{2,12}};
         int res = eraseOverlapIntervals(intervals);
         System.out.println(res);
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        if (intervals.length==0){
            return res;
        }
        Arrays.sort(intervals,(o1, o2) -> Integer.compare(o1[1],o2[1]));
        System.out.println(Arrays.deepToString(intervals));
        int end=intervals[0][1];
        for (int i=1;i<intervals.length;i++){
            if (intervals[i][0]<end){
                res+=1;
            }else {
                end=intervals[i][1];
            }
        }
        return res;
    }
}
