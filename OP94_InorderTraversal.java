package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class OP94_InorderTraversal {
	int val;
	OP94_InorderTraversal left;
	OP94_InorderTraversal right;
	
	OP94_InorderTraversal(int x){
		val=x;
	}

	public static void main(String[] args) {
		OP94_InorderTraversal root = new OP94_InorderTraversal(1);
		OP94_InorderTraversal right = new OP94_InorderTraversal(2);
		OP94_InorderTraversal left1 = new OP94_InorderTraversal(3);
        root.right = right;
        right.left = left1;
		List<Integer> res = new ArrayList<Integer>();
		res = inorderTraversal(root);
		System.out.println(res);
	}
	 public static List<Integer> inorderTraversal(OP94_InorderTraversal root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<OP94_InorderTraversal> stk = new LinkedList<OP94_InorderTraversal>();
        //当节点不为空或栈中有元素时进行循环
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
            	//把左枝压入栈
                stk.push(root);
                root = root.left;
            }
            //取出最后一个压入栈
            root = stk.pop();
            res.add(root.val);
            //去找右枝
            root = root.right;
        }
        return res;
    }
}
