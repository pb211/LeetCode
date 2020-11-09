package Lecode.DeepFirstSearch;

public class RI0404_CheckBalanceLcci {
    int val;
    RI0404_CheckBalanceLcci left;
    RI0404_CheckBalanceLcci right;
    RI0404_CheckBalanceLcci(int x){ val = x; }

    public static void main(String[] args) {
        RI0404_CheckBalanceLcci one = new RI0404_CheckBalanceLcci(1);
        RI0404_CheckBalanceLcci two = new RI0404_CheckBalanceLcci(2);
        RI0404_CheckBalanceLcci two2 = new RI0404_CheckBalanceLcci(2);
        RI0404_CheckBalanceLcci three = new RI0404_CheckBalanceLcci(3);
        RI0404_CheckBalanceLcci three2 = new RI0404_CheckBalanceLcci(3);
        RI0404_CheckBalanceLcci four = new RI0404_CheckBalanceLcci(4);
        RI0404_CheckBalanceLcci four2 = new RI0404_CheckBalanceLcci(4);
        one.left=two;
        one.right=two2;
        two.left=three;
        two.right=three2;
        three.left=four;
        three.right=four2;
        boolean res = isBalanced(one);
        System.out.println(res);
    }

    public static boolean isBalanced(RI0404_CheckBalanceLcci root){
        //检查完成整个二叉树，递归终止
        if (root==null){ return true; }
        int leftTree=deep(root.left);
        int rightTree=deep(root.right);
        //当找到子树不为平衡二叉树时，直接返回false
        if (Math.abs(leftTree-rightTree)>1){
            return false;
        }
        //检查每个子树
        return isBalanced(root.right)&&isBalanced(root.left);
    }

    public static int deep(RI0404_CheckBalanceLcci root){
        if (root==null){ return 0;}
        //在递归左右子树的过程中+1记录最大深度
        return Math.max(deep(root.left),deep(root.right))+1;
    }
}
