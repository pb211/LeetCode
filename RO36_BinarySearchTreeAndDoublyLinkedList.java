package Lecode.DivideAndRule;

public class RO36_BinarySearchTreeAndDoublyLinkedList {
    public int val;
    public RO36_BinarySearchTreeAndDoublyLinkedList left;
    public RO36_BinarySearchTreeAndDoublyLinkedList right;

    public RO36_BinarySearchTreeAndDoublyLinkedList() {}

    public RO36_BinarySearchTreeAndDoublyLinkedList(int _val) {
        val = _val;
    }

    public RO36_BinarySearchTreeAndDoublyLinkedList(int _val,RO36_BinarySearchTreeAndDoublyLinkedList _left,RO36_BinarySearchTreeAndDoublyLinkedList _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public static void main(String[] args) {

    }
    private static RO36_BinarySearchTreeAndDoublyLinkedList pre;
    private static RO36_BinarySearchTreeAndDoublyLinkedList head;
    public RO36_BinarySearchTreeAndDoublyLinkedList treeToDoublyList(RO36_BinarySearchTreeAndDoublyLinkedList root) {
        if (root==null){
            return null;
        }
        //二叉搜索树的中序遍历为递增序列，故采用中序遍历构建链表
        dfs(root);
        //中序遍历完成后，head为头节点， pre为尾节点，修改引用构成双向链表
        head.left=pre;
        pre.right=head;
        return head;
    }
    public static void dfs(RO36_BinarySearchTreeAndDoublyLinkedList cur){
        //当节点为空，递归终止（访问到了叶子节点）
        if (cur==null){
            return;
        }
        dfs(cur.left);
        //给第一次进的节点为链表头节点，赋给head
        if (pre!=null){
            pre.right=cur;
        } else{
            head=cur;
        }
        cur.left = pre;
        //更新pre设为当前节点，即节点 cur 是后继节点的 pre；
        pre=cur;
        dfs(cur.right);
    }
    public RO36_BinarySearchTreeAndDoublyLinkedList treeToDoublyList1(RO36_BinarySearchTreeAndDoublyLinkedList root) {
        if(root == null){
            return root;
        }
        RO36_BinarySearchTreeAndDoublyLinkedList[] nodes = new RO36_BinarySearchTreeAndDoublyLinkedList[2];
        nodes = treeTo(root);
        //让双向列表变为循环双向列表
        nodes[1].right = nodes[0];
        nodes[0].left = nodes[1];
        return nodes[0];
    }

    public RO36_BinarySearchTreeAndDoublyLinkedList[] treeTo(RO36_BinarySearchTreeAndDoublyLinkedList root){

        RO36_BinarySearchTreeAndDoublyLinkedList[] nodes1 = new RO36_BinarySearchTreeAndDoublyLinkedList[2];//左子树的头尾指针
        RO36_BinarySearchTreeAndDoublyLinkedList[] nodes2 = new RO36_BinarySearchTreeAndDoublyLinkedList[2];//右子树的头尾指针
        RO36_BinarySearchTreeAndDoublyLinkedList[] nodes3 = new RO36_BinarySearchTreeAndDoublyLinkedList[2];//该子树的头尾指针
        //判断是否为叶子节点，是就直接返回
        if(root.left == null && root.right == null){
            nodes1[0] = root;
            nodes1[1] = root;
            return nodes1;
        }
        //左子树不为空，遍历左子树
        if(root.left != null){
            nodes1 = treeTo(root.left);
        }else{//为空，将头指针设为根节点
            nodes1[0] = root;
        }
        //右子树是不为空，遍历右子树
        if(root.right != null){
            nodes2 = treeTo(root.right);
        }else{//为空，将尾指针设为根节点
            nodes2[1] = root;
        }
        //若左子树不为空，将根节点左子树指针指向左子树的尾结点，将左子树尾结点指针指向根节点
        if(nodes1[0] != root){
            nodes1[1].right = root;
            root.left = nodes1[1];
        }
        //若右子树不为空，将根节点右子树指针指向右子树的头结点，将右子树头结点指针指向根节点
        if(nodes2[1] != root){
            nodes2[0].left = root;
            root.right = nodes2[0];
        }
        //返回该子树的头尾指针
        nodes3[0] = nodes1[0]; nodes3[1] = nodes2[1];
        return nodes3;
    }

}
