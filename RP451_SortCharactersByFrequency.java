package Lecode.Hash;

import java.util.HashMap;
import java.util.Map;

public class RP451_SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "eeeee";
        String res = frequencySort(s);
        System.out.println(res);
    }
    public static String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++){
            //把字符串以字母为值，存入map，值为其出现的次数
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(map);
        String res = "";
        //从字符串最大长度向下找对应的值，找到后根据其值拼接字符串
        for (int i=s.length();i>0;i--) {
            for (char c : map.keySet()) {
                if (map.get(c) == i) {
                    for (int k=i;k>0;k--)
                        res = res.concat(String.valueOf(c));
                }
            }
        }
        return res;
    }
}
