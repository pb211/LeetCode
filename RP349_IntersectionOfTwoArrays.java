package Lecode.Hash;

import java.util.*;

public class RP349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] res=intersection(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        for (int i =0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums1[i]==nums2[j]){
                    list.add(nums1[i]);
                }
            }
        }
        List<Integer> list2 = new ArrayList<Integer>(new LinkedHashSet<Integer>(list));
        int[] res = new int[list2.size()];
        for (int k=0;k<list2.size();k++){
            res[k]=list2.get(k);
        }
        return res;
    }
}
