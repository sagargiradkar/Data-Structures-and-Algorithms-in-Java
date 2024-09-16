import java.util.ArrayList;

public class ST_02_Stack_Using_ArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // Check if the stack is empty
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // Push (add) an element to the stack
        public static void push(int data) {
            list.add(data);
        }

        // Pop (remove) the top element from the stack
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! No element to pop");
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // Peek (view) the top element of the stack without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        // Display and pop elements from the stack
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // Display the top element
            s.pop();                      // Remove the top element
        }
    }
}
