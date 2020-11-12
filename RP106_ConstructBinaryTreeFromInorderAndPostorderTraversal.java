package Lecode.DeepFirstSearch;
import java.util.Arrays;

public class RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int val;
    RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal left;
    RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal right;
    RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal(int x) { val = x; }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal root =  buildTree(inorder,postorder);

    }

    public static RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal buildTree(int[] inorder, int[] postorder) {
        //判空与递归跳出条件
        if(inorder.length==0) {
            return null;
        }
        //根据后序遍历特点，找到根节点
        RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal root = new RP106_ConstructBinaryTreeFromInorderAndPostorderTraversal(postorder[postorder.length-1]);
        //后序遍历和中序遍历一样，都是先遍历左子树，所以中序数组和后序数组的左子树部分长度是一样的，不用在对其长度进行判断
        //查找每个状态下后序数组所对应的根节点的下标
        for(int i=0;i<inorder.length;++i) {
            if(inorder[i]==postorder[postorder.length-1]) {
                //拆分数组
                int[] inLeft = Arrays.copyOfRange(inorder,0,i);
                int[] inRight = Arrays.copyOfRange(inorder,i+1,inorder.length);
                int[] postLeft = Arrays.copyOfRange(postorder,0,i);
                int[] postRight = Arrays.copyOfRange(postorder,i,postorder.length-1);
                //递归处理左右子树
                root.left = buildTree(inLeft,postLeft);
                root.right = buildTree(inRight,postRight);
                break;
            }
        }
        return root;
    }
}
