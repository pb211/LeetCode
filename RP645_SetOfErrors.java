package Lecode.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RP645_SetOfErrors {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,4};
        int[] nums = {2,2};

        int[] res = findErrorNums(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findErrorNums(int[] nums) {
       Map<Integer,Integer> map=new HashMap<Integer, Integer>();
       int[] res=new int[2];
       for (int n:nums){
           //储存n出现的次数
           map.put(n,map.getOrDefault(n,0)+1);
       }
       //遍历1到n，寻找重复值与缺失值
       for (int i=1;i<=nums.length;i++){
           //如果map的key中有i存在，若其值为2，则其值为重复数字，即结果数组的第一个元素
           if (map.containsKey(i)){
                if (map.get(i)==2){
                    res[0]=i;
                }
           }else {//若不包含，则其值为缺失值
               res[1]=i;
           }
       }
       return res;
    }
}
