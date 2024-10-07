import java.util.Stack;

public class D_37_Min_Stack {
    
    public static void main(String[] args) {
        // Instantiate the MinStack
        MinStack minStack = new MinStack();
        
        // Example usage
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        // Getting the minimum value
        System.out.println("Minimum value: " + minStack.getMin()); // Returns -3
        
        // Pop the top value
        minStack.pop();
        
        // Top value after pop
        System.out.println("Top value: " + minStack.top()); // Returns 0
        
        // Getting the minimum value after pop
        System.out.println("Minimum value: " + minStack.getMin()); // Returns -2
    }
}

class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> min;

    // Constructor initializes two stacks: one for normal operations and one for tracking the minimum value.
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    // Pushes a value onto the stack and updates the min stack if necessary.
    public void push(int val) {
        if (st.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
        st.push(val);
    }

    // Pops a value from the stack, and also updates the min stack if the popped value was the minimum.
    public void pop() {
        int elem1 = st.pop();
        if (elem1 == min.peek()) {
            min.pop();
        }
    }

    // Returns the top value of the stack without removing it.
    public int top() {
        return st.peek();
    }

    // Returns the current minimum value in the stack.
    public int getMin() {
        return min.peek();
    }
}
