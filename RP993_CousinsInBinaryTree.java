package Lecode.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RP993_CousinsInBinaryTree {
    int val;
    RP993_CousinsInBinaryTree left;
    RP993_CousinsInBinaryTree right;
    RP993_CousinsInBinaryTree(){}
    RP993_CousinsInBinaryTree(int val){ this.val = val; }
    RP993_CousinsInBinaryTree(int val,RP993_CousinsInBinaryTree left,RP993_CousinsInBinaryTree right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    public static void main(String[] args) {
        RP993_CousinsInBinaryTree one = new RP993_CousinsInBinaryTree(1);
        RP993_CousinsInBinaryTree two = new RP993_CousinsInBinaryTree(2);
        RP993_CousinsInBinaryTree three = new RP993_CousinsInBinaryTree(3);
        RP993_CousinsInBinaryTree four = new RP993_CousinsInBinaryTree(4);
        RP993_CousinsInBinaryTree five = new RP993_CousinsInBinaryTree(5);
        one.left=two;
        two.right=four;
        one.right=three;
        three.right=five;
        boolean res=isCousins(one,5,4);
        System.out.println(res);
    }
    public static boolean isCousins(RP993_CousinsInBinaryTree root, int x, int y) {
        if (root==null||root.val==x||root.val==y){return false;}
                Queue<RP993_CousinsInBinaryTree>queue=new LinkedList<>();
                queue.add(root);
                RP993_CousinsInBinaryTree xNode=null;
                RP993_CousinsInBinaryTree xFather=null;
                RP993_CousinsInBinaryTree yNode=null;
                RP993_CousinsInBinaryTree yFather=null;
        //广度优先搜索，层次遍历找到xy是否在同一层，并给其父节点赋值
                while (!queue.isEmpty()){
                    int size=queue.size();
                    while(size-->0){
                        RP993_CousinsInBinaryTree temp=queue.poll();
//                        System.out.println(temp.val);
                        if (temp.left!=null){
                            queue.add(temp.left);
                            if (temp.left.val==x){
                                xNode=temp.left;
                                xFather=temp;
                            }
                            if (temp.left.val==y){
                                yNode=temp.left;
                                yFather=temp;
                            }
                        }
                        if (temp.right!=null){
                            queue.add(temp.right);
                            if (temp.right.val==x){
                                xNode=temp.right;
                                xFather=temp;
                            }
                            if (temp.right.val==y){
                                yNode=temp.right;
                                yFather=temp;
                            }
                        }
                        //在同一层找到两个节点后，判断其父节点是否一致，不一致则为堂兄弟结点
                        if (xNode!=null&&yNode!=null){
                            return xFather!=yFather;
                        }

                    }
                    //在当前层只找到了一个节点时，则返回false
                    if ((xNode==null&&yNode!=null)||(xNode!=null&&yNode==null)){
                        return false;
            }
        }
        return false;
    }
}
