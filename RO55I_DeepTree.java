package Tree;

public class RO55I_DeepTree {
	int val;
	RO55I_DeepTree left;
	RO55I_DeepTree right;
	RO55I_DeepTree(int x) {
        val = x;
    }
    public static void main(String[] args) {
    	RO55I_DeepTree root = new RO55I_DeepTree(3);
    	RO55I_DeepTree left = new RO55I_DeepTree(9);
    	RO55I_DeepTree right = new RO55I_DeepTree(20);
    	RO55I_DeepTree left1 = new RO55I_DeepTree(15);
    	RO55I_DeepTree right1 = new RO55I_DeepTree(7);
        root.left = left;
        root.right = right;
        right.right = right1;
        right.left = left1;
        int deep = maxDepth(root);
        System.out.println("maxDepth = " + deep);
    }
    public static int maxDepth(RO55I_DeepTree root){
    	if(root==null){
    		return 0;
    	}
    	
    	int maxleft=maxDepth(root.left);
    	int maxright=maxDepth(root.right);
    	int deep=Math.max(maxleft, maxright)+1;
    	
    	return deep;
    }
    
}
