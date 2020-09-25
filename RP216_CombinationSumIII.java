package Lecode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RP216_CombinationSumIII {
    public static void main(String[] args) {

        RP216_CombinationSumIII res = new RP216_CombinationSumIII();
        int k = 3;
        int n = 7;
        System.out.println(res.combinationSum3(k,n));

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[9];
        int j = 0;
        for(int i=1;i<candidates.length+1;i++){
            candidates[j]=i;
            j++;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length==0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, candidates.length, n, path, res,k);
        return res;
    }

    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res,int k) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            //为零时把找到的路径加入结果集中
            if (path.size()==k){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i
            dfs(candidates, i+1, len, target - candidates[i], path, res,k);

            // 状态重置
            path.removeLast();
        }
    }
}
