package Lecode.Greedy;

import java.util.Arrays;

public class RP452_MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int res = findMinArrowShots(points);
        System.out.println(res);
    }

    public static int findMinArrowShots(int[][] points){
        if (points.length==0){
            return 0;
        }
        //对数组按末端元素进行排序
        Arrays.sort(points,(o1, o2) -> Integer.compare(o1[1],o2[1]));
        int res=1;
        int endLocation = points[0][1];
        for (int i=0;i<points.length;i++){
            //若遇到开始坐标大于前一个状态下的末端坐标时，增加一个箭，并更新末端坐标
            if (points[i][0]>endLocation){
                res+=1;
                endLocation=points[i][1];
            }
        }
        return res;
    }
}
