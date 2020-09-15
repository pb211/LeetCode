package Tree;

public class RO55_BalancedBinaryTree {
	int val;
    RO55_BalancedBinaryTree left;
    RO55_BalancedBinaryTree right;

    RO55_BalancedBinaryTree(int x) {
        val = x;
    }

    public static void main(String[] args) {
        RO55_BalancedBinaryTree root = new RO55_BalancedBinaryTree(1);
        RO55_BalancedBinaryTree left = new RO55_BalancedBinaryTree(2);
        RO55_BalancedBinaryTree right = new RO55_BalancedBinaryTree(2);
        RO55_BalancedBinaryTree left1 = new RO55_BalancedBinaryTree(3);
        RO55_BalancedBinaryTree left2 = new RO55_BalancedBinaryTree(3);
        RO55_BalancedBinaryTree left3 = new RO55_BalancedBinaryTree(4);
        RO55_BalancedBinaryTree left4 = new RO55_BalancedBinaryTree(4);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        left1.left = left3;
        left1.right = left4;
        boolean balanced = isBalanced(root);
        System.out.println("balanced = " + balanced);
    }

    public static boolean isBalanced(RO55_BalancedBinaryTree root) {
        // 空树是平衡的
        if (root == null) {
            return true;
        }
        // 左右子树高度
        int leftTreeDepth = treeDepth(root.left);   
        int rigthTreeDepth = treeDepth(root.right);

        // 以当前结点为根的树是不平衡的
        if (Math.abs(leftTreeDepth - rigthTreeDepth) > 1) {
            return false;
        }

        // 以当前结点为根的树是平衡的，检测其左右子树的平衡性 
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 递归计算以root为根的树的高度
    public static int treeDepth(RO55_BalancedBinaryTree root) {
        // 空树的高度为0
        if (root == null) {
            return 0;
        }
        //返回二叉树的高度
        // 二叉树的高度为左子树高度和右子树高度两者中的较大者 + 1
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

}