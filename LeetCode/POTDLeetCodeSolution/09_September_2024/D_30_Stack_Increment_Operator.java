class CustomStack {
    int stack[];
    int operations[];
    int capacity;
    int size;
    int index;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        operations = new int[maxSize];
        capacity = maxSize;
        size = 0;
        index = -1;
    }

    public void push(int x) {
        if (isFull()) {
            return;
        }
        index++;
        size++;
        stack[index] = x;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int val = stack[index];
        val += operations[index];
        if (index > 0) {
            operations[index - 1] += operations[index];
        }
        operations[index] = 0;
        index--;
        size--;
        return val;
    }

    public void increment(int k, int val) {
        if (isEmpty()) {
            return;
        }
        int num = Math.min(size, k);
        operations[num - 1] += val;
    }

    private boolean isFull() {
        return (size == capacity);
    }

    private boolean isEmpty() {
        return (size == 0);
    }
}

public class D_30_Stack_Increment_Operator {
    public static void main(String[] args) {
        // Create a CustomStack of maximum size 5
        CustomStack customStack = new CustomStack(5);
        
        // Perform operations on the CustomStack
        customStack.push(1);  // Stack: [1]
        customStack.push(2);  // Stack: [1, 2]
        customStack.push(3);  // Stack: [1, 2, 3]
        
        System.out.println(customStack.pop()); // Outputs: 3 (Stack: [1, 2])
        
        customStack.push(4);  // Stack: [1, 2, 4]
        customStack.push(5);  // Stack: [1, 2, 4, 5]
        
        customStack.increment(3, 2); // Increment top 3 elements by 2 (Stack: [3, 4, 6, 5])
        
        System.out.println(customStack.pop()); // Outputs: 5 (Stack: [3, 4, 6])
        System.out.println(customStack.pop()); // Outputs: 6 (Stack: [3, 4])
        
        customStack.increment(2, 5); // Increment top 2 elements by 5 (Stack: [8, 9])
        
        System.out.println(customStack.pop()); // Outputs: 9 (Stack: [8])
        System.out.println(customStack.pop()); // Outputs: 8 (Stack: [])
        System.out.println(customStack.pop()); // Outputs: -1 (Stack is empty)
    }
}
