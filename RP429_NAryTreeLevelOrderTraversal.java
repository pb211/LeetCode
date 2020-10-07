package Lecode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RP429_NAryTreeLevelOrderTraversal {
    public int val;
    public List<RP429_NAryTreeLevelOrderTraversal> children;

    public RP429_NAryTreeLevelOrderTraversal() {}

    public RP429_NAryTreeLevelOrderTraversal(int _val) {
        val = _val;
    }

    public RP429_NAryTreeLevelOrderTraversal(int _val, List<RP429_NAryTreeLevelOrderTraversal> _children) {
        val = _val;
        children = _children;
    }
    public static void main(String[] args) {
        RP429_NAryTreeLevelOrderTraversal one = new RP429_NAryTreeLevelOrderTraversal(1);
        RP429_NAryTreeLevelOrderTraversal two = new RP429_NAryTreeLevelOrderTraversal(2);
        RP429_NAryTreeLevelOrderTraversal three = new RP429_NAryTreeLevelOrderTraversal(3);
        RP429_NAryTreeLevelOrderTraversal four = new RP429_NAryTreeLevelOrderTraversal(4);
        RP429_NAryTreeLevelOrderTraversal five = new RP429_NAryTreeLevelOrderTraversal(5);
        RP429_NAryTreeLevelOrderTraversal six = new RP429_NAryTreeLevelOrderTraversal(6);
        List<RP429_NAryTreeLevelOrderTraversal> second = new ArrayList<>();
        second.add(three);
        second.add(two);
        second.add(four);
        List<RP429_NAryTreeLevelOrderTraversal> third = new ArrayList<>();
        third.add(five);
        third.add(six);
        three.children = third;
        RP429_NAryTreeLevelOrderTraversal root = new RP429_NAryTreeLevelOrderTraversal(1, second);
        List<List<Integer>> res = levelOrder(root);
        System.out.println("res = " + res);
    }
    public static List<List<Integer>> levelOrder(RP429_NAryTreeLevelOrderTraversal root) {
        // 判空返回
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //创建一个队列
        Queue<RP429_NAryTreeLevelOrderTraversal> queue = new LinkedList<RP429_NAryTreeLevelOrderTraversal>();
        //将根节点放入其中
        queue.offer(root);
        while(!queue.isEmpty()) {
            //每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将这一层的元素全部取出，放入到临时数组中，节点的左右孩子不为空，继续放入队列
            for(int i=0;i<size;++i) {
                RP429_NAryTreeLevelOrderTraversal node = queue.poll();
                tmp.add(node.val);
                if(node.children!=null) {
                    for (RP429_NAryTreeLevelOrderTraversal n : node.children) {
                        queue.add(n);
                    }
                }

            }
            res.add(tmp);
        }
        return res;
    }
}
