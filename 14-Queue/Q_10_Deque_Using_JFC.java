
import java.util.*;

public class Q_10_Deque_Using_JFC{
    public static void main(String[] args){
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        System.out.println("First elemet : "+ deque.getFirst());
        System.out.println("Last elemet : "+ deque.getLast());


    }
}