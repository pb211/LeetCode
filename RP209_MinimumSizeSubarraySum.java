package Lecode.Array;
public class RP209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int s=7;
        int[] nums={2,3,1,2,4,3};
        int res = minSubArrayLen(s,nums);
        System.out.println(res);
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int pan=0;
        for (int p:nums){
            pan+=p;
        }
        if (n == 0||pan<s) {//两个判定条件，数组长度为0与总和都不够目标值
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = nums.length;
        //双指针滑动窗口，找到最小值
        while (right < n) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min;
    }
}
