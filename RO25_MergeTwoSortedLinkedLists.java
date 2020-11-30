package Lecode.DivideAndRule;

public class RO25_MergeTwoSortedLinkedLists {
    int val;
    RO25_MergeTwoSortedLinkedLists next;
    RO25_MergeTwoSortedLinkedLists(int x) { val = x; }
    public static void main(String[] args) {
        RO25_MergeTwoSortedLinkedLists one1 = new RO25_MergeTwoSortedLinkedLists(1);
        RO25_MergeTwoSortedLinkedLists two1 = new RO25_MergeTwoSortedLinkedLists(2);
        RO25_MergeTwoSortedLinkedLists three1 = new RO25_MergeTwoSortedLinkedLists(4);
        RO25_MergeTwoSortedLinkedLists one2 = new RO25_MergeTwoSortedLinkedLists(1);
        RO25_MergeTwoSortedLinkedLists two2 = new RO25_MergeTwoSortedLinkedLists(3);
        RO25_MergeTwoSortedLinkedLists three2 = new RO25_MergeTwoSortedLinkedLists(4);
        one1.next=two1;
        two1.next=three1;
        one2.next=two2;
        two2.next=three2;
        RO25_MergeTwoSortedLinkedLists res = mergeTwoLists(one1,one2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }

    public static RO25_MergeTwoSortedLinkedLists mergeTwoLists(RO25_MergeTwoSortedLinkedLists l1, RO25_MergeTwoSortedLinkedLists l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val > l2.val) {
            return mergeTwoLists(l2, l1);
        }
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
}
