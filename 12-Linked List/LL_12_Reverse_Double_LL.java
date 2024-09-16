public class LL_12_Reverse_Double_LL {

    // Node class representing each node in the doubly linked list
    public static class Node {
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

    // Method to add a node at the beginning of the list
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode; // If the list is empty, newNode becomes both head and tail
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Method to add a node at the end of the list
    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (tail == null) {
            head = tail = newNode; // If the list is empty, newNode becomes both head and tail
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Method to reverse the doubly linked list
    public static void reverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        Node temp = null;

        // Traverse the list and swap the next and prev pointers for each node
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node, which is now in prev
        }

        // After reversing, update head to point to what was originally the last node (tail)
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Method to print the list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LL_12_Reverse_Double_LL dll = new LL_12_Reverse_Double_LL();

        // Add elements to the doubly linked list
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addLast(5);

        System.out.println("Original List:");
        dll.print();  // Output: 4 <--> 3 <--> 2 <--> 1 <--> 5 <--> null

        // Reverse the doubly linked list
        dll.reverse();

        System.out.println("Reversed List:");
        dll.print();  // Output: 5 <--> 1 <--> 2 <--> 3 <--> 4 <--> null
    }
}
