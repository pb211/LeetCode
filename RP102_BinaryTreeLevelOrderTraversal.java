package Lecode.Queue;

import java.util.*;

public class RP102_BinaryTreeLevelOrderTraversal {
    int val;
    RP102_BinaryTreeLevelOrderTraversal left;
    RP102_BinaryTreeLevelOrderTraversal right;
    RP102_BinaryTreeLevelOrderTraversal(int x){ val=x; }

    public static void main(String[] args) {
        RP102_BinaryTreeLevelOrderTraversal one = new RP102_BinaryTreeLevelOrderTraversal(3);
        RP102_BinaryTreeLevelOrderTraversal two = new RP102_BinaryTreeLevelOrderTraversal(9);
        RP102_BinaryTreeLevelOrderTraversal three = new RP102_BinaryTreeLevelOrderTraversal(20);
        RP102_BinaryTreeLevelOrderTraversal four = new RP102_BinaryTreeLevelOrderTraversal(15);
        RP102_BinaryTreeLevelOrderTraversal five = new RP102_BinaryTreeLevelOrderTraversal(7);
        one.left=two;
        one.right=three;
        three.left=four;
        three.right=five;
        List<List<Integer>> res=levelOrder(one);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrder(RP102_BinaryTreeLevelOrderTraversal root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        //队列实时存放每层的节点
        Queue queue = new LinkedList();
        queue.add(root);
        //当该层不为空时进行循环
        while (!queue.isEmpty()){
            //每层的元素数，根据其进行循环
            int n=queue.size();
            //存放每层的节点
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<n;i++){
                //把队首元素出队对其下一层进行队列存储
                RP102_BinaryTreeLevelOrderTraversal node = (RP102_BinaryTreeLevelOrderTraversal) queue.poll();
                //存储该层
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            //把每层元素加入结果集
            res.add(list);
        }
        return res;
    }
}
