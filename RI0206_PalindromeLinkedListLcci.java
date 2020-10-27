package Lecode.linkList;

import java.util.Arrays;

public class RI0206_PalindromeLinkedListLcci {
    int val;
    RI0206_PalindromeLinkedListLcci next;
    RI0206_PalindromeLinkedListLcci(int x) { val = x; }
    public static void main(String[] args) {
        RI0206_PalindromeLinkedListLcci one = new RI0206_PalindromeLinkedListLcci(1);
        RI0206_PalindromeLinkedListLcci two = new RI0206_PalindromeLinkedListLcci(2);
        RI0206_PalindromeLinkedListLcci three = new RI0206_PalindromeLinkedListLcci(2);
//        RI0206_PalindromeLinkedListLcci four = new RI0206_PalindromeLinkedListLcci(1);
        one.next=two;
        two.next=three;
//        three.next=four;
        boolean res = isPalindrome(one);
        System.out.println(res);
    }
    public static boolean isPalindrome(RI0206_PalindromeLinkedListLcci head) {
        if (head==null||head.next==null){return true;}
        int l=longs(head);
        int mid= (int) Math.ceil(l/2.00);
        int []arr=reint(head, (int) Math.floor(l/2));
        for (int i=1;i<=l;i++){
            if (i>mid && head.val!=arr[i-mid-1]){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    //计算字符串长度
    public static int longs(RI0206_PalindromeLinkedListLcci head) {
        int l=1;
        while (true){
            if (head.next!=null){
                l+=1;
                head=head.next;
            }else {
                break;
            }
        }
        return l;
    }
    //得到前半段翻数组
    public static int[] reint(RI0206_PalindromeLinkedListLcci head,int mid) {
        int []arr=new int[mid];
        int index=1;
        while (index<=mid){
            arr[index-1]=head.val;
            index++;
            head=head.next;
        }
        for(int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
