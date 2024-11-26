import java.util.Stack;

public class D_39_Impl_Queue_Us_Stack {

    static class MyQueue {
        private Stack<Integer> main;
        private Stack<Integer> helper;

        public MyQueue() {
            main = new Stack<>();
            helper = new Stack<>();
        }

        // Push element x to the back of queue.
        public void push(int x) {
            main.push(x);
        }

        // Removes the element from the front of queue and returns that element.
        public int pop() {
            if (helper.isEmpty()) {
                while (!main.isEmpty()) {
                    helper.push(main.pop());
                }
            }
            return helper.pop();
        }

        // Get the front element.
        public int peek() {
            if (helper.isEmpty()) {
                while (!main.isEmpty()) {
                    helper.push(main.pop());
                }
            }
            return helper.peek();
        }

        // Returns whether the queue is empty.
        public boolean empty() {
            return main.isEmpty() && helper.isEmpty();
        }
    }

    // Main method to test the functionality of the MyQueue class.
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();

        // Test push operation
        obj.push(1);
        obj.push(2);
        obj.push(3);

        // Test peek operation (should return 1)
        System.out.println("Peek: " + obj.peek()); // Outputs 1

        // Test pop operation (should return 1)
        System.out.println("Pop: " + obj.pop()); // Outputs 1

        // Test peek again (should return 2)
        System.out.println("Peek: " + obj.peek()); // Outputs 2

        // Test empty (should return false)
        System.out.println("Empty: " + obj.empty()); // Outputs false
    }
}
