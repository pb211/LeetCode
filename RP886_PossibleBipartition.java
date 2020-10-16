package Lecode.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class RP886_PossibleBipartition {
    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {
                {1, 2},
                {1, 3},
                {2, 4},
        };
        boolean res = possibleBipartition(N, dislikes);
        System.out.println("res = " + res);
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }
        //用下标代表人，下标对应的列表代表讨厌的人
        ArrayList<Integer>[] lists = new ArrayList[N + 1];
        //记录每个人的标记
        int[] visited = new int[N + 1];
        //将初始标记设为-1，表示没被遍历过
        Arrays.fill(visited, -1);

        //初始化数组
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            lists[dislike[0]].add(dislike[1]);
            lists[dislike[1]].add(dislike[0]);
        }

        //开始遍历每一个人
        for (int i = 1; i <= N; i++) {
            //当这个人没被遍历过时，进行查找
            if (visited[i] == -1) {
                if (!find(i, 0, visited, lists)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean find(int i, int cur, int[] visited, ArrayList<Integer>[] lists) {
        //将这个人标记为cur
        visited[i] = cur;
        //遍历i讨厌的人
        for (int next : lists[i]) {
            //如果讨厌的人还没被遍历，则设置为不与ta同的标记
            if (visited[next] == -1) {
                if (!find(next, cur ^ 1, visited, lists)) {
                    return false;
                }
            }
            //若与讨厌的人标记相同，则返回false
            else if (visited[next] == cur) {
                return false;
            }
        }
        return true;
    }

}
