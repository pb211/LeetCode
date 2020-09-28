package Lecode.test;

public class RI1617_ContiguousSequenceLcci {
    public static void main(String[] args) {
        RI1617_ContiguousSequenceLcci res = new RI1617_ContiguousSequenceLcci();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res1 = res.maxSubArray(nums);
        System.out.println(res1);
    }
    public int maxSubArray(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        //当只算首个元素时，最大值即为其本身
        int maxSum = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            int max = arr[i-1];
            int sum = 0;
            //循环累加计算sum的值
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                //取之前的max和相加nums后sum的最大值
                max = Math.max(sum, max);
            }
            arr[i] = max;
            //比较本身和max
            maxSum = Math.max(maxSum, max);
        }
        return maxSum;
    }
}
