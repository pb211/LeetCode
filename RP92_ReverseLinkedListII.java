package Lecode.linkList;

public class RP92_ReverseLinkedListII {
    int val;
    RP92_ReverseLinkedListII next;
    RP92_ReverseLinkedListII(int x){val = x;}

    public static void main(String[] args) {
        RP92_ReverseLinkedListII one = new RP92_ReverseLinkedListII(1);
        RP92_ReverseLinkedListII two = new RP92_ReverseLinkedListII(2);
        RP92_ReverseLinkedListII three = new RP92_ReverseLinkedListII(3);
        RP92_ReverseLinkedListII four = new RP92_ReverseLinkedListII(4);
        RP92_ReverseLinkedListII five = new RP92_ReverseLinkedListII(5);
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        int m=1;
        int n=2;
        RP92_ReverseLinkedListII res = reverseBetween(one, m, n);
        while (res!=null){
            System.out.print(res.val+"\t");
            res=res.next;
        }
    }
    private static RP92_ReverseLinkedListII reverseBetween(RP92_ReverseLinkedListII head, int m, int n) {
        RP92_ReverseLinkedListII res = new RP92_ReverseLinkedListII(0);
        res.next=head;
        RP92_ReverseLinkedListII pre = res;
        RP92_ReverseLinkedListII start = null;
        for (int i = 1; i < n; i++) {
            if (i<m){
                //找到代翻转部分的前驱
                pre = pre.next;
            }
            else if(i==m){
                start=pre.next;
            }
            if(i>=m) {
                //翻转目标区域
                RP92_ReverseLinkedListII cur = start.next;
                start.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
        }
        return res.next;
    }
}
