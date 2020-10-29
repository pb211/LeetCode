package Lecode.linkList;

public class RP19_RemoveNthNodeFromEndOfList {
    int val;
    RP19_RemoveNthNodeFromEndOfList next;
    RP19_RemoveNthNodeFromEndOfList(int val){this.val=val;}
    RP19_RemoveNthNodeFromEndOfList(int val,RP19_RemoveNthNodeFromEndOfList next){
        this.val=val;
        this.next=next;
    }

    public static void main(String[] args) {
        RP19_RemoveNthNodeFromEndOfList one = new RP19_RemoveNthNodeFromEndOfList(1);
        RP19_RemoveNthNodeFromEndOfList two = new RP19_RemoveNthNodeFromEndOfList(2);
        RP19_RemoveNthNodeFromEndOfList three = new RP19_RemoveNthNodeFromEndOfList(3);
        RP19_RemoveNthNodeFromEndOfList four = new RP19_RemoveNthNodeFromEndOfList(4);
        RP19_RemoveNthNodeFromEndOfList five = new RP19_RemoveNthNodeFromEndOfList(5);
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        int n  = 2;
        RP19_RemoveNthNodeFromEndOfList res = removeNthFromEnd(one,2);
        while (res!=null){
            System.out.print(res.val);
            if (res.next!=null){
                System.out.print("->");
            }
            res=res.next;
        }
    }
    public static RP19_RemoveNthNodeFromEndOfList removeNthFromEnd(RP19_RemoveNthNodeFromEndOfList head, int n) {
        RP19_RemoveNthNodeFromEndOfList newHead = new RP19_RemoveNthNodeFromEndOfList(0, head);
        RP19_RemoveNthNodeFromEndOfList s = newHead;
        RP19_RemoveNthNodeFromEndOfList f = s;
        for (int i=1;i<=n;i++){
            f=f.next;
        }
        System.out.println(s.val+","+f.val);
        while (f.next!=null){
            f=f.next;
            s=s.next;
        }
        s.next=s.next.next;
        return newHead;
    }
}
