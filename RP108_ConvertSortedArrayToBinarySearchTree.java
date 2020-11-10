package Lecode.DeepFirstSearch;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RP108_ConvertSortedArrayToBinarySearchTree {
    int val;
    RP108_ConvertSortedArrayToBinarySearchTree left;
    RP108_ConvertSortedArrayToBinarySearchTree right;
    RP108_ConvertSortedArrayToBinarySearchTree(int x){ val = x; }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        RP108_ConvertSortedArrayToBinarySearchTree node = sortedArrayToBST(nums);
        List<List<Integer>> res=levelOrder(node);
        System.out.println(res);
    }
    public static RP108_ConvertSortedArrayToBinarySearchTree sortedArrayToBST(int[] nums) {
        return getTree(nums,0,nums.length-1);
    }
    public static RP108_ConvertSortedArrayToBinarySearchTree getTree(int[] nums, int left,int right) {
        if (left>right){
            return null;
        }
        int mid = (left+right)/2;
        RP108_ConvertSortedArrayToBinarySearchTree root = new RP108_ConvertSortedArrayToBinarySearchTree(nums[mid]);
        root.left = getTree(nums,left,mid-1);
        root.right = getTree(nums,mid+1,right);
        return root;
    }


    //层次遍历
    public static List<List<Integer>> levelOrder(RP108_ConvertSortedArrayToBinarySearchTree root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        //队列实时存放每层的节点
        Queue queue = new LinkedList();
        queue.add(root);
        //当该层不为空时进行循环
        while (!queue.isEmpty()){
            //每层的元素数，根据其进行循环
            int n=queue.size();
            //存放每层的节点
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<n;i++){
                //把队首元素出队对其下一层进行队列存储
                RP108_ConvertSortedArrayToBinarySearchTree node = (RP108_ConvertSortedArrayToBinarySearchTree) queue.poll();
                //存储该层
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            //把每层元素加入结果集
            res.add(list);
        }
        return res;
    }
}
