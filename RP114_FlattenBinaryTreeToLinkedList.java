package Lecode.DeepFirstSearch;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class RP114_FlattenBinaryTreeToLinkedList {
    int val;
    RP114_FlattenBinaryTreeToLinkedList left;
    RP114_FlattenBinaryTreeToLinkedList right;
    RP114_FlattenBinaryTreeToLinkedList() {}
    RP114_FlattenBinaryTreeToLinkedList(int val) { this.val = val; }
    RP114_FlattenBinaryTreeToLinkedList(int val, RP114_FlattenBinaryTreeToLinkedList left, RP114_FlattenBinaryTreeToLinkedList right) {
           this.val = val;
           this.left = left;
           this.right = right;
    }

    public static void main(String[] args) {
        RP114_FlattenBinaryTreeToLinkedList one = new RP114_FlattenBinaryTreeToLinkedList(1);
        RP114_FlattenBinaryTreeToLinkedList two = new RP114_FlattenBinaryTreeToLinkedList(2);
        RP114_FlattenBinaryTreeToLinkedList three = new RP114_FlattenBinaryTreeToLinkedList(3);
        RP114_FlattenBinaryTreeToLinkedList four = new RP114_FlattenBinaryTreeToLinkedList(4);
        RP114_FlattenBinaryTreeToLinkedList five = new RP114_FlattenBinaryTreeToLinkedList(5);
        RP114_FlattenBinaryTreeToLinkedList six = new RP114_FlattenBinaryTreeToLinkedList(6);
        one.left=two;
        two.left=three;
        two.right=four;
        one.right=five;
        five.right=six;
        List<RP114_FlattenBinaryTreeToLinkedList> res = flatten(one);
        for (int i =0;i<res.size();++i){
            System.out.println(res.get(i).val);
        }
    }

    public static List<RP114_FlattenBinaryTreeToLinkedList> flatten(RP114_FlattenBinaryTreeToLinkedList root) {
        List<RP114_FlattenBinaryTreeToLinkedList> list = new ArrayList<RP114_FlattenBinaryTreeToLinkedList>();
        getlist(root, list);
        for(int i=1;i<list.size();i++){
            root.left=null;
            root.right=list.get(i);
            root=root.right;
        }
        return list;
    }

    public static void getlist(RP114_FlattenBinaryTreeToLinkedList root, List<RP114_FlattenBinaryTreeToLinkedList> list){
        if(root!=null){
            list.add(root);
            getlist(root.left,list);
            getlist(root.right,list);
        }
    }
}
