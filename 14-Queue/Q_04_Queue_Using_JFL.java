import java.util.*;

public class Q_04_Queue_Using_JFL {
    public static void main(String[] args) {
        System.out.println("Queue using Queue<Integer> q = new LinkedList<>()");
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
        System.out.println("Queue using Queue<Integer> q1 = new ArrayDeque<>()");
        Queue<Integer> q1 = new ArrayDeque<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(1);
        q1.add(2);
        q1.add(3);

        while (!q1.isEmpty()) {
            System.out.print(q1.peek() + " ");
            q1.remove();
        }

    }
}
