package Lecode.Greedy;

public class RP55_JumpGame {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,0,0};
        int[] nums = {3,2,1,0,4};

        boolean res = canJump(nums);
        System.out.println(res);
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
