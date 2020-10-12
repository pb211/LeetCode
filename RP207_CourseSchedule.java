package Lecode.Graph;

import java.util.*;

public class RP207_CourseSchedule {
    public static void main(String[] args) {
        int[][] course = new int[][]{
                {3,0}, {3,1}, {4,1}, {4,2}, {5,3}, {5,4}
        };
        boolean res = canFinish(6, course);
        System.out.println(res);
    }
    // 节点的入度: 使用数组保存每个节点的入度,
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        // 将所有的课程先放入
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 2.依赖关系, 依赖当前课程的后序课程
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            // (3,0), 想学3号课程要先完成0号课程, 更新3号课程的入度和0号课程的依赖(邻接表)
            int cur = relate[1];//先学的课程
            int next = relate[0];//现在学的课程
            // 1.更新入度
            System.out.println(next+","+(inDegree.get(next)+1));
            //添加对应课程的入度信息
            inDegree.put(next, inDegree.get(next) + 1);

            // 2.当前节点的邻接表
            //判断是否包含指定键名，没有就加入
            if (!adj.containsKey(cur)) {
                adj.put(cur, new ArrayList<>());
            }
//            邻接表加入后续课程
            adj.get(cur).add(next);
        }

        // 3.BFS, 将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        // 取出一个节点, 对应学习这门课程.
        // 遍历当前邻接表, 更新其入度; 更新之后查看入度, 如果为0, 加入到队列
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)) {
                continue;
            }
            List<Integer> successorList = adj.get(cur);
            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }
        // 遍历入队, 如果还有课程的入度不为0, 返回fasle
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
