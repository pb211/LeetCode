package Lecode.test;

public class RP279_PerfectSquares {
    public static void main(String[] args) {
        RP279_PerfectSquares r = new RP279_PerfectSquares();
        int res = r.numSquares(12);
        System.out.println(res);
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况下是每个数=1+1+1+1 .... i次
            dp[i] = i;
            //当i-j*j<0时，不需要再找平方数
            for (int j = 1; i - j * j >= 0; j++) {
                // 对每一个N，观察1到N-1中，谁的解最小，那么N的解就是它+1,给数值+1，丁算找到了新并入的平方数
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
