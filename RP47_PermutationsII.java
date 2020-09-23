package Lecode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RP47_PermutationsII {
    private static boolean[] vis;

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//
//    }

//    boolean[] vis;


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();

        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

}
