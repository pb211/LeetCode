package Lecode.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RO10_I_FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    public static int fib(int n) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        queue.add(1);
        if (n==0){
            return 0;
        } else if (n==1){
            return 1;
        }else {
            for (int i =2;i<=n;i++){
                int a=queue.poll();
                int b=queue.poll();
                if (a==1000000008||b==1000000008){
                    return 1;
                }
                queue.add(b%1000000007);
                queue.add((a+b)%1000000007);
            }
            queue.poll();
            return queue.poll();
        }
    }
}
