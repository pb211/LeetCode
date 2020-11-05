package Lecode.Queue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RO59_II_MaximumValueOfTheQueue2 {
    private static Queue<Integer> queue;
    private static Deque<Integer> deque;
    public static void main(String[] args) {
        RO59_II_MaximumValueOfTheQueue res = new RO59_II_MaximumValueOfTheQueue();
        res.MaxQueue();
        res.push_back(2);
        System.out.println(queue);
        System.out.println(deque);

    }
    public void MaxQueue() {
        queue = new LinkedList<Integer>();
        deque = new LinkedList<Integer>();
    }
    public static int max_value() {
        if (deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }
    public void push_back(int value) {
        while (!deque.isEmpty()&&deque.peekLast()<value){
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }
    public int pop_front(){
        if (queue.isEmpty()){
            return -1;
        }
        int r=queue.poll();
        if (r==deque.peekFirst()){
            deque.pollFirst();
        }
        return r;
    }
}
