public class ST_03_Stack_Using_LL {
    // Node class to represent each element in the stack
    static class Node {
        int data;
        Node next;

        // Constructor to initialize a new node with data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class to handle stack operations
    static class Stack {
        static Node head = null; // Head node to represent the top of the stack

        // Check if the stack is empty
        public static boolean isEmpty() {
            return head == null;
        }

        // Push (add) an element to the stack
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head; // Link the new node to the current head
            head = newNode;      // Update head to the new node
        }

        // Pop (remove) the top element from the stack
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! No element to pop");
                return -1;
            }
            int top = head.data;
            head = head.next; // Move head to the next node
            return top;
        }

        // Peek (view) the top element of the stack without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
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
