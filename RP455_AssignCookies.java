package Lecode.Greedy;

import java.util.Arrays;

public class RP455_AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int res = findContentChildren(g,s);
        System.out.println(res);
    }
    //1.直接暴力
    public static int findContentChildren(int[] g, int[] s) {
        int res=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i =0;i<g.length;i++){
            for (int j = 0;j<s.length;j++){
                if (s[j]>=g[i]){
                    s[j]=0;
                    res+=1;
                    break;
                }
            }
        }
        return res;
    }
    //优化
    public int findContentChildren1(int[] g, int[] s) {
        int res=0;
        int cookies=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(res<g.length&&cookies<s.length){
            if(g[res]<=s[cookies]){
                res++;
            }
            cookies++;
        }
        return res;
    }
}
