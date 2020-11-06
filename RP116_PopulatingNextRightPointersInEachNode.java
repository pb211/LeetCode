package Lecode.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RP116_PopulatingNextRightPointersInEachNode {
    public int val;
    public RP116_PopulatingNextRightPointersInEachNode left;
    public RP116_PopulatingNextRightPointersInEachNode right;
    public RP116_PopulatingNextRightPointersInEachNode next;

    public RP116_PopulatingNextRightPointersInEachNode() {}

    public RP116_PopulatingNextRightPointersInEachNode(int _val) {
        val = _val;
    }

    public RP116_PopulatingNextRightPointersInEachNode(int _val, RP116_PopulatingNextRightPointersInEachNode _left, RP116_PopulatingNextRightPointersInEachNode _right, RP116_PopulatingNextRightPointersInEachNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void main(String[] args) {
        RP116_PopulatingNextRightPointersInEachNode one = new RP116_PopulatingNextRightPointersInEachNode(1);
        RP116_PopulatingNextRightPointersInEachNode two = new RP116_PopulatingNextRightPointersInEachNode(2);
        RP116_PopulatingNextRightPointersInEachNode three = new RP116_PopulatingNextRightPointersInEachNode(3);
        RP116_PopulatingNextRightPointersInEachNode four = new RP116_PopulatingNextRightPointersInEachNode(4);
        RP116_PopulatingNextRightPointersInEachNode five = new RP116_PopulatingNextRightPointersInEachNode(5);
        RP116_PopulatingNextRightPointersInEachNode six = new RP116_PopulatingNextRightPointersInEachNode(6);
        RP116_PopulatingNextRightPointersInEachNode seven = new RP116_PopulatingNextRightPointersInEachNode(7);
        one.left=two;
        one.right=three;
        two.left=four;
        two.right=five;
        three.left=six;
        three.right=seven;
        RP116_PopulatingNextRightPointersInEachNode res = connect(one);
        System.out.println(res);
    }

    public static RP116_PopulatingNextRightPointersInEachNode connect(RP116_PopulatingNextRightPointersInEachNode root) {
        if (root==null){ return root; }
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            for (int i=0;i<n;i++){
                RP116_PopulatingNextRightPointersInEachNode node = (RP116_PopulatingNextRightPointersInEachNode) queue.poll();
                if (i==n-1){
                    node.next=null;
                }else {
                    node.next= (RP116_PopulatingNextRightPointersInEachNode) queue.peek();
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
