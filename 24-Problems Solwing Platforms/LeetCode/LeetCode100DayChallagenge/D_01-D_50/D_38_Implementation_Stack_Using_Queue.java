
import java.util.*;

public class D_38_Implementation_Stack_Using_Queue {

    private static class MyStack {
        private Queue<Integer> main;
        private Queue<Integer> helper;

        public MyStack() {
            main = new LinkedList<>();
            helper = new LinkedList<>();
        }

        public void push(int x) {
            // moving element from main to helper
            while (main.size() > 0) {
                helper.add(main.remove());
            }
            // add X in main
            main.add(x);
            // moving all elements from helper back to main
            while (helper.size() > 0) {
                main.add(helper.remove());
            }
        }

        public int pop() {
            return main.remove();
        }

        public int top() {
            return main.peek();
        }

        public boolean empty() {
            if (main.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);

        System.out.println(obj.top()); // Output: 2 (top element)
        System.out.println(obj.pop()); // Output: 2 (element popped)

        System.out.println(obj.top()); // Output: 1 (new top element)
        System.out.println(obj.empty()); // Output: false (stack is not empty)
    }
}