package Lecode.Hash;

import java.util.*;

public class RI1624_PairsWithSumLcci {
    public static void main(String[] args) {
        int[] nums={5,6,5,6};
//        int[] nums={2, 1, 8, 6, 5, 7, -1, 3, 5, 5};

        int target=11;
        List<List<Integer>> res=pairSums(nums,target);
        System.out.println(res);
    }
    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            Integer num=map.get(target-nums[i]);
            //如果相加为target的值存在，加入结果集，并根据其出现次数更新map(不将当前值加入map，并移除对应值)
            if (num!=null){
                res.add(Arrays.asList(nums[i],target-nums[i]));
                if (num==1){
                    map.remove(target-nums[i]);
                }else {
                    map.put(target-nums[i],num-1);
                }
            }else {
                //把出现的元素当成key，出现的次数当成value存到map中
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
      return res;
    }
}











//for (int num : nums) {
//    Integer count = map.get(target - num);
//    if (count != null) {
//        ans.add(Arrays.asList(num, target - num));
//        if (count == 1)
//            map.remove(target - num);
//        else
//            map.put(target - num, --count);
//    } else
//    map.put(num, map.getOrDefault(num, 0) + 1);
//}

