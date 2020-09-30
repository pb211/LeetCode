package Lecode.test;

public class RP64_MinimumPathSum {
    public static void main(String[] args) {
        RP64_MinimumPathSum r = new RP64_MinimumPathSum();
        int [][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        int res = r.minPathSum(grid);
        System.out.println(res);
    }
    public int minPathSum(int[][] grid) {
        if(grid==null){
            return 0;
        }
        int h=grid.length;
        int l=grid[0].length;
        //用新数组dp去储存行进到该点的路径和
        int[][] dp = new int[h][l];
        //原点的路径就是本身的路径
        dp[0][0] = grid[0][0];
        //第一行与第一列的最小路径和是固定的，都是上一位加下一位
        for(int i=1;i<h;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<l;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        //遍历而出其余点的最小路径和
        for (int i=1;i<h;i++) {
            for (int j=1;j<l;j++) {
                //到达grid[i][j]的最短路径是上一位加本身与右一位加本身的最小值
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //返回到达终点的最短路径和
        return dp[h-1][l-1];
    }
}
