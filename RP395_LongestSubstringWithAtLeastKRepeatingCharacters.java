package Lecode.DivideAndRule;

import java.util.ArrayList;

public class RP395_LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 3;
        int res = longestSubstring(s,k);
        System.out.println(res);
    }
    public static int longestSubstring(String s, int k) {
        //字母数组，下标为26个英文字母，值为该位置的字母出现次数
        int[] count = new int[26];
        for (int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        //list记录分割点
        ArrayList<Integer> split = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if (count[s.charAt(i)-'a']<k){
                split.add(i);
            }
        }
        //当没有分割点时，现在的字符串为符合条件的子串
        if (split.isEmpty()){
            return s.length();
        }
        int res=0;
        int pre=0;
        split.add(s.length());
        //找符合条件的最长子字符串
        for (Integer i:split){
            res=i>pre ? Math.max(res,longestSubstring(s.substring(pre,i),k)) : res;
            pre=i+1;
        }
        return res;
    }
}
