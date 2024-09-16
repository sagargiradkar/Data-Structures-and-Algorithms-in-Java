public class ST_01_Stack_Using_Array {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with a given size
    public ST_01_Stack_Using_Array(int size) {
        stack = new int[size];
        capacity = size;
        top = -1; // Stack is empty initially
    }

    // Push method to add an element to the stack
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot add element " + element);
            return;
        }
        stack[++top] = element; // Increment top and add the element
        System.out.println("Pushed " + element);
    }

    // Pop method to remove the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No element to pop");
            return -1;
        }
        return stack[top--]; // Return the element and decrement top
    }

    // Peek method to view the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        ST_01_Stack_Using_Array stack = new ST_01_Stack_Using_Array(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // This will cause stack overflow

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element after popping: " + stack.peek());
    }
}
