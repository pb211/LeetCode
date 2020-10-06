package Lecode.Tree;

import java.util.*;

public class RP559_MaximumdepthOfNAryTree {
    public int val;
    public List<RP559_MaximumdepthOfNAryTree> children;

    public RP559_MaximumdepthOfNAryTree() { }

    public RP559_MaximumdepthOfNAryTree(int _val) {
        val = _val;
    }

    public RP559_MaximumdepthOfNAryTree(int _val, List<RP559_MaximumdepthOfNAryTree> _children) {
        val = _val;
        children = _children;
    }
    public static void main(String[] args) {
        RP559_MaximumdepthOfNAryTree one = new RP559_MaximumdepthOfNAryTree(1);
        RP559_MaximumdepthOfNAryTree two = new RP559_MaximumdepthOfNAryTree(2);
        RP559_MaximumdepthOfNAryTree three = new RP559_MaximumdepthOfNAryTree(3);
        RP559_MaximumdepthOfNAryTree four = new RP559_MaximumdepthOfNAryTree(4);
        RP559_MaximumdepthOfNAryTree five = new RP559_MaximumdepthOfNAryTree(5);
        RP559_MaximumdepthOfNAryTree six = new RP559_MaximumdepthOfNAryTree(6);
        List<RP559_MaximumdepthOfNAryTree> second = new ArrayList<>();
        second.add(three);
        second.add(two);
        second.add(four);
        one.children = second;
        List<RP559_MaximumdepthOfNAryTree> third = new ArrayList<>();
        third.add(five);
        third.add(six);
        three.children = third;
        RP559_MaximumdepthOfNAryTree root = new RP559_MaximumdepthOfNAryTree(1, second);
        int res = maxDepth(root);
        System.out.println("res = " + res);
    }
    //方法一：迭代————与昨天一样，定义一个变量在进行迭代完一层后将，将其+1即可
    public static int maxDepth(RP559_MaximumdepthOfNAryTree root) {
        if (root==null){
            return 0;
        }
        //记录树的深度
        int d = 0;
        Queue<RP559_MaximumdepthOfNAryTree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //每次遍历的数量为队列的长度
            int size = queue.size();
            for(int i=0;i<size;++i) {
                // 依次取出这一层的每一个节点,对当前层进行遍历，不涉及深度
                RP559_MaximumdepthOfNAryTree node = queue.poll();
                //与
                if (node.children != null) {
                    for (RP559_MaximumdepthOfNAryTree n : node.children) {
                        queue.add(n);
                    }
                }
            }
            //遍历完所有节点后深度++
            d++;
        }
        return d;
    }
    //方法二·：递归
    public static int maxDepth1(RP559_MaximumdepthOfNAryTree root) {
        if (null == root) {
            return 0;
        }
        //存放深度，若root不为空，就至少有一层，赋值1
        int d = 1;
        //递归找到所有的孩子节点，找到最大值
        for (RP559_MaximumdepthOfNAryTree child : root.children) {
            d = Math.max(d, 1 + maxDepth1(child));
        }
        return d;
    }
}
