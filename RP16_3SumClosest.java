package Lecode.Array;

import java.util.Arrays;

public class RP16_3SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 2;
        RP16_3SumClosest r = new RP16_3SumClosest();
        int res = r.threeSumClosest(nums,target);
        System.out.println(res);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(target - sum) < Math.abs(target - res)){
                    res = sum;
                }
                if(sum > target){
                    right--;
                }else if (sum < target){
                    left++;
                }else {
                    return res;
                }

            }
        }
        return res;
    }
}
