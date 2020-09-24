package Lecode.test;

import java.util.*;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的每个数字在每个组合中只能使用一次。
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。 

public class RP40_CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        RP40_CombinationSumII solution = new RP40_CombinationSumII();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("res：" + res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //目标值减去candidates[i]小于0直接break
            if (target - candidates[i] < 0) {
                break;
            }
            //与前一个数相同发生重复，跳过，继续运行continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            //递归传递i+1
            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}



