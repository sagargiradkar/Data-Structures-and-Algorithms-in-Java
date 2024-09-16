public class LL_11_Double_LL {

    // Define the Node class
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Method to add a node at the beginning
    public static void addFirst(int data) {
        Node newNode = new LL_11_Double_LL().new Node(data); // Create new node
        size++;
        if (head == null) {
            head = tail = newNode; // If list is empty, set both head and tail to new node
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Method to add a node at the end
    public static void addLast(int data) {
        Node newNode = new LL_11_Double_LL().new Node(data); // Create new node
        size++;
        if (head == null) {
            head = tail = newNode; // If list is empty, set both head and tail to new node
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Method to remove the first node (head)
    public static void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null; // If only one element, set both head and tail to null
        } else {
            head = head.next; // Move head to the second node
            head.prev = null; // Set the new head's previous reference to null
        }

        size--;
    }

    // Method to remove the last node (tail)
    public static void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null; // If only one element, set both head and tail to null
        } else {
            tail = tail.prev; // Set tail to the second-to-last node
            tail.next = null; // Remove reference to the old tail
        }

        size--;
    }

    // Method to print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LL_11_Double_LL dll = new LL_11_Double_LL();
        
        // Test addFirst
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(45);
        dll.print();  // Expected: 45 <--> 2 <--> 3 <--> null
        
        // Test addLast
        dll.addLast(10);
        dll.addLast(20);
        dll.print();  // Expected: 45 <--> 2 <--> 3 <--> 10 <--> 20 <--> null
        
        // Test removeFirst
        dll.removeFirst();
        dll.print();  // Expected: 2 <--> 3 <--> 10 <--> 20 <--> null

        // Test removeLast
        dll.removeLast();
        dll.print();  // Expected: 2 <--> 3 <--> 10 <--> null
    }
}
