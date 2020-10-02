package Lecode.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RP120_Triangle {
    public static void main(String[] args) {
        RP120_Triangle r = new RP120_Triangle();
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(new LinkedList<>(Arrays.asList(2)));
        triangle.add(new LinkedList<>(Arrays.asList(3, 4)));
        triangle.add(new LinkedList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new LinkedList<>(Arrays.asList(4, 1, 8, 3)));
        int res = r.minimumTotal(triangle);
        System.out.println(res);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        //三角形行数
        int n = triangle.size();
        //动态数组，重新把数赋给每一行
        int[][] dp = new int[n+1][n+1];
        //从下向上进行
        for(int i=n-1;i>=0;i--){
            //对应的i就是每行的个数
            for (int j=0;j<=i;j++){
                //动态方程，找出每个元素对应的最短路径对应的数并赋值给上一行
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        //返回结果
        return dp[0][0];
    }
}
