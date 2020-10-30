package Lecode.linkList;
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//你应当保留两个分区中每个节点的初始相对位置。
//示例:
//输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5

public class RP86_PartitionList {
    int val;
    RP86_PartitionList next;
    RP86_PartitionList(int x){val=x;}


    public static void main(String[] args) {
        RP86_PartitionList one = new RP86_PartitionList(1);
        RP86_PartitionList two = new RP86_PartitionList(4);
        RP86_PartitionList three = new RP86_PartitionList(3);
        RP86_PartitionList four = new RP86_PartitionList(2);
        RP86_PartitionList five = new RP86_PartitionList(5);
        RP86_PartitionList six = new RP86_PartitionList(2);
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        five.next=six;
        int x = 3;
        RP86_PartitionList res = partition(one,x);
        while (res!=null){
            System.out.print(res.val);
            if (res.next!=null){
                System.out.print("->");
            }
            res=res.next;
        }
    }

    public static RP86_PartitionList partition(RP86_PartitionList head, int x) {
        //新建两个链表存储大小目标值
        RP86_PartitionList minLink = new RP86_PartitionList(0);
        RP86_PartitionList bigLink = new RP86_PartitionList(0);
        RP86_PartitionList mincur = minLink;
        RP86_PartitionList maxcur = bigLink;
        while (head!=null){
            if (head.val<x){
                mincur.next=head;
                head=head.next;
                mincur=mincur.next;
                //为下次遍历开辟空间
                mincur.next=null;
            }
            else{
                maxcur.next=head;
                head=head.next;
                maxcur=maxcur.next;
                //为下次遍历开辟空间
                maxcur.next=null;
            }
        }
        mincur.next=bigLink.next;
        return minLink.next;
    }
}
