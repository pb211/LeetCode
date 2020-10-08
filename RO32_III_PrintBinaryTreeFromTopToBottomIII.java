package Lecode.Tree;

import java.util.*;

public class RO32_III_PrintBinaryTreeFromTopToBottomIII {
    int val;
    RO32_III_PrintBinaryTreeFromTopToBottomIII left;
    RO32_III_PrintBinaryTreeFromTopToBottomIII right;
    RO32_III_PrintBinaryTreeFromTopToBottomIII(int x){val = x;}

    public static void main(String[] args) {
        RO32_III_PrintBinaryTreeFromTopToBottomIII root = new RO32_III_PrintBinaryTreeFromTopToBottomIII(3);
        RO32_III_PrintBinaryTreeFromTopToBottomIII left = new RO32_III_PrintBinaryTreeFromTopToBottomIII(9);
        RO32_III_PrintBinaryTreeFromTopToBottomIII right = new RO32_III_PrintBinaryTreeFromTopToBottomIII(20);
        RO32_III_PrintBinaryTreeFromTopToBottomIII right1 = new RO32_III_PrintBinaryTreeFromTopToBottomIII(15);
        RO32_III_PrintBinaryTreeFromTopToBottomIII right2 = new RO32_III_PrintBinaryTreeFromTopToBottomIII(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        List<List<Integer>> res = levelOrder(root);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> levelOrder(RO32_III_PrintBinaryTreeFromTopToBottomIII root){
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //创建一个队列
        Queue<RO32_III_PrintBinaryTreeFromTopToBottomIII> queue = new LinkedList<RO32_III_PrintBinaryTreeFromTopToBottomIII>();
        //将根节点放入其中
        queue.offer(root);
        //判断条件
        int p = 1;
        while(!queue.isEmpty()) {
            //每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将这一层的元素全部取出，放入到临时数组中，节点的左右孩子不为空，继续放入队列
            for(int i=0;i<size;++i) {
                RO32_III_PrintBinaryTreeFromTopToBottomIII node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            if (p%2!=0){
                res.add(tmp);
            }else {
                Collections.reverse(tmp);
                res.add(tmp);
            }
            p++;
        }
        return res;
    }
}
