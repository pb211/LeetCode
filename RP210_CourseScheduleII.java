package Lecode.Graph;

import java.util.*;

public class RP210_CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1,0},{1,2},{0,1}};
        int[] res = findOrder(numCourses,prerequisites);
        System.out.println( Arrays.toString(res));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites){
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        //创建入度表和课程依赖关系
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if(map.containsKey(prerequisites[i][1])){
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
        //遍历，将结果数组指针index入队
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        // 出队，并将入度为零的入队
        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            res.add(cur);
            if(map.containsKey(cur) && map.get(cur).size() != 0){
                for (Integer num : map.get(cur)) {
                    inDegree[num]--;
                    if(inDegree[num] == 0){
                        queue.offer(num);
                    }
                }
            }
        }
        //通过遍历把list转为int[]数组
        int[] d = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            d[i] = res.get(i);
        }
        //如果能上完课就返回路径，否则就返回空数组
        if (res.size() == numCourses){
            return d;
        }else {
            return new int[0];
        }
    }
}

















