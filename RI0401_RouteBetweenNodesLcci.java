package Lecode.Graph;

import java.lang.reflect.Array;
import java.util.*;

public class RI0401_RouteBetweenNodesLcci {
    public static void main(String[] args) {
        int n = 3;
        int start = 0;
        int target = 2;
        int[][] graph = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 2},
        };
        boolean res = findWhetherExistsPath(n, graph, start, target);
        System.out.println("res = " + res);
    }
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //用链表存储图结构
        ArrayList<Integer>[] list = new ArrayList[n];
        //用左边数做下标，右边数为指向初始化链表
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < graph.length;i++){
            list[graph[i][0]].add(graph[i][1]);
        }
        //判断数组，用来判断是否改过节点
        int booleaned[] = new int[n];
        return find(list, booleaned, start, target);
    }
    public static boolean find(ArrayList<Integer>[] list, int[] booleaned, int start, int target){
        //找到目标返回真
        if(start==target){
            return true;
        }
        //将访问过的点标记为1
        booleaned[start]=1;
        //寻找当前节点（start）的每条路径
        for(int i=0;i<list[start].size();i++){
            //当没被访问过时才进行
            if(booleaned[list[start].get(i)] == 0){
                if(find(list,booleaned,list[start].get(i),target)){
                    return true;
                }
            }
        }
        return false;
    }

}
