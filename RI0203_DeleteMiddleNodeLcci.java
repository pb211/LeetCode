package Lecode.linkList;

public class RI0203_DeleteMiddleNodeLcci {
    int val;
    RI0203_DeleteMiddleNodeLcci next;
    RI0203_DeleteMiddleNodeLcci(int x) { val = x; }
    public static void main(String[] args) {
        RI0203_DeleteMiddleNodeLcci one = new RI0203_DeleteMiddleNodeLcci(4);
        RI0203_DeleteMiddleNodeLcci two = new RI0203_DeleteMiddleNodeLcci(5);
        RI0203_DeleteMiddleNodeLcci three = new RI0203_DeleteMiddleNodeLcci(1);
        RI0203_DeleteMiddleNodeLcci four = new RI0203_DeleteMiddleNodeLcci(9);
        one.next=two;
        two.next=three;
        three.next=four;
        deleteNode(two);
        one.getList(one);
    }
    public void getList(RI0203_DeleteMiddleNodeLcci node) {
        while(node!=null) {
            System.out.print(node.val+"\t");
            node=node.next;
        }
    }
    public static void deleteNode(RI0203_DeleteMiddleNodeLcci node) {
        //把下一个结点赋值给这个已知结点，然后删掉下一个结点
        node.val=node.next.val;
        node.next = node.next.next;
    }
}
