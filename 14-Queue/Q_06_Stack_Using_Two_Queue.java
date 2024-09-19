import java.util.*;

public class Q_06_Stack_Using_Two_Queue {

    public static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            // Always push into the non-empty queue
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }

            int top = -1;

            // Move elements from q1 to q2 or vice versa, but leave the last one (top element)
            if (!q1.isEmpty()) {
                while (q1.size() > 1) {
                    q2.add(q1.remove());
                }
                top = q1.remove(); // This is the element to pop
            } else {
                while (q2.size() > 1) {
                    q1.add(q2.remove());
                }
                top = q2.remove(); // This is the element to pop
            }

            return top;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }

            int top = -1;

            // Similar to pop, but we just peek at the last element instead of removing it
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
