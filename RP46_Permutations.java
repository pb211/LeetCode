package Lecode.test;

import java.util.*;

public class RP46_Permutations {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num :nums){
            output.add(num);
        }
        int len = nums.length;
        if (len == 0){
            return res;
        }
        findall(len,output,res,0);
        return res;
    }
    public static void findall(int len,List<Integer> output,List<List<Integer>> res,int first){
        if (first == len){
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first;i < len;i++){
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            findall(len, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
            
        }
    }
}
