package Lecode.DeepFirstSearch;

import javax.swing.tree.TreeNode;

public class RP98_ValidateBinarySearchTree {
    int val;
    RP98_ValidateBinarySearchTree left;
    RP98_ValidateBinarySearchTree right;
    RP98_ValidateBinarySearchTree(int x) { val = x; }

    public static void main(String[] args) {
        RP98_ValidateBinarySearchTree one = new RP98_ValidateBinarySearchTree(5);
        RP98_ValidateBinarySearchTree two = new RP98_ValidateBinarySearchTree(1);
        RP98_ValidateBinarySearchTree three = new RP98_ValidateBinarySearchTree(4);
        RP98_ValidateBinarySearchTree four = new RP98_ValidateBinarySearchTree(3);
        RP98_ValidateBinarySearchTree five = new RP98_ValidateBinarySearchTree(6);
        one.left=two;
        one.right=three;
        three.left=four;
        three.right=five;
        boolean res = isValidBST(one);
        System.out.println(res);
    }

    public static boolean isValidBST(RP98_ValidateBinarySearchTree root) {
        //传入最大值与最小值，查找左子树时，最大值为该节点，查找右子树时，最小值为当前结点
        return judge(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean judge(RP98_ValidateBinarySearchTree root, long min, long max){
        if (root==null){
            return true;
        }
        if (root.val>=max||root.val<=min){
            return false;
        }
        return judge(root.left,min,root.val)&&judge(root.right,root.val,max);
    }

}
