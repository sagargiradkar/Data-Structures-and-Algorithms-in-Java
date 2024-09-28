public class D_28_Circular_Deque {

    public static void main(String[] args) {
        // Test case 1: Basic functionality - inserting and deleting from both ends
        MyCircularDeque deque1 = new MyCircularDeque(3);  // Capacity of 3
        System.out.println("Test Case 1");
        System.out.println(deque1.insertLast(1));    // Insert 1 at the rear, returns true
        System.out.println(deque1.insertLast(2));    // Insert 2 at the rear, returns true
        System.out.println(deque1.insertFront(3));   // Insert 3 at the front, returns true
        System.out.println(deque1.insertFront(4));   // Insert 4 at the front, should fail, returns false (deque is full)
        System.out.println(deque1.getRear());        // Returns 2
        System.out.println(deque1.isFull());         // Should return true, deque is full
        System.out.println(deque1.deleteLast());     // Delete from the rear, returns true
        System.out.println(deque1.insertFront(4));   // Insert 4 at the front, returns true
        System.out.println(deque1.getFront());       // Returns 4
        
        System.out.println();

        // Test case 2: Testing edge case when deque is empty
        MyCircularDeque deque2 = new MyCircularDeque(2);  // Capacity of 2
        System.out.println("Test Case 2");
        System.out.println(deque2.getFront());       // Should return -1 (deque is empty)
        System.out.println(deque2.getRear());        // Should return -1 (deque is empty)
        System.out.println(deque2.deleteFront());    // Should return false (nothing to delete)
        System.out.println(deque2.deleteLast());     // Should return false (nothing to delete)
        
        System.out.println();

        // Test case 3: Filling the deque and checking isFull()
        MyCircularDeque deque3 = new MyCircularDeque(2);  // Capacity of 2
        System.out.println("Test Case 3");
        System.out.println(deque3.insertLast(10));    // Insert 10 at the rear, returns true
        System.out.println(deque3.insertLast(20));    // Insert 20 at the rear, returns true
        System.out.println(deque3.insertLast(30));    // Should return false (deque is full)
        System.out.println(deque3.isFull());          // Should return true (deque is full)

        System.out.println();

        // Test case 4: Alternating insert and delete operations
        MyCircularDeque deque4 = new MyCircularDeque(5);  // Capacity of 5
        System.out.println("Test Case 4");
        System.out.println(deque4.insertFront(1));    // Insert 1 at the front, returns true
        System.out.println(deque4.insertLast(2));     // Insert 2 at the rear, returns true
        System.out.println(deque4.deleteFront());     // Delete from the front, returns true
        System.out.println(deque4.getFront());        // Should return -1 (deque is now empty)
        System.out.println(deque4.insertLast(3));     // Insert 3 at the rear, returns true
        System.out.println(deque4.getRear());         // Should return 3
        
        System.out.println();

        // Test case 5: Checking if deque handles wrap-around correctly
        MyCircularDeque deque5 = new MyCircularDeque(3);  // Capacity of 3
        System.out.println("Test Case 5");
        System.out.println(deque5.insertLast(5));    // Insert 5 at the rear, returns true
        System.out.println(deque5.insertLast(6));    // Insert 6 at the rear, returns true
        System.out.println(deque5.insertLast(7));    // Insert 7 at the rear, returns true
        System.out.println(deque5.deleteFront());    // Delete from the front, returns true
        System.out.println(deque5.insertLast(8));    // Insert 8 at the rear, returns true
        System.out.println(deque5.getRear());        // Should return 8
        System.out.println(deque5.getFront());       // Should return 6
    }
}
class MyCircularDeque {
    int front;
    int rear;
    int size;
    int capacity;
    int deque[];
    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        rear = k-1;
        size = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front +1) % capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
          if(isEmpty()){
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return deque[front];
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return deque[rear];
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == capacity);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */