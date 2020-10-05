package Lecode.Tree;
import java.util.*;
public class RP107_BinaryTreeLevelOrderTraversalII {
    int val;
    RP107_BinaryTreeLevelOrderTraversalII left;
    RP107_BinaryTreeLevelOrderTraversalII right;
    RP107_BinaryTreeLevelOrderTraversalII(int x) {
        val = x;
    }
    public static void main(String[] args) {
        RP107_BinaryTreeLevelOrderTraversalII root = new RP107_BinaryTreeLevelOrderTraversalII(3);
        RP107_BinaryTreeLevelOrderTraversalII left = new RP107_BinaryTreeLevelOrderTraversalII(9);
        RP107_BinaryTreeLevelOrderTraversalII right = new RP107_BinaryTreeLevelOrderTraversalII(20);
        RP107_BinaryTreeLevelOrderTraversalII right1 = new RP107_BinaryTreeLevelOrderTraversalII(15);
        RP107_BinaryTreeLevelOrderTraversalII right2 = new RP107_BinaryTreeLevelOrderTraversalII(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        List<List<Integer>> res = levelOrderBottom(root);
        System.out.println("res = " + res);
    }
    public static List<List<Integer>> levelOrderBottom(RP107_BinaryTreeLevelOrderTraversalII root) {
        //如果为空返回空列表
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //创建一个队列
        Queue<RP107_BinaryTreeLevelOrderTraversalII> queue = new LinkedList<RP107_BinaryTreeLevelOrderTraversalII>();
        //将根节点放入其中
        queue.offer(root);
        while(!queue.isEmpty()) {
            //每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将这一层的元素全部取出，放入到临时数组中，节点的左右孩子不为空，继续放入队列
            for(int i=0;i<size;++i) {
                RP107_BinaryTreeLevelOrderTraversalII node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        //返回翻转后的结果就是最终结果
        Collections.reverse(res);
        return res;
    }
}
