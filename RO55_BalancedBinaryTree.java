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
        // ������ƽ���
        if (root == null) {
            return true;
        }
        // ���������߶�
        int leftTreeDepth = treeDepth(root.left);   
        int rigthTreeDepth = treeDepth(root.right);

        // �Ե�ǰ���Ϊ�������ǲ�ƽ���
        if (Math.abs(leftTreeDepth - rigthTreeDepth) > 1) {
            return false;
        }

        // �Ե�ǰ���Ϊ��������ƽ��ģ����������������ƽ���� 
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // �ݹ������rootΪ�������ĸ߶�
    public static int treeDepth(RO55_BalancedBinaryTree root) {
        // �����ĸ߶�Ϊ0
        if (root == null) {
            return 0;
        }
        //���ض������ĸ߶�
        // �������ĸ߶�Ϊ�������߶Ⱥ��������߶������еĽϴ��� + 1
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

}